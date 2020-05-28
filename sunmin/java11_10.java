package CollectionFrameWork;
import java.util.*;

public class java11_10 {
	public static void main(String[] args) {
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size() <25; i++) {
			set.add((int)(Math.random()*30)+1+"");
		}
		
		List list  = new LinkedList(set);
		Collections.shuffle(list);
		
		Iterator itr = list.iterator();
		
		for(int i=0; i<board.length; i++) {
			for(int j =0; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)itr.next());
				System.out.print((board[i][j]<10? " " : " ")
												+board[i][j]);
			}
			System.out.println();
		}
	}
}
