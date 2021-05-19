plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(Dependencies.AndroidSdk.compiledVersion)

    defaultConfig {
        applicationId = "com.example.composeplayground"
        minSdkVersion(Dependencies.AndroidSdk.minSdk)
        targetSdkVersion(Dependencies.AndroidSdk.targetSdk)
        versionCode = Dependencies.Application.versionCode
        versionName = Dependencies.Application.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Libraries.composeVersion
        kotlinCompilerVersion = Dependencies.GradlePlugins.kotlinVersion
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")

    // Compose
    implementation("androidx.compose.ui:ui:${Dependencies.Libraries.composeVersion}")
    implementation("androidx.compose.material:material:${Dependencies.Libraries.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling:${Dependencies.Libraries.composeVersion}")
    implementation("androidx.activity:activity-compose:1.3.0-alpha08")

    // Tests
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}