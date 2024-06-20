plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(project(":domain"))
    implementation(libs.converter)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation (libs.retrofit)



}

//
//val ktor_version: String by project
//val kotlin_version: String by project
//val logback_version: String by project
//val exposed_version: String by project
//val h2_version: String by project
//val mySqlConnector_version: String by project
//
//plugins {
//    kotlin("jvm") version "1.9.24"
//    id("io.ktor.plugin") version "2.3.11"
//    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.24"
//    id("com.github.gmazzo.buildconfig") version "5.3.5"
//}
//
//group = "pfsz.ru"
//version = "0.0.1"
//
//application {
//    mainClass.set("pfsz.ru.ApplicationKt")
//
//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
//}
//
//repositories {
//    mavenCentral()
//}
//
//buildConfig {
//
//    buildConfigField<String>("sault", "\$5\$rounds=5000\$")
//    buildConfigField<String>("cryptKey", "q%$!{bK9];ll6i%t")
//    buildConfigField<String>("cipherInstanceTransform", "AES/ECB/PKCS5Padding")
//    buildConfigField<String>("cipherAlgorithm", "AES")
//}
//
//
//dependencies {
//
//    implementation("com.squareup.retrofit2:converter-gson:2.10.0")
//    implementation("com.squareup.okhttp3:okhttp:4.12.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
//    implementation ("com.squareup.retrofit2:retrofit:2.10.0")
//
//    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
//    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")
//    implementation("com.mysql:mysql-connector-j:$mySqlConnector_version")
//
//    implementation("ch.qos.logback:logback-classic:$logback_version")
//    implementation("org.slf4j:slf4j-api:2.0.9")
//    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
//
//
//    implementation("io.ktor:ktor-server-core-jvm")
//    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
//    implementation("io.ktor:ktor-server-content-negotiation-jvm")
//    implementation("io.ktor:ktor-serialization-gson-jvm")
//    implementation("io.ktor:ktor-server-netty-jvm")
//    implementation("ch.qos.logback:logback-classic:$logback_version")
//    testImplementation("io.ktor:ktor-server-tests-jvm")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
//}

