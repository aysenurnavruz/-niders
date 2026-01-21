import java.util.Stack;
public class Tree {
    private Node root;
    public Tree(){
        root=null;
    }
    public void insert(long data){
        Node newNode = new Node();
        newNode.data = data;
        if (root==null){
            root=newNode;
        }else {
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if (data< current.data){
                    current = current.leftChild;
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }
                else{
                    current=current.rightChild;
                    if (current==null){
                        parent.rightChild= newNode;
                        return;
                    }
                }
            }
        }
    }
    public Node find(long data){
        Node current = root;
        while (current.data!=data){
            if (data<current.data){
                current = current.leftChild;
            }else current = current.rightChild;
            if (current==null)
                return null;
        }
        return current;
    }
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.print("\n Preorder:");
                preOrder(root);

            case 2:
                System.out.print("\n Inorder:");
                inOrder(root);
            case 3:
                System.out.print("\n Postorder:");
                postOrder(root);
        }
        System.out.println(" ");
    }
    public void preOrder(Node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.data +" ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }
    public void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.data + " ");
        }
    }
    public Node minumum(){
        Node current = root;
        Node last = null;
        while (current!= null){
            last = current;
            current =current.leftChild;
        }
        return last;
    }
    public Node maximum(){
        Node current = root;
        Node last = null;
        while (current!= null){
            last = current;
            current =current.rightChild;
        }
        return last;
    }
    public boolean delete(long key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.data != key){
            parent = current;
            if (key< current.data){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current= current.rightChild;
            }
            if( current == null)// sol yada sağ çocuk düğüm boşmu dolu mu
                return false;
        }//...... durum1: child yoksa sadece sil...
        if (current.leftChild == null && current.rightChild==null){
            if (current==root)
                root=null;
            else if (isLeftChild) {
                parent.leftChild=null;
            }else
                parent.rightChild = null;
        }
        //durum2 sağ child yok..
        else if (current.rightChild == null)
            if(current == root)
                root= current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
            //durum2 sol child yok
        else if(current.leftChild ==null)
            if (current==root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild=current.rightChild;
            else
                parent.rightChild=current.rightChild;
            //durum3 hem sol hem sağı var
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else parent.rightChild=successor;
            successor.leftChild = current.leftChild;
        }
        return true;


    }
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current!= null){
            successorParent = successor;
            successor=current;
            current=current.leftChild;
        }
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild=delNode.rightChild;
        }
        return successor;

    }
}
