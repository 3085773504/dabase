package KMP;

public class BaoLiPiPei {
    public static void main(String[] args) {
        String str1 = "1234567890";
        String str2 = "567";
        System.out.println(baoLiPiPei(str1,str2));
    }
    public static int baoLiPiPei(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2Len){
            return i-j;
        }else {
            return -1;
        }
    }
}
