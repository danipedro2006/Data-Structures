package javaex;

import java.util.Iterator;

class HashEntry{
	
	private int key;
	private int value;
	private HashEntry next;
	
	HashEntry(int key, int value){
		
		this.key=key;
		this.value=value;
		this.next=null;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
	
	public HashEntry getNext() {
		return next;
	}

	public void setNext(HashEntry next) {
		this.next=next;
		
	}

	@Override
	public String toString() {
		return "HashEntry [key=" + key + ", value=" + value + ", next=" + next + "]";
	}

	public void setValue(int value) {
		this.value=value;
		
	}
}

public class HashMap implements Iterator{
	
	private static final int TABLE_SIZE=8;
	
	HashEntry[] table;
	
	HashMap(){
		
		table=new HashEntry[TABLE_SIZE];
		
		for(int i=0;i<TABLE_SIZE;i++) {
			table[i]=null;
		}
		
	}
	
	
	
	public int get(int key) {
		
		int hash=(key%TABLE_SIZE);
		
		if(table[hash]==null)
			return -1;
		
		else {
			
			HashEntry entry=table[hash];
			
			while(entry!=null && entry.getKey()!=key) 
				
				entry=entry.getNext();
				
				if(entry==null)
					return -1;
				
				else
					return entry.getValue();
		}
	}
	
	public void put(int key, int value) {
		
		int hash=(key%TABLE_SIZE);
		
		if(table[hash]==null) 
			table[hash]=new HashEntry(key, value);
						
			else {
				HashEntry entry=table[hash];
				
				while(entry.getNext()!=null && entry.getKey()!=key) 
					entry=entry.getNext();
					
					if(entry.getKey()==key) 
						entry.setValue(value);
						else
							entry.setNext(new HashEntry(key, value));
					}
		}
	
	
	public static void main(String[] args) {
		
		HashMap map=new HashMap();
		
		map.put(2, 3);
		map.put(3, 4);
		map.put(4, 3);
		map.put(5, 4);
		map.put(6, 9);
		map.put(7, 9);
		map.put(8, 9);
		map.put(9, 9);
		map.put(10, 9);
		map.put(11, 9);
		map.put(12, 9);
		map.put(13, 9);
		map.put(14, 9);
		
		
	//int mapvalue=map.get(4);
	
	
	
		for(int i=0;i<TABLE_SIZE;i++) {
			if(map.table[i]!=null) {
				System.out.println(map.table[i].toString());
			}
		}
	}



	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
