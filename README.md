# Android Jetpack
Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.[(more)](https://developer.android.com/jetpack/?gclid=CjwKCAjw8MD7BRArEiwAGZsrBcWWPlbqOVdetcKYhpKiDONWNEccFtASkfuCydKnrWjNhUFhwOVwYxoCH24QAvD_BwE&gclsrc=aw.ds "(more)")

## Room
The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.([Guide](https://developer.android.com/topic/libraries/architecture/room?gclid=CjwKCAjw8MD7BRArEiwAGZsrBezbhFbt_rq_AWHuENJ9VnCwZaeWnRyvgpOi1pN3S_g-9T_aN6hmaxoCF6kQAvD_BwE&gclsrc=aw.ds "Guide"))

## ViewModel
The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations. ([Guide](https://developer.android.com/topic/libraries/architecture/viewmodel "Guide"))

## LiveData
LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.([Guide](https://developer.android.com/topic/libraries/architecture/livedata "Guide"))

## Navigation
Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer. The Navigation component also ensures a consistent and predictable user experience by adhering to an established set of principles.([Guide](https://developer.android.com/guide/navigation "Guide"))

# Architecture overview
- /**data** (manage local data SQLite data source using objects)
- /**fragment** (UI of our app)
- /**model** (store the entities schema)
- /**repository** (clean API for UI to communicate with)
- /**viewmodel** (holds all the date needed for the UI)

# License
Slink android is distributed under the MIT License. 
Copyright (c) 2020 Rizke Aymane.

