plugins {
    id("java")
    id("org.graalvm.buildtools.native") version "0.10.4"
    id("io.freefair.lombok") version "8.11"
}

group = "me.hermippus"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("stream-api-study")
            mainClass.set("me.hermippus.Main")
            buildArgs.addAll("-Ob", "--gc=G1")
        }
    }
}

tasks.withType(Jar::class) {
    manifest {
        attributes["Manifest-Version"] = "1.0"
        attributes["Main-Class"] = "me.hermippus.Main"
    }
}
