#!/bin/bash

sudo java -jar /var/lib/jenkins/workspace/SmsMvn/Source/target/SmsApp-0.0.1.jar --spring.profiles.active=http &

exit 0
