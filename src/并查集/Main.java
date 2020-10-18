package 并查集;

public class Main {



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
