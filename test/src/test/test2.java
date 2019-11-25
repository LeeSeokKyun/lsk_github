package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2 {
	public static void main(String[] args) {
      
/*      ������ �ֹ��� ���� �����͸� �̿��� ������ ���� �پ��ϰ� �ֹ��� ������ �������� �˾ƺ��� �մϴ�. ������ �ֹ� �� ���� ���� ���� ������ �ֹ��ϸ�, ���� ������ ���� �� �ֹ��� ���� �ֽ��ϴ�.

      ���� ��� ���� �ֹ� �����Ͱ� ������ ���� ���

      ["alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"]

      alex�� pizza, pasta, noodle�� �ֹ��߽��ϴ�.
      bob�� pasta, noodle, sandwich, steak�� �ֹ��߽��ϴ�.
      ���� bob�� �ֹ��� ������ �� �� ������ ���� �����ϴ�.

      ���� ID�� �� ������ �ֹ��� ������ ���ڿ� ���·� ����ִ� �迭 orders�� �Ű������� �־��� ��, ���� ���� ������ ������ �ֹ��� ������ ���̵� �迭�� ��� return �ϵ��� solution 
      �Լ��� �ϼ����ּ���. ����, �׷� ������ ���� ���̸� �ش� �������� ������������ ������ return �ϸ� �˴ϴ�*/

		String[] input = { "alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta",
				"bob noodle sandwich pasta", "bob steak noodle" };

		Map<String, Object> orderMap = new HashMap<String, Object>();
		
		for (int i = 0; i < input.length; i++) {
			String[] order_data = getStringSplit(input[i]," ");
			
			for (int j = 1; j < order_data.length; j++) {
				
				List<String> arrOrder = new ArrayList<String>();
				// �ű�
				if (!orderMap.containsKey(order_data[0])) {
					if (!orderMap.containsValue(order_data[j])) {
						arrOrder.add(order_data[j]);
						orderMap.put(order_data[0], arrOrder);
						break;
					}
				}
				// ����
				arrOrder = getMapKeyCheckValue(orderMap,order_data[0]);

				if (!arrOrder.contains(order_data[j])) {
					arrOrder.add(order_data[j]);
					orderMap.put(order_data[0], arrOrder);
				}
			}
		}
		System.out.println(orderMap.toString());
		
		Map<String,Integer> resultMap = new HashMap<String, Integer>();
		
		for (String key : orderMap.keySet()) {
			List<String> resultCnt = (List<String>)orderMap.get(key);
			resultMap.put(key, resultCnt.size());
		}
		
		System.out.println(sortByValue(resultMap));
	}
	private static String[] getStringSplit(String inputArray, String regex) {
		String[] resultArray = inputArray.split(regex);
		return resultArray;
	}
	
	private static List<String> getMapKeyCheckValue(Map<String, Object> inputMap, String mapCheckString){
		List<String> resultList = (List<String>) inputMap.get(mapCheckString);
		return resultList;
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
		Collections.reverse(list); // �ּ��� ��������
		return list;
	}

}