package cn.sxt.annotation.dynamiccompile;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

/**
 * 测试java中的脚本引擎调用JavaScript脚本
 * @author 黄建波
 */
public class Demo02 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        //获得脚本引擎
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        //定义变量 向上下文中定义一个变量
        engine.put("msg","gaoqi is a good man");
        String str = "var user = {name:'gaoqi',age:18,shcools:['清华大学','北京尚学堂']};";
        str += "print(user.name);";
        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a good school';");
        System.out.println(engine.get("msg"));
        System.out.println("******************");

        //定义函数
        engine.eval("function add(a,b) {var sum = a + b; return sum;}");
        //取得调用接口
        Invocable jsInvoke = (Invocable)engine;
        //执行脚本中定义的方法
        Object result1 = jsInvoke.invokeFunction("add", 13,20);
        System.out.println(result1);

        //导入其他的Java包，使用其他包中的Java类
        //jdk1.8使用规则
        String jsCode = "var list = java.util.Arrays.asList([\"北京尚学堂\",\"清华大学\",\"北京大学\"]); ";
        engine.eval(jsCode);
        List<String> list2 = (List<String>)engine.get("list");
        for (String  temp: list2) {
            System.out.println(temp);
        }

        //执行一个js文件
        URL is = Demo02.class.getClassLoader().getResource("a.js");
        assert is != null;
        Reader r = new FileReader(is.getPath());
        engine.eval(r);
    }
}
