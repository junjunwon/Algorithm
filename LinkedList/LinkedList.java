package LinkedList;

class LinkedList<T>{
    /**
     * 데이터와 주소 : node라고 부른다.
     * 포인터 : 각 노드 안에서 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간.
     * 장점 : 공간을 미리 할당하지 않아도 된다.
     * 단점 : 부가적인 작업이 필요하다.
     */

    public Node<T> head = null;
    public class Node<T>{
        T data;
        Node<T> next = null;
    
        public Node(T data){
            this.data=data;
        }
    }

public Node<T> searchData(T data){
    if(this.head == null){
        return null;
    } else{
        Node<T> node = this.head;
        while(node != null){
            if(node.data == data){
                return node;
            } else{
                node = node.next;
            }
        }
        return null;
    }

}

public void addInsideNode(T data, T preData){
    Node<T> searchNode = this.searchData(preData);
    if(searchNode==null){
        this.addNode(data);
    }else{
        Node<T> nextNode = searchNode.next;
        searchNode.next=new Node<T>(data);
        searchNode.next.next=nextNode;
    }
}

public boolean deleteNode(T isData){
    if(this.head==null){
        return false;
    }
    else{
        Node<T> node = this.head;
        if(node.data == isData){
            this.head=this.head.next; //포인터를 잃은 node는 GC에 의해 정리된다.
            return true;
            /**
             * head데이터 삭제의 경우
             * 다음 노드를 head에 넣어준다.
             */
        }else{
            while(node.next != null){
                if(node.next.data == isData){
                    node.next = node.next.next;
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }
}

public void addNode(T data){
    if(head==null){  
        head = new Node<T>(data);
    } else{
        Node<T> node = this.head;
        while(node.next != null){
            node = node.next;
        }
        node.next=new Node<T>(data);
    }
}

public void printAll(){
    if(head != null){
        Node<T> node = this.head;
        System.out.println(node.data);
        while(node.next != null){
            node = node.next;
            System.out.println(node.data);
        }
    }
}
    public static void main(String[]args){
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.printAll();
        myLinkedList.addInsideNode(8, 2);
        System.out.println("====================");
        myLinkedList.printAll();
        System.out.println("====================");
        myLinkedList.addInsideNode(11, 10);
        myLinkedList.printAll();
        System.out.println("====================");
        myLinkedList.deleteNode(2);
        myLinkedList.printAll();
        System.out.println("====================");
    }
}

