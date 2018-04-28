package cn.eli.random;

import java.util.Random;

public class testRadom {

    public static void main(String[] args) {
        Random random = new Random();
        //加了随机种子就会使得执行获得的随机数固定
//        Random random = new Random(1000);
        for (int i = 1 ; i< 4; i++){
            System.out.println("第"+i+"次："+ random.nextInt());
        }
    }
}
