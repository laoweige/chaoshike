package com.chaoshi.multitask;

import java.util.Random;

public class TestParallerCalculater extends AbsParallelCalculater<String, String> {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TestParallerCalculater calculater = SpringContext.instance(TestParallerCalculater.class);
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		list.add("6");
//		calculater.start(list, "");
//		Queue<String> queue = calculater.getSequenceQueue();
//		for

	}
	
	
	Random random1 = new Random(100);
	@Override
	public float calculate(String position, String resume) {
		// TODO Auto-generated method stub
		return random1.nextFloat();
	}

	@Override
	public int compareItem(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
