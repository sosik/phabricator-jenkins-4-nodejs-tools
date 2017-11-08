def call(String filename, Boolean debug = false, Closure body = null) {
	def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

	debug && echo "${filename}"
/*	def wd = config.pwd ? new File(config.pwd) : new File('.')
	def file = new File(wd, config.filename)

	echo "File to parse ${file.absolutePath}, WD ${wd.absolutePath}"
*/
}
