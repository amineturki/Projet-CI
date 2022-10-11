
pipeline {

	agent any

	stages {

		stage('Testing pass - 1') {
			steps {
				sh 'exit 0'
			}
		}
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
		stage('unit test') {
			steps {
				sh "mvn clean verify sonar:sonar \
  -Dsonar.projectKey=projet-ci \
  -Dsonar.host.url=http://4.236.128.114:9000 \
  -Dsonar.login=sqp_2e031efe1cb6e283102953b33ae4e4cb8018d62c "

			}
		}  

		}  

	}
