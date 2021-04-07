package Stack;

import java.util.Scanner;

public class ArrayStackDemoTest {
    public static void main(String[] args) {
        boolean loop = true;
        ArrayStackTest arrayStack = new ArrayStackTest(5);
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
                        arrayStack.show();
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
class ArrayStackTest{
    private int maxSize;
    private int[] stack;
    private int top = -1;
    public ArrayStackTest(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        //判断栈是否为空
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        //判断栈是否为空
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void show(){
        //判断栈是否为空
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
