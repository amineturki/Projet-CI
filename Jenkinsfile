
pipeline {

	agent any

	stages {
		
		stage('Junit + Mockito Test') {
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
		       
		stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=faf5060f1fdac026b36edab0e340e8261b1a07cf"

			}
		        post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				       }    
			    } 

		 }  
		 stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 } 
		  stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: "https://hub.docker.com/"]) {
         			  sh 'printenv'
        			  sh 'docker build -t louay123/louaymed .'
	 			  sh 'docker tag louay123/louaymed louay123/louaymed:latest'
         			  sh 'docker push louay123/louaymed:latest'
         			}
     			  }
    		}

	}  

}
