def call(String filename, Boolean debug = false, Closure body = null) {
	def config = [:]

	try {
	if (body) {
    	body.resolveStrategy = Closure.DELEGATE_FIRST
	    body.delegate = config
    	body()
	}

	def f = new File(filename)
	def wd = new File(pwd())

	f = f.absolute ?: new File(wd, filename)
	} catch (e) {
		print e
	}
*/
}
