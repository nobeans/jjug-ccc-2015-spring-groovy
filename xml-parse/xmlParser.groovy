def inputXml = """
<root>
  <items>
    <item id="1" name="あいうえお">OK</item>
    <item id="2" name="かきくけこ">NG</item>
    <item id="3" name="さしすせそ">OK</item>
  </items>
</root>
"""
def root = new XmlParser().parseText(inputXml) // <root>に対応するgroovy.util.Nodeオブジェクト

// すべてのitem要素をフォーマットして出力する
root.items.item.each { Node item ->
    println "${item.@id}: ${item.@name} => ${item.text()}"
}
//=> 1: あいうえお => OK
//   2: かきくけこ => NG
//   3: さしすせそ => OK

// OKのitem要素のみをフォーマットして出力する
root.items.item.findAll { it.text() == "OK" }.each {
    println "${it.@id}: ${it.@name} => ${it.text()}"
}
//=> 1: あいうえお => OK
//   3: さしすせそ => OK
