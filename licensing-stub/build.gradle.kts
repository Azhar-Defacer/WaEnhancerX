// Stand-in for the private `waex-licensing` submodule so the public source can compile.
// It contains NO license validation and NO Pro feature implementations: Pro stays locked and
// every Pro feature is an inert no-op. It is only used when the real submodule is absent.
plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.waenhancer.licensing"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}