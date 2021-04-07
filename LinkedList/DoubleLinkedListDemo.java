package LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "1", "1");
        HeroNode2 heroNode2 = new HeroNode2(2, "1", "1");
        HeroNode2 heroNode3 = new HeroNode2(3, "1", "1");
        HeroNode2 heroNode4 = new HeroNode2(4, "1", "1");
        HeroNode2 heroNode5 = new HeroNode2(5, "1", "1");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addOrderBy(heroNode1);
        doubleLinkedList.addOrderBy(heroNode3);
        doubleLinkedList.addOrderBy(heroNode4);
        doubleLinkedList.addOrderBy(heroNode5);
        doubleLinkedList.addOrderBy(heroNode2);
        doubleLinkedList.show();
    }
}
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
    //向链表中顺序添加数据的方法
    public void addOrderBy(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNode2.no){
                flag = true;
                break;
            }
            if (temp.next.no > heroNode2.no){
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("此编号已经存在,添加失败");
        }else {
            heroNode2.next = temp.next;
            temp.next = heroNode2;
            heroNode2.pre = temp;

        }
    }
    //链表中添加数据的方法
    public void add(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
        System.out.println("添加成功！");
    }
    //删除链表中数据的方法
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空！没有数据");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
            System.out.println("删除成功！");
        }else {
            System.out.printf("没有找到编号为%d的英雄",no);
        }
    }
    //修改链表中数据的方法
    public void update(HeroNode2 heroNode2){
        if (head.next == null){
            System.out.println("列表为空，没有任何数据");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == heroNode2.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;
        }else {
            System.out.println("没有找到该节点的信息");
        }
    }
    //查询链表中的数据的方法
    public void show(){
        if (head.next == null){
            System.out.println("链表为空，没有数据！");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    //构造器
    public HeroNode2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}