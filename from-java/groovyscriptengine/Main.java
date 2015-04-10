import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java.io.*;

public class Main {

    public static void main(String... args) throws IOException, ResourceException, ScriptException {
        String[] roots = new String[] { "./" };
        GroovyScriptEngine engine = new GroovyScriptEngine(roots);
        Binding binding = new Binding();
        binding.setVariable("name", "from Java by GroovyScriptEngine");
        Object result = engine.run("hello.groovy", binding);
        System.out.println(result);
    }
}
