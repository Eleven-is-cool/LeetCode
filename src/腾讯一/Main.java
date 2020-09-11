package 腾讯一;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long countA = sc.nextLong();
//            long[] A = new long[(int) countA];
            ListNode headA = new ListNode(-1);
            ListNode A = headA;
            for (long i = 0 ; i < countA; i++){
//                A[(int) i] = sc.nextLong();
                headA.next = new ListNode(sc.nextInt());
                headA = headA.next;
            }
            long countB = sc.nextInt();
//            long[] B = new long[(int) countB];
            ListNode headB = new ListNode(-2);
            ListNode B = headB;
            for (long i = 0 ; i < countB; i++){
//                B[(int) i] = sc.nextLong();
                headB.next = new ListNode(sc.nextInt());
                headB = headB.next;
            }
            ArrayList<Integer> res = new ArrayList<>();
            A = A.next;
            B = B.next;
//            System.out.println(A.val);
//            System.out.println(B.val);
            while (A != null && B != null){
                if (A.val == B.val){
                    res.add(A.val);
                    A = A.next;
                    B = B.next;
                }else if (A.val > B.val){
                    A = A.next;
                }else{
                    B = B.next;
                }
            }
            for (long k = 0; k < res.size(); k++){
                res.get((int) k);
                System.out.print(res.get((int) k) + " ");
            }
        }
    }
}
