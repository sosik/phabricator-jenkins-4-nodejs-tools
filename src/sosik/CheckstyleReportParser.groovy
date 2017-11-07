package sosik

class CheckstyleReportParser {
String filename

def parse() {

	def checkstyleReportFile = new File(filename)
	def workdir = new File('.')

    println("path: ${filename}, absolute: ${checkstyleReportFile.absolute}")

	if (!checkstyleReportFile.exists()) {
		println "File ${filename} does not exist"
		return
	}

	def checkstyleReport = new XmlSlurper().parse(checkstyleReportFile)

	int counter = 0
	def checkstyleResult = checkstyleReport.file.collect {

	String filename = it.@name.toString().drop(workdir.absolutePath.length() + 1)

	it.error.collect {[   
		name: it.@source.toString(),
		severity: it.@severity.toString(),
		code: it.@source.toString(),
		path: filename,
		line: it.@line?.toInteger() ?: 0,
		char: it.@column?.toInteger() ?: 0,
		description: it.@message.toString(),
	]}
	}.flatten().findAll {
		it
	}
}
}

