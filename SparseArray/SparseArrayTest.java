package SparseArray;

public class SparseArrayTest {
    public static void main(String[] args) {
        //先创建一个二维数组10*10
        int[][] chessArr1 = new int[10][8];
        //给二维数组赋若干个值
        chessArr1[2][1] = 10;
        chessArr1[5][1] = 20;
        chessArr1[8][7] = 30;
        //遍历二维数组
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }
        //获取有有效数字
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        int count = 0;
        //给稀疏数组赋值
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //遍历稀疏数组
        System.out.println("新的稀疏数组为：");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将稀疏数组赋值给二维数组
        int[][] chessArry2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++){
            chessArry2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("新的二维数组为");
        for (int[] row : chessArry2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
