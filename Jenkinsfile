node {

          stage('Branch Checkout'){
            git branch: 'load-balancer', url: 'https://github.com/mTemus/Project-Microservice'
          }


          stage('Building maven Package'){
            def mvnHome = tool name: 'maven-3', type: 'maven'
            def mvnCMD = "${mvnHome}/bin/mvn"
            sh "${mvnCMD} clean install"
          }


          stage('Building docker Image'){
            sh 'docker build -t temus/load-balancer:latest -t temus/load-balancer:1.0 .'
          }

          stage('Pushing docker Image'){
            withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
              sh "docker login -u temus -p ${dockerHubPwd}"
            }
            sh 'docker push temus/load-balancer:latest'
          }

          stage('Building docker Container'){
            sh 'docker run --name load-balancer --network host -d temus/load-balancer:latest'
          }

    }