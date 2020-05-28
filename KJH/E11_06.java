package may0528;

import java.util.*;

class Student1 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student1 (String name, int ban, int no, int kor, int eng, int math) {
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
	public int compareTo (Object o) {
		if (o instanceof Student1) {
			Student1 tmp = (Student1)o;
			return name.compareTo(tmp.name);
		}
		else {
			return -1;
		}
	}
}


public class E11_06 {
	static int getGroupCount(TreeSet<Student1> test, int from, int to) {
		Iterator<Student1> i = test.iterator();
		int count = 0;
		while(i.hasNext()) {
			int avg =  (int)(i.next()).getAverage();
			if (avg>=from && avg<to) {
				count++;
				}
		}
		return count;
	}
	public static void main(String[] args) {
		TreeSet<Student1> set = new TreeSet<>(new Comparator() {
			public int compare(Object o1, Object o2) {
				int a = (int)((Student1)o1).getAverage();
				int b = (int)((Student1)o2).getAverage();
				return a - b;
			}
		});
		
		set.add(new Student1 ("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student1 ("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student1 ("김자바", 1, 3, 80, 80, 90));
		set.add(new Student1 ("이자바", 1, 4, 70, 90, 70));
		set.add(new Student1 ("안자바", 1, 5, 60, 100, 80));
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("[60 ~ 69] : "+getGroupCount(set, 60, 70));
		System.out.println("[70 ~ 79] : "+getGroupCount(set, 70, 80));
		System.out.println("[80 ~ 89] : "+getGroupCount(set, 80, 90));
		System.out.println("[90 ~ 100] : "+getGroupCount(set, 90, 101));
	}
}
