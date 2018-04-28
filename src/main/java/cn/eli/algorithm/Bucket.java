package cn.eli.algorithm;

import java.util.*;

/**
 *  桶排序算法研究
 * */
public class Bucket {
    public static void main(String[] args) {
//        /** 初始化待排序数据*/
//        int[] scores = {4,2,5,3,8};
//        /** 桶数组*/
//        int[] result = new int[11];
//
//        /** 数据分桶投放*/
//        int length = scores.length;
//        for(int i = 0; i < length; i++){
//            result[scores[i]]++;
//        }
//        /** 打印排序结果*/
//        for(int i = 10; i >= 0; i--){
//            for(int j = 0; j< result[i]; j++){
//                System.out.print(i+" ");
//            }
//        }
        /**
         * N = 299 假设整个班同学成绩分布情况为：1/5同学100分以下
         * 100分以上的数量比较多，所以我们用5个桶装100分以上的同学，1个桶装100分一下同学
         * M = 6
         * */

        /** 初始化待排序数据 50位同学的成绩*/
        double[] scores = new double[50];
        double ran;
        for(int i=0; i<40; i++){
            ran = new Random().nextInt(50)+100;

            if(ran%2 == 0){
                ran = ran + 0.5;
            }
            scores[i]=ran;
        }

        for(int i=0; i<10; i++){
            ran = new Random().nextInt(100);
//            System.out.println(ran);
            if(ran%2 == 0){
                ran = ran + 0.5;
            }
            scores[40+i]=ran;
        }
        /** 桶
         *  由于需要动态分配桶里容量的大小
         *  所以为了方便使用arraylist作为桶
         *  map满足  桶-桶里存储的元素 这样的映射关系
         * */
        Map<Integer,List<Double>> scoreMap = new HashMap<>();

        /** 数据分桶投放
         *      由于同一个桶内的分数可能存在多个值
         *      所以桶内需要可以存多个分值得数据结构
         * */
        int length = scores.length;
        int hash;
        for(int i = 0; i < length; i++){
            hash = scoreHash(scores[i]);
            if(scoreMap.get(hash) == null){
                scoreMap.put(hash,new ArrayList<Double>());
            }
            scoreMap.get(hash).add(scores[i]);
        }
        /** 对同一个桶里的元素排序*/
        Iterator<Integer> iterator = scoreMap.keySet().iterator();
        while(iterator.hasNext()){
            int a = iterator.next();
            Collections.sort(scoreMap.get(a));

        }
        System.out.println(scoreMap.get(0));
        int bucketSize = 0;
        int index = 0;
        List<Double> sysoList ;
        for(int i = 5; i >= 0; i--){
            sysoList = scoreMap.get(i);
            bucketSize = sysoList.size();
            for(int j = bucketSize-1; j>=0; j--){
                scores[index++] = sysoList.get(j);
            }
        }

        for(int i=0;i< length ; i++){
            System.out.print(scores[i]+" ");
        }

        /**
         *
         * 如果现在可能存在0.5分的情况，即存在9.5分这样的分值，那么存在19种分值情况，N相应的变为了N=19，
         * 如果满分100分，N=199；满分150，N=299。也就是说排序的时候我们要对这三种情况分配19/199/299个桶，
         * 即
         *      N=19    M=19
         *      N=199   M=199
         *      N=299   M=299
         * 每个桶都需要分配内存地址去存放数据，可是假设所有同学的成绩都很不错，大多数的同学分值保持在100-130，那么100以下的桶
         * 就几乎没有被利用到，分配的内存地址也就浪费了，为了避免这种情况，我们就需要设置一个映射函数，来保证
         * 桶都能被最大效率地利用到，减少内存的浪费。(ps:300左右的不占多少内存地址，这里仅举例说明)
         *
         * */

        /**
         * 总结
         *      我们为50个同学的成绩分配了6个桶，先将成绩根据定义的映射函数放入对应的桶中，然后再对桶中的元素进行排序，由于我们假设了100分以下的分数占比很小，所以仅用一个桶去装100分以下成绩，但是如果
         *      某次考试卷子很难，同学们都没考好，全是100分以下，这种情况下，桶排序就几乎转为我们对单个桶内的数据进行排序，也就是collections.sort()使用的排序算法进行排序
         *      collections.sort(List<Integer>)底层是用的comparabTimSort
         * */
    }
    /** 映射函数*/
    private static int scoreHash(double score){
        if(score < 100){
            return 0;
        }else{
            return (int)(score/10) -9;
        }
    }
}
