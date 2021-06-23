# Breweries
An Android application which will get the list of breweries https://api.openbrewerydb.org

The app is built with Kotlin and mvvm architecture. It also features dependency injection via koin and networking with retrofit. Room is used for the database.

## Getting Started
1. Download and install android studio

2. Clone the repo:
- `https://github.com/farooqkazi/Breweries2021`

3. Sync gradle

4. Run the app on an emulator or device

# Architecture
- The app was built with an mvvm architecture. 
- This keeps UI code simple and free of app logic in order to make it easier to manage and test. 
- An RX mindset was used to keep the app scalable going forward. 
- Dependency injection was done via koin so that components can be tested independently without strong references.
- For networking I used retrofit, a strong yet light-weight client.
- To manage data between the screens a room database was used. This keeps the data synced between screens.
