package castello;

import java.util.*;

class Student implements Comparable<Student> {
	String name;
	int ban, no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int) ((getTotal() / 3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();	
	}
	
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
}

public class E11_5 {
	
	public static void main(String[]args) {
		ArrayList<Student>list = new ArrayList<Student>();
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("박길동", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("안자바", 1, 4, 70, 90, 70));
		list.add(new Student("장자바", 1, 5, 60, 100, 80));
		
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}

}
