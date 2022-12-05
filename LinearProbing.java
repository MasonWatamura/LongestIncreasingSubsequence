package program3cs232;

public class LinearProbing<Key, Value> {
	private int n;
	private int m;   //table size
	private Key[] keys;  //keys in table
	private Value[] vals; //with their value for the table
	
	public LinearProbing(int m) {  //creates linear probing hash table
		this.m = m;  //setting table size
		keys = (Key[]) new Object[m];  //for the keys
		vals = (Value[]) new Object[m]; //for the values
	}
	
	private int hash(Key key) { //hashes the key and takes the mod to determine where in the table the key and value go 
        int k = key.hashCode();
        return (k & (m-1)) % m;
    }
	
	public boolean contains(Key key) { //checks if the key is in the table
        return get(key) != null;
    }
	
	public void put(Key key, Value val) {
        if (n >= m/2) {  //resizes table if its half full
        	resize(2*m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) { //goes through table and if the key is already there overrides the value
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;  
    }
	
	public Value get(Key key) {  //uses same for loop in order to return the value of the key
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
	
	private void resize(int capacity) {
        LinearProbing<Key, Value> temp = new LinearProbing<Key, Value>(capacity);  //creates another instance of Linear Probing and re-hashes all the keys to the new table
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }
	
	public Iterable<Key> keys() {  //goes over all the keys and returns them
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
}
