pipeline {
    agent any

    tools {
        // Install the Maven version configured as "Maven" and add it to the path.
        maven "Maven"
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/qvu3/jen-dock.git']])

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t sonvu51092/svtodo-1.0-snapshot .'
                }
            }
        }
        stage('Push Image To Docker Hub'){
            steps{
                script{
                    // log into Docker
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u sonvu51092 -p ${dockerhubpwd}'
                    }
                    sh 'docker push sonvu51092/svtodo-1.0-snapshot'
                }
            }
        }
    }
}
