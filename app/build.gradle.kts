plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.example.wallpapeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.WallPaper.wallpaperfirebase_23"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-crashlytics:19.0.1")
    implementation("com.google.firebase:firebase-firestore-ktx:25.0.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.githubPhilJay:AndroidChart:v3.1.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    testImplementation("junit:junit:4.13.2")

    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.github.upheaval2404:image picker:2.1 ")

    implementation("org.jetbrains.kotlin-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlin-coroutines-android:1.9.0")



    implementation("com.makeramen:roundedimageview:2.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}