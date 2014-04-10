# Android Gradle Sample

This project was created to be a simple android project that uses the new build tool from Google and runs tests on a connected device.

## Goals with this project

* Simple, easy to understand, android gradle project with some basic functionality.
* Utilizes ActivityInstrumentationTestCase2<T> to execute tests on a connected device.
    * Run a single test class and/or method from command line.
* Uses Robotium Solo to communicate with the app's views and widgets during tests.
* Jenkins setup

## Project structure

The project was first created using the New Project... wizard within Android Studio 0.5.3.
This means that the structure of the project has the new layout with java sources at src/java/main and so fourth.

    AndroidGradleSample/
    └── androidAdderApp                <-- Android Studio internal module name
        ├── build                      <-- Gradle build result folder
        ├── libs
        └── src
            └── main
                ├── java
                └── res

## Main application

The main application is a simple adder, you haven't seen one of those before have you :)
For the purpose of achieving the goals of this project it is sufficient though.

The files altered and added was simply:

    src/main/java/org.company.androidadderapp/MainActivity.java
    src/main/res/drawable/viperaberus1.jpg
    src/main/res/layout/activity_main.xml
    src/main/res/values/strings.xml

To see exactly what was done, take a look into the different text files above, they are commented.

_If you only are interested of the code this far check out the tag TheAdderAppOnly._

## Instrumentation testing

The instrumentation testing is performed with help of the Robotium Solo.

The following was entered to the dependency section in the modules build.gradle:

    androidTestCompile ('com.jayway.android.robotium:robotium-solo:5.+') {
        exclude module: 'android'
        exclude module: 'android-test'
    }

After that the folders `androidTest/java/instrumentationTests` was added to the `src` folder.

The structure of the project is now like this:

    AndroidGradleSample
    └── androidAdderApp
        ├── libs
        └── src
            ├── androidTest
            │   └── java
            |       └── instrumentationTests
            └── main
                ├── java
                └── res

In the instrumentationTests folder the MainActivityTest was added.
In that class we use ActivityInstrumentationTestCase2<T> and Robotium Solo.

Take a look at the MainActivityTest class for more information, it is commented where needed.

_If you want to look at the code at this stage check out the TheFirstInstrumentationTest tag_

## Plain jUnit tests (that runs on device)

In this section a new test package is added where we put our plain jUnit tests.
Please keep in mind that these tests runs on the device and not in your IDE.

In the androidTest/java folder a new package is created and called unitTests:

    AndroidGradleSample
    └── androidAdderApp
        ├── libs
        └── src
            ├── androidTest
            │   └── java
            |       └── instrumentationTests
            |       └── unitTests
            └── main
                ├── java
                └── res

MainActivityUnitTest was added in the unitTests package to host our unit tests.

_If you want to look at the code at this stage check out the TheFirstUnitTest tag_
