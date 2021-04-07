package LinkedList;

public class SingleLinkedListDemoTest3 {
    public static void main(String[] args) {
        HeroNodeTest3 hero1 = new HeroNodeTest3(1, "一", "一");
        HeroNodeTest3 hero2 = new HeroNodeTest3(2, "一", "一");
        HeroNodeTest3 hero3 = new HeroNodeTest3(3, "一", "一");
        SingleLinkedListTest3 singleLinkedListTest3 = new SingleLinkedListTest3();
        singleLinkedListTest3.add(hero1);
        singleLinkedListTest3.add(hero2);
        singleLinkedListTest3.add(hero3);
        HeroNodeTest3 hero4 = new HeroNodeTest3(3, "13", "一");
        singleLinkedListTest3.alter(hero4);
        singleLinkedListTest3.show();
    }
}
class SingleLinkedListTest3{
    //先创建一个头节点，头节点不存放任何数据
    private HeroNodeTest3 head = new HeroNodeTest3(0,"","");
    //插入节点，将数据插入到链表的尾部
    public boolean add(HeroNodeTest3 hero){
        //先创建一个头指针变量指向头结点
        HeroNodeTest3 temp = head;
        //遍历链表到链表的末尾
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //到此部已经遍历到链表的尾部
        temp.next = hero;
        System.out.println("插入节点成功！");
        return true;
    }
    //删除指定编号的节点
    public boolean del(int no){
        //先创建一个头指针指向头节点
        HeroNodeTest3 temp = head;
        //判断链表是否为空
        if (temp.next == null){
            System.out.println("链表为空，没有任何数据！");
            return false;
        }
        //声明一个标志位变量来判断是否找到该编号
        boolean flag = false;
        //遍历链表
        while (temp.next != null){
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
            System.out.println("删除节点信息成功！");
            return true;
        }else {
            System.out.println("没有找到该编号");
            return false;
        }
    }
    //修改制定编号的节点
    public boolean alter(HeroNodeTest3 heroNodeTest3){
        //先创建辅助指针指向头指针
        HeroNodeTest3 temp = head;
        //判断链表是否为空
        if (temp.next == null){
            System.out.println("链表为空！没有任何数据！");
            return false;
        }
        boolean flag = false;//定义标志位变量，用来表示是否找到待修改的节点
        while (temp != null){
            if (heroNodeTest3.no == temp.no){//代表找到了该节点
                flag = true;
                break;
            }
            //否则继续往下遍历
            temp = temp.next;
        }
        if (flag){
            temp.no = heroNodeTest3.no;
            temp.nickname = heroNodeTest3.nickname;
            temp.name = heroNodeTest3.name;
            System.out.println("修改成功！");
            return true;
        }else {
            System.out.println("没有找到该编号的信息！");
            return false;
        }
    }
    //查询链表中的信息
    public void show(){
        //定义一个辅助指针
        HeroNodeTest3 temp = head.next;
        //判断链表是否为空
        if (temp.next == null){
            System.out.println("链表为空！没有任何数据！");
            return;
        }
        while (temp != null){
            System.out.println(temp.toString());
            System.out.println();
            temp = temp.next;
        }
    }
}
class HeroNodeTest3{
    public int no;
    public String name;
    public String nickname;
    public HeroNodeTest3 next;
    public HeroNodeTest3(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "HeroNodeTest3{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
