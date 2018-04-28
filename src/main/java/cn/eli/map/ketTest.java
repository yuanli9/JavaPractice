package cn.eli.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ketTest {
    public static void main(String[] args) {

        Map<String ,Integer> map = new HashMap<>();

        for(int i = 0; i < 10 ; i++){
            map.put("vaule"+i,i);
        }

        Iterator iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
