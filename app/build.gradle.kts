plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Sdk.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AppConfiguration.APPLICATION_ID
        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION
        versionCode = AppConfiguration.VERSION_CODE
        versionName = AppConfiguration.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(AndroidXLibs.CORE)
    implementation(AndroidXLibs.APP_COMPACT)
    implementation(AndroidLibs.MATERIAL)

    implementation(ComposeLibs.UI)
    implementation(ComposeLibs.MATERIAL)
    implementation(ComposeLibs.TOOLING_PREVIEW)
    implementation(ComposeLibs.NAVIGATION)
    implementation(ComposeLibs.HILT_NAVIGATION)
    implementation(ComposeLibs.ACTIVITY)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(AndroidXTestLibs.JUNIT)
    androidTestImplementation(ComposeLibs.UI_TEST)

    implementation(HiltLibs.ANDROID)
    kapt(HiltLibs.ANDROID_COMPILER)

    debugImplementation(ComposeLibs.TOOLING_PREVIEW)
}