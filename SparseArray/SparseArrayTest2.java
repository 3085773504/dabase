package SparseArray;
/*
    2021/1/2第二次复习
 */
public class SparseArrayTest2 {
    public static void main(String[] args) {
        //先创建一个二维数组
        int[][] arr = new int[10][10];
        arr[1][2] = 10;
        arr[1][3] = 20;
        System.out.println("原来的二维数组：");
        for (int[] row : arr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //先拿到二维数组中的非零数据的个数
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组的第一行赋值
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        //对稀疏数组中存放的二维数组数据赋值
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        //输出构建完成的稀疏数组
        System.out.println("构造完成的稀疏数组：");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //然后再将稀疏数组转换成二维数组
        //首先创建一个二维数组
        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组中存放的数据
        //i从1开始遍历
        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }
        //输出通过稀疏数组创建的二维数组
        System.out.println("通过稀疏数组还原的二维数组");
        for (int[] row : arr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
