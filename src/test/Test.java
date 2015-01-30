package test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Test{
//	int x = 0;
//	int y = 0;
//	
//	int [][] desk = new int[8][8];
//	int count = 0;
	
	
	private List init(Context context) {
		List<Pair> moves = new LinkedList<Pair>();
		moves.add(new Pair(context.getX()+2, context.getY()+1));
		moves.add(new Pair(context.getX()+2, context.getY()-1));
		moves.add(new Pair(context.getX()-2, context.getY()+1));
		moves.add(new Pair(context.getX()-2, context.getY()-1));
		moves.add(new Pair(context.getY()+2, context.getX()+1));
		moves.add(new Pair(context.getY()+2, context.getX()-1));
		moves.add(new Pair(context.getY()-2, context.getX()+1));
		moves.add(new Pair(context.getY()-2, context.getX()-1));
		return moves;
	}
	
	
	
	
	private void doAllMoves(List moves, Context context){
		
		for (Iterator<Pair> iterator = moves.iterator(); iterator.hasNext();) {
			Pair entry = (Pair) iterator
					.next();
			
			if(doMove(entry.getX(),entry.getY(), context)){
				System.out.println(entry.getX() + ":" + entry.getY());
				context.setCount(context.getCount() + 1 );
				if(context.getCount() == 63){
					System.out.println("Ended!!!!!!!!");
					System.exit(1);
				}
				System.out.println(context.getCount());
				moves = init(context);
				//Collections.reverse(moves);
				print(context);
				try {
					doAllMoves(moves,(Context)context.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				return;
			}
			
		}
		
System.out.println("Finished");
//System.out.println("Last position: " + context.getX() + ":" + context.getY() );
//System.out.println("Count: " + context.getCount());
//		print();
		
	}
	
	private boolean doMove(int newX , int newY , Context context){
		int newPos = -1; 
		
		try {
			newPos = context.desk[newX][newY];
		} catch (Exception e) {
			return false;
		}
		if(newPos == 0){
			context.desk[newX][newX] = 1;
			context.setX(newX);
			context.setY(newY);
			return true;
		}else{
			return false;
		}
		
	}
	
	private void print(Context context){
		for (int i = 0; i < context.desk.length; i++) {
			System.out.println();
			for (int j = 0; j < context.desk[i].length; j++) {
				System.out.print(context.desk[j][i]);
			}
		}
		System.out.println();
	}
	
	private class Pair{
		int x=0;
		int y=0;
		
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
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
	}
	
//	private class Context{
//		int x = 0;
//		int y = 0;
//		
//		int [][] desk = new int[8][8];
//		int count = 0;
//		
//		
//		public int getX() {
//			return x;
//		}
//		public void setX(int x) {
//			this.x = x;
//		}
//		public int getY() {
//			return y;
//		}
//		public void setY(int y) {
//			this.y = y;
//		}
//		public int getCount() {
//			return count;
//		}
//		public void setCount(int count) {
//			this.count = count;
//		}
		
		

	
	public static void main(String[] args) {
		Test test = new Test();
		Context context = new Context();
		test.print(context);
		test.doAllMoves(test.init(context), context);
		
		
	}

}
