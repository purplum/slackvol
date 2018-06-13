#!/bin/bash

new_version=$1

echo ${new_version}

sed -e "s/{{ base_url }}/${new_version}/g" \
    < deployment_dev.yml \
    > deployment.yml