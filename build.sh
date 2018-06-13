#!/bin/bash

mvn package
docker build -t docker.wdf.sap.corp:51119/service/streetcleanersv:$1 .
docker push docker.wdf.sap.corp:51119/service/streetcleanersv:$1
docker rmi docker.wdf.sap.corp:51119/service/streetcleanersv:$1 -f