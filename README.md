serenity.properties

# Se automatizara con Chrome
webdriver.autodownload = true
webdriver.driver=chrome
webdriver.chrome.driver=chromedriver.exe
# Cada cuanto o en que momento quiero que se tomen evidencias
serenity.take.screenshots=FOR_EACH_ACTION
# Se configura la espera implicita
# Switches de Chrome - configuraciones de ejecucion
chrome.switches = --start-maximized --disable-notifications --disable-popup-blocking --disable-infobars --remote-allow-origins=*
#chrome.capabilities.supportsAlerts  = false
chrome.capabilities.unexpectedAlertBehaviour = ignore
serenity.outputDirectory = target/site/serenity
systemProp.file.encoding=utf-8

build.gradle
apply plugin: 'java-library'
apply plugin: 'net.serenity-bdd.aggregator'

repositories {
    mavenLocal()
    mavenCentral()
}

buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "net.serenity-bdd:serenity-gradle-plugin:${gradlePlugin}"
    }
}
compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"
dependencies {
    implementation "net.serenity-bdd:serenity-core:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-junit:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}"
    implementation "net.serenity-bdd:serenity-cucumber:${serenityCoreVersion}"
    implementation "org.assertj:assertj-core:${serenityCoreVersion}"
    implementation "org.apache.poi:poi:${poi}"
    implementation "org.apache.poi:poi-ooxml:${poi}"
    implementation "org.slf4j:slf4j-simple:${slf4jVersion}"
    implementation "net.serenity-bdd:serenity-ensure:${Ensure}"
    implementation "org.slf4j:slf4j-nop:${slf4}"
    implementation 'io.rest-assured:rest-assured:5.2.0'
    implementation 'org.json:json:20210307'
    testImplementation("io.rest-assured:rest-assured:5.3.0")
    implementation 'net.serenity-bdd:serenity-screenplay-rest:3.6.0'
    testImplementation("io.github.bonigarcia:webdrivermanager:${bonigarcia}")
    implementation group: 'com.sikulix', name: 'sikulixapi', version: '2.0.5'
    implementation fileTree (dir: 'libs/sikulix', include: 'sikulixapi-2.0.5.jar')
    testImplementation group: 'org.sikuli', name: 'sikuli-core', version: '1.2.2'

}


test {
    useJUnit {
        include "**/*";
        gradle.startParameter.continueOnFailure = true
        testLogging.showStandardStreams = true
        systemProperties System.getProperties()
        systemProperty "cucumber.filter.tags", System.getProperty("cucumber.filter.tags")
    }
    finalizedBy 'aggregate'
}


gradle.properties

serenityCoreVersion=3.7.1
poi=4.1.1
slf4jVersion=2.0.0-alpha5
Ensure=3.7.1
serenityGradle=3.2.0
slf4=2.0.7
bonigarcia=5.7.0
gradlePlugin=3.2.0


runner
package com.coeasy.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/EjecucionTodosLosMicros.feature",
        //tags = "@Get",
        glue = "com.coeasy.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}




stepdefintions (before)
@Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }
