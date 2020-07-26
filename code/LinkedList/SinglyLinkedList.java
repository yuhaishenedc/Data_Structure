package LinkedList;

public class SinglyLinkedList {

}



class MyLinkedList{

    private class ListNode{
        private int val;
        private ListNode next=null;
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    private ListNode head;
    private int size=0;

    public MyLinkedList(){
        this.head=null;
        this.size=0;
    }

    public void buildLinkedList(){
        for(int i=0;i<10;i++){
            add(i,i);
        }
    }

    //insert at the head of the linked list
    public void addFirst(int t){
        ListNode node=new ListNode(t);
        if(head==null){
            head=node;
        }
        else{
            node.next=this.head;
            this.head=node;
        }
        this.size++;
    }

    //insert a node anywhere in the linked list
    public void add(int t,int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("index is error");
        }
        if(index==0){
            this.addFirst(t);
        }
        else{
            ListNode preNode=this.head;
            for(int i=0;i<index-1;i++){
                preNode=preNode.next;
            }
            ListNode node=new ListNode(t);
            node.next=preNode.next;
            preNode.next=node;
            this.size++;
        }
    }

    //insert at the end of the linked list
    public void addLast(int val){
        this.add(val,this.size);
    }

    public ListNode getHead(){
        return head;
    }

    public int getSize(){ return size; }

    public void printLinkedList(ListNode root){
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }

    public void remove(int t){
        if(head==null){
            System.out.println("the linked list is empty");
            return;
        }
        //The node that needs to be deleted is the head node
        while(head!=null&&head.val==t){
            head=head.next;
            if(head==null){
                return;
            }
            this.size--;
        }
        ListNode cur=this.head;
        while(cur.next!=null){
            if(cur.next.val==t){
                this.size--;
                cur.next=cur.next.next;
            }
            else{
                cur=cur.next;
            }
        }
    }

    //remove the head node
    public void removeFirst(){
        if(this.head==null){
            System.out.print("head is none");
            return;
        }
        ListNode delNode=this.head;
        this.head=this.head.next;
        delNode.next=null;
        this.size--;
        return;
    }

    //remove the last node
    public void removeLast(){
        if(this.head==null){
            System.out.print("head is null");
            return;
        }
        if(this.getSize()==1){
            this.removeFirst();
        }
        ListNode cur=this.head;
        ListNode pre=this.head;
        while(cur.next!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=cur.next;
        this.size--;
        return;
    }


    public boolean contains(int t){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==t){
                return true;
            }
            else{
                cur=cur.next;
            }
        }
        return false;
    }



}

