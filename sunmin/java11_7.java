package CollectionFrameWork;
import java.util.*;
class Student2 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
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
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	public String toString() {
		return name
				+ ","+ban
				+ ","+no
				+ ","+kor
				+ ","+eng
				+ ","+math
				+ ","+getTotal()
				+ ","+getAverage();
	}
}

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		 if (o1 instanceof Student2 && o2 instanceof Student2) {
	            Student2 s1 = (Student2) o1;
	            Student2 s2 = (Student2) o2;
	            int result = s1.ban - s2.ban;
	            return result;
	}
		 return -1;
}

public class java11_7 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("김다영", 1, 4, 70, 90, 70));
		list.add(new Student2("장정은", 1, 1, 100, 100, 100));
		list.add(new Student2("구지혜", 1, 3, 80, 80, 90));
		list.add(new Student2("김진현", 1, 2, 90, 70, 80));
		list.add(new Student2("하재준", 1, 5, 60, 100, 80));
		
		Collections.sort(list, new BanNoAscending());
		Iterator itr = list.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
