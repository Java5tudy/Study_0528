package study0528;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

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
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
} 

public class Exercise1106 {
	static int getGroupCount(TreeSet<Student2> tset, int from, int to) {
		Iterator<Student2> itr = tset.iterator();
	
		int count = 0;
		while(itr.hasNext()) {
			int avg = (int)itr.next().getAverage();
			if(avg >= from && avg < to) {
				count++;
			}					
		}
		return count;
		
		}
		public static void main(String[] args) {	
		TreeSet set = new TreeSet(new Comparator<Student2>() {
		
			public int compare(Student2 o1, Student2 o2) {
				return (int)o1.getAverage() - (int)o2.getAverage();
			}
		});
		
		set.add(new Student2("È«±æµ¿",1,1,100,100,100)); 
		set.add(new Student2("³²±Ã¼º",1,2,90,70,80));
		set.add(new Student2("±èÀÚ¹Ù",1,3,80,80,90));
		set.add(new Student2("ÀÌÀÚ¹Ù",1,4,70,90,70));
		set.add(new Student2("¾ÈÀÚ¹Ù",1,5,60,100,80)); 
		
		Iterator it = set.iterator();
		while(it.hasNext())
		System.out.println(it.next());
		System.out.println("[60~69] :"+getGroupCount(set,60,70));
		System.out.println("[70~79] :"+getGroupCount(set,70,80));
		System.out.println("[80~89] :"+getGroupCount(set,80,90));
		System.out.println("[90~100] :"+getGroupCount(set,90,101));

	}
}
