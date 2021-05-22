plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Dependencies.AndroidSdk.compiledVersion

    defaultConfig {
        applicationId = "com.example.composeplayground"
        minSdk = Dependencies.AndroidSdk.minSdk
        targetSdk = Dependencies.AndroidSdk.targetSdk
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
        kotlinCompilerExtensionVersion = Dependencies.Libraries.Compose.compose
    }
}

dependencies {
    // Kotlin
    implementation(kotlin("reflect"))

    // Data Store
    implementation("androidx.datastore:datastore-preferences:${Dependencies.Libraries.dataStore}")

    // ktx
    implementation("androidx.core:core-ktx:${Dependencies.Libraries.Ktx.core}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.Libraries.Ktx.lifecycleRuntime}")

    // UI
    implementation("androidx.appcompat:appcompat:${Dependencies.Libraries.appcompat}")
    implementation("com.google.android.material:material:${Dependencies.Libraries.material}")

    // Compose
    implementation("androidx.compose.ui:ui:${Dependencies.Libraries.Compose.compose}")
    implementation("androidx.compose.material:material:${Dependencies.Libraries.Compose.compose}")
    implementation("androidx.compose.ui:ui-tooling:${Dependencies.Libraries.Compose.compose}")
    implementation("androidx.activity:activity-compose:${Dependencies.Libraries.Compose.activityCompose}")
    implementation( "androidx.navigation:navigation-compose:${Dependencies.Libraries.Compose.navigation}")
    implementation("com.google.accompanist:accompanist-insets:${Dependencies.Libraries.Compose.insets}")
    // Tests
    testImplementation("junit:junit:${Dependencies.Test.junit}")
    androidTestImplementation("androidx.test.ext:junit:${Dependencies.AndroidTest.junit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.AndroidTest.espresso}")
}