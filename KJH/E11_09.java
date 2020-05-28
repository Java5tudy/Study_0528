package may0528;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int total;
	int schoolRank;
	int classRank;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}

	public int compareTo (Object o) {
		if (o instanceof Student) {
			Student tmp = (Student)o;
			return Integer.compare(tmp.total, total);
		}
		else {
			return -1;
		}
	}

	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math 
				+ ", " + getTotal() + ", " + getAverage() + ", " + schoolRank + ", " + classRank;  
	}
}

class ClassTotalComparator implements Comparator {
	public int compare (Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student) {
			Student oo1 = (Student)o1;
			Student oo2 = (Student)o2;
			return oo1.ban - oo2.ban;
		}
		else {
			return -1;
		}
	}
}

public class E11_09 {
	public static void calculateClassRank (List list) {
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = 0;
		int prevTotal = -1;
		int length = list.size();
		
		Iterator i = list.iterator();
		int count = 0;
		for (int x = 0; x < length; x ++) {
			Student s = (Student)i.next();
			if (s.ban != prevBan) {
				prevRank = 1;
				prevTotal = -1;
				s.classRank = prevRank;
				prevBan = s.ban;
			}
			else {
				if(s.total == prevTotal) {
					s.classRank = prevRank;
				}
				else {
					prevRank++;
					prevTotal = s.total;
					
					if(count == 0) {
						s.classRank = prevRank;
					}
					else { 
						s.classRank = prevRank+count;
						prevRank = s.classRank;
						count = 0;
					}
				}
			}
		}
	}
	public static void calculateSchoolRank (List list) {
		Collections.sort(list);

		int prevRank = 0;
		int prevTotal = -1;
		int length = list.size();

		Iterator i = list.iterator(); 
		int count = 0;
		for (int x = 0 ; x<length; x++) {
			Student s = (Student) i.next(); 
			
			if (s.total == prevTotal) { 
				s.schoolRank = prevRank;
				count++;
			}
			else { 
				prevRank++;
				prevTotal = s.total;
				
				if(count == 0) {
					s.schoolRank = prevRank;
				}
				else { 
					s.schoolRank = prevRank+count;
					prevRank = s.schoolRank;
					count = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student ("이자바",2,1,70,90,70));
		list.add(new Student ("안자바",2,2,60,100,80));
		list.add(new Student ("홍길동",1,3,100,100,100));
		list.add(new Student ("남궁성",1,1,90,70,80));
		list.add(new Student ("김자바",1,2,80,80,90));

		calculateSchoolRank(list);
		calculateClassRank(list);

		Iterator it = list.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}