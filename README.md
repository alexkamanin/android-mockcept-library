## Mockcept = Mock + Intercept [![Maven Central](badge.svg)](ссылка)

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
    implementation "com.github.alexkamanin:mockcept:$mockceptVersion"
}
```

#### Create handler for you method path

###### SampleHandler.kt

```kotlin
object SampleHandler : MethodHandler {

    override val path = "/sample"

    init {
        get(
            "number" to 1,
            "count" to 10
        ) {
            status = StatusCode.OK,
            body = R.raw.get_sample_request
        }
        post(
            "id" to "[0-9]+" // or if you like Intellij hints "[0-9]+".toRegex()
        ) {
            status = StatusCode.OK,
            body = R.raw.post_sample_request
        }
    }
}
```

> Library support multiply responses for one request method. For example, if you have **GET** without parameters and you want different responses any time or if you need response error periodically.

#### Add Mockcept to dependency injection

> Don't forget to enable `android:usesCleartextTraffic="true"` in your **AndroidManifest.xml** application tag, if you use HTTP traffic.

###### Hilt

```kotlin
@Provides
@Singleton
fun provideMockcept(@ApplicationContext context: Context): Mockcept =
    Mockcept(context, mockceptHandlers)

private val mockceptHandlers = sequenceOf(SampleHandler)

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
        Mokcept(
            context = androidContext(),
            handlers = sequenceOf(SampleHandler)
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