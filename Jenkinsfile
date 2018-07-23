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
        withCredentials([file(credentialsId: 'docker', variable: 'dockerhub')]) {
          sh "docker login -u temus -p ${dockerhub}"
        }

        sh 'docker push temus/load-balancer:1.0'
      }
}