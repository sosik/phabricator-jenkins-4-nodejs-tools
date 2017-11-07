package sosik

class ConduitClient {
String token
Boolean debug = false

def sendLint(def checkstyleResult, String buildPhid) {
	def msg = [
			buildTargetPHID: buildPhid,
			type: 'work',
			lint: checkstyleResult,
			__conduit__: [token: token]
		]
	String msgstr = groovy.json.JsonOutput.toJson(msg)
    msgstr = 'params=' + java.net.URLEncoder.encode(msgstr, 'UTF-8') + '&output=json&__conduit__=0'

	if (debug) { println(msgstr) }
} 
}
