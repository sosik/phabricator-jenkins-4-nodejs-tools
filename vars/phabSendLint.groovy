def call(Closure body) {
	echo "xxx"
	def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

	echo "aaa"
/*	def wd = config.pwd ? new File(config.pwd) : new File('.')
	def file = new File(wd, config.filename)

	echo "File to parse ${file.absolutePath}, WD ${wd.absolutePath}"
*/
}
