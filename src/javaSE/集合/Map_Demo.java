package javaSE.集合;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map集合一次添加一个元素，collection集合一次添加一个元素
 * map<K,V>  map集合中存储的是键值对
 * map集合中必须保证key的唯一性
 *
 * 常用子类
 *      HashTable 内部哈希表，同步 ，不允许null作为键值
 *          properties 存储键值对型的配置文件的信息，可以和IO技术结合
 *      HashMap   内部哈希表，不同步 允许null作为键值
 *      TreeMap   内部二叉树，不同步，可以对map中键值进行排序
 *
 */
public class Map_Demo {
    public static void main(String args[]){
        HashMap hm=new HashMap();
        method3(hm);
    }


    /**
     * 取出map集合中所有元素
     * 通过keyset方法获取map中所有键的key值所在的Set集合
     * 通过Set集合中的迭代器Iterator获取键值
     * 通过nap集合中get方法获得key对应的值
     */
    public static void method2(Map map){
        map.put(8,"bbbb");
        map.put(1,"aaaa");
        map.put(3,"cccc");

        Set keyset=map.keySet();
        Iterator<Integer> it = keyset.iterator();
        while(it.hasNext()){
            Integer key=  it.next();
            String value= (String)map.get(key);
            System.out.println(key+":"+value);
        }
    }

    public static void method3(Map map){
        map.put(8,"bbbb");
        map.put(1,"aaaa");
        map.put(3,"cccm");

        Set me=map.entrySet();
        Iterator<Map.Entry> it = me.iterator();
        while(it.hasNext()){
            Map.Entry entry =  it.next();
            //String value = (String)entry.getValue();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


    public static void method(Map<Integer,String> map){
        System.out.println(map.put(8,"aaaa"));
        System.out.println(map.put(8,"bbbb"));
        map.put(1,"aaaa");
        map.put(3,"cccc");
        System.out.println(map);
    }
}
