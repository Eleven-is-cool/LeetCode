package 京东一;
/*
第n个数
时间限制： 3000MS
内存限制： 589824KB
题目描述：
自从学了素数以后，小明喜欢上了数字2、3和5。当然，如果一个数字里面只出现2、3和5这三个数字，他也一样喜欢，例如222、2355、223355。

现在他希望你能够帮他编写一个程序，快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5。



输入描述
单组输入。

每组输入数据占1行，每行输入一个正整数n。（n<=1000）

输出描述
每组输出数据占1行，即满足要求的第n个数。


样例输入
3
样例输出
5
 */
import java.util.*;

//public class Main {
//    public int helper(int k){
//        List<String> res = new ArrayList<>();
//        for (int i=1; i<=10; i++){
//            getList(i, res);
//        }
//        String cur = res.get(k-1);
//        return Integer.parseInt(cur);
//    }
//    public List<String> getList(int k, List<String> res){
//        int[] num = {2, 3, 5};
//        StringBuilder list = new StringBuilder();
//        backTrack(num, list, 0, k, res);
//        return res;
//
//    }
//    public void backTrack(int[] num, StringBuilder list, int start, int k, List<String> res){
//
//        if (list.length() == k){
//            res.add(list.toString());
//            return;
//        }
//        for(int i = 0; i < num.length; i++){
//            list.append(num[i]);
//            backTrack(num, list, i, k, res);
//            list.deleteCharAt(list.length()-1);
//        }
//    }
//    public static void main(String[] args) {
//        Main a = new Main();
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int N = sc.nextInt();
//            System.out.println(a.helper(N));
//        }
//    }
//}
public class Main {
    public int BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        int i = 0;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            i++;
            if (i == n)
                return temp;
            queue.add(temp*10+2);
            queue.add(temp*10+3);
            queue.add(temp*10+5);
        }
        return 0;
    }

    public static void main(String[] args) {
        Main a = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            System.out.println(a.BFS(N));

        }
    }
}