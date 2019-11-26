package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1 {
	public static void main(String[] args) {
      
/*      유저가 주문한 음식 데이터를 이용해 음식을 가장 다양하게 주문한 유저는 누구인지 알아보려 합니다. 유저는 주문 한 번당 음식 여러 종류를 주문하며, 같은 음식을 여러 번 주문할 수도 있습니다.

      예를 들어 음식 주문 데이터가 다음과 같은 경우

      ["alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"]

      alex는 pizza, pasta, noodle을 주문했습니다.
      bob은 pasta, noodle, sandwich, steak를 주문했습니다.
      따라서 bob이 주문한 음식이 총 네 종류로 가장 많습니다.
String[] array = new String[]{"foo", "bar", "baz"};

List<String> list = new ArrayList<>(Arrays.asList(array));
list.remove("foo");
      유저 ID와 각 유저가 주문한 음식이 문자열 형태로 들어있는 배열 orders가 매개변수로 주어질 때, 가장 많은 종류의 음식을 주문한 유저의 아이디를 배열에 담아 return 하도록 solution 
      함수를 완성해주세요. 만약, 그런 유저가 여러 명이면 해당 유저들을 오름차순으로 정렬해 return 하면 됩니다*/

		String[] input = { "alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta",
				"bob noodle sandwich pasta", "bob steak noodle" };

		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		for (int i = 0; i < input.length; i++) {
			String[] order_data = input[i].split(" ");
			for (int j = 1; j < order_data.length; j++) {
				List<String> arrOrder = new ArrayList<String>();
				// 신규
				if (!orderMap.containsKey(order_data[0])) {
					if (!orderMap.containsValue(order_data[j])) {
						arrOrder.add(order_data[j]);
						orderMap.put(order_data[0], arrOrder);
					}
				}
				// 기존
				else {
					arrOrder = (List<String>) orderMap.get(order_data[0]);

					if (!arrOrder.contains(order_data[j])) {
						arrOrder.add(order_data[j]);
						orderMap.put(order_data[0], arrOrder);
					}
				}
			}
		}
		String[] result = new String[orderMap.size()];
		Map<String,Integer> resultMap = new HashMap<String, Integer>();
		for (String key : orderMap.keySet()) {
			List<String> resultCnt = (List<String>)orderMap.get(key);
			resultMap.put(key, resultCnt.size());
		}
		
		System.out.println(sortByValue(resultMap));
	}
	
	// 
//	private String[] splitStringArray(String[] inputString) {
//		String[] result = new String[inputString.length];
//			result = inputString.split(" ");
//		result = inputString[i].split(" ")
//		return result;
//	}
	
	private static List<String> sortByValue(final Map<String, Integer> map) {
		List<String> list = new ArrayList<String>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable<Object>) v1).compareTo(v2);
			}
		});
		Collections.reverse(list); // 주석시 오름차순
		return list;
	}

}