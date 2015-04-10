String html = new URL("http://groovy-lang.org/").text
//println html

// 1行ずつチェックしてURLをパースする
def urls = html
    // 1行ずつのリストにする
    .readLines()
    // 行中にURLパターンがあったらそれを返す（なければnull）
    .collect { line ->
        if (line =~ $/.*(https?://[a-zA-Z0-9%?._]+).*/$) {
            return java.util.regex.Matcher.lastMatcher.group(1)
        }
    }
    // nullを除外する
    .findAll { it != null }
    // 重複したURLを除去する
    .unique()

// ソートして表示する
urls.sort().each { println it }
