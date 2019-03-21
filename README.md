# AutomationProject
This contains the sample appium tests in BDD (cucumber) framework and uses maven to build.
SampleApp: pessoas.apk

# Prerequisites to run:
1. java -version( java should be setup)
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
2.Android  sdk should be installed (can check https://developer.android.com/studio)
3. ANDROID_HOME environment variable should be set (path upto sdk. check: echo ANDROID_HOME
and it should return /Users/{userName}/Library/Android/sdk
4. Appium Server should be installed( npm install -g appium  # get appium and node should be already installed to do this)
5. Device/emulator information should be there( connect your real device or create emulator using android studio-avd manager run 'adb devices' and pick  deviceName of emulator or real device on which you want to execute the test and note platform version from device)



# Getting adb, appium server and device/emulator up and running
--There is a script file which can be either configured in jenkins job or for local run need to trigger it.
This Script starts installed appium server on 127.0.0.1:4723(please see the script)
This script uses ANDROID_HOME variable from the machine on which it is executed.
(can uncomment # export ANDROID_HOME=/Users/garima/Library/Android/sdk and set it your sdk location in script file)

This starts emulator given by name in step 1 

AutomationBddAppium/start-appium-new.sh

How to execute the script:

open terminal

1. If you want to run tests on emulator

# open terminal and run below command for emulator

avd_name='nameofyouremulatordevice' sh start-appium-new.sh 

AND HIT ENTER/RETURN

NOTE: ( nameofyouremulatordevice : created in step 5)

2. If you want to run tests on real device

# open terminal and run below command for real device

avd_name='USB' sh start-appium-new.sh 




After checks: 
check appium server is running
ps -ef|grep appium

If chosen option 1 then emulator should be running check 
ps -ef|grep emulator

or  If i chosen option 2 then I should EXPLICITLY connect real device to machine 

run command:  adb devices( to note udid )

List of devices attached
0815f8aacb270504	device ( the first one is udid)



#2:  run the testsuite

# Navigate to project directory /MyAppiumTests

# execute command to run test suite

mvn clean test  -DdeviceName="0815f8aacb270504" -DplatformVersion="7.0"

give udid value in -DdeviceName and platform version in -DplatformVersion of your device(noted from previous step)







