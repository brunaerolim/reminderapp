buildscript {

    repositories {
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20") }
}
plugins {
    id("com.android.application") version "8.1.4" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id ("com.google.dagger.hilt.android") version "2.49" apply false
}