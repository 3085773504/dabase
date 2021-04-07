package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemoTest {
    public static void main(String[] args) {
//进行测试，先创建节点
        HeroNodeTest heroNode1 = new HeroNodeTest(1, "宋江", "及时雨");
        HeroNodeTest heroNode2 = new HeroNodeTest(2, "卢俊义", "玉麒麟");
        HeroNodeTest heroNode3 = new HeroNodeTest(3, "吴用", "智多星");
        HeroNodeTest heroNode4 = new HeroNodeTest(4, "林冲", "豹子头");
//        //创建要给的链表
        SingleLinkedListTest singleLinkedList = new SingleLinkedListTest();
        //加入
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //按编号的顺序插入
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        //显示一把
        singleLinkedList.list();
        System.out.println("逆序输出的链表：");
        reversePrint(singleLinkedList.getHead());
//        System.out.println("反转后的链表：");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
//        HeroNodeTest heroNodeTest = new HeroNodeTest(2,"小卢","玉麒麟~~");
//        singleLinkedList.update(heroNodeTest);
//        //更新后的结果
//        System.out.println("更新后的结果");
//        singleLinkedList.list();
////        singleLinkedList.del(1);
////        singleLinkedList.del(2);
////        singleLinkedList.del(3);
////        singleLinkedList.del(4);
////        System.out.println("删除后的结果");
////        singleLinkedList.list();
//        System.out.println("有效节点的个数为：" + getLength(singleLinkedList.getHead()));
//        HeroNodeTest heroNodeTest1 = findLastIndexNode(singleLinkedList.getHead(),3);
//        System.out.println(heroNodeTest1);

    }
    public static void reversePrint(HeroNodeTest head){
        if (head.next == null){
            return;
        }
        HeroNodeTest cur = head.next;
        Stack<HeroNodeTest> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    public static void reverseList(HeroNodeTest head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNodeTest cur = head.next;
        HeroNodeTest next = null;
        HeroNodeTest reverseHead = new HeroNodeTest(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public static HeroNodeTest findLastIndexNode(HeroNodeTest head, int index){
        //如果链表为空，则返回null
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        HeroNodeTest cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public static int getLength(HeroNodeTest head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNodeTest cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
class SingleLinkedListTest{
    private HeroNodeTest head = new HeroNodeTest(0,"","");

    public HeroNodeTest getHead() {
        return head;
    }

    public void add(HeroNodeTest heroNodeTest){
        HeroNodeTest temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNodeTest;
    }
    public void addByOrder(HeroNodeTest heroNodeTest){
        HeroNodeTest temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNodeTest.no){
                break;
            }else if (temp.next.no == heroNodeTest.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("要插入的%d号英雄已经存在\n",heroNodeTest.no);
        }else {
            heroNodeTest.next = temp.next;
            temp.next = heroNodeTest;
        }
    }
    public void update(HeroNodeTest newHeroNodeTest){
        if (head.next == null){
            return;
        }
        HeroNodeTest temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNodeTest.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNodeTest.name;
            temp.nickname = newHeroNodeTest.nickname;
        }else {
            System.out.printf("没有找到编号为%d的记录\n",newHeroNodeTest.no);
        }
    }
    public void del(int no){
        HeroNodeTest temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的编号%d不存在",no);
        }
    }
    public void list(){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        HeroNodeTest temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}
class HeroNodeTest{
    public int no;
    public String name;
    public String nickname;
    public HeroNodeTest next;
    public HeroNodeTest(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNodeTest{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
