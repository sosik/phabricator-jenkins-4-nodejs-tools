def call(String filename, Map options = [:]) {
	def opt = [
		debug: false
	] + options

	def f = new File(filename)
	def wd = new File(pwd())

	f = f.absolute ?: new File(wd, filename)

	if (!f.exists()) {
		if (opts.debug) {println "checkstyle file does not exist, skipping..."}
		return
	}

	def r = new XmlSlurper().parse(f)
	def reportMap = r.file.collect {
		// get relative filename
		String filename = it.@name.toString().drop(wd.absolutePath.length() + 1)
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

	if (opt.debug) { println "${reportMap}"}
}
