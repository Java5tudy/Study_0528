//HashSet의 특징 : Set을 구현한 컬랙션 클래스는 순서를 유지하지 않기 때문에 저장한 순서와 다르다
//LinkedHashSet : 저장순서도 저장

package may0528;

import java.util.*;

public class E11_10 {
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		
		for (int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random()*30)+1+""); // 이미 랜덤으로 넣기 때문에 출력은 그대로
		}
		Iterator it = set.iterator();
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.println((board[i][j]<10?" ":" ")+board[i][j]);
			}
			System.out.println();
		}
		
	}
}
