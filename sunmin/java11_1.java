package CollectionFrameWork;
import java.util.*;

public class java11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); //교집합
		ArrayList cha = new ArrayList(); //차집합
		ArrayList hap = new ArrayList(); //합집합
		
		kyo.addAll(list1); // list1의 전체집합 먼저 추출
		kyo.retainAll(list2); // list1의 전체집합에서 list2와 동일한것만 남기고 삭제
		
		hap.addAll(list1);
		hap.addAll(list2);
		hap.removeAll(kyo);
		
		cha.addAll(list1);
		cha.removeAll(kyo);
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		
		
	
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("교집합:"+kyo);
		System.out.println("차집합:"+cha);
		System.out.println("합집합:"+hap);

	}
}
