package com.operasolutions.mongo;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class FundOverviewEntityTest {

	FundOverviewEntity cl;

	@Before
	public void setup() {
		cl = new FundOverviewEntity();
	}

	@Test
	public void testKeepSequence() {
		Field[] field = cl.getClass().getDeclaredFields();
		assertEquals(field[0].getName(), "fundName");
		assertEquals(field[1].getName(), "fundId");
		assertEquals(field[2].getName(), "date");
	}

	@Test
	public void testFieldType() {
		Field[] field = cl.getClass().getDeclaredFields();
		System.out.println(field[0].getType().getSimpleName());
		assertEquals(field[0].getType().getSimpleName(), "String");
		assertEquals(field[1].getType().getSimpleName(), "String");
		assertEquals(field[2].getType().getSimpleName(), "Long");
		assertEquals(field[3].getType().getSimpleName(), "Integer");
		assertEquals(field[4].getType().getSimpleName(), "Boolean");
	}

	@Test
	public void testFetchMethod() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Field[] field = cl.getClass().getDeclaredFields();
		String fieldName = field[0].getName();
		String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
		System.out.println("methodName:" + methodName);
		Method first = cl.getClass().getMethod(methodName, null);
		System.out.println("method:" + first.getName());
		System.out.println("result:" + first.invoke(cl, null));
	}
}
