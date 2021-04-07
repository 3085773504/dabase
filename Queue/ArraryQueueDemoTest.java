package Queue;

import java.util.Scanner;

/*
    2021/1/2第一次复习顺序队列
 */
public class ArraryQueueDemoTest {
    public static void main(String[] args) {
        //测试
        System.out.println("请输入要创建多大的队列：");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        boolean state = true;
        ArrayQueueTest arrayQueueTest = new ArrayQueueTest(size);

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
                        int getData = arrayQueueTest.get();
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
class ArrayQueueTest{
    private int maxSize;//表示队列的最大容量
    private int front;//表示指向队头的指针
    private int rear;//表示指向队尾的指针
    private int[] arr;//用来模拟队列存储数据
    public ArrayQueueTest(int maxSize){
        this.maxSize = maxSize;
        front = -1;//队头的初始坐标
        rear = -1;//队尾的初始坐标
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
    //像队列中添数据
    public void add(int n){
        //先判断队里中是否已满
        if (isFull()){
            //如果队列已满则直接结束方法
            System.out.println("队列已满！无法添加数据！");
            return;
        }
        //如果未满则rear后移，并将数据添加
        rear++;
        arr[rear] = n;
        System.out.println("添加成功！");
    }
    //在队列中取出数据
    public int get(){
        //先判断队列是否为空
        if (isEmpty()){
            //如果队列为空，则不能取出数据
            throw new RuntimeException("队列为空！不能取出数据！");
        }
        //如果队列为空，则取出数据，front后移
        front++;
        return arr[front];
    }
    //查看队列的队头数据
    public int getHead(){
        //先判断队列是否为空
        if (isEmpty()){
            //如果为空，则不能取出数据
            throw new RuntimeException("队列为空！不能取出数据！");
        }
        //如果不为空，则直接返回队头的数据
        return arr[front + 1];//因为front指向的是队头的前一位
    }
    //显示队列的所有数据
    public void show(){
        //先判断队列是否为空
        if (isEmpty()){
            System.out.println("队列为空！没有任何数据！");
            return;
        }
        //如果不为空，则遍历队列中的数据
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
}
