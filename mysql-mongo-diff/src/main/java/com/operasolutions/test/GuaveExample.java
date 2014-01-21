package com.operasolutions.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GuaveExample {

	public static void main(String[] args) {
		Random idRandomizer = new Random();
		List studentList = new ArrayList();

		StudentBean stBean1 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "III", "Bangalore");
		StudentBean stBean2 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "II", "Bangalore");
		StudentBean stBean3 = new StudentBean(idRandomizer.nextInt(), "Satya",
				"Asokan", "III", "Chennai");
		StudentBean stBean4 = new StudentBean(idRandomizer.nextInt(), "Balaji",
				"MK", "I", "Chennai");
		StudentBean stBean5 = new StudentBean(idRandomizer.nextInt(), "Satya",
				"Asokan", "IV", "Chennai");
		StudentBean stBean6 = new StudentBean(idRandomizer.nextInt(), "Balaji",
				"MK", "V", "Chennai");
		StudentBean stBean7 = new StudentBean(idRandomizer.nextInt(), "Jagan",
				"Asokan", "VI", "Chennai");
		StudentBean stBean8 = new StudentBean(idRandomizer.nextInt(), "Venu",
				"Karthik", "I", "Bangalore");

		studentList.add(stBean1);
		studentList.add(stBean2);
		studentList.add(stBean3);
		studentList.add(stBean4);
		studentList.add(stBean5);
		studentList.add(stBean6);
		studentList.add(stBean7);
		studentList.add(stBean8);

		System.out.println("BEFORE");

		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}

		Collections.sort(studentList);

		System.out.println("AFTER");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
	}
}
