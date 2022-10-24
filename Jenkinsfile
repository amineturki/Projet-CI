
pipeline {

	agent any

	stages {
		
		stage('git') {
            steps {
               
                git branch: 'hazem', credentialsId: 'git', url: 'https://github.com/amineturki/Projet-CI.git'            }
        }
		
		/*stage('Junit Test') {
			steps {
				sh 'mvn test'
			} 
		}

	 		stage('SonarQube SAST') {
			steps {
				sh "mvn clean install"
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://20.172.244.255:9000  -Dsonar.login=sqp_8e13e986844b5af5ad1a29d7218362c749cef201"

			}
			

		} */

		stage('Maven Build') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			}
		}
	 
		 stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hubb", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t hazemtahri/spring-ci:latest .'
           sh 'docker push hazemtahri/spring-ci:latest '
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
		       sh 'sleep 10m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }
		/* stage('Nexus Deploy JAR') {
			steps {
				
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		} 
		
		
				
	}  
	post {
				success {

					
					
						emailext attachLog: true, body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:Check console output at $BUILD_URL to view the results.', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', to: 'hazem.tahri@esprit.tn'
				}    
						failure {
						emailext attachLog: true, body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:Check console output at $BUILD_URL to view the results.', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', to: 'hazem.tahri@esprit.tn'
				} 
				//}
		}*/

}
}
