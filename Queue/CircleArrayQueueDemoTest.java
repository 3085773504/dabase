package Queue;

import java.util.Scanner;

public class CircleArrayQueueDemoTest {
    public static void main(String[] args) {
        CircleArray1 circleArray1 = new CircleArray1(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop){
            System.out.println("s(show)，显示队列");
            System.out.println("a(add)，添加数据到队列");
            System.out.println("g(get)，取出队列中的值");
            System.out.println("h(head)，查看队列头部数据");
            System.out.println("e(exit)，退出程序");
            System.out.println("请输入要执行的的操作：");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    circleArray1.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int n = scanner.nextInt();
                    circleArray1.addQueue(n);
                    break;
                case 'g':
                    try {
                        int queue = circleArray1.getQueue();
                        System.out.println("取出的值为：" + queue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = circleArray1.headQueue();
                        System.out.println("队列头为：" + i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    System.out.println("退出程序……");
                    break;
            }
        }
    }
}
class CircleArray1{
    private int front;//队首
    private int rear;//队尾
    private int maxSize;//队列的大小
    private int[] arr;//存储数据，用来模拟队列
    public CircleArray1(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //像队列中添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满！添加失败！");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将队尾后移，需要考虑取模
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列没有数据！");
        }
        int vaule = arr[front];
        front = (front + 1) % maxSize;
        return vaule;
    }
    //显示队列中所有的数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列没有数据！");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //求出当前队列的有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列头的数据
    public int headQueue(){
        if (isEmpty()){
           throw new RuntimeException("队列没有数据！");
        }
        return arr[front];
    }
}
