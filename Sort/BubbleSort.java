package Sort;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 冒泡排序算法 20万数据时间一分十七秒
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {100,10,20,11,40,21,23,14};
        int[] arr = new int[200000];
        for (int i = 0; i < 200000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String qian = simpleDateFormat.format(date);
        System.out.println("排序前的时间：" + qian);
//        System.out.println("排序前的结果：");
//        System.out.println(Arrays.toString(arr));
        BubbleSort(arr);
        Date date1 = new Date();
        String hou = simpleDateFormat.format(date1);
        System.out.println("排序后的时间：" + hou);
//        System.out.println("排序后的结果:");
//        System.out.println(Arrays.toString(arr));
    }
    public static void BubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;//标志位变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
//            System.out.println("第" + (i + 1) + "趟排序的结果");
//            System.out.println(Arrays.toString(arr));
            if (!flag){
                break;
            }else {
                flag = false;//重置标志位变量，为了下一趟排序做判断
            }
        }
    }
}
