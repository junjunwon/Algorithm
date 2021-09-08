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
    
    public static void main(String[] args){
        
    }
}
