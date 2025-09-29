pipeline {
  agent any

  tools {
    maven 'Maven3'   // must match your Jenkins Maven installation name
    jdk 'JDK21'      // must match your Jenkins JDK installation name
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/hpp92/OrangeHRM-Automation.git'
      }
    }
    stage('Build & Test') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}
