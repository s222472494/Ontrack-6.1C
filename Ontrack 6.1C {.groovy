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

            post {
                success {
                    mail to: "kyle.shailen3@gmail.com",
                        subject: "Security Scan Email",
                        body: "The security scan has been passed and the build is all good to continue."
                }
                failure {
                    mail to: "kyle.shailen3@gmail.com",
                        subject: "Security Scan Email",
                        body: "The security scan has failed, hence we need to go back and reconfigure."
                }
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

        post {
            success {
                mail to: "kyle.shailen3@gmail.com",
                    subject: "Build Status Email",
                    body: "The build was successful, the logs are attached below:"
            }
            failure {
                mail to: "kyle.shailen3@gmail.com",
                    subject: "Build Status Email",
                    body: "The build has unfortunately failed"
            }
        }
    }
}
