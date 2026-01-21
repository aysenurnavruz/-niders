public class LinkQueue {
    private LinkList theList;
    public LinkQueue(){theList=new LinkList();}
    public boolean isEmpty(){return theList.isEmpty();}
    public void insert(long d){theList.insertToTail(d);}
    public long remove(){return theList.deleteFromHead();}
    public void displayQueue(){
        System.out.print("Kuyruk (front-->rear):");
        theList.displayList();
    }
}
