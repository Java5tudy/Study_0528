package may0528;

import java.util.*;

class Student2 implements Comparable<Student2> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student2 (String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int) ((getTotal()/3f)*10+0.5)/10f;
	}
	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math
				+ ", " + getTotal() + ", " + getAverage();
	}
	@Override
	public int compareTo(Student2 s) {
		return ban - s.ban;
	}
}

class BanNoAscending implements Comparator<Student2> {
	public int compare(Student2 o1, Student2 o2) {
		if (o1.ban == o2.ban) {
			return o1.no - o2.no;
		}
		else {
			return o1.ban - o2.ban;
		}
	}
}
public class E11_07 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student2("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student2("김자바", 1, 2, 80, 80, 90));
		list.add(new Student2("이자바", 2, 1, 70, 90, 70));
		list.add(new Student2("안자바", 2, 2, 60, 100, 80));
		
		Collections.sort(list, new BanNoAscending());
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
