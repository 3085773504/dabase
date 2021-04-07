package Queue;

import java.util.Scanner;

/*
    2021/1/3日循环队列第二次复习
    遍历队列数据环节出错！重点复习
 */
public class CircleArrayQueueDemoTest2 {
    public static void main(String[] args) {
        System.out.println("请输入你要创建多大的队列：");
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        CircleArrayQueueTest2 circleArrayQueueTest2 = new CircleArrayQueueTest2(maxSize);
        boolean state = true;
        while (state){
            System.out.println("请输入你要执行的操作");
            System.out.println("1.添加数据到队列");
            System.out.println("2.取出队列中的元素");
            System.out.println("3.查看队列的头元素");
            System.out.println("4.查看队列的数据");
            System.out.println("5.查看队列的有效数据的个数");
            System.out.println("6.退出程序");
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    //添加数据到队列的操作
                    System.out.println("请输入你要添加的数据");
                    int n = scanner.nextInt();
                    circleArrayQueueTest2.add(n);
                    break;
                case 2:
                    //取出队列中的元素
                    try {
                        int i = circleArrayQueueTest2.get();
                        System.out.println("取出的数据为：" + i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    //查看队列的头元素
                    try {
                        int head = circleArrayQueueTest2.head();
                        System.out.println("头元素的数据为：" + head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    //查看队列的数据
                    circleArrayQueueTest2.show();
                    break;
                case 5:
                    //查看队列的有效数据的个数
                    int size = circleArrayQueueTest2.size();
                    System.out.println("有效数据的个数为：" + size);
                    break;
                case 6:
                    //退出程序
                    scanner.close();
                    state = false;
                    System.out.println("退出程序~~");
            }
        }
    }
}
class CircleArrayQueueTest2{
    private int front;//指向队头的元素，初始化指向0
    private int rear;//指向队尾的元素，初始化指向0
    private int maxSize;//队列容纳的最大数据的个数
    private int[] arr;//用来模拟队列，存储数据
    public CircleArrayQueueTest2(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //向队列中添加数据
    public void add(int n){
        //先判断队列是否为满
        if (isFull()){
            System.out.println("队列已满，不能添加数据！");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        System.out.println("添加数据成功！");
    }
    //取出队列中的数据
    public int get(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据!");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //查看队头的元素
    public int head(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }
    //查看队列中的数据
    public void show(){
        //先判断队列是否为空
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\t",i,arr[i]);
        }
        System.out.println();
    }
    //求出当前队列的有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}
