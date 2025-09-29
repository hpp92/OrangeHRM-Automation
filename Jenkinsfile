pipeline {
    agent any

    tools {
        maven 'Maven3'   // Configure Maven in Jenkins (Global Tool Configuration)
        jdk 'JDK11'      // Configure JDK in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone your GitHub repo
                git branch: 'main',
                    credentialsId: 'your-github-credentials-id',
                    url: 'https://github.com/hpp92/OrangeHRM-Automation.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and build project
                sh 'mvn clean install -DskipTests=true'
            }
        }

        stage('Test') {
            steps {
                // Run TestNG tests
                sh 'mvn test'
            }
        }

        stage('Publish Report') {
            steps {
                // Archive ExtentReports or Allure reports
                publishHTML(target: [
                    reportDir: 'test-output',      // adjust path if needed
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            // Archive logs & screenshots even if test fails
            archiveArtifacts artifacts: '**/screenshots/*.png', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
