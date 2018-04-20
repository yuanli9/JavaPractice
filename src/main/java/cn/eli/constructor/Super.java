package cn.eli.constructor;

public class Super extends SuperSuper{
    public Super(){
        OverrideMe();
    }
    public void OverrideMe(){
        System.out.println("super");
    }
}
