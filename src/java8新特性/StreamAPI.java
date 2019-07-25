package java8新特性;

import javaSE.src2.Person;
import org.junit.Test;
import utils.SortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream:
 *      自己不存储元素；
 *      不改变源对象，会返回一个持有结果的新流；
 *      延迟操作（需要结果时才执行）
 *
 * Stream操作的步骤：
 *      创建----中间操作-----终止操作
 *
 */
public class StreamAPI {

    List<Person> peoples = Arrays.asList(
            new Person("张三",18),
            new Person("李四",20),
            new Person("王五",55),
            new Person("王二麻子",33),
            new Person("小黄豆",123),
            new Person("赵六",4),
            new Person("田七",46)
    );

    /**
     * 创建流的四种方式
     */
    @Test
    public void testCreate(){
        // 1、通过collection集合提供的stream方法或 parallelStream方法
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2、通过Array中的静态方法stream获取数组流
        Integer[] array = SortUtil.getArray(10,() -> (int)(Math.random()*100));
        Stream<Integer> stream2 = Arrays.stream(array);

        // 3、通过Stream类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        // 4、创建无限流
        //    1:迭代方式
        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x+2);
        stream4.limit(10).forEach(System.out::println);
        //    2:生成
        Stream.generate(() -> Math.random()).forEach(System.out::println);
    }


    /**
     * 中间操作：
     *      延迟操作，直到终止操作时才会并且一次性全部执行，否则不执行
     *      内部迭代
     */
    @Test
    public void testMiddleOperate(){

        Stream<Person> stream = peoples.stream()
                .filter( (e) -> e.getAge()>18 ).limit(4).skip(2);
        //终止操作
        stream.forEach(System.out::println);

    }

    /**
     * 映射操作map和flatmap
     *      map：生成流，并接受一个函数作为参数，该函数将每个元素映射成一个新的元素放入流中；
     *      flatmap：接受一个函数,该函数将流中每一个元素转换成另一个流，最后将所有的流连接成一个流；
     *
     *      如果一个函数返回的是流就使用flatmap,便于操作；
     */
    @Test
    public void testMap(){
        List<String> list = new ArrayList<>();

        Stream<String> stream = peoples.stream().map(Person::getName);
        stream.forEach(list::add);

        System.out.println("-------------");

        Stream<Stream<Character>> stream1 = list.stream().map(StreamAPI::filterCharater);
        stream1.forEach( (sm)->sm.forEach(System.out::println) );

        System.out.println("flatmap-------------");
        Stream<Character> stream2 = list.stream().flatMap(StreamAPI::filterCharater);
        stream2.forEach(System.out::println);

    }

    public static Stream<Character> filterCharater(String str){
        List<Character> list = new ArrayList<>();
        for(Character character : str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }


}
