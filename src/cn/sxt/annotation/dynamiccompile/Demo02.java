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
 * ����java�еĽű��������JavaScript�ű�
 * @author �ƽ���
 */
public class Demo02 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        //��ýű�����
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        //������� ���������ж���һ������
        engine.put("msg","gaoqi is a good man");
        String str = "var user = {name:'gaoqi',age:18,shcools:['�廪��ѧ','������ѧ��']};";
        str += "print(user.name);";
        //ִ�нű�
        engine.eval(str);
        engine.eval("msg = 'sxt is a good school';");
        System.out.println(engine.get("msg"));
        System.out.println("******************");

        //���庯��
        engine.eval("function add(a,b) {var sum = a + b; return sum;}");
        //ȡ�õ��ýӿ�
        Invocable jsInvoke = (Invocable)engine;
        //ִ�нű��ж���ķ���
        Object result1 = jsInvoke.invokeFunction("add", 13,20);
        System.out.println(result1);

        //����������Java����ʹ���������е�Java��
        //jdk1.8ʹ�ù���
        String jsCode = "var list = java.util.Arrays.asList([\"������ѧ��\",\"�廪��ѧ\",\"������ѧ\"]); ";
        engine.eval(jsCode);
        List<String> list2 = (List<String>)engine.get("list");
        for (String  temp: list2) {
            System.out.println(temp);
        }

        //ִ��һ��js�ļ�
        URL is = Demo02.class.getClassLoader().getResource("a.js");
        assert is != null;
        Reader r = new FileReader(is.getPath());
        engine.eval(r);
    }
}
