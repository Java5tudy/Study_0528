package CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student8 implements Comparable{
	String name;
	int ban, no;
	int kor, eng, math;
	int total;
	int schoolRank;
	
	Student8(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
	    this.math = math;
	    
	    total = kor+eng+math;
	}
	int getTotal() { return total;} 
	
	float getAverage() {return (int)((getTotal()/3f)*10+0.5) / 10f;}
	//��� ���Ⱑ �ؼ��� �� �ȵȴ�. 
	public int compareTo(Object o) {
		if(o instanceof Student8) {
			Student8 s = (Student8)o;
			return s.total - this.total; //�� ����� �ұ�?
			//return this.total < s.total ? 1 : -1;
		} else {
			return -1;
		}
	}
	public String toString() {
		return name+","+ban+","+no+","+
	kor+","+eng+","+math+","+
				getTotal()+","+getAverage()+","+schoolRank;
	}
}

public class java11_8 {
	
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); //���� list �������� �����������������Ѵ�.
		int prevRank = -1; //������ ��� -1�� ���� ������? ������ �ٸ��� �ϱ� ����?
		int prevTotal = -1; //������ ����
		int length = list.size();
		
		//for������ list �б� 
		for (int i=0; i<length;i++) {
			Student8 s = (Student8)list.get(i);
			//total�� preTotal�� ������  prevRank����
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} 
			//total�� preTotal�� �ٸ���  ���� ����, ������ �� ����ϱ�.
			else {
				s.schoolRank = i + 1;
			}
			//����� ������ ����. 
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[]args) {
		ArrayList list = new ArrayList();
		list.add(new Student8("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student8("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student8("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student8("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student8("���ڹ�", 1, 2, 80, 80, 90));
		// calculateSchoolRank�� list�� �־ ����~
	    calculateSchoolRank(list);
	    // list�� �ݺ��ڸ� itr�� �ִ´�.
	    Iterator itr = list.iterator();
	    //������ �ð� ������ ? �������� ����Ѵ�.~
	    while(itr.hasNext())
	    	System.out.println(itr.next());
	}
}