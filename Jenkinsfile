pipeline {
    agent any
    tools{
        maven 'maven_3_9_4'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mimaraslan/devops-automation']]])
               sh 'mvn --version'
               sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                      sh 'docker build -t mimaraslan/devops-automation . '
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u mimaraslan -p ${dockerhubpwd}'
                    }
                   sh 'docker push mimaraslan/devops-automation'
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'k8sconfigpwd')
                }
            }

        }
    }
}