package 作业;
import com.csvreader.CsvReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 别人的实现
 */
public class FriendsCircles {
    /*** 保存id与数组下标的映射关系*/
    private Map<String, Integer> map = new HashMap<>();
    /** 数组的值代表当前节点的朋友节点在数组中的下标 **/
    private Integer[] array;
    private List<Integer> list = new ArrayList<>();

    /**
     * 第一次读取csv文件初始化hashMap，将每个id映射到相应的数组下标
     * @param filepath
     */
    public void initMap(String filepath) {
        CsvReader br = readCsv(filepath);
        String line = "";
        String[] lines = {};
        int count = 0;
        try {
            br.readHeaders();
            while (br.readRecord()) {
                line = br.getRawRecord();
                lines = line.split("\t");
                if (!map.containsKey(lines[0])) {
                    map.put(lines[0], count);
                    count++;
                }
                if (!map.containsKey(lines[1])) {
                    map.put(lines[1], count);
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用初始化完成的hashmap的大小来初始化数组，并将初始值置为-1
     * @param n
     */
    public void initArray(int n) {
        array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }
    }

    /**
     * 再次读取csv文件，每一行作为朋友关系输入
     *
     * @param filepath
     */
    public void insert(String filepath) {
        CsvReader br = readCsv(filepath);
        String line = "";
        String[] lines = {};
        try {
            br.readHeaders();
            while (br.readRecord()) {
                line = br.getRawRecord();
                lines = line.split("\t");
                union(map.get(lines[0]), map.get(lines[1]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 查找节点对应的根节点
     * @param x
     * @return
     */
    public Integer find(Integer x) {
        while (array[x] != -1) {
            x = array[x];
        }
        return x;
    }

    /**
     * 插入朋友关系时，寻找二者的根
     * 如果根相同，无需操作，根不同，将根连接起来
     * @param x
     * @param y
     */
    public void union(Integer x, Integer y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            array[rootx] = rooty;
        }
    }

    /**
     * 遍历数组，值为-1说明当前节点为根节点，count++
     * @return
     */
    public Integer count() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 创建CsvReader
     * @param filepath
     * @return
     */
    public CsvReader readCsv(String filepath) {
        try {
            CsvReader cr = new CsvReader(filepath);
            return cr;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 采用List动态更新，从而在一次读取csv文件的过程中
     * 完成hashmap更新与朋友关系的插入
     * @param filepath
     */
    public void initMapV1(String filepath) {
        CsvReader cr = readCsv(filepath);
        String line = "";
        String[] lines = {};
        int count = 0;
        try {
            boolean re = cr.readHeaders();
            while ((cr.readRecord())) {
                line = cr.getRawRecord();
                lines = line.split("\t");
                if (!map.containsKey(lines[0])) {
                    map.put(lines[0], count);
                    count++;
                    list.add(-1);
                }
                if (!map.containsKey(lines[1])) {
                    map.put(lines[1], count);
                    count++;
                    list.add(-1);
                }
                unionV1(lines);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer findV1(Integer x) {
        while (list.get(x) != -1) {
            x = list.get(x);
        }
        return x;
    }

    public void unionV1(String[] lines) {
        int rootx = findV1(map.get(lines[0]));
        int rooty = findV1(map.get(lines[1]));
        if (rootx != rooty) {
            list.set(rootx, rooty);
        }
    }



    public Integer countV1() {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String filepath = "/Users/yuguichen/IdeaProjects/exercise_me/src/作业/snsActivity.csv";
        FriendsCircles fc = new FriendsCircles();
        Boolean flag = true;
        Long time1 = System.currentTimeMillis();
        Integer count = 0;
        if (!flag) {
            //list
            fc.initMapV1(filepath);
            count = fc.countV1();
        }else {
            //array
            fc.initMap(filepath);
            fc.initArray(fc.map.size());
            fc.insert(filepath);
            count = fc.count();
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("result:" + count);  // count值为12003
        System.out.println("花费时间" + (time2 - time1));  // 耗时均在1200ms左右
}
}


