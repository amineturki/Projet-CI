
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
		        stage('Git') {
           steps {
		echo "Getting project from Git";
                git "https://github.com/amineturki/Projet-CI.git";
            }
	}
		stage('SonarQube test') {
			steps {
				sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=louay"

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
