
pipeline {

	agent any

	stages {
		
		/*stage('Junit Test  ') {
			steps {
				sh 'mvn test'  } 
		  }*/

	 	/* stage('Testing pass - 1') {
			steps {
				sh 'exit 0'
			}
		} */
		/*	stage('Testing fail - Error Stage') {
			steps {
				sh 'exit 1'
			}
		}  */

		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			}
		}
		stage('SonarQube test') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=Sonaryoussef -Dsonar.host.url=http://youssefbc.westus3.cloudapp.azure.com:9000 -Dsonar.login=sqp_5a107f624ccb89b84c8dc14a0b891211145303e0"

			}
			
		} 
		 stage('Nexus') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}

	}  

}
