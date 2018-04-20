package cn.eli.constructor;

import java.util.Date;

public class Sub extends Super {
    private final Date date ;
    public Sub(){
        date = new Date();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.OverrideMe();
    }
    @Override
    public void OverrideMe(){
        System.out.println(date);
    }
}
