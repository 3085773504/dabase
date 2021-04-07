package SparseArray;

public class SparseArrayTest3 {
    public static void main(String[] args) {
        //先创建一个二维数组
        int[][] arr1 = new int[10][10];
        arr1[1][1] = 1;
        arr1[2][2] = 2;
        //遍历二维数组
        System.out.println("原始的二维数组：");
        for (int[] row : arr1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //拿到二维数组中的非零的个数
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[1].length; j++) {
                if (arr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = arr1.length;
        sparseArray[0][1] = arr1[0].length;
        sparseArray[0][2] = sum;
        //给稀疏数组赋值
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr1[i][j];
                }
            }
        }
        //遍历稀疏数组
        System.out.println("赋值后的稀疏数组为：");
        for (int[] row : sparseArray){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //稀疏数组还原成二维数组
        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < 3; j++){
                arr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }
        //输出通过稀疏数组赋值的二维数组
        System.out.println("输出通过稀疏数组赋值的二维数组");
        for (int[] row : arr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
