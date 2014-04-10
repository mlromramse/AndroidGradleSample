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

The files I altered added was simply:

    src/main/java/org.company.androidadderapp/MainActivity.java
    src/main/res/drawable/viperaberus1.jpg
    src/main/res/layout/activity_main.xml
    src/main/res/values/strings.xml

To see exactly what I've done look into the different text files above, they are commented.

