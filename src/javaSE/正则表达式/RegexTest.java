package javaSE.正则表达式;

import java.util.TreeSet;

public class RegexTest {

    public static void main(String args[]){
        //test3();
        String s = "hello";
        System.out.println(s.charAt(0));

    }

    /**
     * 治疗口吃
     */
    public static void test1(){
        String str = "我我....我我我........我我我我我我...要要要..." +
                "要要要要....要要要要要.....学学学...学学学学学....学学...编" +
                ".....编编编编....编编编编....程程程程程程......程程程程程程程";

        //1、将字符串中的.去掉
        //str = str.replaceAll("(\\.)\\1+","");
        //2、将字符串中重复字去掉
        //str = str.replaceAll("(.)\\1+","$1");

        str = str.replaceAll("\\.+","").replaceAll("(.)\\1+","$1");
        System.out.println(str);
    }

    /**
     * 测试IP地址排序
     */
    public static void test2(){
        String ips_str = "192.168.10.34 127.0.0.1 3.3.3.3 105.70.11.55";

        //补0 去0
        ips_str = ips_str.replaceAll("(\\d+)","00$1").
                replaceAll("0*(\\d{3})","$1");

        //将多个IP地址分开
        String ips[] = ips_str.split(" +");

        //存入treeSet集合自动排序
        TreeSet<String> treeSet = new TreeSet<>();
        for(String ip:ips)
            treeSet.add(ip);

        for(String ip:treeSet)
            System.out.println(ip.replaceAll("0*(\\d+)","$1"));


    }

    /**
     * 邮箱地址检查
     */
    public static void test3(){
        String mail = "yuguichen@mail.dlut.edu.cn";

        String regex = "[a-zA-Z0-9_]+@[A-Za-z]+(\\.[A-Za-z]+){1,3}"; //  \w :A word character: [a-zA-Z_0-9]

        System.out.println(mail+":"+mail.matches(regex));
    }
}
