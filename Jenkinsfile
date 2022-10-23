
pipeline {

	agent any

	stages {
		
		stage('Junit Test  ') {
			steps {
				sh 'mvn clean install'  } 
		
		stage('Build Artifact') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive'target/*.jar'
			}
		}
		stage('SonarQube test') {
			steps {
				sh "mvn clean install"
				sh "mvn  sonar:sonar -Dsonar.projectKey=Sonaryoussef -Dsonar.host.url=http://youssefbc.westus3.cloudapp.azure.com:9000 -Dsonar.login=sqp_5a107f624ccb89b84c8dc14a0b891211145303e0"

			}
			
		} 
		
		
     stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t youssef1998/spring-app:""$GIT_COMMIT"" .'
           sh 'docker push youssef1998/spring-app:""$GIT_COMMIT""'
         }
       }
     }
		 /*stage('Nexus') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}*/
			

	}  

}
