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

    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    node = new Node<T>(isData);
                    return node.data;
                }
                else {
                    node = node.next;
                }
            }   
            return null;         
        }
    }
    
    public T searchFromTail(T isData){
        if(this.head == null)
            return null;
        else { 
            Node<T> node = this.tail;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                } else{
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existData, T addData){
        if(this.head == null){
            this.head = new Node<T>(addData);
            return true;
        } else if(this.head.data == existData){
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;
            return true;
        } else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == existData){
                    // Node<T> prevNode = new Node<T>(addData);
                    Node<T> prevNode = node.prev;
                    prevNode.next = new Node<T>(addData);
                    prevNode.next.next = node;
                    node.prev = prevNode.next;
                    prevNode.next.prev = prevNode;
                    return true;

                    

                } else{
                    node = node.next;
                }
                
            }
            return false;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.printAll();
        System.out.println("===================");
        linkedList.insertToFront(3, 2);
        linkedList.printAll();
        System.out.println("===================");
        linkedList.insertToFront(6, 2);
        linkedList.insertToFront(1, 0);
        linkedList.printAll();
        System.out.println("===================");
        linkedList.addNode(6);
        linkedList.printAll();
        System.out.println(linkedList.searchFromHead(1));
        System.out.println(linkedList.searchFromTail(2));
        

    }
}
