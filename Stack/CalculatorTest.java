package Stack;

public class CalculatorTest {
    public static void main(String[] args) {
        String expression = "300+2*6-2";
        ArrayStackTest2 numStack = new ArrayStackTest2(10);
        ArrayStackTest2 operStack = new ArrayStackTest2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index + 1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
//                numStack.push(ch - 48);
                keepNum += ch;
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("%s = %d",expression,numStack.pop());
    }
}
class ArrayStackTest2{
    private int top = -1;
    private int[] stack;
    private int maxSize;
    public ArrayStackTest2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //查询栈顶数据的方法
    public int peek(){
        return stack[top];
    }
    //判断栈是否满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //判断栈是否空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        //判断栈是否为满
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
            System.out.printf("stack[%d] = %d",i,stack[i]);
        }
    }
    //判断运算符的优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
