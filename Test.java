public class Test<T> {

    public Node<T> head = null;

    public void addNode(T data){
        if(this.head == null){
            this.head = new Node<T>(data);
        } else{
            Node<T> node = this.head;
            while(node.next!=null){
                node = node.next;
            }
            
            node.next = new Node<T>(data);            
        }
    }

    public boolean deleteNode(T data){
        if(this.head == null){
            return false;
        }
        else{
            Node<T> node = this.head;
            if(node.data == data){
                node = node.next;
                return true;
            } else{
                while(node.data != data){
                    node = node.next;
                }
                node = node.next;
                return true;
            }
        }
    }

    public Node<T> searchData(T data){
        if(this.head == null){
            return null;
        } else{
            Node<T> node = this.head;
            while(node.data != data){
                node = node.next;
            }
            node = new Node<T>(data);
            return node;
        }
    }
    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            while(node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Test<Integer> node = new Test<>();
        node.addNode(1);
        node.addNode(2);
        node.printAll();
    }
}
