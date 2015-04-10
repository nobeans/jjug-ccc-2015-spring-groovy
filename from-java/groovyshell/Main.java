import groovy.lang.*;
import java.io.*;

public class Main {

    public static void main(String... args) throws IOException {
        Binding binding = new Binding();
        binding.setVariable("name", "from Java by GroovyShell");
        GroovyShell shell = new GroovyShell(binding);
        Object result = shell.evaluate(new File("hello.groovy"));
        System.out.println(result);
    }
}
