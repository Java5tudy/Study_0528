package CollectionFrameWork;
import java.util.*;

public class java11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); //������
		ArrayList cha = new ArrayList(); //������
		ArrayList hap = new ArrayList(); //������
		
		kyo.addAll(list1); // list1�� ��ü���� ���� ����
		kyo.retainAll(list2); // list1�� ��ü���տ��� list2�� �����Ѱ͸� ����� ����
		
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
		System.out.println("������:"+kyo);
		System.out.println("������:"+cha);
		System.out.println("������:"+hap);

	}
}
