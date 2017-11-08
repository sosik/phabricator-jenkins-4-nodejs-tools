def call(String filename, Boolean debug = false) {
	def f = new File(filename)
	def wd = new File(pwd())

	f = f.absolute ?: new File(wd, filename)

	echo "${f.absolutePath}"
}
