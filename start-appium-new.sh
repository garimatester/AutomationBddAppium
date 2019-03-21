#!/bin/bash


# set Path variables assumed ANDROID_HOME is set already up to Android/sdk

# export ANDROID_HOME=/Users/garima/Library/Android/sdk

export PATH=$PATH:$ANDROID_HOME/tools
alias emu="$ANDROID_HOME/tools/emulator"
export PATH=$PATH:$ANDROID_HOME/build-tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/Cellar/daemonize/1.7.8/sbin


# pass avd or emulator name either from shell or set in Jenkins , It could be USB in case of real devices or your emulator 


echo Kill adb:
killall adb &
wait


echo Start adb:
$ANDROID_HOME/platform-tools/adb start-server &
wait





echo Kill emulator:
# adb -s $avd_name emu kill
# for proc in $(ps -ef | grep emulator | grep -v grep | awk -F " " '{print $2}'); do kill # $proc; done
adb devices | grep emulator | cut -f1 | while read line; do adb -s $line emu kill; done



# echo Kill Appium:
# for proc in $(ps -ef | grep appium | grep -v grep | awk -F " " '{print $2}'); do kill # # $proc; done





sleep 2

# if [ -f ~/appiumLog/appium_*.log ]; then
    # mv ~/appiumLog/appium_*.log ~/appiumLog/bak/
# fi


if [ "USB" != "${avd_name}" ]; then
     echo StartEmulator
     emu -avd $avd_name


fi

echo Start Appium:


daemonize -E BUILD_ID=dontKillMe /usr/local/bin/appium --address 127.0.0.1 --port 4723 --session-override --log ~/appiumLog/appium_${BUILD_ID}.log --default-capabilities '{"deviceReadyTimeout":120}' &
sleep 15



