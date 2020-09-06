package javaSE.集合;

import org.junit.Test;

import java.util.*;

public class CollectionTest1 {
    @Test
    public void demo1(){
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Integer[] moreInts = {7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);

        for(Integer i:collection){
            System.out.print(i+",");
        }

        List<Integer> list = Arrays.asList(16,17,18,18,20);
        list.set(1,99);

        /*
        java.lang.UnsupportedOperationException
        原因：我们调用Arrays的asList()方法将数组转换成List时返回的是Arrays的静态内部类ArrayList，
        它自身并未重写add()方法，而其父类AbstractList实现的add()方法只会抛出UnsupportedOperationException，
        导致我们调用Arrays的静态内部类ArrayList的add()方法时，
        实际调用的是只会抛出UnsupportedOperationException的AbstractList的add()方法，这就是异常出现的原因了。
         */
        //list.add(20);
    }

    @Test
    /**
     * 利用 map javaSE.集合，验证 random.nextInt 产生的随机数是均匀分布的。
     */
    public void demo2(){
        Random random = new Random(47);
        Map<Integer,Integer> map =  new HashMap<>();

        for(int i=0;i<10000;i++){
            int t = random.nextInt(20);
            Integer value_t = map.get(t);
            map.put(t,value_t==null?1:value_t+1);
        }
        //第一种便利方式
        for(int i:map.keySet()){
            System.out.print(i+"="+map.get(i)+";");
        }

        System.out.println();
        //第二种便利方式（iterator）
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            int i =iterator.next();
            System.out.print(i+"="+map.get(i)+";");
        }


    }
}
