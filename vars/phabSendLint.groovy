def call(String filename, Map options = [:]) {
	def opt = [
		debug: false
	] + options

	def f = new File(filename)
	def wd = new File(pwd())

	f = f.absolute ?: new File(wd, filename)

	!opt.debug ?: echo "${f.absolutePath}"
}
