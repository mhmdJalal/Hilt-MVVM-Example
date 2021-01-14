A sample of usage Hilt Dependency Injection

Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Doing [manual dependency injection](https://developer.android.com/training/dependency-injection/manual) requires you to construct every class and its dependencies by hand, and to use containers to reuse and manage dependencies.

Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library [Dagger](https://developer.android.com/training/dependency-injection/dagger-basics) to benefit from the compile-time correctness, runtime performance, scalability, and [Android Studio support](https://medium.com/androiddevelopers/dagger-navigation-support-in-android-studio-49aa5d149ec9) that Dagger provides. For more information, see [Hilt and Dagger](https://developer.android.com/training/dependency-injection/hilt-android#hilt-and-dagger).

This guide explains the basic concepts of Hilt and its generated containers. It also includes a demonstration of how to bootstrap an existing app to use Hilt.

### Technology used
- Coroutine
- Moshi Converter
- Retrofit & Okhttp
- Hilt Dependency Injection
