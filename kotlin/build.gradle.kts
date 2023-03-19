import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.7.10"
  application
}

group = "org.kotlin.dojo"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

object Versions {
  const val kotlinCoroutines = "1.6.4"
  const val junit = "5.9.0"
  const val junitSuiteEngine = "1.9.0"
  const val kluent = "1.68"
  const val mockk = "1.12.7"
  const val gson = "2.9.1"
}

object Dependencies {
  val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}" }
  val kluent by lazy { "org.amshove.kluent:kluent:${Versions.kluent}" }
  val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
  val junit by lazy { "org.junit.jupiter:junit-jupiter:${Versions.junit}" }
  val junitSuiteEngine by lazy { "org.junit.platform:junit-platform-suite-engine:${Versions.junitSuiteEngine}" }
  val kotlinBom by lazy { "org.jetbrains.kotlin:kotlin-bom" }
  val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
}

dependencies {
  implementation(platform(Dependencies.kotlinBom))
  implementation(kotlin("stdlib-jdk8"))
  implementation(Dependencies.kotlinCoroutines)
  implementation(Dependencies.junit)
  implementation(Dependencies.gson)
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")

  testImplementation(kotlin("test"))
  testImplementation(Dependencies.kluent)
  testImplementation(Dependencies.mockk)
  testImplementation(Dependencies.junitSuiteEngine)
}

tasks.test {
  useJUnitPlatform()
}
//
//configure<JavaPluginExtension> {
//  sourceCompatibility = JavaVersion.VERSION_11
//}

tasks.withType<KotlinCompile>() {
  kotlinOptions.jvmTarget = "11"
}