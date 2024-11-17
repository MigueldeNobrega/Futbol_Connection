plugins {
    alias(libs.plugins.androidApplication)
  //  id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.futbol_connection"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.futbol_connection"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore-ktx:25.1.0")
    implementation ("com.google.firebase:firebase-database:21.0.0") // versión puede variar
    implementation ("com.google.firebase:firebase-auth:23.1.0")   // si usas autenticación

}