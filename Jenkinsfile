#!groovy

/*
    CREDENCIALES NECESARIAS
    - SonarQube     (Token de acceso)
    - Github        (Usuario y clave)
    - DockerHub     (Usuario y clave)
    - Kubernetes    (Token del service account de Jenkins)

    HERRAMIENTAS NECESARIAS
    - Java 20
    - Docker 24.0.2 (Cualquier versión que soporte --password-stdin)
    - Maven 3.9.3
    - NodeJS 16.20.1

    PLUGINS NECESARIOS
    - Slack
    - Docker
    - Kubernetes
    - JUnit
    - EmailText

    CONSIDERACIONES
    * Se debe configurar como multibranch pipeline
    * Deben existir las ramas master y develop
    * Se debe configurar la cloud de kubernetes para el acceso al servidor
 */

def ARTIFACT_ID
def IDENTIFICADOR_PROYECTO
def IDENTIFICADOR_UNICO_BUILD
def RAMA_PARA_CLONAR

pipeline {
    agent any

    options {
        skipDefaultCheckout true
    }

    tools {

        maven "maven3.8.8"
        jdk 'java20' //cambiar
        dockerTool 'docker-2'
    //    nodejs 'node-js'
    
    }

    environment {

        HORA_DESPLIEGUE = sh(returnStdout: true, script: "date '+%A %W %Y %X'").trim()

        GITHUB_DESPLIEGUE_URL = "https://github.com/dim-desarrollo/backend-ubicacion-padrones.git"

        GITHUB_CREDENCIALES = "github"
        DOCKERHUB_CREDENCIALES = "dockerhub"
        KUBERNETES_CREDENCIALES = "k8s-jenkins-account-15"
        SONARQUBE_CREDENCIALES = 'sonarqube'

        CANAL_SLACK = "#canal-slack"            // TODO: Por reemplazar
        CORREO_A_NOTIFICAR = "dim@gmail.com"    // TODO: Por reemplazar

        CARPETA_APLICACION = './'
        //CARPETA_DESPLIEGUE = 'despliegue'

    }

    stages {
        stage('Tools initialization') {
            steps {
                script {
                    if (env.BRANCH_NAME){
                        RAMA_PARA_CLONAR = env.BRANCH_NAME
                    }
                    else{
                        RAMA_PARA_CLONAR = 'develop'
                    }

                    DOCKER_VERSION = sh(returnStdout: true, script: 'docker version')
                    JAVA_VERSION = sh(returnStdout: true, script: 'java -version')
                    MAVEN_VERSION = sh(returnStdout: true, script: 'mvn -v')
                    //NODEJS_VERSION = sh(returnStdout: true, script: 'npm -v')

                    sh "echo 'Hora despliegue: ${HORA_DESPLIEGUE}'"
                    sh "echo 'Docker version: ${DOCKER_VERSION}'"
                    sh "echo 'Java version: ${JAVA_VERSION}'"
                    sh "echo 'Maven version:  ${MAVEN_VERSION}'"
                    sh "echo 'Rama a clonar:  ${RAMA_PARA_CLONAR}'"
                }
            }
        }

        /* 

        stage('Git checkout') {
            steps{

                script {
                    checkout scmGit(branches: [[name: "${RAMA_PARA_CLONAR}"]], extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${CARPETA_APLICACION}"]], userRemoteConfigs: [[credentialsId: "${GITHUB_CREDENCIALES}", url: "${GITHUB_MONOLITO_URL}"]])
                }
            }
        }
        */

        stage('Build Maven') {
            steps {
                dir("${CARPETA_APLICACION}"){
                    script {
                        //PROYECTO_VERSION = sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout')
                        //ARTIFACT_ID = sh(script: "mvn help:evaluate -Dexpression=project.artifactId -f pom.xml -q -DforceStdout", returnStdout: true).trim()
                        //IDENTIFICADOR_PROYECTO = "${ARTIFACT_ID}:${PROYECTO_VERSION}"
                        //IDENTIFICADOR_UNICO_BUILD = "${IDENTIFICADOR_PROYECTO}.${BUILD_NUMBER}"

                        //sh "echo 'Versión Proyecto: ${PROYECTO_VERSION}'"
                        //sh "echo 'ArtifactID Proyecto: ${ARTIFACT_ID}'"
                        //sh "echo 'Identificador Proyecto: ${IDENTIFICADOR_PROYECTO}'"
                        //sh "echo 'Identificador Único Build: ${IDENTIFICADOR_UNICO_BUILD}'"

                        sh 'mvn clean package -DskipTests'
                    }
                }
            }
        }


        /* 
            stage('Test') {
                steps {
                    dir("${CARPETA_APLICACION}"){
                        sh 'mvn test'
                        sh 'mvn integration-test'
                    }
                }
            }

        */
        /* 

        stage('Build and push to DockerHub') {
            when{
                anyOf{
                    branch 'master'
                    branch 'develop'

                    expression{
                        return (RAMA_PARA_CLONAR == 'develop' || RAMA_PARA_CLONAR == 'master')
                    }
                }
            }
            steps {
                script {
                    dir ("${CARPETA_APLICACION}"){
                        // Verifica si existe un archivo Dockerfile en la subcarpeta actual
                        if (!fileExists("Dockerfile")) {
                            error "Dockerfile not found"
                        }

                        withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENCIALES}", usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {

                            // Construye la imagen de Docker usando el nombre y la versión obtenidos
                            sh "docker build -t \$DOCKERHUB_USERNAME/${IDENTIFICADOR_UNICO_BUILD} ."

                            // Sube la imagen a DockerHub
                            sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                            sh "docker push \$DOCKERHUB_USERNAME/${IDENTIFICADOR_UNICO_BUILD}"
                        }
                    }
                }
            }
        }

        */

    }


}
