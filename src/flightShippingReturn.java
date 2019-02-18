import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.*;

/**
 * Created by jianzhe on 2/17/19.
 */
public class flightShippingReturn {
    public List<List<Integer>> findC(int travelDistance, List<List<Integer>> forward, List<List<Integer>> returnShipping) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        int forwardSize = forward.size();
//        int returnSize = returnShipping.size();
//        int i = 0;
//        int j = 0;
//        int
//        while (i < forwardSize && j < returnSize) {
//            List<Integer> forwardList = forward.get(i);
//            List<Integer> returnList = returnShipping.get(j);
//
//        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for(int i = 0; i < forward.size(); i++) {
            List<Integer> pair = forward.get(i);
            int idx = pair.get(0);
            int dist = pair.get(1);
            if (!treeMap.containsKey(dist)) {
                ArrayList<Integer> distList = new ArrayList<>();
                distList.add(idx);
                treeMap.put(dist, distList);
            } else {
                treeMap.get(dist).add(idx);
            }

        }
        int minDiff = Integer.MAX_VALUE;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        //        for(int i = 0; i < returnShipping.size(); i++) {
//            List<Integer> returnPair = returnShipping.get(i);
//            int returnIdx = returnPair.get(0);
//            int returnDist = returnPair.get(1);
//            Integer closestDist = treeMap.floorKey(travelDistance - returnDist);
//            System.out.println(returnDist + ",");
//            System.out.println(closestDist);
//            List<Integer> closestIndex = treeMap.get(closestDist);
//            int diff = Math.abs(travelDistance - returnDist - closestDist);
//            if (diff <= minDiff) {
//                minDiff = Math.min(diff, minDiff);
//                if (!map.containsKey(minDiff)) {
//                    List<List<Integer>> candidates = new ArrayList<>();
//                    for (int j = 0; j < closestIndex.size(); j++) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(closestIndex.get(j));
//                        list.add(returnIdx);
//                        candidates.add(list);
//
//                    }
//                    map.put(minDiff, candidates);
//                } else {
//                    List<List<Integer>> c = map.get(minDiff);
//                    for (int j = 0; j < closestIndex.size(); j++) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(closestIndex.get(j));
//                        list.add(returnIdx);
//                        c.add(list);
//                    }
//                    map.put(minDiff, c);
//                }
//            }
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < returnShipping.size(); i++) {
            List<Integer> returnPair = returnShipping.get(i);
            int returnIdx = returnPair.get(0);
            int returnVal = returnPair.get(1);
            Map.Entry<Integer, List<Integer>> entry = treeMap.floorEntry(travelDistance - returnVal);
            if (diff >= travelDistance - returnVal - entry.getKey()) {
                diff = travelDistance - returnVal - entry.getKey();
                if (!map.containsKey(diff)) {
                    List<List<Integer>> candidates = new ArrayList<>();

                    for (int j = 0; j < entry.getValue().size(); j++) {
                        List<Integer> list = new ArrayList<>();
                        list.add(entry.getValue().get(j));
                        list.add(returnIdx);
                        candidates.add(list);
                    }
                    map.put(diff, candidates);
                } else {
                    List<List<Integer>> c = map.get(diff);
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        List<Integer> list = new ArrayList<>();
                        list.add(entry.getValue().get(j));
                        list.add(returnIdx);
                        c.add(list);
                    }
                    map.put(diff, c);

                }

            }



            System.out.println("this is" + diff);

        }
        return map.get(diff);

    }
    public static void main(String[] args) {
        int distance = 10000;
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> returnF = new ArrayList<>();

        List<Integer> a = Arrays.asList(new Integer[]{1,3000});
        List<Integer> b = Arrays.asList(new Integer[]{2,7000});

        List<Integer> c = Arrays.asList(new Integer[]{3,7000});
        List<Integer> d = Arrays.asList(new Integer[]{4,10000});


        forward.add(a);
        forward.add(b);
        forward.add(c);
        forward.add(d);

        List<Integer> aa = Arrays.asList(new Integer[]{1,2000});
        List<Integer> bb = Arrays.asList(new Integer[]{2,3000});

        List<Integer> cc = Arrays.asList(new Integer[]{3,4000});
        List<Integer> dd = Arrays.asList(new Integer[]{4,5000});

        returnF.add(aa);
        returnF.add(bb);
        returnF.add(cc);
        returnF.add(dd);

        List<List<Integer>> res = new flightShippingReturn().findC(distance, forward, returnF);
        for(int i = 0; i < res.size(); i++) {
            for(Integer integer : res.get(i)) {
                System.out.println(integer);
            }
            System.out.println("....");
        }


    }
}
