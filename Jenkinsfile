pipeline {
    agent any
    environment {
        branch = 'master'
        scmUrl = 'https://github.com/iamrameshtk/SampleApp.git'
        serverPort = '8080'
        }
    stages {
        stage('checkout git') {
            steps {
                git branch: branch, credentialsId: 'GitCredentials', url: scmUrl
            }
        }
   stage('build') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
    post {
        failure {
            mail to: 'rameshkasinath08@gmail.com', subject: 'Pipeline failed', body: "${env.BUILD_URL}"
         }
        }
    }
}
