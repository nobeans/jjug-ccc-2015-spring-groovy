@GrabResolver(name="bintray", root="http://dl.bintray.com/nobeans/maven")
@Grab("org.jggug.kobo:gexcelapi:0.4")
import org.jggug.kobo.gexcelapi.GExcel

// example...
def book = GExcel.open("sample.xlsx")
def sheet = book[0]
println sheet.A1.value
