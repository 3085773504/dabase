package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 选择排序算法，20万数据时间13秒
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 0; i < 200000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String qian = simpleDateFormat.format(date);
        System.out.println("排序前的时间：" + qian);
        selectSort(arr);
        Date date1 = new Date();
        String hou = simpleDateFormat.format(date1);
        System.out.println("排序后的时间：" + hou);
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假定最小数的索引
            int min = arr[i];//假定最小数
            for (int j = i + 1; j < arr.length; j++){
                if (min > arr[j]){//如果假定的数不是最小值
                    minIndex = j;//更新最小值的索引
                    min = arr[j];//更新最小值
                }
            }
            //交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "轮后");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
