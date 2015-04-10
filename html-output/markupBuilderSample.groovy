def builder = new groovy.xml.MarkupBuilder()

// 属性値のクォートはデフォルトではシングルクォーテーションが使われる。
// この設定でダブルクォーテーションに変更できる。
builder.doubleQuotes = true

def existMethod(a) { "EXIST_METHOD: ${a}" }

// 最初の呼び出しで使った名前がルート要素のタグ名になる
builder.aaa {
    // 存在しないメソッド名で呼び出すと要素宣言と見なされる。引数は子要素になる。
    bbb "BBB"

    // 引数をマップで指定すると属性値になる
    ccc(c1: "C1", c2: "C2")

    // 引数としてクロージャを渡すとネストになる
    ddd {
        xxx "XXX"
    }

    // 制御構造がそのまま使える
    if (false) {
        // ここが実行されなければ出力されない
        ignoredThis "IGNORED"
    }

    // 存在するメソッドであれば単にそのメソッドが呼ばれるだけで要素は生成されない
    // 存在しないメソッドを実行しようとすることが、要素生成のトリガとなる
    existMethod "ただのメソッド呼び出し"
}
