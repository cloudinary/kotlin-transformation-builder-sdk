Cloudinary Kotlin Transformation Builder SDK
=========================
[![Build Status](https://api.travis-ci.com/cloudinary/cloudinary_kotlin.svg?branch=master)](https://app.travis-ci.com/github/cloudinary/cloudinary_kotlin)
## About
This is an internal Cloudinary SDK. The Cloudinary Kotlin-Transformation-Builder-SDK allows you to generate transformations for [Cloudinary_Kotlin](https://github.com/cloudinary/cloudinary_kotlin).

### Additional documentation
This Readme provides basic installation and usage information.
For the complete documentation, see the [Kotlin SDK Guide](https://cloudinary.com/documentation/kotlin_integration).

## Table of Contents
- [Key Features](#key-features)
- [Version Support](#Version-Support)
- [Installation](#installation)
- [Usage](#usage)
    - [Transform and Optimize Assets](#Transform-and-Optimize-Assets)

## Key Features
- [Transform](https://cloudinary.com/documentation/kotlin_media_transformations) and [optimize](https://cloudinary.com/documentation/kotlin_media_transformations#image_optimizations) assets.

## Version Support
| SDK Version   |  Kotlin Version  |
|---------------|------------------|
|      1.x      |       > 1.0      | 

## Installation
Add the SDK to your project as a dependency, we recommend using a build management tool such as Maven or Gradle to do this.

**Using Gradle**:

Add the Cloudinary Kotlin SDK to the dependencies section of your `build.gradle` file.

```
implementation 'com.cloudinary:kotlin-transformation-builder-sdk:1.2.0'
```

**Using Maven**:

Add the Cloudinary Kotlin SDK to the list of dependencies in your `pom.xml` file.
```xml
<dependency>
  <groupId>com.cloudinary</groupId>
  <artifactId>kotlin-transformation-builder-sdk</artifactId>
  <version>1.2.0</version>
  <type>pom</type>
</dependency>
```

## Usage
### Transform and Optimize Assets

```kotlin
// Create your transformation
val transformation = resize(Resize.fill {
  width(100)
  height(150)
})
```

This will output the following:
`c_fill,h_150,w_100`

## Contributions
See [contributing guidelines](/CONTRIBUTING.md).

## Get Help
If you run into an issue or have a question, you can either:
- [Open a Github issue](https://github.com/cloudinary/cloudinary_kotlin/issues) (for issues related to the SDK)
- [Open a support ticket](https://cloudinary.com/contact) (for issues related to your account)

## About Cloudinary
Cloudinary is a powerful media API for websites and mobile apps alike, Cloudinary enables developers to efficiently manage, transform, optimize, and deliver images and videos through multiple CDNs. Ultimately, viewers enjoy responsive and personalized visual-media experiences—irrespective of the viewing device.

## Additional Resources
- [Cloudinary Transformation and REST API References](https://cloudinary.com/documentation/cloudinary_references): Comprehensive references, including syntax and examples for all SDKs.
- [MediaJams.dev](https://mediajams.dev/): Bite-size use-case tutorials written by and for Cloudinary Developers
- [DevJams](https://www.youtube.com/playlist?list=PL8dVGjLA2oMr09amgERARsZyrOz_sPvqw): Cloudinary developer podcasts on YouTube.
- [Cloudinary Academy](https://training.cloudinary.com/): Free self-paced courses, instructor-led virtual courses, and on-site courses.
- [Code Explorers and Feature Demos](https://cloudinary.com/documentation/code_explorers_demos_index): A one-stop shop for all code explorers, Postman collections, and feature demos found in the docs.
- [Cloudinary Roadmap](https://cloudinary.com/roadmap): Your chance to follow, vote, or suggest what Cloudinary should develop next.
- [Cloudinary Facebook Community](https://www.facebook.com/groups/CloudinaryCommunity): Learn from and offer help to other Cloudinary developers.
- [Cloudinary Account Registration](https://cloudinary.com/users/register/free): Free Cloudinary account registration.
- [Cloudinary Website](https://cloudinary.com)

## Licence
Released under the MIT license.
