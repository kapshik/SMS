#!/bin/bash

java -jar /var/lib/jenkins/workspace/SmsMvn/Source/target/SmsApp-0.0.1.jar --spring.profiles.active=https &

exit 0
