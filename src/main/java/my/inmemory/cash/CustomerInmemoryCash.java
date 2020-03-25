package my.inmemory.cash;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 
 * @author Conroy White
 *
 * @param <K>
 * @param <V>
 * cash implementation
 * 
 */
public class CustomerInmemoryCash<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1122519407768415461L;
	private int size;
	
	public CustomerInmemoryCash(int size) {
		super(size,0.75f,true);
		this.size = size;
		getInstance(size);
	}
	
	/*
	 * will remove the eldes element from the mak
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {		
		return size() > size;
		
	}
	
	/*
	 * set what size we want the cash to be  and return a map
	 */
	public static <k,v> LinkedHashMap<k,v> getInstance(int size){
		return new LinkedHashMap<k, v>(size);
		
	}
	
	/*
	 * set what size we want the cash to be cashe and return a new instance of the class
	 */
	public static <k,v> CustomerInmemoryCash<k,v> newInstance(int size){
		return new CustomerInmemoryCash<k, v>(size);
		
	}

}
