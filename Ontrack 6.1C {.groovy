pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the code using Maven...'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit and integration tests using Selenium'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Analysing the code through the following code analysis tools: SonarQube, CodeClimate, Synk Code'
                echo 'SonarQube running'
                echo 'CodeClimate running'
                echo 'Synk Code running'
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan through ESET Endpoint Security'
                echo 'Security scan is underway'
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying the application to staging server: Github-Jenkins Testplane '
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging server: Github-Jenkins Testplane '
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying the application to production server: Github-Jenkins  '
            }
        }
    }

    post {
        success {
            emailext subject: "Pipeline Status: SUCCESS",
                      body: "The pipeline finished successfully.",
                      to: "kyle.shailen3@gmail.com",
                      attachmentsPattern: "**/*"
        }
        failure {
            emailext subject: "Pipeline Status: FAILURE",
                      body: "The pipeline finished with failure.",
                      to: "kyle.shailen3@gmail.com",
                      attachmentsPattern: "**/*"
        }
    }
}
