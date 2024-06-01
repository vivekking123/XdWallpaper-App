import com.android.build.gradle.internal.dsl.decorator.SupportedPropertyType.Collection.List.type

buildscript {

    repositories {

            mavenCentral()
            maven { url = uri(" https://dl.google.com/dl/android/maven2' ") }
            // OR
            google()



    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("com.google.gms:google-services:4.4.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
          classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.0" apply false
    id("com.android.library") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
}


allprojects{
    repositories {


            mavenCentral()
            maven { url = uri("https://jitpack.io") }
     google()

            // OR


    }
}