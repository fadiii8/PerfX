plugins {
    id("com.android.application")
}

android {
    namespace = "dev.whoisfadi.perfx"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.whoisfadi.perfx"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Compile against Modern libxposed API; LSPosed supplies it at runtime.
    compileOnly("io.github.libxposed:api:102.0.0")
}
