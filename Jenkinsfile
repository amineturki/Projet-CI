
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
				sh "mvn clean install"
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://20.172.244.255:9000  -Dsonar.login=sqp_8e13e986844b5af5ad1a29d7218362c749cef201"

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
