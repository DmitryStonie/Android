plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    kotlin("plugin.serialization")
}


android {
    namespace = "com.example.lab1"
    compileSdk = 34

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.lab1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    flavorDimensions += "default"
    productFlavors {
        create("finalProduction") {
            dimension = "default"
            applicationId = "me.fleka.modernandroidapp"
            resValue("string", "app_name", "Modern App")
        }
        create("demoProduction") {
            dimension = "default"
            applicationId = "me.fleka.modernandroidapp.demoproduction"
            resValue("string", "app_name", "Modern App Demo P")
        }
        create("demoTesting") {
            dimension = "default"
            applicationId = "me.fleka.modernandroidapp.demotesting"
            resValue("string", "app_name", "Modern App Demo T")
        }
        create("mock") {
            dimension = "default"
            applicationId = "me.fleka.modernandroidapp.mock"
            resValue("string", "app_name", "Modern App Mock")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    kapt("com.android.tools.build:gradle:8.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}