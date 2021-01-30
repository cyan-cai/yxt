package com.java.yxt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.yxt.base.PositionExceptionEnum;
import com.java.yxt.base.Response;
import com.java.yxt.util.MapUtil;
import com.java.yxt.util.Sm4;

public class Test {

	public static void main2(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Response r = new Response(PositionExceptionEnum.POSITION_CANCEL_DOWN);
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "ss");
		map.put(2, "ss");
		map.put(5, "ss");
		map.put(100, "ss");
		map.put(30, "ss");
		
		LinkedHashMap<Integer, String> sortedMap = (LinkedHashMap<Integer, String>) MapUtil.sortDescByKey(map);
		
		Map.Entry<Integer, String> maxEntry = MapUtil.getHead(sortedMap);
		int maxCi = maxEntry.getKey();
		
		Map.Entry<Integer, String> minEntry = MapUtil.getTailByReflection(sortedMap);
		 int minCi = minEntry.getKey();
		
		
		for (int i = 201; i< 256; i++) {
			System.out.print(i + ", ");
		}
		
		Integer[] continueCiArr = new Integer[]{ 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
		List list = Arrays.asList(continueCiArr);
		Set<Integer> set = new HashSet(Arrays.asList(continueCiArr));
		
		Set<Integer> set2 = new HashSet(Arrays.asList(new Integer[]{121,122,123}));
		
		set.removeAll(set2);
		System.out.println(set.size());
		System.out.println(sortedMap);
		
		
	}
	
	public static void main(String[] args) {
		Map<String, Integer> ciMap = new HashMap<>();
		ciMap.put("17404457365", 1);
		ciMap.put("17404451204", 1);
		ciMap.put("17404457530", 2);
		ciMap.put("17404457586", 2);
		ciMap.put("17404457500", 3);
		ciMap.put("17404457506", 3);
		
		Map<Integer, Set<String>> msisdnMap = new HashMap<>();
		Set<Entry<String, Integer>> ciEntrySet = ciMap.entrySet();
		for (Entry<String, Integer> entry : ciEntrySet) {
			String msisdn = entry.getKey();
			int ci = entry.getValue();
			MapUtil.putSetMap(msisdnMap, ci, msisdn);
		}

		Map<Integer, Set<String>> notReportedMsisdnMap = null;
		
		notReportedMsisdnMap = msisdnMap.entrySet().stream()
			    .collect(Collectors.toMap(e -> e.getKey(), e -> new HashSet<>(e.getValue())));
		
		notReportedMsisdnMap.remove(1);
		notReportedMsisdnMap.get(3).remove("17404457500");
		
		
		Map<Integer, List<Sm4>> allPositionInfoMap = msisdnMap.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> new ArrayList<>()));
		
		
		System.out.println("----");
		
		Integer t = 160;
		byte b = t.byteValue();
		System.out.println(b);
		
		
	}	
	
	

}
