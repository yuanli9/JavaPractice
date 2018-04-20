package cn.eli.finalRange;

public class Person{
    final int age=18;
    int name;
    final  int finalV = 5;

    final void getAge(){
        System.out.println("get age");
    }
    final void getName(){
        System.out.println("get name");
    }

    int getFinalV(){
        return finalV;
    }
//    void setFinalV(int v){
//        finalV = v;
//    }
}
