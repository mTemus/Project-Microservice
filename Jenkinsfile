node {

      stage('Branch Checkout'){
        git branch: 'load-balancer', url: 'https://github.com/mTemus/Project-Microservice'
      }


      stage('Maven Package'){
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvn CMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean install"
      }
}