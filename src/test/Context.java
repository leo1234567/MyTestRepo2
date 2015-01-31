package test;

public class Context implements Cloneable{
	int x = 0;
	int y = 0;
	
	int [][] desk = new int[8][8];
	int count = 0;
	//bbb
	//www
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	 @Override
	    public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
}
