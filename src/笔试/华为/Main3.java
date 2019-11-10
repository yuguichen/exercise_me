package 笔试.华为;

import java.util.*;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Map<String,String> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String[] s = in.nextLine().split(",");
            map.put(s[0]+","+s[1],s[2]);
        }
        int m = in.nextInt();
        in.nextLine();
        Map<String,String> change = new HashMap<>();
        for(int i=0;i<m;i++){
            String s[] = in.nextLine().split(",");
            String ticket = s[0]+","+s[1];
            String newTicket = s[2]+","+s[3];
            change.put(map.get(ticket),newTicket);
        }

        for(Map.Entry<String,String> entry:map.entrySet()){
            String name = entry.getValue();
            String ticket = entry.getKey();
            boolean same = false;
            for(Map.Entry<String,String> entry1:change.entrySet()){
                if(ticket.equals(entry1.getValue())) {
                    same = true;
                    break;
                }
            }
            if(!change.containsKey(name) && !same){
                change.put(name,entry.getKey());
            }
        }

        Set<String> set = new TreeSet<>();
        Map<String,String> newMap= new HashMap<>();
        for(Map.Entry<String,String> entry:change.entrySet()){
            String s = entry.getValue();
            newMap.put(s,entry.getKey());
            set.add(s);

        }

        for(String s:set){
            System.out.println(s+","+newMap.get(s));
        }
    }
}
