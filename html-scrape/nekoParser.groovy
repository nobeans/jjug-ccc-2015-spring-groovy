@Grab('net.sourceforge.nekohtml:nekohtml:1.9.21')
import org.cyberneko.html.parsers.SAXParser
import groovy.util.Node

def parser = new XmlParser(new SAXParser())

Node html = parser.parse("http://groovy-lang.org/")

// 1行ずつチェックしてURLをパースする
def urls = html
    // html配下のすべての子要素のaタグのhref属性値を集める
    .'**'.A.@href
    // http(s)のものだけ抽出する
    .findAll { 
        it ==~ /https?:.*/
    }
    // 重複したURLを除去する
    .unique()

// ソートして表示する
urls.sort().each { println it }
