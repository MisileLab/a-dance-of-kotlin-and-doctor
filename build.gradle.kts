import com.soywiz.korge.gradle.korge

repositories {
    mavenCentral()
}
val kotestVersion = "4.6.1"

plugins {
    java
}

dependencies {
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven { url = uri("https://dl.bintray.com/korlibs/korlibs") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://oss.jfrog.org/simple/libs-snapshot") }
    }
    dependencies {
        classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:2.4.1")
        classpath("com.soywiz.korlibs.korau:korau:2.4.1")
        classpath("be.bluexin:drpc4k:0.9")
    }
}

apply<com.soywiz.korge.gradle.KorgeGradlePlugin>()

korge {
    id = "com.misilelab.projects1.games.adokad"
    targetJs()
    targetJvm()
    targetAndroid()
    targetIos()
    targetDesktop()
}
