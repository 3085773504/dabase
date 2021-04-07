package LinkedList;

public class josephuTest {
    public static void main(String[] args) {
        CircleSingleLinkedListTest circleSingleLinkedList = new CircleSingleLinkedListTest();
        circleSingleLinkedList.add(10);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1,2,10);
    }
}
class CircleSingleLinkedListTest{
    private BoyTest first = null;
    public void add(int nums){
        if (nums < 1){
            System.out.println("nums的值不正确！");
            return;
        }
        BoyTest curBoy = null;
        for (int i = 1; i <= nums; i++){
            BoyTest boyTest = new BoyTest(i);
            if (i == 1){
                first = boyTest;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boyTest);
                boyTest.setNext(first);
                curBoy = boyTest;
            }
        }
    }
    public void show(){
        if (first == null){
            System.out.println("链表为空！");
            return;
        }
        BoyTest curBoy = first;
        while (true){
            System.out.printf("小孩的编号 %d \n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    public void countBoy(int starNo,int countNum,int nums){
        if (first == null || starNo < 1 || starNo > nums){
            System.out.println("输入的参数不正确，请从新输入");
            return;
        }
        BoyTest helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < starNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("出圈的小孩的编号为%d\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后圈中的小孩的编号为%d\n",first.getNo());
    }
}
class BoyTest{
    private int no;
    private BoyTest next;
    public BoyTest(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyTest getNext() {
        return next;
    }

    public void setNext(BoyTest next) {
        this.next = next;
    }
}
