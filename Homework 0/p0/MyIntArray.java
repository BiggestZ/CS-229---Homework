package p0;

public class MyIntArray {
	
	private int[] array;
	public int size;
	
	public MyIntArray(int s) {
		this.array = new int[s];
		this.size = s;
	}
	
	public int get(int idx) {
		return this.array[idx];
	}
	
	public void set(int idx, int val) {
		this.array[idx] = val;
	}

}
