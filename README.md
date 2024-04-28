# 🤖 GIPHY APP ANDROID
## What is this repository for?

Android app repository integrates Hilt DI, Clean Architecture with MVVM, and RxJava/RxKotlin for reactive programming. This setup ensures efficient dependency management, modularity, and responsiveness in app development.

## Technology Stack

|                | **Name** | **Version** |  
|----------------|----------|-------------|  
| **Lenguage**   | Kotlin   | 1.9.0       |  
| **Build Tool** | Gradle   | 8.3.1       |  


## 🛠 Setup & Installation
* This app is and app which uses the [Giphy Api](https://developers.giphy.com/docs/api/#quick-start-guide) to be able to show trending gifs.
* To be able to execute this app it will have the necessity to create an account and obtain an API KEY.
* Finally on local.properties add this line:
```  
api_key=<Your Api Key>  
```

# Dependencies

This project uses the following dependencies:

- `androidx.core.ktx`: A set of Kotlin extensions that are included with Android Jetpack and other Android libraries.
- `androidx.lifecycle.runtime.ktx`: Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component.
- `androidx.activity.compose`: A library that contains Compose-specific APIs for Activities.
- `androidx.compose.bom`: Bill of Materials for Jetpack Compose. It simplifies the declaration of Compose dependencies.
- `androidx.ui` and `androidx.ui.graphics`: Libraries for building UIs with Jetpack Compose.
- `androidx.ui.tooling.preview`: A library that provides previews of your Compose UI.
- `androidx.material3`: Material Design 3 components for Android.
- `androidx.hilt.navigation.compose`: A library that provides extensions to use Hilt with Jetpack Compose.
- `hilt.android`: A dependency injection library for Android.
- `logging.interceptor`: An HTTP/HTTP2 client for Android and Java applications.
- `retrofit`: A type-safe HTTP client for Android and Java.
- `moshi` and `moshi.kotlin`: Libraries for parsing JSON into Kotlin and Java objects.
- `converter.moshi`: A converter for serialization to and from JSON.
- `arrow.core`: Functional companion to Kotlin's Standard Library.
- `androidx.lifecycle.viewmodel.ktx`: ViewModel is a class that is responsible for preparing and managing the data for an Activity or a Fragment.
- `androidx.room.ktx`: A persistence library that provides an abstraction layer over SQLite.
- `coil.compose` and `coil.gif`: An image loading library for Android backed by Kotlin Coroutines.
- `lottie.compose`: A library that parses Adobe After Effects animations exported as JSON with Bodymovin and renders them natively on mobile.
- `androidx.paging.runtime.ktx` and `androidx.paging.compose`: Libraries that help you load and display small chunks of data at a time.
- `androidx.room.compiler`, `hilt.android.compiler`, `moshi.kotlin.codegen`: Compiler plugins for Room, Hilt, and Moshi respectively.