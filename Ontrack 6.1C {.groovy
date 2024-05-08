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
                echo 'SonarQube'
                echo 'CodeClimate'
                echo 'Synk Code'
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
            echo 'Sending success notification email...'
        }
        failure {
            echo 'Sending failure notification email...'
        }
    }
}
