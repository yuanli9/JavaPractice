package cn.boccfc.transport.help;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B{
    private int size;

    private Map<String , A> spMap;

    public void addPeople(String name){
        if(spMap == null){
            spMap = new HashMap();
        }
        spMap.put(name,new A(name));

        this.size ++;
    }

    public int getSize(){
        return this.size;
    }

    public void add(A a){
        if(spMap == null){
            spMap = new HashMap();
        }
        spMap.put(a.getName(), a);

        this.size ++;
    }

    public void cacl(){
        Iterator mapIte = this.spMap.keySet().iterator();

        while(mapIte.hasNext()){
            A a = this.spMap.get(mapIte.next());

        }

    }
}
