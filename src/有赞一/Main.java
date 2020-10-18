package 有赞一;

public class Main {
    public long sum (int num, int itemNum) {
        // write code here
        long res = 0;
        int pre = 0;
        for (int i =1; i<= itemNum; i++){
            pre = pre *10 + num;
            res += pre;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Main().sum(3, 5));
    }

}
