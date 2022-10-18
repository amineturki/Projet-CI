
pipeline {

	agent any

	stages {
		
		stage('Git') {
            steps {
                echo 'Pulliing ...';
                git branch: 'hazem', credentialsId: 'git', url: 'https://github.com/amineturki/Projet-CI.git'            }
        }
		
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
			

		}  
		 stage('Nexus') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		} 
		
		
				
	}  
	post {
				success {

					//jacoco execPattern: 'target/jacoco.exec'
					
						emailext attachLog: true, body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:Check console output at $BUILD_URL to view the results.', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', to: 'hazem.tahri@esprit.tn'
				}    
						failure {
						emailext attachLog: true, body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:Check console output at $BUILD_URL to view the results.', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', to: 'hazem.tahri@esprit.tn'
				} 
				//}
		}

}
