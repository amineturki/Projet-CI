
pipeline {

	agent any

	stages {
		

		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			}
		}
	/*	stage('Nexus') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}   */
		

			        stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t motazmezrani/ci:latest .'
           sh 'docker push motazmezrani/ci:latest '
         }
       }
     }
		
		
		 stage('Docker compose') {
       steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 1m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }


	}  

}
