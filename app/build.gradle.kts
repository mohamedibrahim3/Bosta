plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.mada.bosta_assessment"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mada.bosta_assessment"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Hilt - ViewModel
    implementation (libs.androidx.hilt.lifecycle.viewmodel)
    kapt (libs.androidx.hilt.compiler)
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.runtime.ktx.v262)
    implementation (libs.androidx.lifecycle.livedata.ktx.v262)
    implementation (libs.androidx.lifecycle.common.java8.v262)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    //  Recycler View
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
    //Dagger
    implementation (libs.dagger)
    kapt (libs.dagger.compiler)

    // Hilt - Android
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)

    // Retrofit and Gson
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Coroutines
    implementation (libs.kotlinx.coroutines.core.v173)
    implementation (libs.kotlinx.coroutines.android.v173)

    // Room
    kapt (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)
    implementation (libs.androidx.room.runtime)
    androidTestImplementation (libs.androidx.room.testing)

    implementation (libs.material.v160)


    implementation(project(":data"))
    implementation(project(":domain"))

}