import org.jetbrains.intellij.tasks.RunIdeTask

plugins {
  application
  id("org.jetbrains.intellij") version "0.3.5" apply true
}

application {
  mainClassName = "org.matsim.gui.MATSimGUI"
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_7
  targetCompatibility = JavaVersion.VERSION_1_7
}

repositories {
  maven {
    setUrl("http://download.osgeo.org/webdav/geotools/")
  }
  jcenter()
  maven {
    setUrl("https://dl.bintray.com/matsim/matsim")
  }

  maven {
    setUrl("http://repo.boundlessgeo.com/main")
  }
}

dependencies {
  testCompile("junit:junit:4.12")
  compile("org.matsim:matsim:0.10.0")
  compile("javax.media.jai:com.springsource.javax.media.jai.core:1.1.3")
}

tasks {
  withType<RunIdeTask> {
    args = listOf(projectDir.absolutePath)
  }
}

intellij {
  pluginName = "AceJump"
  updateSinceUntilBuild = false
}

group = "org.duckietown"
version = "0.1"
