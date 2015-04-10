@Grab('org.jsoup:jsoup:1.8.1')
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

Document doc = Jsoup.connect("http://groovy-lang.org/").get()

def urls = doc
    // すべてのaタグのhref属性を集める
    .select('a')*.attr("href")
    // http(s)のものだけ抽出する
    .findAll { 
        it ==~ /https?:.*/
    }
    // 重複したURLを除去する
    .unique()

// ソートして表示する
urls.sort().each { println it }
