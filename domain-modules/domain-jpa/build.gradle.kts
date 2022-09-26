plugins {
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

dependencies {
    implementation(project(":domain-modules:user-domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    runtimeOnly("org.postgresql:postgresql")
}

