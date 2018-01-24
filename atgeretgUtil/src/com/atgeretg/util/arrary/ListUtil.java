package com.atgeretg.util.arrary;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.atgeretg.util.file.FileUtil;

public class ListUtil {

	/**
	 * 判断list是不是null和empty,如果是null和empty返回true
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNull(List<?> list) {
		if (list != null && !list.isEmpty())
			return false;
		return true;
	}

	/**
	 * list<String>集合转成数组<br>
	 * list集合转成数组可用list.toArray(..)
	 * 
	 * @param list
	 * @return
	 */
	public static String[] list2Aarray(List<String> list) {
		if (list == null)
			return null;
		String[] strings = new String[list.size()];
		return list.toArray(strings);
	}

	/**
	 * string数组转成list<String>集合<br>
	 * 数组转成list集合可用java.util.Arrays.asList(..)方法
	 * 
	 * @param strArray
	 * @return null | List<String>
	 */
	public static List<String> array2List(String[] strArray) {
		if (strArray == null)
			return null;
		return java.util.Arrays.asList(strArray);
	}

	/**
	 * 将一个list集合分割若干个指定的大小的的list集合 list为null或size<1,返回空的list<br>
	 * 可以直接调用 new SplitListUtil<String>().splitList(list, subSize)
	 * @param list
	 *            源集合
	 * @param subSize
	 *            每个小的集合大小
	 * @return
	 */
	public static List<List<String>> splitList(List<String> list, int subSize) {
		return new SplitListUtil<String>().splitList(list, subSize);
	}
	
	

	public static void main(String[] args) {
		String path = "E:\\jfsc\\pageNum1.txt";
		String string = FileUtil.readFile2str(new File(path));
		String[] split = string.split(",");
		List<String> array2List = array2List(split);
		System.out.println(array2List.size());
		List<List<String>> splitList = (List<List<String>>) splitList(array2List, 5);
		System.out.println(splitList.size());
		// for(int i = 0; i < 500; i++) {
		// System.out.print(i+",");
		// }
		// System.out.println();
		for (List<String> list : splitList) {
			for (String string2 : list) {
				System.out.println(string2);
			}
		}
	}

	/**
	 * 获取两个List的不同元素(list2不包含list1的元素)
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> getDiffrent(List<String> list1, List<String> list2) {
		// long st = System.nanoTime();
		List<String> diff = new ArrayList<String>();
		Set<String> set = new HashSet<>(list2);//contains用hash计算会比较快，是list的10倍左右
		for (String str : list1) {
			if (!set.contains(str)) {
				diff.add(str);
			}
		}
		// System.out.println("getDiffrent total times "+(System.nanoTime()-st));
		return diff;
	}

	/**
	 * list2包含list1的元素
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> getLike(List<String> list1, List<String> list2) {
		// long st = System.nanoTime();
		List<String> diff = new ArrayList<String>();
		Set<String> set = new HashSet<>(list2);//contains用hash计算会比较快，是list的10倍左右
		for (String str : list1) {
			if (set.contains(str)) {
				diff.add(str);
			}
		}
		// System.out.println("getDiffrent total times "+(System.nanoTime()-st));
		return diff;
	}
}
