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
        bat 'cmd /c start allure generate'
      }
    }

  }
}