## Mockcept = Mock + Intercept [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.alexkamanin/mockcept/badge.svg)](https://search.maven.org/artifact/io.github.alexkamanin/mockcept)

### Description

Sometimes during testing and demonstration, sending requests to the server is unnecessary. Sometimes
the server may not work at all, which delays the development of features. There is a need to receive
predefined responses from the server. Writing a mocking mechanism takes some time and would like to
have an easy tool for implementation. This library solves this goal.

When writing this library, the following goals were set:

* Must have convenient syntax for mocking HTTP/HTTPS-requests;
* Must correctly display the current status and code;
* Must have support regular expressions for parameter values.

> You may use this library with [ProductFlavor's](https://developer.android.com/studio/build/build-variants) and switch between **release** or **debug**.

### Guide

#### Add library to a project

###### build.gradle

```groovy
allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    // ------ Retrofit ------
    implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"

    // ------ Any converter to choose from ------
    implementation "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    implementation "com.squareup.retrofit2:converter-gson:$retrofitVersion"

    // ------ For logging requests ------
    implementation "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"

    // ------ Mockcept ------
    implementation "io.github.alexkamanin:mockcept:$mockceptVersion"
}
```

#### Create handler for you method path

###### SampleHandler.kt

```kotlin
val sampleHandler = pathHandler("/sample") {

    get(
        "number" to 1,
        "count" to 10
    ) {
        status = StatusCode.OK
        body = R.raw.get_sample_request
    }
    post(
        "id" to "[0-9]+" // or if you like Intellij hints "[0-9]+".toRegex()
    ) {
        status = StatusCode.OK
        body = R.raw.post_sample_request
    }
}
```

> Library support multiply responses for one request method. For example, if you have **GET** without parameters and you want different responses any time or if you need response error periodically.

#### You may specify regular expressions in the middle of the path

###### SampleHandler.kt

```kotlin
val sampleHandler = pathHandler("/sample/[0-9]+/something") {

    get {
        status = StatusCode.OK
        body = R.raw.get_sample_request
    }
}
```

#### If your path at the end implies a resource identifier, for example, http://sample.com/something/{somethingId}. You can return different answers.

###### SampleHandler.kt

```kotlin
val sampleHandler = pathHandler("/something") {

    "/(1000|1001)".get {
        status = StatusCode.OK
        body = R.raw.get_sample_request
    }
    "/1002".get {
        status = StatusCode.NotFound
    }
}
```

#### Add Mockcept to dependency injection

> Don't forget to enable `android:usesCleartextTraffic="true"` in your **AndroidManifest.xml** application tag, if you use HTTP traffic.

###### Hilt

```kotlin
@Provides
@Singleton
fun provideMockcept(@ApplicationContext context: Context): Mockcept =
    Mockcept(
        context = context,
        handlers = listOf(sampleHandler)
    )

@Provides
@Singleton
fun provideOkHttpClient(mockcept: Mockcept): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(mockcept)
        .build()

@Provides
@Singleton
fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .client(client)
        .baseUrl("http://sample.com/")
        .build()
```

###### Koin

```kotlin
single {
    OkHttpClient.Builder().addInterceptor(
        Mockcept(
            context = androidContext(),
            handlers = listOf(sampleHandler)
        )
    )
}

single {
    Retrofit.Builder()
        .client(get())
        .baseUrl("http://sample.com/")
        .build()
}
```

# License

   Copyright 2022 Alex Kamanin

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
