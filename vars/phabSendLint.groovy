def call(String filename, Boolean debug = false, Closure body = null) {
	def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

	!debug ?: echo "Filename: ${filename}"
	def f = new File(filename)
	def wd = new File(pwd())

	!debug ?: echo "${WD: ${wd.absolutePath}"
	f = f.absolute ?: new File(wd, filename)

	!debug ?: echo "${Final: ${f.absolutePath}"
	echo "File to parse ${file.absolutePath}, WD ${wd.absolutePath}"
*/
}
