#!groovy

node('DockerNode_72') {
    def mvnHome
    def k8saddr = "10.129.126.224"
    def Release = params.ReleaseVersion
    def buildno = env.BUILD_ID
    def versions = "v${Release}.${buildno}";

    try {
        currentBuild.description = "Starting build"
        notifyBuild('STARTED')

        stage('Preparation') {
            // for display purposes
            currentBuild.description = "Preparation"
            echo "Running ${env.BUILD_ID} on ${params.ReleaseVersion}"
            // Get some code from a GitHub repository
            checkout scm: [$class: 'GitSCM', gitTool: 'GitRedhat', branches: [[name: '*/dev']], userRemoteConfigs: [[url: 'https://github.wdf.sap.corp/SF-Automation/sv_streetcleaner.git', credentialsId: 'beda9adc-6aef-4483-9840-6adcec84c52b']]]
            // Get the Maven tool.
            // ** NOTE: This 'M3' Maven tool must be configured
            // **       in the global configuration.
            mvnHome = tool 'MVN72'
        }
        stage('Unit Test') {
            // Run the maven build
            currentBuild.description = "Unit test"
            if (isUnix()) {
                sh "'${mvnHome}/bin/mvn' test"
            } else {
                bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
        stage('Assemble') {
            // Run the maven build
            currentBuild.description = "Archive spring package"
            if (isUnix()) {
                sh "'${mvnHome}/bin/mvn' package"
            } else {
                bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
        stage('Docker Build') {
            // Run the maven build
            currentBuild.description = "Docker build"
            if (isUnix()) {
                sh "./build.sh v${Release}.${buildno}"
            } else {
                bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
        stage('Deployment') {
            // Run the maven build
            currentBuild.description = "Deploy to k8s"
            sh "./applyupdate.sh v${Release}.${buildno}"
            sh "./applyClusterDeploy.sh"
        }
        stage('Reports') {
            currentBuild.description = "Finish"

            echo "Done"
        }

    } catch (e) {
        // If there was an exception thrown, the build failed
        currentBuild.result = "FAILED"
        throw e
    } finally {
        // Success or failure, always send notifications
        notifyBuild(currentBuild.result)
        //slackSend baseUrl: '/', channel: '#pipeline', message: 'test', teamDomain: 'sfcaf', token: 'iPQCLoDpU3ZZoYrO14DgpvPz'
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    def slackhooks = "https://hooks.slack.com/services/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";

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
        emojis = 'snowboarder'
        summary = "${currentBuild.fullDisplayName} started"
    } else if (buildStatus == 'SUCCESSFUL') {
        color = 'GREEN'
        colorCode = '#00FF00'
        emojis = 'white_check_mark'
        summary = "\n<${env.BUILD_URL}|${currentBuild.fullDisplayName}> ${buildStatus} ${currentBuild.description}"
    } else {
        color = 'RED'
        colorCode = '#FF0000'
        emojis = 'x'
        summary = "\n<${env.BUILD_URL}|${currentBuild.fullDisplayName}> ${buildStatus} ${currentBuild.description}"
    }

    // Send notifications
    //slackSend baseUrl: '/', channel: '#pipeline', message: 'test', teamDomain: 'sfcaf', token: 'iPQCLoDpU3ZZoYrO14DgpvPz'
    sh "curl -X POST --data-urlencode 'payload={\"channel\": \"#pipeline\", \"color\": \"${colorCode}\", \"username\": \"webhookbot\", \"text\": \"${summary} \", \"icon_emoji\": \":${emojis}:\"}' \"${slackhooks}\""
    //slackSend (color: colorCode, message: summary, channel: 'pipeline', teamDomain: 'sfcaf', token: 'iPQCLoDpU3ZZoYrO14DgpvPz')
}
