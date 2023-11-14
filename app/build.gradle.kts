import com.android.ide.common.repository.main

plugins {
  id("com.android.application")
}

android {
  namespace = "com.android_app.day_task_android"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.android_app.day_task_android"
    minSdk = 24
    targetSdk = 33
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
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  buildFeatures {
    viewBinding = true;
  }
  sourceSets {
    named("main") {
      res.srcDirs(
        "src/main/res",
        "src/main/res/layouts/",
        "src/main/res/layouts/main",
        "src/main/res/layouts/sign-in",
        "src/main/res/layouts/sign-up",
        "src/main/res/layouts/bottom-tabs",
        "src/main/res/layouts/create-project",
        "src/main/res/layouts/project-details",
        "src/main/res/layouts/create-task",
        "src/main/res/layouts/task-details",
        "src/main/res/layouts/contact-details",
      )
    }
  }
}

dependencies {

  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.8.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.navigation:navigation-fragment:2.5.3")
  implementation("androidx.navigation:navigation-ui:2.5.3")
  implementation("androidx.legacy:legacy-support-v4:1.0.0")
  implementation("androidx.recyclerview:recyclerview:1.3.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}