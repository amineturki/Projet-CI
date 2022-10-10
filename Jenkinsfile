
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
				sh "echo "test" "

			}
		}  

		}  

	}
