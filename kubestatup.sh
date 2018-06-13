#/bin/bash

KUBEMasterAddress=10.129.126.224:8080
kubectl apply -f deployment.yml --record --server=$KUBEMasterAddress

kubectl describe svc triggerbuildsv-microservice --server=$KUBEMasterAddress