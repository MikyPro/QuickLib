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
	  <version>VERSION ARE YOU USING<version>
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
    implementation 'com.github.QuickGlare:QuickLib:VERSION ARE YOU USING'
  }
```

## TO-DO List
* Configurations API(JSON and YAML)
* Messages
* Logs
* Commands API
* Title and ActionBar
* Actions(for menus) 
* Menus
* Scoreboard
