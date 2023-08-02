pipeline {
  agent any
  stages {
  stage('git repo') {
    steps {
      git poll: false, url: 'https://github.com/Krk098789/CucumberAPI.git'
      git changelog: false, poll: false, url: 'https://github.com/Krk098789/ParaBank.git'
      bat "mvn clean -f CucumberAPI"
    }
  }
  stage ('install') {
    steps {
      bat "mvn install -f ParaBank"
    }
  }
  stage ('test') {
    steps {
      bat "mvn test-f ParaBank"
    }
  }
  stage('package') {
    steps {
      bat "mvn package -f ParaBank"
    }
    }
        }
}
