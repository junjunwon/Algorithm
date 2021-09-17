package Tree;

public class BinaryTree {
    
    Node head = null;

    public class Node{
        
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean saveData(int data){
        if(this.head == null){
            this.head = new Node(data);
            return true;
        } else{
            Node findNode = this.head;
            while(true){
                if(data < findNode.data){
                    if(findNode.left != null){
                        findNode = findNode.left;
                    } else{
                        findNode.left = new Node(data);
                        break;
                    }
                } 
                else {
                    if(findNode.right != null){
                        findNode = findNode.right;
                    }else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
            return true;
        }
    }

    public Node searchData(int data){
        if(this.head == null){
            return null;
        } else{
            //크기가 같을때
            Node findNode = this.head;
            while(findNode != null){
                if(data==findNode.data){
                    return findNode;
                }
                //크기가 작을때
                else if(data < findNode.data){
                    findNode = findNode.left;
                }
                //크기가 클때
                else
                {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean deleteNode(int value){
        boolean searched = false; //node를 찾으면 true
        Node curParentNode = this.head;
        Node curNode = this.head;

        //node가 하나도 없을때
        if(this.head == null){
            return false;
        } else{
            //node가 단지 1개만 있고 해당 Node가 삭제할 node일때
            if(this.head.data == value && this.head.left == null && this.head.right ==null){
                this.head = null;
                return true;
            }

            //curNode : 삭제할 노드, curParentNode : 삭제할 노드의 부모
            while(curNode != null){
                if(curNode.data == value){
                    searched = true;
                    break;
                } else if(value < curNode.data){
                    curParentNode = curNode;
                    curNode = curNode.left;
                } else{
                    curParentNode = curNode;
                    curNode = curNode.right;
                }
            }
            if(!searched){
                return false;
            } else{
                //data를 찾은 경우만! 체크
                //Case1 : 삭제할 Node가 Leaf Node인 경우
                if(curNode.left ==null && curNode.right == null){
                        curParentNode.left = null;
                        curNode = null; //명시적으로 작성. (굳이 작성하지 않아도 curParentNod.left=null로 하면 삭제됌.)
                }
                //Case2 : 삭제할 Node가 Child Node를 한개 가지고 있을 경우.
                else if(curNode.left != null && curNode.right ==null ){
                    if(value < curParentNode.data){
                        curParentNode.left = curNode.left;
                        curNode = null;
                    } else{
                        curParentNode.right = curNode.left;
                        curNode = null;
                    }
                } else if(curNode.left == null && curNode.right !=null){
                    if(value < curParentNode.data){
                        curParentNode.left = curNode.right;
                        curNode = null;
                    } else{
                        curParentNode.right = curNode.right;
                        curNode = null;
                    }
                }
                else{
                    //Case 3-1 :삭제할 노드가 Child 노드를 두 개 가지고 있고, 삭제할 노드가 Parent Node에 왼쪽에 있을때
                    if(value < curParentNode.data){
                        Node changeNode = curNode.right;
                        Node changeParentNode = curNode.right;
                        while(changeNode.left != null){
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        
                        //changeNode.left가 null이면 해당 노드에선 changeNode가장 작은 값이 됌.
                        if(changeNode.right == null){
                            //Case 3-1-1  : changeNode의 child node가 없을때
                            changeParentNode.left = null;
                        } else{
                            //Case 3-1-2 : changeNode.right가 있을때
                            changeParentNode.left = changeNode.right;
                        }
                        //curParentNode의 왼쪽 child Node의 삭제할 Node의 오른쪽 자식 중 
                        //가장 작은 값을 가진 노드가 changeNode를 연결.
                        curParentNode.left = changeNode;
                        //parentNode의 왼쪽 child node가 현재 변경된 changeNode
                        //changeNode의 왼쪽/오른쪽 child node를 모두 삭제할 currnode의
                        //기존 왼쪽/오른쪽 노드로 변경.
                        changeNode.right = curNode.right;
                        changeNode.left = curNode.left;

                    } else {
                        Node changeNode = curNode.right;
                        Node changeParentNode = curNode.right;
                        while(changeNode.left != null){
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        //changeNode.left가 null이면 해당 노드에선 changeNode가장 작은 값이 됌.
                        if(changeNode.right == null){
                            //Case 3-1-1  : changeNode의 child node가 없을때
                            changeParentNode.left = null;
                        } else{
                            //Case 3-1-2 : changeNode.right가 있을때
                            changeParentNode.left = changeNode.right;
                        }
                        //curParentNode의 "오른쪽" child Node의 삭제할 Node의 오른쪽 자식 중 
                        //가장 작은 값을 가진 노드가 changeNode를 연결.
                        curParentNode.right = changeNode; //왼쪽과 다른 점!!!
                        //parentNode의 왼쪽 child node가 현재 변경된 changeNode
                        //changeNode의 왼쪽/오른쪽 child node를 모두 삭제할 currnode의
                        //기존 왼쪽/오른쪽 노드로 변경.
                        changeNode.right = curNode.right;
                        changeNode.left = curNode.left;
                    }
                }
            }

        }
        return true;
    }


    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.saveData(10);
        tree.saveData(15);
        tree.saveData(13);
        tree.saveData(11);
        tree.saveData(14);
        tree.saveData(18);
        tree.saveData(16);
        tree.saveData(19);
        tree.saveData(17);
        tree.saveData(7);
        tree.saveData(8);
        tree.saveData(6);
        System.out.println(tree.deleteNode(15));
        System.out.println("=================");
        Node node = tree.searchData(7);
        System.out.println(node.left.data);
        System.out.println(node.data);
        System.out.println(node.right.data);
        System.out.println("=================");
        node = tree.searchData(16);
        System.out.println(node.left.data);
        System.out.println(node.data);
        System.out.println(node.right.data);
        System.out.println("=================");
        node = tree.searchData(18);
        
        System.out.println(node.left.data);
        System.out.println(node.data);
        System.out.println(node.right.data);

    }
}
