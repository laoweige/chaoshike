package com.chaoshi.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayUtil {
	public static void main(String[] args) {
		// 测试union
		String[] arr1 = { "abc", "df", "abc" };
		String[] arr2 = { "abc", "cc", "df", "d", "abc" };
		String[] result_union = union(arr1, arr2);
		System.out.println("求并集的结果如下：");
		for (String str : result_union) {
			System.out.println(str);
		}
		System.out
				.println("---------------------可爱的分割线------------------------");

		// 测试insect
		List result_insect = intersect(arr1, arr2);
		System.out.println("求交集的结果如下：");
		for (Object str : result_insect) {
			System.out.println(str);
		}

		System.out
				.println("---------------------疯狂的分割线------------------------");
		// 测试minus
		String[] result_minus = minus(arr1, arr2);
		System.out.println("求差集的结果如下：");
		for (String str : result_minus) {
			System.out.println(str);
		}
	}

	// 求两个字符串数组的并集，利用set的元素唯一性
	public static String[] union(Object[] arr1, Object[] arr2) {
		Set<String> set = new HashSet<String>();
		for (Object str : arr1) {
			set.add(str.toString());
		}
		for (Object str : arr2) {
			set.add(str.toString());
		}
		String[] result = {};
		return set.toArray(result);
	}

	// 求两个数组的交集
	public static List intersect(Object[] arr1, Object[] arr2) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LinkedList<String> list = new LinkedList<String>();
		for (Object str : arr1) {
			if (!map.containsKey(str)) {
				map.put(str.toString(), Boolean.FALSE);
			}
		}
		for (Object str : arr2) {
			if (map.containsKey(str)) {
				map.put(str.toString(), Boolean.TRUE);
			}
		}

		for (Entry<String, Boolean> e : map.entrySet()) {
			if (e.getValue().equals(Boolean.TRUE)) {
				list.add(e.getKey());
			}
		}

		return list;
	}

	// 求两个数组的差集
	public static String[] minus(String[] arr1, String[] arr2) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> history = new LinkedList<String>();
		String[] longerArr = arr1;
		String[] shorterArr = arr2;
		// 找出较长的数组来减较短的数组
		if (arr1.length > arr2.length) {
			longerArr = arr2;
			shorterArr = arr1;
		}
		for (String str : longerArr) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : shorterArr) {
			if (list.contains(str)) {
				history.add(str);
				list.remove(str);
			} else {
				if (!history.contains(str)) {
					list.add(str);
				}
			}
		}

		String[] result = {};
		return list.toArray(result);
	}

	public static boolean isHasIntersect(Object[] arr1, Object[] arr2) {
		return intersect(arr1, arr2).size() > 0;
	}

	public static boolean isHasMinus(String[] arr1, String[] arr2) {
		return minus(arr1, arr2).length > 0;
	}
	
	public static boolean isHave(String[] arr1, String s) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i].indexOf(s) != -1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isHave(int[] arr1, int i) {
		for (int j = 0; j < arr1.length; j++) {
			if (arr1[j]== i) {
				return true;
			}
		}
		return false;
	}
}
