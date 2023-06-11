pipeline {
    agent any
    tools {
        maven 'Maven 3.9.2'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/NguyenCongTam1807/springboot-cicd']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker image') {
            steps {
                script {
                    def workspaceDir = pwd()
                    bat "docker build -t java ${workspaceDir}"
                    bat "docker tag java nctam1807/devops-integration"
                }

            }
        }
        stage('Push Image to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'password')]) {
                        bat "docker login -u nctam1807 -p $password"
                        bat 'docker push nctam1807/devops-integration'
                    }
                }

            }
        }
    }
}