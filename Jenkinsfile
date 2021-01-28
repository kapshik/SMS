pipeline {
  agent {
    docker {
      image 'node:6-alpine'
      args '-p 3000:3000'
    }

  }
  stages {
    stage('Pull') {
      steps {
        sh 'git branch:\'ForTMC\', url:\'https://github.com/kapshik/SMS.git\''
      }
    }

    stage('Build') {
      steps {
        sh 'mvn install -f Source/pom.xml'
      }
    }

    stage('Deploy') {
      steps {
        sh 'chmod 755 Batch/*.sh'
      }
    }

    stage('Start SmsApp') {
      steps {
        sh 'Batch/StartSmsApp_HTTP_Jenkins.sh'
      }
    }

  }
}