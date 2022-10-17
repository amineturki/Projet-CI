
pipeline {

	agent any

	stages {
		
		stage('Junit Test') {
			steps {
				sh 'mvn test'
			} 
		}

		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			}
		}
		stage('SonarQube test') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar "

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
