object Dependencies {

    object GradlePlugins {
        // TODO: Upgrade to 1.5.0 when Compose supports it
        const val kotlinVersion = "1.4.32"
        const val gradleVersion = "7.1.0-alpha01"
    }

    object Libraries {
        const val material = "1.3.0"
        const val appcompat = "1.3.0"
        const val dataStore = "1.0.0-beta01"

        object Ktx {
            const val core = "1.5.0"
            const val lifecycleRuntime = "2.3.1"
        }

        object Compose {
            const val compose = "1.0.0-beta07"
            const val activityCompose = "1.3.0-alpha08"
            const val navigation = "2.4.0-alpha01"
            const val insets = "0.10.0"
            const val icons = "0.2.0"
        }
    }

    object AndroidSdk {
        const val compiledVersion = 30
        const val minSdk = 21
        const val targetSdk = 30
    }

    object Application {
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Test {
        const val junit = "4.13.2"
    }

    object AndroidTest {
        const val junit = "1.1.2"
        const val espresso = "3.3.0"
    }
}