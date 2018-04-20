package cn.eli.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InvokeTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("xx", 1);
        Class c = map.getClass();
        try {
            Method m = c.getDeclaredMethod("size");
            Object o = c.newInstance();

            m.setAccessible(true);
            System.out.println(m.invoke(o));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("---");

    }
}
