# FOBtest

# Project Title

Running Test cases for Flipkart Android Mobile App (Flipkart is India's Largest ecommerce)


### Prerequisites

We need to have install these below


1) Appium

2) Android studio

3) maven

4) jdk1.8



### Installing Flipkart App

1) To install flipkart app (App is present in code directory itself) Please find below steps

   a) Start emualator using andorid studio
   b) Do adb devices to see list of devices 
   c) Do adb adb -s $Device udid  install $Flipkart app

  



## Running the tests

1) Once emulator Android virtual device is up and appium server is up please run below command to start test

mvn clean test

Note:- If you want to run test on other devices Go to this class src/test/java/FlipkartTest/BaseTest.java and change udid to your device udid


 dc.setCapability("udid","emulator-5556");



2) Once test are run report are present in below path in project

/target/surefire-reports/index.html






## Built With

* [Appium](http://appium.io/) - The mobile testing framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [testng](http://testng.org/) - testing framework
* [Selenium](http://www.seleniumhq.org/)-UI testing framework

## Test Case Included


1) Verify Login is successful to flipkart app and user navigate to Home Page for Valid User

2) Verify Login is unsuccessful to flipkart app and user not navigate to Home Page if user enters wrong creditianls

3) Verify Successful logged in User is able to search for product and able to see product details once he/she navigate to Product Detail page by clicking on product in search page

4) Verify Successful logged in User is able to search for  product in search page by entering search keyword

## Run test on real android Devices

Steps

1) Connect your device to Laptop/Pc
2) Enable USB debugging. To enable USB Debugging please find below steps
   a) Navigate to Settings app on phone
   b) Scroll down and click on the Developer Options
   c) Turn on the Developer Options and click the USB Debugging.
3) Run command adb devices and make sure you are seeing your connected devices. adb devices will show your devices connected with udid

4) Go to this class src/test/java/FlipkartTest/BaseTest.java and change udid to your device udid
  For ex:-
    dc.setCapability("udid","emulator-5556");

5) Run mvn clean test to run tests.
