package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotaionTest {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        System.out.println("list = " + listString);
        int calculate = calculate(listString);
        System.out.println("计算结果为：" + calculate);
    }
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split){
            list.add(ele);
        }
        return list;
    }
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls){
            if (item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
