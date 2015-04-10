import groovy.util.slurpersupport.NodeChild

def inputXml = """
<root>
  <items>
    <item id="1" name="あいうえお">OK</item>
    <item id="2" name="かきくけこ">NG</item>
    <item id="3" name="さしすせそ">OK</item>
  </items>
</root>
"""
def root = new XmlSlurper().parseText(inputXml) // <root>に対応するgroovy.util.slurpersupport.NodeChildオブジェクト

root.items.item.each { NodeChild item ->
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
