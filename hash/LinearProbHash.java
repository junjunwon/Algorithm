package hash;

class LinearProbHash {
    
    Slot[] hashTable;
    
    public LinearProbHash(int size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        
        String key;
        String value;

        public Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key){
       return (int)(key.charAt(0))% hashTable.length;
    }
    public boolean saveData(String key, String value){
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null){
            if(this.hashTable[address].key == key){
                this.hashTable[address].value = value;
                return true;
            } else{
                Integer curAddress = address + 1;
                while(this.hashTable[curAddress] != null){
                    if(this.hashTable[curAddress].key == key){
                        this.hashTable[curAddress].value = value;
                        return true;
                    } else{
                        curAddress++;
                        if(curAddress >= this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[curAddress] = new Slot(key, value);
                return true;
            } 
        }
        else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null){
            if(this.hashTable[address].key == key){
                return this.hashTable[address].value;
            } else{
                Integer curAddress = address +1;
                while(this.hashTable[curAddress]!=null){
                    if(this.hashTable[curAddress].key == key){
                        return this.hashTable[curAddress].value;
                    } else {
                        curAddress++;
                        if(curAddress >= this.hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }
            
            
        }else{
            return null;
        }
    }

    public static void main(String[] args){
        LinearProbHash hash = new LinearProbHash(30);
        hash.saveData("a", "A");
        hash.saveData("b", "B");
        hash.saveData("c", "C");
        hash.saveData("as", "AA");
        System.out.println(hash.getData("as"));
    }
    
}
