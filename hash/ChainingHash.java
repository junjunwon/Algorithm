package hash;

public class ChainingHash {
    
    Slot[] hashTable;

    public ChainingHash(int size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        public Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    public boolean saveData(String key, String value){
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    findSlot.value = value;
                    return true;
                } else{
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        }else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = hashFunc(key);
        if(this.hashTable[address]!= null){

            Slot findSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                } else{
                    findSlot = findSlot.next;
                } 
            }
            return null;
            
        }
        else {
            return null;
        }
    }

    public static void main(String[] args){
        ChainingHash hash = new ChainingHash(20);
        hash.saveData("a", "A");
        hash.saveData("b", "B");
        hash.saveData("c", "C");
        hash.saveData("as", "AA");
        System.out.println(hash.getData("a"));
        
    }
}
