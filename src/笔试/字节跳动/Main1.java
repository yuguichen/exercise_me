package 笔试.字节跳动;

import java.util.Scanner;

public class Main1 {

    static class Node {
        int val;
        Node next;
        Node(int x) { val = x;}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node root = new Node(0);
        Node temp = root;

        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            Node node = new Node(val);
            temp.next  = node;
            temp = temp.next;
        }
        int resultNum = sc.nextInt();

        if(resultNum>=n)
            System.out.println("null");
        else{
            for(int i=0;i<n-resultNum;i++){
                root = root.next;
            }

            System.out.println(root.val);
        }

    }
}
