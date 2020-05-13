#!/bin/bash

ps aux | grep SmsApp | grep -v grep | awk '{ print "sudo kill -9", $2 }' | sh

exit 0
