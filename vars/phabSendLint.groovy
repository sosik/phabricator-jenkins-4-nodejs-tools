def call(String filename, Map options = [:]) {
	def opt = [
		debug: false
	] + options

	try {
		def f = new File(filename)
		def wd = new File(pwd())

		f = f.absolute ?: new File(wd, filename)
		echo "${f.absolutePath}"
		println "aaa"
	} catch(e) {
		println e
	}
}
