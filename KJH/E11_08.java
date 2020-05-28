package com.may28;

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
			//Integer끼리 Comparable interface에 있는 메소드
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math 
				+ ", " + getTotal() + ", " + getAverage() + ", " + schoolRank;  
	}
}

public class E11_08 {
	public static void calculateSchoolRank (List list) {
		Collections.sort(list);
		
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		Iterator i = list.iterator(); //list 객체 받기
		int count = 0;
		for (int x = 0 ; x<length; x++) {
			Student s = (Student) i.next(); // 받은 객체 Student형변환
			
			if (s.total == prevTotal) { // 동점자 나올 경우 전 등수와 동일하게 한 후 count +1
				s.schoolRank = prevRank;
				count++;
			}
			else { //다를 경우 rank1 올리고, total 초기화
				prevRank++;
				prevTotal = s.total;
				
				if(count == 0) { // 앞에 동점자 없었을 경우 올린 rank넣어줌
					s.schoolRank = prevRank;
				}
				else { //동점자가 있었을 경우 rank는 전의 등수에서 count더해주고, rank를 다시 초기화
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
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
