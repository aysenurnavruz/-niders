public class Tree {
    private Node root;

    public Tree(){
        root=null;
    }

    public void insert(long data){
        Node newNode = new Node();
        newNode.data=data;

        if (root==null)
            root=newNode;
        else{
            Node current= root;
            Node parent;
            while (true){
                parent=current;
                if (data< current.data){
                     current=current.leftChild;
                     if (current==null){
                         parent.leftChild=newNode;
                         return;
                     }
                }
                else{
                    current=current.rightChild;
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
            else
                current=current.rightChild;
            if (current==null)
                return null;
        }
        return current;
    }
}
