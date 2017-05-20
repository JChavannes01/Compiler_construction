package pp.block3.cp.lockcoupling;	

interface List<T> {
	public void insert(int pos, T val);
	public void add(T val);
	public void remove(T item);
	public void delete(int pos);
	public int size();
	public String toString(); 
}
