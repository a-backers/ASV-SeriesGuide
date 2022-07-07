pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
//        mavenCentral()
        jcenter()
    }
}

// https://docs.gradle.org/current/userguide/dependency_management.html#sub:centralized-repository-declaration
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
//        mavenCentral()
        jcenter()
        // For debugdrawer and sonarqube
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

include(":api")
include(":billing")
include(":widgets")
include(":app")
