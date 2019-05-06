package javaSE.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式用于操作字符串数据
 *   1、匹配   matches(regex)
 *   2、切割
 *   3、替换
 *   4、获取
 * java.util.regex.Pattern 定义了正则表达式的符号
 *
 */
public class RegexDemo1 {

    public static void main(String args[]){

//        String qq = "012344566777";
//        System.out.println("qq:"+demo1(qq));

        demo5();
    }

    /**
     * 验证 获取
     *  Pattern p = Pattern.compile("a*b");
     *  Matcher m = p.matcher("aaaaab");
     *  boolean b = m.matches();
     */
    public static void demo5(){
        String str = "da lian li gong da xue huan ying nin";
        //1、将正则表达式封装成对象
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]{3}\\b");// \b代表边界符
        //2、通过正则对象获取匹配对象
        Matcher matcher = pattern.matcher(str);
        //通过匹配器对象查找
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    /**
     * 验证 替换
     */
    public static void demo4(){
        String str = "zhangsanmmmmmmmlisittttttygchhhhhhhhwangwu";
        // (.)代表组，(.)\\1+代表任意第一组连续出现的字符；
        str = str.replaceAll("(.)\\1+","$1");
        System.out.println(str);
    }

    /**
     * 验证 切割
     */
    public static void demo3(){
        String str = "zhangsan    lisi    ygc  wangwu";
        String names[] = str.split(" +");//以空格进行切割," +"表示一个或多个空格
        for(String name:names){
            System.out.println(name);
        }

        String str1 = "zhangsan.lisi.ygc.wangwu";
        String names1[] = str1.split("\\.");
        for(String name:names1){
            System.out.println(name);
        }
    }

    /**
     * 验证 匹配手机号
     */
    public static void demo2(){
        String tel = "14941171863";
        String regex = "1[358]\\d{9}"; // \d代表数字0-9，\\d表示将“\d”转义成0-9
        System.out.println("tel:"+tel.matches(regex));
    }


    /**
     * 利用 javaSE.正则表达式 验证
     *      字符串是否由15位数字组成且首字母不能为0
     * @param qq
     * @return
     */
    public static boolean demo1(String qq){

        String regex = "[1-9][0-9]{4,14}";
        return qq.matches(regex);

    }

}
