def call(String filename, Map options = [:]) {
	def opts = [
		debug: false
	] + options

	def f = new File(filename)
	def wd = new File(pwd())

	println "GGGG"
	f = f.absolute ?: new File(wd, filename)

	println "GGGG"
	if (!f.exists()) {
		if (opts.debug) {println "checkstyle file ${f.absolutePath} does not exist, skipping..."}
		return
	}

	println "GGGG"
	def r = new XmlSlurper().parse(f)
	def reportMap = r.file.collect {
		// get relative filename
		String relFilename = it.@name.toString().drop(wd.absolutePath.length() + 1)
		it.error.collect {[   
			name: it.@source.toString(),
			severity: it.@severity.toString(),
			code: it.@source.toString(),
			path: relFilename,
			line: it.@line?.toInteger() ?: 0,
			char: it.@column?.toInteger() ?: 0,
			description: it.@message.toString(),
		]}
	}.flatten().findAll {
		it
	}
	println "FFFFF"
	if (opts.debug) { println "${reportMap}"}
}
