import groovy.lang.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException {
        new Main().runGroovyClass();
    }

    private void runGroovyClass() throws IOException, InstantiationException, IllegalAccessException {
        // GroovyClassLoaderを使ってHelloWorldクラスをロードする。
        ClassLoader parent = getClass().getClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);
        Class groovyClass = loader.parseClass(new File("HelloWorld.groovy"));

        // HelloWorldクラスをインスタンス化してGroovyObject型経由で実行する。
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        Object[] args = {"from Java by dynamic-loading"};
        Object result = groovyObject.invokeMethod("hello", args);

        System.out.println(result);
    }
}
