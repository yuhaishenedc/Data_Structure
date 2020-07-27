package Tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        MyBinarySearchTree test=new MyBinarySearchTree();
        test.insert(8);
        test.insert(7);
        test.insert(9);
        test.insert(11);
        test.insert(6);
        test.insert(10);
        System.out.println(test.findMax());
        System.out.println(test.findMin());
        test.postOrder();
        System.out.println("");
        System.out.println(test.contains(10));
        test.remove(8);
        test.postOrder();
        System.out.println("");
        test.preOrder();
    }
}

class MyBinarySearchTree{
    private class BinaryNode{
        int element;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(int element,BinaryNode left,BinaryNode right){
            this.element=element;
            this.left=left;
            this.right=right;
        }
    }
    private BinaryNode root;

    public boolean contains(int x){
        return contains(x,root);
    }

    private boolean contains(int x,BinaryNode t){
        if(t==null){
            return false;
        }
        else if(x<t.element){
            return contains(x,t.left);
        }
        else if(x>t.element){
            return contains(x,t.right);
        }
        else{
            return true;
        }
    }

    public int findMin(){
        return findMin(root);
    }

    //recursive version
    private int findMin(BinaryNode t){
        if(t==null){

        }
        if(t.left==null){
            return t.element;
        }
        return findMin(t.left);
    }

    public int findMax(){
        return  findMax(root);
    }

    //iteration version
    private int findMax(BinaryNode t){
        if(t!=null){
            while(t.right!=null){
                t=t.right;
            }
        }
        return t.element;
    }

    public void insert(int x){
        root=insert(x,root);
    }

    //recursive version
    private BinaryNode insert(int x,BinaryNode t){
        if(t==null){
            return new BinaryNode(x,null,null);
        }
        else if(x<t.element){
            t.left=insert(x,t.left);
        }
        else if(x>t.element){
            t.right=insert(x,t.right);
        }
        else{
            //duplicate value
        }
        return t;
    }

    public void remove(int x){
        remove(x,root);
    }

    private BinaryNode remove(int x,BinaryNode t){
        if(t==null){
            return null;
        }
        if(x<t.element){
            t.left=remove(x,t.left);
        }
        else if(x>t.element){
            t.right=remove(x,t.right);
        }
        else if(t.left!=null&&t.right!=null){
            t.element=findMin(t.right);
            t.right=remove(t.element,t.right);
        }
        else{
            return (t.left!=null)?t.left:t.right;
        }
        return t;
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(BinaryNode t){
        if(t!=null){
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t.element+" ");
        }
    }

    public void preOrder() { preOrder(root); }

    private void preOrder(BinaryNode t){
        if(t!=null){
            System.out.print(t.element+" ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }



}
