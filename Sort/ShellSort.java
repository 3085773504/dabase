package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/*
 * 希尔排序算法，20万数据量排序时间不到一秒
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 0; i < 200000; i++) {
            arr[i] = (int) Math.random() * 8000000;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String qian = simpleDateFormat.format(date);
        System.out.println("排序前的时间：" + qian);
        shellSort(arr);
        Date date1 = new Date();
        String hou = simpleDateFormat.format(date1);
        System.out.println("排序后的时间：" + hou);
    }
    public static void shellSort(int[] arr){
        int gap = arr.length/2;
        while (gap > 0){
            for (int i = 0; i < gap; i++){
                for (int j = 1; j < arr.length/gap; j++){
                    int index = i+gap*j;
                    int indexVal = arr[i+gap*j];
                    while (index-gap>=0 && arr[index-gap] > indexVal){
                        arr[index] = arr[index-gap];
                        index -= gap;
                    }
                    if (index != i+gap*j){
                        arr[index] = indexVal;
                    }
                }
            }
            gap /= 2;
        }
    }
}
