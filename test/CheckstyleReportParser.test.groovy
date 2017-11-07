
def parser = new sosik.CheckstyleReportParser([filename: 'test/checkstyle.xml'])

def lint =  parser.parse()


def cc = new sosik.ConduitClient([token: 'aaa', debug: true])

cc.sendLint(lint, 'xxx')
