# MYMEDI

MYMEDI is an Android medicine-management application built with Java in Android Studio.
This public repository contains only my approved contribution to a larger company project.

## Authorship Declaration

All source code, configuration files, and documentation included in this public repository were implemented and maintained by me individually.
No team member code is included in this repository snapshot.
Any missing parts belong to restricted company-owned systems that cannot be shared publicly due to policy.

## Important Scope Note

Due to company policy, I cannot publish the complete production codebase.

This repository intentionally includes only:
- Android client code that I am allowed to share
- UI flows and modules implemented by me
- Build setup and CI/CD workflow files related to my contribution

This repository does not include:
- company-private modules and internal services
- proprietary business logic
- production credentials, private endpoints, or sensitive data

## Features in This Public Version

- user authentication flows (`Login`, `SignUp`)
- pharmacy authentication flows (`PharmacyLogin`, `PharmacyRegister`)
- medicine listing, selection, and detail screens
- cart and place-order flow
- notes and reminder-related screens
- map/location integration for pharmacy-related use cases

## Tech Stack

- Language: Java
- Platform: Android
- Build system: Gradle
- Backend integration: Firebase Realtime Database
- Libraries: Material Components, RecyclerView, Glide, CardView
- Other integrations: Google Maps / Places API, Dexter

## Current Build Version

- App version: `1.0`
- Version code: `1`
- Compile SDK: `32`
- Minimum SDK: `26`
- Target SDK: `32`

## Project Structure

- `app/src/main/java/com/example/mymedi/` - Java source files
- `app/src/main/res/layout/` - XML layout files
- `app/src/main/res/drawable/` - drawable resources
- `app/src/main/AndroidManifest.xml` - manifest and activity declarations
- `app/build.gradle` - Android config and dependencies
- `.github/workflows/` - CI/CD workflows

## Build and Run (Android Studio)

### Prerequisites

- Android Studio (latest stable recommended)
- Android SDK 32 installed
- JDK 11 recommended
- emulator or physical Android device

### Setup Steps

1. Clone this repository.
2. Open the project in Android Studio.
3. Wait for Gradle sync to complete.
4. Use your own Firebase configuration file at `app/google-services.json` if needed.
5. Connect a device or start an emulator.
6. Click Run in Android Studio to launch the app.

### Build APK in Android Studio

1. Go to `Build`.
2. Select `Build Bundle(s) / APK(s)`.
3. Select `Build APK(s)`.
4. After success, use the notification link to open the APK output.

### Run Tests in Android Studio

1. Open `Run`.
2. Select `Run 'All Tests'`, or right-click `app/src/test` and run tests.

## CI/CD (GitHub Actions)

- `ci.yml`
  - triggers on push and pull request
  - runs unit tests
  - builds debug APK artifact

- `cd.yml`
  - triggers on tags like `v1.0.0`
  - builds release APK
  - publishes release artifact on GitHub Releases

## Security and Public Sharing Guidelines

- Do not commit API keys, secrets, or production configs.
- Use local config and CI secrets for sensitive values.
- Keep company-private logic and identifiers out of public commits.

## How To Describe This Project

For resume, portfolio, or interview use:
"This repository contains only the part of the Android healthcare application fully implemented by me. I built and maintained this public scope independently in Android Studio, while confidential company modules are excluded as required by policy."

## License

This repository is shared for portfolio/review purposes only. No permission is granted to reuse, modify, or distribute the code.
