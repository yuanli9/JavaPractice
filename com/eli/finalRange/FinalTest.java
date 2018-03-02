package com.eli.finalRange;

public class FinalTest {
    public static void main(String[] args){
        Custom c = new Custom();
        c.getAge(3);
        c.getAge();
       int a = c.getFinalV();
//        c.age = 5;
        /**
         * conclusion： final修饰的方法可以重载不可以重写 can not override '' ,overridden method is final
         *              final修饰的成员变量不可以修改  Cannot assign a value to final variable
         *              final修饰的类不可以被继承 can not inherit from final
         * */
    }
}
