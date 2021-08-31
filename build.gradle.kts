import com.soywiz.korge.gradle.korge

plugins {
    java
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven { url = uri("https://dl.bintray.com/korlibs/korlibs") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:2.3.3")
        classpath("com.soywiz.korlibs.korau:korau:2.3.3")
    }
}

apply<com.soywiz.korge.gradle.KorgeGradlePlugin>()

korge {
    id = "com.misilelab.projects1.games.adokad"
    name = "a dance of kotlin and doctor"
    icon = File("logo.png")
    targetJs()
    targetJvm()
    targetAndroid()
    targetIos()
    targetDesktop()
}
