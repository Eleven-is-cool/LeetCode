package 广联达;

public class Main {
}
/*
public class t01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr,m,x));
    }

    public static int solve(int[] arr,int m,int x){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if (arr[i]>max){
                max = arr[i];
            }
        }
        while (m>0){
            int cur = pq.poll();
            while (m>0&&cur+x<max){
                cur+=x;
                m--;
            }
            pq.add(cur);
        }
        return pq.peek();
    }
}```
/*
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int hp = sc.nextInt();
            map.put(x,hp);
        }
        int count = 0;
        for (int item:map.keySet()) {
            int x =map.get(item);
            if (x>0){
                for (int other:map.keySet()) {
                    if (other<=item+2*y){
                        map.put(other,map.get(other)-x);
                    }
                }
                count+=x;
            }

        }
        System.out.println(count);
    }

}

 */

/*

t02机器人

```java
public class t02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        int[] value = new int[n];
        float[] cost = new float[n];
        for (int i=0;i<n;i++){
            cost[i] = sc.nextFloat();
            value[i] = sc.nextInt();
        }
        System.out.println(solve(C,value,cost));
    }

    public static int solve(int bag,int[] value,float[] cost){
        int[][] dp = new int[value.length+1][bag+1];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (j-cost[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][(int) (j-cost[i-1])]+value[i-1]);
                }
            }
        }
        return dp[value.length][bag];

    }
}```
*/
/*

t03

```java
public class t03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i=0;i<n;i++){
            list[i] = sc.nextInt();
        }
        List<Integer> res = adjustArray(list);
        for (int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }

    }
    public static List<Integer> adjustArray(int[] nums) {
        //使用优先队列对数据进行调
        List<Integer> list = new ArrayList<Integer>();
        for (int m : nums) {
            list.add(m);
        }
        Iterator<Integer> iterator = list.iterator();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        //入队列
        while (iterator.hasNext()) {
            queue.offer(iterator.next());
        }

        for (int n = 0; n < queue.size(); n++) {
            //取出最小值
            int min = queue.poll();
            //计算重复次数
            int count = 0;
            //定位重复元素的索引
            int fristIndex = 0;
            int secondIndex = 0;
            //验证最小值是否重复
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == min) {
                    count++;
                    //数据重复
                    if (count == 1){
                        fristIndex = i;
                    }
                    if (count == 2) {
                        //定位第二个重复数据
                        secondIndex = i;
                        break;
                    }
                }
            }
            //如果有重复数据,删除第一个重复数据，修改第二个重复数据，并且更新队列
            if (count == 2) {
                int cur = list.get(secondIndex)*2;
                list.set(secondIndex, cur);
                list.remove(fristIndex);
                //修改后，更新队列
                queue.poll();
                queue.add(cur);
            }
            //更新计数器
            count = 0;
            //更新n
            n = 0;
        }
        return list;
        }
    }```


 **/
