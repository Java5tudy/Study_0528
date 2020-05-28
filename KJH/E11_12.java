package com.may28;

import java.util.*;

public class E11_12 {
	public static void main(String args[]) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		
		deck.shuffle();
		Player p1 = new Player("타짜", deck.pick(), deck.pick());
		Player p2 = new Player("고수", deck.pick(), deck.pick());
		
		System.out.println(p1 + " " + deck.getPoint(p1));
		System.out.println(p2 + " " + deck.getPoint(p2));
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	int pos = 0; //다음에 가져올 카드 위치
	HashMap jokbo = new HashMap(); //족보 저장할 hashmap
	
	SutdaDeck() {
		for(int i = 0; i<cards.length; i++) {
			int num = i % 10 + 1;
			boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);
			
			cards[i] = new SutdaCard(num, isKwang);
		}
		registerJokbo(); // 족보 등록
	}
	
	void registerJokbo() {
		jokbo.put("KK", 4000);
		jokbo.put("1010",3100); jokbo.put("12", 2060);
		jokbo.put("99", 3090); jokbo.put("21", 2060);
		jokbo.put("88", 3080); jokbo.put("14", 2050);
		jokbo.put("77", 3070); jokbo.put("41", 2050);
		jokbo.put("66", 3060); jokbo.put("19", 2040);
		jokbo.put("55", 3050); jokbo.put("91", 2040);
		jokbo.put("44", 3040); jokbo.put("110", 2030);
		jokbo.put("33", 3030); jokbo.put("101", 2030);
		jokbo.put("22", 3020); jokbo.put("104", 2020);
		jokbo.put("11", 3010); jokbo.put("410", 2020);
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);

	}
	int getPoint(Player p) {
		if (p == null) return 0;
		
		SutdaCard c1 = p.c1;
		SutdaCard c2 = p.c2;
		
		Integer result = 0;
		
		String c1n = Integer.toString(c1.num);
		String c2n = Integer.toString(c2.num);
		String cn = c1n + c2n; // String더하기가 그냥 된다는 것을 알았다.
		
		if (c1.isKwang == true && c2.isKwang == true) {
			result = (Integer) jokbo.get("KK");
		}
		else if (jokbo.containsKey(cn)) { // key값에 cn이 있는지 여부 판단.
			result = (Integer) jokbo.get(cn);
		}
		else {
			result = (c1.num + c2.num) % 10 + 1000;
		}
		return result.intValue();
	}
	
	SutdaCard pick() throws Exception {
		SutdaCard c = null;
		
		if(0<=pos && pos < CARD_NUM) {
			c = cards[pos];
			cards[pos++] = null;
		}else {
			throw new Exception ("남아있는 카드가 없습니다.");
		}
		return c;
	}
	void shuffle() {
		for(int x = 0; x < CARD_NUM * 2 ; x++) {
			int i = (int)(Math.random() * CARD_NUM);
			int j = (int)(Math.random() * CARD_NUM);
			
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
}

class Player {
	String name;
	SutdaCard c1;
	SutdaCard c2;
	
	int point;
	
	Player (String name, SutdaCard c1, SutdaCard c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}
	public String toString() { 
		return "[" + name + "]" + c1.toString() + ", " + c2.toString();
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}
