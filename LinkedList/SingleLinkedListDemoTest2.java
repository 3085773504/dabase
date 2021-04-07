package LinkedList;

import java.util.Stack;

/*
    2021/1/3第二次复习
 */
public class SingleLinkedListDemoTest2 {
    public static void main(String[] args) {
        SingleLinkedListTtst2 SingleLinkedListTtst2 = new SingleLinkedListTtst2();
        HeroNodeTest2 heroNodeTest = new HeroNodeTest2(1,"123","456");
        HeroNodeTest2 heroNodeTest1 = new HeroNodeTest2(2,"123","456");
        HeroNodeTest2 heroNodeTest2 = new HeroNodeTest2(3,"123","456");
        SingleLinkedListTtst2.addOrderBy(heroNodeTest2);
        SingleLinkedListTtst2.addOrderBy(heroNodeTest1);
        SingleLinkedListTtst2.addOrderBy(heroNodeTest);
        SingleLinkedListTtst2.show();
        System.out.println("逆序输出后的链表");
        reversePrint(SingleLinkedListTtst2.getHead());
//        System.out.println("反转后的链表：");
//        reversList(SingleLinkedListTtst2.getHead());
//        SingleLinkedListTtst2.show();
//        HeroNodeTest2 heroNodeTest3 = new HeroNodeTest2(3,"2546","456");
//        SingleLinkedListTtst2.update(heroNodeTest3);
//        SingleLinkedListTtst2.show();
//        System.out.println(findLastIndexNode(SingleLinkedListTtst2.getHead(), 1));
    }
    //实现链表的逆序输出
    public static void reversePrint(HeroNodeTest2 head){
        if (head.next == null){
            return;
        }
        HeroNodeTest2 cur = head.next;
        Stack<HeroNodeTest2> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    //实现链表的反转
    public static void reversList(HeroNodeTest2 head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNodeTest2 cur = head.next;
        HeroNodeTest2 next = null;
        HeroNodeTest2 reverseHead = new HeroNodeTest2(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
    //找到链表中的导数第K个节点
    public static HeroNodeTest2 findLastIndexNode(HeroNodeTest2 head,int index){
        if (head.next == null){
            return null;
        }

        int size = getLength(head);
        if (index < 0 || index > size){
            return null;
        }
        HeroNodeTest2 temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //获取链表节点的个数（不算入头结点）
    public static int getLength(HeroNodeTest2 head){
        if (head.next == null){
            return 0;
        }
        HeroNodeTest2 temp = head.next;
        int length = 0;
        while (true){

            if (temp != null){
                length++;
                temp = temp.next;
            }else {
                break;
            }
        }
        return length;
    }

}
class SingleLinkedListTtst2{
    //先创建一个头指针，该指针不存放任何数据
    private HeroNodeTest2 head = new HeroNodeTest2(0,"","");
    //返回头结点

    public HeroNodeTest2 getHead() {
        return head;
    }

    //向链表中添加一个节点
    public void add(HeroNodeTest2 heroNodeTest2){
        //定义一个辅助变量
        HeroNodeTest2 temp = head;
        while (true){
            //找到链表的最后节点
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNodeTest2;
    }
    //按编号的顺序向链表中添加节点
    public void addOrderBy(HeroNodeTest2 heroNodeTest2){
        HeroNodeTest2 temp = head;
        boolean flag = false;//定义一个标志位变量，判断这个编号有没有存在
        while (true){
            //先判断链表是否为空
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNodeTest2.no){
                flag = true;
                break;
            }
            if(temp.next.no > heroNodeTest2.no){
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("您添加的节点编号已经存在");
        }else {
            heroNodeTest2.next = temp.next;
            temp.next = heroNodeTest2;
            System.out.println("添加节点成功！");
        }
    }
    //在链表中删除一个节点
    //靠编号来删除
    public void del(int no){
        //先判断链表是否为空
        if (head.next == null){
            System.out.println("链表中没有数据！");
            return;
        }
        //定义一个辅助变量，因为头结点不能移动
        HeroNodeTest2 temp = head;
        boolean flag = false;//定义一个标志位变量来判断有没有找到相应的编号
        while (true){
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
            System.out.println("删除节点信息成功！");
        }else {
            System.out.println("没有找到该编号的英雄");
        }
    }
    //修改节点
    public void update(HeroNodeTest2 heroNodeTest2){
        //先判断链表中是否为空
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //定义一个辅助变量，因为头节点不能动
        HeroNodeTest2 temp = head;
        boolean flag = false;//定义一个标志位变量来判断有没有找到相对应的编号
        while (true){
            if (temp.next.no == heroNodeTest2.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next.name = heroNodeTest2.name;
            temp.next.nickname = heroNodeTest2.nickname;
            System.out.println("修改成功！");
        }else {
            System.out.println("没有找到该节点的信息");
        }
    }
    //显示链表的节点信息
    public void show(){
        //先判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空，没有数据！");
            return;
        }
        //定义一个辅助变量，因为在遍历的过程中头结点是不能移动的
        HeroNodeTest2 temp = head.next;
        while (true){
            if (temp == null){//判断下一个节点是否为空
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNodeTest2{
    public int no;//编号
    public String name;//名字
    public String nickname;//绰号
    public HeroNodeTest2 next;//指向下一个节点的指针
    public HeroNodeTest2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "HeroNodeTest2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
