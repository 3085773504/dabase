package LinkedList;

public class DoubleLinkedListDemoTest {

}
//class DoubleLinkedList2{
//    //先定义一个头节点
//    private HeroNode3 head = new HeroNode3(0," "," ");
//    //双向链表的添节点
//    public boolean add(HeroNode3 heroNode3){
//        //定义一个辅助
//    }
//}
class HeroNode3{
    public int no;
    public String name;
    public String nickname;
    public HeroNode3 next;
    public HeroNode3 pre;
    //构造器
    public HeroNode3(int no,String name,String nickname){
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
