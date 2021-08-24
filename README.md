# Description

Github Android client app that gets data from a Github API and shows user repositories.

# List to Detail screen

![Github Android Client Demo](https://github.com/burakkarabekir/IngCase/tree/master/intro/demo.gif)

## Development

### API Key

To run the application you need to supply an API key from [Github](https://github.com/settings/tokens). When you get the key please add following variable to your local environment.

# API

https://api.github.com/

### User Repositories (GET)

https://api.github.com/users/{user}/repos

## Architecture

- Single Activity
- MVVM Pattern

**View:** Renders UI and delegates user actions to ViewModel

**ViewModel:** Can have simple UI logic but most of the time just gets the data from UseCase

**UseCase:** Contains all business rules and they written in the manner of single responsibility principle

**Repository:** Single source of data. Responsible to get data from one or more data sources

## Tech Stack

#### Dependencies

- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Jetpack Compose is Android’s modern toolkit for building native UI.
- **[LiveData](https://developer.android.com/kotlin/flow):** An asynchronous data stream that sequentially emits values and completes
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** Holds UI data across configuration changes
- **[Hilt](https://github.com/google/dagger):** Dependency injector
- **[Coroutines](https://github.com/Kotlin/kotlinx.coroutines):** Asynchronous programming
- **[Coil](https://coil-kt.github.io/coil/):** An image loading library for Android backed by Kotlin Coroutines.
- **[Retrofit](https://github.com/square/retrofit):** Type safe HTTP client
- **[Room](https://developer.android.com/topic/libraries/architecture/room):** Object mapping for SQLite












