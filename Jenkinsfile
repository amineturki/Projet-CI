
pipeline {

	agent any

	stages {
		
		stage('Junit Test') {
			steps {
				sh 'mvn test'
			} 
		}

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
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=6fd3770c23232ce307ff694b0710fbc7c9b5517d"

			}
		        post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				}    
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
