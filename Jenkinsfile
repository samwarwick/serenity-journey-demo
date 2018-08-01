node {
    def mvnHome
	def mvnArgs = env.MAVEN_ARGS ?: "-Dwebdriver.driver=chrome -Dchrome.switches=--headless"
	
    stage('Checkout') { 
        checkout scm
        mvnHome = tool 'M3'
    }
	
	stage('Smoke') {
		mvnArgs = "clean verify ${mvnArgs} -Dcucumber.options=\"--tags @smoke\""
		if (isUnix()) {
			sh "'${mvnHome}/bin/mvn' ${mvnArgs}"
		} else {
			bat "${mvnHome}\\bin\\mvn ${mvnArgs}"
		}
		publishHTML(target: [
			reportName : 'Smoke',
			reportDir:   'target/site/serenity',
			reportFiles: 'index.html',
			keepAll:     true,
			alwaysLinkToLastBuild: true,
			allowMissing: false
		])
    }
	
    stage('UI') {
		mvnArgs = "clean verify ${mvnArgs}"
		try {
			if (isUnix()) {
				sh "'${mvnHome}/bin/mvn' ${mvnArgs}"
			} else {
				bat "${mvnHome}\\bin\\mvn ${mvnArgs}"
			}
		} catch (err) {

		} finally {
				publishHTML(target: [
					reportName : 'UI',
					reportDir:   'target/site/serenity',
					reportFiles: 'index.html',
					keepAll:     true,
					alwaysLinkToLastBuild: true,
					allowMissing: false
			])
		}
    }
   
    stage('Results') {
        junit '**/target/failsafe-reports/TEST-*.xml'
    }  
}
