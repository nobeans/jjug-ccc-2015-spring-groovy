def generateHtml = { data, writer ->
  def reportTitle = '試験実施日時報告'
  def formatCount = { now, latest ->
    def diffCount = now - latest
    return "${now} (${diffCount > 0 ? "+" : ""}${diffCount})"
  }
  new groovy.xml.MarkupBuilder(writer).html {
    head {
      title reportTitle
    }
    body(style: "background: #afa") {
      h1 reportTitle
      h2 '試験件数等'
      ul {
        li "試験項目数: ${formatCount(data.tests, data.latest.tests)}"
        li "終了件数: ${formatCount(data.done, data.latest.done)}"
        li "バグ件数: ${formatCount(data.issues, data.latest.issues)}"
      }
      h2 '備考'
      if (data.remarks) {
        ul {
          data.remarks.each {
            li(it)
  } } } } }
}

def data = [
  tests: 1230, done:   350, issues: 123,
  latest: [tests: 1235, done:   320, issues: 93],
  remarks: ["進捗は特に問題なし", "インフルエンザが流行中なので不安"]
]
new File("daily-test-report.html").withWriter { writer ->
  generateHtml(data, writer)
}
