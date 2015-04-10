
@Grab('com.h2database:h2')
@GrabConfig(systemClassLoader=true) // JDBCはシステムクラスローダから探されるため必要

import groovy.sql.Sql

// 別途DataSourceやConnectionを用意するなら、Sqlのコンストラクタに渡せばOK
def db = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")


// Sql#execute()でDDLを実行する
db.execute("""
create table person (
    name varchar(255),
    age int
)
""")

// DataSetを使うとコレクションオブジェクト風にレコード操作ができる
import groovy.sql.DataSet

DataSet people = db.dataSet('person')
people.add(name: 'Mike', age:13)
people.add(name: 'Junko', age: 14)
people.add(name: 'Ken', age: 23)

people.findAll { it.age < 20 }.sort { it.age }.each {
    println "${it.name} (${it.age})"
}


