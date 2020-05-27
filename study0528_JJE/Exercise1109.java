package study0528;
import java.util.*;

class Student3 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // �������
	int classRank; // �ݵ��
	
	Student3(String name, int ban, int no, int kor, int eng, int math) {
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
		if(o instanceof Student3) {
		Student3 tmp = (Student3)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
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
		+","+schoolRank
		+","+classRank // �����߰�
		;
	}
}

class ClassTotalComparator implements Comparator<Student3> {
	public int compare(Student3 o1, Student3 o2) {
		
		if(o1.ban == o2.ban) 
			return o1.total < o2.total? 1:-1;
		else if(o1.ban != o2.ban)
			return o1.ban > o2.ban ? 1:-1;
		else	
			return -1;
	}
}
		
public class Exercise1109 {
	
	public static void calculateClassRank(List<Student3> list) {
		
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = 0;
		int prevTotal = -1;
		int length = list.size();
	
		for(int i = 0; i < length; i++) {
			
			Student3 s = list.get(i);
			
			if(s.ban != prevBan) {
				prevRank = 0;
				prevTotal = -1;
			}else {
				if(s.total == prevTotal) {
					s.schoolRank = prevRank;
				}else {
					s.classRank = prevRank + 1;
				}
			}
			prevTotal = s.total;
			prevRank = s.classRank;
			prevBan = s.ban;
				
			}
		}
	
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // list . ���� �� �������� ������������ �����Ѵ�
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		
		for(int i=0;i < length; i++) {
			Student3 s = (Student3)list.get(i);
			if(s.total==prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}
			
			prevRank = s.schoolRank;
			prevTotal = s.total;
		} // for
	}
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("���ڹ�",2,1,70,90,70)); 
		list.add(new Student3("���ڹ�",2,2,60,100,80));
		list.add(new Student3("ȫ�浿 ",1,3,100,100,100));
		list.add(new Student3("���ü� ",1,1,90,70,80));
		list.add(new Student3("���ڹ� ",1,2,80,80,90));
		
		calculateSchoolRank(list);
		calculateClassRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		System.out.println(it.next());
		}

}
