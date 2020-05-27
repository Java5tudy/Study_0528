package study0528;
import java.util.*;
class Student3 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student3(String name, int ban, int no, int kor, int eng, int math) {
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
		return (int)((getTotal()/ 3f)*10+0.5)/10f;	
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
				;
	}
} // class Student

class BanNoAscending implements Comparator<Student3> {
	public int compare(Student3 o1, Student3 o2) {
		if(o1.ban > o2.ban)
			return 1;
		else if(o1.ban < o2.ban)
			return -1;
		else {
			if(o1.no > o2.no)
				return 1;
			else if(o1.no < o2.no)
				return -1;
			else 
				return 0;
		}
	}
}

public class Exercise1107 {
	

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(new Student3("ÀÌÁö¹Ù",2,1,70,90,70)); 
		list.add(new Student3("¾ÈÀÚ¹Ù",2,2,60,100,80)); 
		list.add(new Student3("È«±æµ¿",1,3,100,100,100));
		list.add(new Student3("³²±Ã¼º",1,1,90,70,80));
		list.add(new Student3("±èÀÚ¹Ù",1,2,80,80,90));
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while(it.hasNext())
		System.out.println(it.next());
		}
}
