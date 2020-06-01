package CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student8 implements Comparable{
	String name;
	int ban, no;
	int kor, eng, math;
	int total;
	int schoolRank;
	
	Student8(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
	    this.math = math;
	    
	    total = kor+eng+math;
	}
	int getTotal() { return total;} 
	
	float getAverage() {return (int)((getTotal()/3f)*10+0.5) / 10f;}
	//사실 여기가 해석이 잘 안된다. 
	public int compareTo(Object o) {
		if(o instanceof Student8) {
			Student8 s = (Student8)o;
			return s.total - this.total; //왜 빼줘야 할까?
			//return this.total < s.total ? 1 : -1;
		} else {
			return -1;
		}
	}
	public String toString() {
		return name+","+ban+","+no+","+
	kor+","+eng+","+math+","+
				getTotal()+","+getAverage()+","+schoolRank;
	}
}

public class java11_8 {
	
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); //먼저 list 총점기준 내림차순으로정렬한다.
		int prevRank = -1; //이전의 등수 -1을 해준 이유는? 순서를 다르게 하기 위해?
		int prevTotal = -1; //이전의 총점
		int length = list.size();
		
		//for문으로 list 읽기 
		for (int i=0; i<length;i++) {
			Student8 s = (Student8)list.get(i);
			//total이 preTotal과 같으면  prevRank쓰기
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} 
			//total이 preTotal과 다르면  새로 저장, 동점자 수 고려하기.
			else {
				s.schoolRank = i + 1;
			}
			//등수와 총점을 저장. 
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[]args) {
		ArrayList list = new ArrayList();
		list.add(new Student8("이자바", 2, 1, 70, 90, 70));
		list.add(new Student8("안자바", 2, 2, 60, 100, 80));
		list.add(new Student8("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student8("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student8("김자바", 1, 2, 80, 80, 90));
		// calculateSchoolRank에 list를 넣어서 실행~
	    calculateSchoolRank(list);
	    // list의 반복자를 itr에 넣는다.
	    Iterator itr = list.iterator();
	    //다음에 올게 있으면 ? 다음것을 출력한다.~
	    while(itr.hasNext())
	    	System.out.println(itr.next());
	}
}