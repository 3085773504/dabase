package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试，先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(10, "林冲2", "豹子头");
        HeroNode heroNode6 = new HeroNode(6, "林冲22", "豹子头");
        HeroNode heroNode7 = new HeroNode(80, "林冲33", "豹子头");

//        //创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        //加入
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode2);
        singleLinkedList1.add(heroNode5);
        singleLinkedList1.add(heroNode6);
        singleLinkedList1.add(heroNode7);
        mergeList(singleLinkedList.getHead(),singleLinkedList1.getHead());
        //按照编号的顺序加入
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode2);
//        //显示一把
//        singleLinkedList.list();
//        System.out.println("逆序输出后的链表");
//        reversePrint(singleLinkedList.getHead());
//        System.out.println("反转后的链表：");
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();
//        HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(heroNode);
//        //修改后的结果
//        System.out.println("修改后的结果");
//        singleLinkedList.list();
////        singleLinkedList.del(1);
////        singleLinkedList.del(2);
////        singleLinkedList.del(3);
////        singleLinkedList.del(4);
////        System.out.println("删除后的结果");
////        singleLinkedList.list();
//        System.out.println("有效的节点个数" + getLength(singleLinkedList.getHead()));
//        //测试输出倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),3);
//        System.out.println("res = " + res);

    }
    //实现两个链表的合并，并按顺序排列(练习)
    public static void mergeList(HeroNode head1,HeroNode head2){
        if (head1.next == null && head2.next == null){
            return;
        }
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        while (cur1 != null){
            stack.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            stack.push(cur2);
            cur2 = cur2.next;
        }
        while (stack.size() > 0){
            singleLinkedList.addByOrder(stack.pop());
        }
        singleLinkedList.list();
    }
    //将单链表逆序输出（百度面试题）
    //可以利用栈这个结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        //创建一个栈，将各个节点压入
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    //将单链表进行反转（腾讯面试题）
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        //动脑筋
        while (cur != null){
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最后端
            reverseHead.next = cur;
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第K个节点（新浪微博面试题）
    //思路
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示是倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总的长度getLength
    //4.得到size之后，我们从链表的第一个开始遍历（size - index）个，就可以看到
    //5.如果找到了，则返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if (head.next == null){
            return null;
        }
        //第一个遍历得到链表的长度（节点个数）

        int size = getLength(head);
        //第二次遍历，size - index的位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index < 0 || index > size){
            return null;
        }
        //定义给辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //获取到单链表的节点个数（如果有头结点， 则减去头结点）
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
//定义SingleLinkdeList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助的遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null)  {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }
    //第二种方式在添加英雄时，根据排名将英雄插入到指定的位置
    //如果有这个排名，则添加失败，否则添加成功
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//falg标志添加的编号是否存在，默认为flase
        while (true){
            if (temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no){//说明希望添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag){//不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //修改节点的信息，根据no编号来修改，no编号不能被修改
    //说明
    //1.根据no来修改即可
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编写
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            if (temp == null){
                break;//表示已经遍历完该链表
            }
            if (temp.no == newHeroNode.no){
                //表示找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            //还没找到
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp = head;
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
            System.out.printf("要删除的编号为%d的节点不存在\n",no);
        }
    }
    //显示链表（遍历）
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表中没有数据");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表的最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
//定义HeroNode ，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示遍历，我们重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
