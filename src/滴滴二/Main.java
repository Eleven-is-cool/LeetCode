package 滴滴二;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int z = sc.nextInt();
            int n = 0;
            for (int i = 0; i < z; i++){
                n = sc.nextInt();
                UnionFind u = new UnionFind(n);


                int m = sc.nextInt();
                int k = sc.nextInt();
                for (int j = 0; j < m; j++){
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int c = sc.nextInt();
                    if (c <= k){
                        int one = u.find(a);
                        int two = u.find(b);
                        u.union(one, two);
                    }

                }
                if (u.count() == 1) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }

        }
    }
}

class UnionFind {

    private int[] record;
    private int count;//岛屿数目

    public UnionFind(int n) {
        record = new int[n+1];
        for (int i = 0;i <= n;i++) {
            record[i] = i;
        }
        count = n;
    }

    public int find(int p) {
        if (p != record[p])
            record[p] = find(record[p]);
        return record[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //造桥
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid)
            return;
        record[pid] = qid;
        count--;//联通的岛屿算成一个
    }

    public int count() {
        return count;
    }
}


