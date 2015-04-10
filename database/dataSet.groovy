@Grab('com.h2database:h2')
@GrabConfig(systemClassLoader=true) // JDBCはシステムクラスローダから探されるので必要
import groovy.sql.Sql

// 別途DataSourceやConnectionを用意するなら、Sqlのコンストラクタに渡せばOK
def db = Sql.newInstance("jdbc:h2:mem:sample", "org.h2.Driver")

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

people.each {
    println "${it.name} (${it.age})"
}
//=> Mike (13)
//   Junko (14)
//   Ken (23)
