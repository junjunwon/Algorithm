package LinkedList;


public class DoublyLinkedList<T> {
    /**
     * 
     * @param args
     * 이중 연결 리스트
     * 장점 : 양방향으로 연결되어 있어 노드 탐색이 양쪽으로 모두 가능.
     */
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T>{
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){
            Node<T> node = new Node<T>(data);
            this.head = node;
            this.tail = head;
        } else{
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head!=null){
            Node<T> node = this.head;
            System.out.println(node.data);

            while(node.next != null){
                node=node.next;
                System.out.println(node.data);

            }
        }
    }
    
    public static void main(String[] args){
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.printAll();

    }
}
