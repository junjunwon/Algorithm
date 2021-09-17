package hash;

class BasicHash {
    
    
    public Slot[] hashTable;

    public BasicHash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{ //slot배열마다 각각의 String value를 가질 수 있게 class 생성.
        String value;
        Slot(String value){
            this.value = value;
        }
    }
    
    //공간을 미리 확보한 hashFunction 생성
    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer addr = hashFunc(key);
        if(this.hashTable[addr] != null){
            this.hashTable[addr].value = value;
        } else {
            this.hashTable[addr] = new Slot(value); //hashTable[addr]에 값이 없다면 Slot이 아직 만들어지지 않은 상태. 
        }
        return true;
    }

    public String getData(String key){
        Integer addr = hashFunc(key);
        if(this.hashTable[addr].value != null){
            return this.hashTable[addr].value; 
        } else {
            return null;
        }
    }

    public static void main(String[] args){
        BasicHash hash = new BasicHash(20);
        hash.saveData("junho", "yanju");
        hash.saveData("a", "A");
        hash.saveData("b", "B");
        System.out.println(hash.getData("junho"));
        
    }   
}