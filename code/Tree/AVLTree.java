package Tree;

public class AVLTree {
    public static void main(String[] args) {
        MyAVLTree test=new MyAVLTree();
        for(int i=1;i<8;i++){
            test.insert(i);
        }
        test.postOrder();
        System.out.println("");
        test.preOrder();
        System.out.println("");
        test.insert(16);
        test.insert(15);
        test.postOrder();
        System.out.println("");
        test.preOrder();
    }
}

class MyAVLTree{
    private class AvlNode{
        int element;
        AvlNode left;
        AvlNode right;
        int height;
        AvlNode(int element,AvlNode left,AvlNode right,int h){
            this.element=element;
            this.left=left;
            this.right=right;
            this.height=h;
        }
    }

    private AvlNode root;

    private static int ALLOWED_IMBALANCE=1;

    private int height(AvlNode t){
        return t==null?-1:t.height;
    }

    public void insert(int x){
        root=insert(x,root);
    }

    private AvlNode insert(int x,AvlNode t){
        if(t==null){
            return new AvlNode(x,null,null,0);
        }
        else if(x<t.element){
            t.left=insert(x,t.left);
        }
        else if(x>t.element){
            t.right=insert(x,t.right);
        }
        t=balance(t);
        return t;
    }

    private AvlNode balance(AvlNode t){
        if(t==null){
            return null;
        }
        if(height(t.left)-height(t.right)>ALLOWED_IMBALANCE){
            if(height(t.left.left)>=height(t.left.right)){
                t=rotateWithLeftChild(t);
            }
            else{
                t=doubleWithLeftChild(t);
            }
        }
        else if(height(t.right)-height(t.left)>ALLOWED_IMBALANCE){
            if(height(t.right.right)>=height(t.right.left)){
                t=rotateWithRightChild(t);
            }
            else{
                t=doubleWithRightChild(t);
            }
        }
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    private AvlNode rotateWithLeftChild(AvlNode k2){
        AvlNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }

    private AvlNode doubleWithLeftChild(AvlNode k3){
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode rotateWithRightChild(AvlNode k2){
        AvlNode k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }

    private AvlNode doubleWithRightChild(AvlNode k3){
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    public void remove(int x){
        remove(x,root);
    }

    private AvlNode remove(int x,AvlNode t){
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
            return t.left!=null?t.left:t.right;
        }
        balance(t);
        return t;
    }

    public int findMin(){
        return findMin(root);
    }

    //recursive version
    private int findMin(AvlNode t){
        if(t==null){

        }
        if(t.left==null){
            return t.element;
        }
        return findMin(t.left);
    }

    public int findMax(){ return findMax(root); }

    //iteration version
    private int findMax(AvlNode t){
        if(t!=null){
            while(t.right!=null){
                t=t.right;
            }
        }
        return t.element;
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(AvlNode t){
        if(t!=null){
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t.element+" ");
        }
    }

    public void preOrder() { preOrder(root); }

    private void preOrder(AvlNode t){
        if(t!=null){
            System.out.print(t.element+" ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }


}