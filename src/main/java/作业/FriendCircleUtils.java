package 作业;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.csvreader.CsvReader;
import org.junit.Test;

public class FriendCircleUtils {
    // 朋友圈编号
    private int circleNumID;
    // id--朋友集合
    private Map<String, Set<String>> idTofriendIds = new HashMap<>();
    // id集合（只记录 idTofriendIds 中的key）
    private Set<String> persons = new HashSet<>();
    // 某个朋友圈：朋友圈编号--id集合
    private Map<Integer, Set<String>> numToIds = new HashMap<>();
    // id--id所属朋友圈编号
    private Map<String, Integer> idToNum = new HashMap<>();

    /**
     * 读取文件，初始化数据
     * @param path 文件路径
     */
    public void init(String path){
        Long time1 = System.currentTimeMillis();
        CsvReader fileReader = null;
        try {
            fileReader = new CsvReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(fileReader != null) {
            try {
                fileReader.readHeaders();
                while(fileReader.readRecord()){
                    String[] lines = fileReader.getValues()[0].split("\t");

                    String id = lines[0];
                    String friendId = lines[1];

                    Set<String> friendSet;
                    if(idTofriendIds.containsKey(id) && idTofriendIds.containsKey(friendId)) {
                        friendSet = idTofriendIds.get(id);
                        friendSet.addAll(idTofriendIds.get(friendId));
                        friendSet.add(friendId);
                    } else if(idTofriendIds.containsKey(id)) {
                        idTofriendIds.get(id).add(friendId);
                    } else if(idTofriendIds.containsKey(friendId)) {
                        idTofriendIds.get(friendId).add(id);
                    } else {
                        friendSet = new HashSet<>();
                        friendSet.add(friendId);
                        idTofriendIds.put(id, friendSet);
                        persons.add(id);
                    }
                }

                fileReader.close();
                Long time2 = System.currentTimeMillis();
                System.out.println("init花费时间" + (time2 - time1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 计算朋友圈数量
     * @return
     */
    public int calculateCircleNums() {
        getFriends();
        return numToIds.size();
    }

    /**
     * 划分朋友圈
     */
    private void getFriends() {
        Long time1 = System.currentTimeMillis();

        for(String id : persons) {
            if(!idTofriendIds.containsKey(id)) {
                continue;
            }

            Set<String> friends = new HashSet<>();
            Stack<String> stack = new Stack<>();
            stack.push(id);
            friends.add(id);

            Set<Integer> circleNums = new HashSet<>();
            int minCircleNumID = Integer.MAX_VALUE;
            while (!stack.empty()) {
                String tempId = stack.pop();
                if(idTofriendIds.containsKey(tempId)) {
                    Set<String> friendIds = idTofriendIds.get(tempId);

                    // 检查是否已经存在朋友圈
                    for(String friendId : friendIds) {
                        if(idToNum.containsKey(friendId)) {
                            int num = idToNum.get(friendId);
                            circleNums.add(num);
                            minCircleNumID = Math.min(minCircleNumID, num);
                        } else {
                            stack.push(friendId);
                            friends.add(friendId);
                        }
                    }
                    // 移除被选出的id
                    idTofriendIds.remove(tempId);
                }
            }

            updateFriendsCircles(friends, circleNums, minCircleNumID);
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("getFriends花费时间" + (time2 - time1));
    }

    /**
     *
     * @param friends
     * @param circleNums
     * @param minCircleNumID
     */
    private void updateFriendsCircles(Set<String> friends, Set<Integer> circleNums, int minCircleNumID) {
        // 先判断是否有已存在朋友圈

        if(circleNums != null && circleNums.size() > 0) {
            // 只有一个已存在的朋友圈
            if(circleNums.size() == 1){
                Set<String> newSet = numToIds.get(minCircleNumID);
                newSet.addAll(friends);
                for(String s : friends){
                    idToNum.put(s, minCircleNumID);
                }
                return;
            }

            // 发现已存在多个朋友圈，合并朋友圈
            if(circleNums.size() > 1) {
                for (Integer i : circleNums) {
                    if(i != minCircleNumID) {
                        friends.addAll(numToIds.get(i));
                        numToIds.remove(i);
                    }
                }

                for(String s : friends){
                    idToNum.put(s, minCircleNumID);
                }
                numToIds.get(minCircleNumID).addAll(friends);
                return;
            }
        }

        // 新的朋友圈
        if(friends != null && friends.size()>0) {
            numToIds.put(++circleNumID, friends);
            for(String friend : friends) {
                idToNum.put(friend, circleNumID);
            }
            return;
        }

    }


    @Test
    public void test() {
        String path = "/Users/yuguichen/IdeaProjects/exercise_me/src/作业/snsActivity.csv";
        this.init(path);
        int circleNums = this.calculateCircleNums();
        System.out.println(circleNums);

    }

}

