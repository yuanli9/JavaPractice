package cn.eli.PersonCompare;

import java.util.*;

/**
 * 找出名字相同的人中年龄最低以及最高的人
 * */
public class TestPersonCompare {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

//        Person p1 = new Person("zhangsan" , 27);
//        Person p2 = new Person("zhangsan" , 23);
//        Person p3 = new Person("zhangsan" , 33);
//        Person p4 = new Person("zhangsan" , 27);
//        Person p5 = new Person("lisi" , 25);
//        Person p6 = new Person("lisi" , 21);
//        Person p7 = new Person("lisi" , 53);
//
//        personList.add(p1);
//        personList.add(p2);
//        personList.add(p3);
//        personList.add(p4);
//        personList.add(p5);
//        personList.add(p6);
//        personList.add(p7);

        Person p;
        String name;
        int size,score;
        for(int i=0;i<10000;i++){
            name = "zhang"+ i;
            size = new Random().nextInt();
            size = Math.abs(size)%100;
            for (int j = 0 ;j<=size;j++){
                score = new Random().nextInt();
                score = Math.abs(score)%100 ;
                p = new Person(name,score);
                personList.add(p);
            }

        }
        System.out.println("list.size ="+personList.size());
        long start = System.currentTimeMillis();
        sort(personList);
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
        System.out.println("排序时间："+(end - start));
    }
    private static void sort(List<Person> personList){
        Map<String,List<Person>> personMap = new HashMap<>();

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() > o2.getAge()){
                    return 1;
                }else if(o1.getAge() == o2.getAge()){
                    return 0;
                }else{
                    return -1;
                }
            }
        };

        for(Person p:personList){
            List<Person> pl = personMap.get(p.getName());
            if(pl == null || pl.size() == 0){
                pl = new ArrayList<>();
            }
            pl.add(p);

            personMap.put(p.getName(),pl);
        }
//        System.out.println(personMap);

        Set<String> keySet = personMap.keySet();

        List<Person> list = new ArrayList<>();
        Object[] perArray ;
        for (Iterator iter = keySet.iterator(); iter.hasNext();) {
            String str = (String) iter.next();
            List<Person> pl = personMap.get(str);
            Collections.sort(pl,comparator);
//            perArray = pl.toArray();
//            BinarySort.binarySort(perArray,0,pl.size(),0);
//            System.out.println(perArray);
            list.add(pl.get(0));
            list.add(pl.get(pl.size()-1));
//            list.add((Person)perArray[0]);
//            list.add((Person)perArray[perArray.length-1]);
        }

        System.out.println(list);
    }
}
