package com.successfactor.caf.service.build.trigger.actions;

import com.successfactor.caf.service.build.trigger.datamodel.CarStatus;

import java.util.Date;

public class SlackAction {

    private static SlackAction instance = null;
    private static final String LinePrefix = "\n";
    private static final String SlackTitle = "Demo1";
    private static final String SlackContent = "Failed for some builds!";
    private static String slackWebHookUrl = "https://hooks.slack.com/services/"+System.getenv("SLACK_HOOK");;
    private HttpUtils httpUtil = new HttpUtils();

    public static SlackAction getInstance() {

        if(instance==null) {
            instance = new SlackAction();
        }
        return instance;
    }

    public static SlackAction getInstance(String url) {

        if(instance==null) {
            instance = new SlackAction();
            instance.setSlackWebHookUrl(url);
        }
        return instance;
    }

    public static void main(String[] args) {

//		String filter = "filter=1&runType=Full";
//		ArrayList<JobBean> aepJobList = util.buildAEPJobList(filter);
//        String body = "{\"text\": \"This is a line of text in a channel.\\nAnd this is another line of text.\"}";

//        SlackAction.getInstance().sendAlert("demo from perslaa");

    }

    public void convertDates(String origin) {

        Date date = new Date(origin);
    }

    public int sendAlert(String slackMessage) {

        String body = "{\"text\": \""+SlackTitle+LinePrefix+slackMessage+"\"}";
//        String body = "{\"text\": \"This is a line of text in a channel.\\nAnd this is another line of text.\"}";
        httpUtil.postSimple(getSlackWebHookUrl(), body);
        return -1;
    }

    public int sendAlert(String title, String slackMessage) {

        String body = "{\"text\": \""+title+LinePrefix+slackMessage+"\"}";
        httpUtil.postSimple(getSlackWebHookUrl(), body);
        return -1;
    }

    public int sendAttachment(CarStatus carStatus) {



        String body =
                "{\"attachments\": " +
                    "[" +
                        "{" +
                            "\"fallback\": \"My Car in ["+carStatus.isWholeStatus()+
                                    "] Fuel Usage ["+(carStatus.getFuelAmount()*100.00/68)+"%].\",\n" +
                            "\"color\": \""+(carStatus.isWholeStatus()?"#2eb886":"#F35A00")+"\",\n" +
                            "\"pretext\": \"Car Status\",\n" +
                            "\"author_name\": \"Allen Car "+carStatus.getOdometer()*1.00/1000+" KM\",\n" +
                            "\"author_link\": \"http://flickr.com/bobby/\",\n" +
                            "\"author_icon\": \"http://flickr.com/icons/bobby.jpg\",\n" +
                            "\"title\": \"Car Status Summary "+(carStatus.getFuelAmount()*100/68)+"%\",\n" +
                            "\"title_link\": \"https://api.slack.com/\",\n" +
                            "\"text\": \""
                                        + " Door ["+(carStatus.getDoors().isWholeDoor()?"OPEN!":"Closed")+"]"
                                        + " Window ["+(carStatus.getWindows().isWholeWindowOpen()?"OPEN!":"Closed")+"]"
                                        + " Tyres ["+(carStatus.getTyrePressure().isWholeTyrePressure()?"Normal":"ISSUE!")+"]"
                                        +"\",\n" +
                            "\"fields\": " +
                                "[\n" +
                                    "{\n" +
                                    "\"title\": \"FuelAmount\",\n" +
                                    "\"value\": \""+carStatus.getFuelAmount()+" L\",\n" +
                                    "\"short\": true\n" +
                                    "},\n" +
                                    "{\n" +
                                    "\"title\": \"RemainDistance\",\n" +
                                    "\"value\": \""+carStatus.getDistanceToEmpty()+" KM\",\n" +
                                    "\"short\": true\n" +
                                    "},\n" +
                                    "{\n" +
                                    "\"title\": \"Washer\",\n" +
                                    "\"value\": \""+carStatus.getWasherFluidLevel()+"\",\n" +
                                    "\"short\": true\n" +
                                    "},\n" +
                                    "{\n" +
                                    "\"title\": \"BrakeFluid\",\n" +
                                    "\"value\": \""+carStatus.getBrakeFluid()+"\",\n" +
                                    "\"short\": true\n" +
                                    "},\n" +
                                    "{\n" +
                                    "\"title\": \"CarLocked\",\n" +
                                    "\"value\": \""+(carStatus.isCarLocked()?"YES":"NO")+"\",\n" +
                                    "\"short\": true\n" +
                                    "}\n" +
                                "],\n" +
                            "\"image_url\": \"http://my-website.com/path/to/image.jpg\",\n" +
                            "\"thumb_url\": \"http://example.com/path/to/thumb.png\",\n" +
                            "\"footer\": \"Slack API\",\n" +
                            "\"footer_icon\": \"https://platform.slack-edge.com/img/default_application_icon.png\",\n" +
                            "\"ts\": "+System.currentTimeMillis()/1000 +
                        "}" +
                    "]" +
                "}";

        httpUtil.postSimple(getSlackWebHookUrl(), body);
        return -1;
    }

    public String getSlackWebHookUrl() {
        return slackWebHookUrl;
    }

    public void setSlackWebHookUrl(String slackWebHookUrl) {
        this.slackWebHookUrl = slackWebHookUrl;
    }
}
