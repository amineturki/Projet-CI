//@Library('slack') _

pipeline {

	agent any

	stages {
		
		stage('Git ') {
            steps {
                echo 'pulling Main Project from git ...';
                git branch: 'amine', credentialsId: 'git', url: 'https://github.com/amineturki/Projet-CI.git'            }
        }
		
		/* stage('Junit Test') {
			steps {
				sh 'mvn test'
			} 
		} */

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
	/*	stage('SonarQube Test') {
			steps {
				sh"mvn clean install"
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://4.236.128.114:9000  -Dsonar.login=sqp_2e031efe1cb6e283102953b33ae4e4cb8018d62c"

			}
			post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				}    
			} 

		}  
	stage('deploy jar to Nexus ?') {
       steps {
         timeout(time: 2, unit: 'DAYS') {
           input 'Do you want to Approve the jar file Nexus'
         }
       }
     }   
	stage('Nexus') {
			steps {				
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			        }
	                } 
		
	}  */
		
		
		 stage('Vulnerability Scan - Docker') {
       steps {
         parallel(
         	"Dependency Scan": {
         		sh "mvn dependency-check:check"
	 		},
	 		"Trivy Scan":{
	 			sh "bash trivy-docker-image-scan.sh"
	 		}   	
       	)
       }
     }  
		
		        stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t amineturki/ci:latest .'
           sh 'docker push amineturki/ci:latest '
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
		       sh 'sleep 2m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }
	 
		
	}
		
		post {
			
			  always {
           
	       dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
	       //publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'owasp-zap-report', reportFiles: 'zap_report.html', reportName: 'Owasp zap HTML Report', reportTitles: 'Owasp zap HTML Report', useWrapperFileDirectly: true])
	      
		  //   sendNotification currentBuild.result
           }
			
				success {

					echo "passed"
				}    
			       failure {
				       echo "failed"
				
		                }
		}


}
