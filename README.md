# QuickLib [![CircleCI (all branches)](https://img.shields.io/circleci/project/github/QuickGlare/QuickLib.svg)](https://circleci.com/gh/QuickGlare/QuickLib)

How to include QuickLib in your project:

## Maven

```xml
  <repository>
	  <id>jitpack.io</id>
	  <url>https://jitpack.io</url>
  </repository>
  <dependency>
	  <groupId>com.github.QuickGlare</groupId>
	  <artifactId>QuickLib</artifactId>
	  <version>VERSION YOU ARE USING</version>
  </dependency>
```

## Gradle
```groovy
  repositories {
	maven {
	  url 'https://jitpack.io' 
	}
  }
  
  dependencies {
    implementation 'com.github.QuickGlare:QuickLib:VERSION YOU ARE USING'
  }
```

## TO-DO List
* Configurations API (JSON and YAML) - **WIP**
* Messages - **WIP**
* Logs
* Commands API - **WIP**
* Title and ActionBar - **WIP**
* Actions (for menus) 
* Menus
* Scoreboard
