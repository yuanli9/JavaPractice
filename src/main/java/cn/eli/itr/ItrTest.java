package cn.eli.itr;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ItrTest {
    public static void main(String[] args){
//        List<String> list = new ArrayList<String>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            String str = (String) iterator.next();
            if(str.equals("e")){
//                list.remove(str);
//                list.add("f");
//                iterator.remove(); //remove当前遍历的元素
            }else{
//                System.out.println(str);
            }
        }
        System.out.println("--------------------------------");
        ListIterator listItr = list.listIterator();
        while(listItr.hasNext()){
            String str = (String) listItr.next();
            if(str.equals("d")){
//                list.add("f");
//                listItr.add("f");
//                listItr.set("g");//替换当前遍历的元素
            }else{
//                System.out.println(str);
            }
        }
        System.out.println(list);
        /**
         * conclusion： iterator 遍历ArrayList 首先要获取ArrayList中内部类ListItr的实例 ListItr继承了Itr ，Itr.next方法持有elementData返回数组内元素
         *              iterator 循环遍历时也不能对list本身进行remove，add操作，否则就会异常
         *              ListIterator ListItr中有remove、add、set方法对list进行增删元素 iterator中只有remove
         *              iterator 不能保证线程安全
         *              CopyOnWriteArrayList 使用迭代器进行遍历时不能remove、add、set操作 (但是可以对list本身进行remove、add等操作)
         *                  public void remove() {throw new UnsupportedOperationException();}
         * */
        /**
         * Collection & Map conclusion：
         *              ArrayList：默认容量10(jdk1.8) 线程不安全，支持随机访问吗；扩容机制：oldCapacity + (oldCapacity >> 1);(1.5倍扩容或者更大)
         *              EnumMap
         *              EnumSet
         *              HashMap
         *              HashSet
         *              Hashtable
         *              IdentityHashMap
         *              PriorityQueue
         *              Vector  线程安全，多采用方法层面上加synchronized进行同步处理；支持随机访问；没有初始容量，初始化时判断创建
         *                      扩容机制：设置了增值capacityIncrement则扩容为oldCapacity+capacityIncrement，否则oldCapacity + oldCapacity
         *              TreeMap
         *              TreeSet
         *              WeakHashMap
         *
         * collections  (util包下的collections类)   对集合进行多线程同步处理
         *              synchronizedMap()
         *              synchronizedList()
         *              synchronizedSet()
         *              synchronizedSortedMap()
         *              同步方式：
         *                       private final Map<K,V> m;     // collection类型的是private final Collection<E> c;
         *                       final Object      mutex;        // mutex持有集合，对mutex对象synchronize处理
         *
         * concurrent   (java.util.concurrent包)     该包下有实现同步处理的集合类
         *              ConcurrentHashMap
         *              ConcurrentLinkedDeque
         *              ConcurrentLinkedDeque
         *              ConcurrentSkipListMap
         *              ConcurrentSkipListSet
         *              CopyOnWriteArrayList
         *              CopyOnWriteArraySet
         *              DelayQueue
         *              LinkedBlockingDeque
         *              LinkedBlockingQueue
         *              PriorityBlockingQueue
         *              SynchronousQueue
         *
         * */
    }
}
