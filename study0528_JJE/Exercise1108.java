package study0528;


import java.util.*;
class Student2 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // ����
	int schoolRank; // �������

	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
	
	int getTotal() {
		return total;
	}
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public int compareTo(Object o) {
		Student2 s = (Student2)o;
		
		if(this.total < s.total)
			return 1;
		else if(this.total > s.total) 
			return -1;
		else
			return 0;	
	}

	public String toString() {
		return name
			+","+ban
			+","+no
			+","+kor
			+","+eng
			+","+math
			+","+getTotal()
			+","+getAverage()
			+","+schoolRank; // �����߰�
	}
}

public class Exercise1108 {
	public static void calculateSchoolRank(List<Student2> list) {
		Collections.sort(list); // list . ���� �� �������� ������������ �����Ѵ�
			int prevRank = 0; // ���� �������
			int prevTotal = -1; // ���� ����
			int length = list.size();
			
		
//		Iterator<Student> itr = list.iterator();
//		while(itr.hasNext()) {
//			int total = itr.next().total;
//			int Rank;
		for(int i=0; i<length; i++) {
			Student2 s = list.get(i);
	
			if(s.total == prevTotal) {
				 s.schoolRank = prevRank;
			}else {
				s.schoolRank = prevRank+1;
			}
			prevRank = s.schoolRank;
			prevTotal= s.total;
			}
		}
		
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("���ڹ�",2,1,70,90,70));
		list.add(new Student2("���ڹ�",2,2,60,100,80));
		list.add(new Student2("ȫ�浿",1,3,100,100,100));
		list.add(new Student2("���ü�",1,1,90,70,80));
		list.add(new Student2("���ڹ�",1,2,80,80,90));
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		while(it.hasNext())
		System.out.println(it.next());
	
	}


}
