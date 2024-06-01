pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
       }
}

dependencyResolutionManagement {
    this.repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()


        maven {
            url= uri( " 'https://jitpack.io ")
        } }
}

rootProject.name = "WallpapeApp"
include(":app")
