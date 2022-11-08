package ders22.calisma3;

import java.util.ArrayList;
import java.util.HashMap;

public class Calisma3 {

	public static void main(String[] args) {
		ArrayList<String> person=new ArrayList<String>();
		String p1="Adil";
		String p2="Hesen";
		String p3="Eli";
		String p4="Mehemmed";
		String p5="Xalid";
		person.add(p1);
		person.add(p2);
		person.add(p3);
		person.add(p4);
		person.add(p5);
		


HashMap<String, Integer> m=new HashMap<String,Integer>();
for (String person1 : person) {
	if(m.containsKey(person1)) {
		Integer say=m.get(person1);
		say++;
		m.replace(person1, say);
	}else {
		m.put(person1, 1);
	}
}

m.clear();

	}

}
