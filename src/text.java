

//   数字 字母 空格
//   小写
//   格式
// 1. 分词：连续数字 字母
// 2. 词与词空格分隔
// 3. 一行最多80个字符
// 4. 词跨行，下一行输出
// 5. 如果特长，最多保留80个字符，其余丢弃




//public class text {
//    public String helper(String string){
//        StringBuilder s = new StringBuilder(string);
//        int preIndex = 0;
//        int len = 0;
//        StringBuilder res = new StringBuilder();
//        for (int i = 1; i < s.length(); i++){
//
//            if (s.charAt(i) == s.charAt(preIndex) && s.charAt(preIndex)!=' '){
//                break;
//            }
//            preIndex = i;
//            String cur = s.substring(preIndex, i);
//            if (cur.length() > 80)
//                cur = cur.substring(0,81);
//
//            res.append(cur+" ");
//
////            len += i-preIndex;
//
//        }
//        for (int i = 1; i < res.length()+1; i++){
//            if (i%80 == 0){
//                System.out.println(res.substring(i-1,i+80));
//            }
//        }
//
//
//
//    }
//}
