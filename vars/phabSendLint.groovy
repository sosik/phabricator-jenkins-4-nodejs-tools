def call(String filename, Boolean debug = false, String pwd , body) {
	def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

	def wd = pwd ? new File(pwd) : new File('.')
	def file = new File(wd, filename)

	echo "File to parse ${file.absolutePath}, WD ${wd.absolutePath}"

}
