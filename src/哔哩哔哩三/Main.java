package 哔哩哔哩三;

public class Main {
    public int GetFragment (String str) {
        // write code here
        char pre = str.charAt(0);
        int len = 0;
        int count = 0;
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) != pre){
                count++;
            }
            len++;
            pre = str.charAt(i);
        }
        return len/count;
    }

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] num = new int[n];
//            for (int i = 0; i < n; i++){
//                num[n] = sc.nextInt();
//            }
//
////            System.out.println(new 哔哩哔哩一.Main().helper(num));
//        }

        System.out.println(new 哔哩哔哩二.Main().SpiralMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
