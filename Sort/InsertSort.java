package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 插入排序算法 20万数据量排序时间4秒
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 0; i < 200000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String qian = simpleDateFormat.format(date);
        System.out.println("排序前的时间：" + qian);
        insertSort(arr);
        Date date1 = new Date();
        String hou = simpleDateFormat.format(date1);
        System.out.println("排序后的时间：" + hou);
    }
    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++){
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
