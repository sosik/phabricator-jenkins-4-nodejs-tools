def call(Boolean debug = false, String filename) {
	def f = new File(filename)
	def wd = new File(pwd())

	f = f.absolute ?: new File(wd, filename)

	echo "${f.absolutePath}"
}
