package hash;


/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	private int capacity;
	private int size;
	private static final int INITIAL_CAP = 60;
	private K[] keys;
	private V[] values;
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
		this.table = (HashNode<K,V>[])new HashNode[initialCapacity];
		this.capacity = initialCapacity;
		this.size = 0;
		K[] keys = (K[])new Object[initialCapacity];
		this.keys = keys;
		V[] values = (V[])new Object[initialCapacity];
		this.values = values;
		
		
	}
	
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(this.size>= (capacity/3)) {
			resize(2*this.capacity);
		}
		int i;
		
		for(i = ((Math.abs(key.hashCode())) % this.capacity); keys[i] != null; i = (i+1) % this.capacity) {
			if(keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		this.size++;
	}

	@Override
	public V retrieve(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		int i = (Math.abs(key.hashCode())) % this.capacity;
		for(int k = i; keys[k] != null; k = (k+1) % this.capacity)
			if(keys[k].equals(key))
				return values[k];
		return null;
	}

	@Override
	public boolean contains(K key) {
		return retrieve(key) != null;
	}

	@Override
	public void remove(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(!contains(key))
			return;
		int i = (Math.abs(key.hashCode())) % this.capacity;
		while(!key.equals(keys[i])) {
			i = (i+1) % this.capacity;}
		keys[i] = null;
		values[i] = null;
		
		for(i = (i+1) % INITIAL_CAP; keys[i] != null;
				i =(i+1) % INITIAL_CAP) {
			K temp1 = keys[i];
			V temp2 = values[i];
			this.size--;
			insert(temp1, temp2);
		}
		this.size--;
	}
	
	private void resize(int cap) {
		
		HashTable<K, V> temp = new HashTable<K,V>(cap);
		
		for(int i = 0; i < capacity; i++) {
			if (keys[i] != null) {
				temp.insert(keys[i], values[i]);
				
			}
		}
		keys = temp.keys;
		values = temp.values;
		this.capacity = temp.capacity;
//		HashNode<K, V>[] temp = this.table;
//		this.table = (HashNode<K,V>[])new HashNode[cap];
//		for(int i = 0; i < temp.length; i++) {
//			if (keys[i] != null) {
//				this.insert(keys[i], values[i]);
//				
//			}
//		}
//		
//		this.capacity = cap;
//		
	}
	
	public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < this.capacity; i++)
                System.out.println(keys[i] + " " + values[i]);
        System.out.println();
    }
	
}

