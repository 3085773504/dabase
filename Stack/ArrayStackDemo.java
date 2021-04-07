package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        boolean loop = true;
        ArrayStack arrayStack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("请输入你的选择：");
            System.out.println("1：向栈中加入数据");
            System.out.println("2：取出栈顶数据");
            System.out.println("3：显示栈中的数据");
            System.out.println("4：退出程序");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("请输入你要加入的数据：");
                    int data = scanner.nextInt();
                    arrayStack.push(data);
                    break;
                case 2:
                    try {
                        int getData = arrayStack.pop();
                        System.out.println("出去的栈顶数据为：" + getData);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        arrayStack.list();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出~~");
            }
        }
    }
}
//定义一个ArrayStack表示栈
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//top表示栈顶，初始化为-1；
    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //判断栈是否满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //判断栈是否空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈 push
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈 pop 将栈顶的数据返回
    public int pop(){
        //先判断栈是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况（遍历栈），遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
        }
        //需要从栈顶开始遍历数据
        for (int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
