# longdo_map

A longdo map plugin for Flutter.

## Getting Started

1. Get a Longdo Map API Key [HERE](https://map.longdo.com/api-mobile/android/document/api_key.html)
2. Update **YOUR_API_KEY** in `example/android/app/src/main/AndroidManifest.xml` to run example

## Installation

1. Add code below to `android/app/build.gradle`
``` gradle
repositories {
    maven { url 'http://maven.longdo.com/artifactory/libs-release-public' }
}

dependencies {
    ...
    implementation 'com.longdo.map:sdk:0.9.8'
}
```

2. Add code below to `android/app/src/main/AndroidManifest.xml`
``` xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    ...
    <application
        tools:replace="android:label"
        ...

        <meta-data
            android:name="longdo.map.key"
            android:value="YOUR_API_KEY" />
    </application>
```

3. Add dependencies to `pubspec.yaml`
``` yaml
dependencies:
  longdo_map:
    path: ./path/to/plugin/root
```

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.
