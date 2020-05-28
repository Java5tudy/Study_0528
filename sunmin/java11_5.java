package CollectionFrameWork;
import java.util.*;

class Student implements Comparable<Object>{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
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
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
				+getTotal() + "," + getAverage();
	}


	@Override
	public int compareTo(Object o) {
		if( o instanceof Student) {
			Student s = (Student)o;
			return this.name.compareTo(s.name);
		}
		else {return -1;}//���ϴ� ���� ũ�� -1, ������ 0, ������ 1 ��ȯ 
	}
}

public class java11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("������", 1, 1, 100, 100, 100));
		list.add(new Student("������", 1, 2, 90, 70, 80));
		list.add(new Student("������", 1, 3, 80, 80, 90));
		list.add(new Student("��ٿ�", 1, 4, 70, 90, 70));
		list.add(new Student("������", 1, 5, 60, 100, 80));
		
		Collections.sort(list);
		Iterator itr = list.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
