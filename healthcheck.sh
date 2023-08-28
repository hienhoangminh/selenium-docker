#!/usr/bin/env bash
# Environment variables
# HUB_HOST
# BROWSER
# SUITE
echo "Checking if Selenium Hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" \
    -DBROWSER=$BROWSER \
    -DHUB_HOST=$HUB_HOST \
    org.testng.TestNG $SUITE