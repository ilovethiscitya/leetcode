import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.*;

/**
 * Created by jianzhe on 2/17/19.
 */
public class flightShippingReturn {
    public List<List<Integer>> findC(int travelDistance, List<List<Integer>> forward, List<List<Integer>> returnShipping) {
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
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int diff = Integer.MAX_VALUE;
        // sort the returnShipping
        Collections.sort(returnShipping, (r1, r2) -> {
            return r1.get(0) - r2.get(0);
        });
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



//            System.out.println("this is" + diff);

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

        returnF.add(dd);
        returnF.add(bb);
        returnF.add(cc);
        returnF.add(aa);

        List<List<Integer>> res = new flightShippingReturn().findC(distance, forward, returnF);
        for(int i = 0; i < res.size(); i++) {
            for(Integer integer : res.get(i)) {
                System.out.println(integer);
            }
            System.out.println("....");
        }


    }
}
