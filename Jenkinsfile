node {
          stage('Branch Checkout'){
            git branch: 'stock-service', url: 'https://github.com/mTemus/Project-Microservice'
          }


          stage('Building maven Package'){
            def mvnHome = tool name: 'maven-3', type: 'maven'
            def mvnCMD = "${mvnHome}/bin/mvn"
            sh "${mvnCMD} clean install"
          }


          stage('Building docker Image'){
            sh 'docker build -t temus/stock-service:latest -t temus/stock-service:1.0 .'
          }

          stage('Pushing docker Image'){
            withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
              sh "docker login -u temus -p ${dockerHubPwd}"
            }
            sh 'docker push temus/stock-service:latest'
          }
           stage('Building docker Container'){
             sh 'docker run --name stock-service --network host -d temus/stock-service:latest'
           }
    }