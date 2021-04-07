package Queue;

import java.util.Scanner;

public class ArraryQueueDemoTest2 {
    public static void main(String[] args) {
        //测试
        System.out.println("请输入要创建多大的队列：");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        boolean state = true;
        ArrayQueueTest2 arrayQueueTest = new ArrayQueueTest2(size);

        while (state){
            System.out.println("请选择你要执行的操作：");
            System.out.println("1.添加数据到队列");
            System.out.println("2.取出队列中的数据");
            System.out.println("3.查看队列中的队头数据");
            System.out.println("4..查看队列中的所有数据");
            System.out.println("5.退出系统");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("请输入你要添加的数据：");
                    int data = scanner.nextInt();
                    arrayQueueTest.add(data);
                    break;
                case 2:
                    try {
                        int getData = arrayQueueTest.del();
                        System.out.println("取出的数据为：" + getData);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int getHead = arrayQueueTest.getHead();
                        System.out.println("队头数据为：" + getHead);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    arrayQueueTest.show();
                    break;
                case 5:
                    scanner.close();
                    state = true;
                    System.out.println("退出程序~~");
                    System.exit(0);

            }
        }
    }
}
class ArrayQueueTest2{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public ArrayQueueTest2(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //入队列
    public void add(int n){
        //先判断队列是否为满
        if (isFull()){
            System.out.println("队列已满，无法添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
        System.out.println("添加成功！");
    }
    //出队列
    public int del(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }
    //显示队列的头部
    public int getHead(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front + 1];
    }
    //显示队列中的数据
    public void show(){
        //先判断队列是否为空
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
}
