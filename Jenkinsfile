pipeline {
    agent any

    stages {
        stage('Staging build') {
            steps {
                echo 'stag env'
            }
        }
        
    }
    post{
        always{
            emailext body: 'Summary', subject: 'Pipeline status', to: 'haris.siddique311@gmail.com'
        }
    }
}
