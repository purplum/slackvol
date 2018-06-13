#!/bin/bash

new_version=$1

scp -o StrictHostKeyChecking=no deployment.yml root@10.129.126.224:/root
#kubectl get deployments --server=10.129.126.224:8080 --namespace=aep; kubectl apply -f deployment.yml --server=10.129.126.224:8080 --namespace=aep; kubectl rollout status deployment/prebuildsv-microservice --server=10.129.126.224:8080 --namespace=aep
ssh root@10.129.126.224 "kubectl apply -f /root/deployment.yml --namespace=aep; kubectl rollout status deployment/streetcleanersv-microservice --namespace=aep"