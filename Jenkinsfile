pipeline {
  agent any
  stages {
    stage('run project') {
      parallel {
        stage('run project') {
          steps {
            bat 'mvn clean test'
          }
        }

        stage('maven version') {
          steps {
            bat 'mvn -v'
          }
        }

      }
    }

    stage('generate allure') {
      steps {
        script {
          stage('Generate Allure Report') {
            steps {
              run arbitrary pipeline script: 'allure-generate'
            }
          }

          stage('Upload Allure Report') {
            steps {
              archiveArtifacts artifacts: 'allure-results/**'
            }
          }
        }

      }
    }

  }
}