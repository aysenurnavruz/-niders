package BinaryTree;

import java.util.Stack;

public class Tree {
    private Node root;
    public Tree(){
        root=null;
    }
    public void insert(long data){
        Node newNode =  new Node();
        newNode.data=data;

        if (root==null)
            root=newNode;
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (data< current.data){
                    current=current.leftChild;
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if (current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }
    public Node find(long data){
        Node current= root;
        while(current.data != data){
            if (data< current.data)
                current=current.leftChild;
            else current=current.rightChild;
            if (current==null)
                return null;
        }
        return current;
    }

    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.print("\n Preorder: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\n InOrder:");
                inOrder(root);
                break;
            case 3:
                System.out.print("\n PostOrder:");
                postOrder(root);
                break;
        }
        System.out.println("");
    }
    public void preOrder(Node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.data+" ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    public void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data+" ");
            inOrder(localRoot.rightChild);
        }
    }
    public void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data+" ");
        }
    }

    public Node miimum(){
        Node current= root;
        Node last= null;
        while(current != null){
            last = current;
            current=current.leftChild;
        }
        return last;
    }
    public Node maksimum(){
        Node current= root;
        Node last= null;
        while(current !=null){
            last=current;
            current=current.rightChild;
        }
        return last;
    }

    public boolean delete(long key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.data!=key){
            parent=current;
            if (key < current.data){
                isLeftChild = true;
                current=current.leftChild;
            }
            else{
                isLeftChild=false;
                current=current.rightChild;
            }
            if (current==null)
                return false;
        }
        //durum 1: Child yoksa sadece sil
        if (current.leftChild==null &&   current.rightChild==null){
            if (current==root)
                root=null;
            else if (isLeftChild)
                parent.leftChild=null;
            else
                parent.rightChild=null;
        }
        //durum 2: Sağ child yok
        else if (current.rightChild ==null)
            if (current==root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild=current.leftChild;
            else
                parent.rightChild=current.leftChild;
        //durum 2: Sol child yok
        else if (current.leftChild==null)
            if (current==root)
                root=current.rightChild;
            else if (isLeftChild)
                parent.leftChild =current.rightChild;
            else
                parent.rightChild = current.rightChild;
        //durum 3: hem sol hem sağ var
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root=successor;
            else if (isLeftChild)
                parent.leftChild=successor;
            else
                parent.rightChild=successor;
            successor.leftChild=current.leftChild;
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

    public void displayTree(){
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..........................................");
        while (isRowEmpty==false){
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty=true;

            for (int j = 0; j <nBlanks ; j++)
                System.out.print(' ');

            while (globalStack.isEmpty()==false){
                Node temp =(Node) globalStack.pop();
                if (temp!= null){
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild !=null)
                        isRowEmpty=false;
                }
                else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks*2-2; j++)
                    System.out.print(' ');
            }//end while globalstcak boş değil
            System.out.println();
            nBlanks/=2;
            while (localStack.isEmpty()==false)
                globalStack.push(localStack.pop());
        }//end while isRowEmpty false
        System.out.println("...............................................");
    }

}
