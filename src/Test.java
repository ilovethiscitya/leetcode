

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Created by jianzhe on 2018/7/12.
 */
public class Test {
    public static void main(String[] args) {
//        [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        String[][] input = {{"JFK", "KUL"}, {"JFK","NRT"},{"NRT","JFK"}};
//        ReconstructIter reconstructIter = new ReconstructIter();
//        List<String> res = reconstructIter.findItinerary(input);
//        for(int i = 0; i < res.size(); i++) {
//            System.out.print(res.get(i) + "ddd   ");
//        }
//        numSubarrayProductLessThanK test1 = new numSubarrayProductLessThanK();
//        int[] nums = {10, 5, 2, 6};
//        int k = 100;
//        int sum = test1.numSubarrayProductLessThanK(nums, k);
//        System.out.println(sum);
//        fractionToDecimal test = new fractionToDecimal();
//        String res = test.fraction2(2, 8);
//        System.out.println(res);

//            FindReplacePattern findReplacePattern = new FindReplacePattern();
//        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
//        String pattern = "abb";
//        List<String> res = findReplacePattern.findAndReplacePattern(words, pattern);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }


//          long a = 1;
//          long b = 2;
//          long prefix = a/b;
//        System.out.println(Long.toString(prefix));

//            FractionAdditionAndSubstraction fractionAdditionAndSubstraction = new FractionAdditionAndSubstraction();
//            String a1 = fractionAdditionAndSubstraction.fractionAddition("-1/2+1/2+1/3");
//        System.out.println(a1);

//        rotateList rotateList = new rotateList();
//            Node n1 = new Node(1);
//            Node n2 = new Node(2);
//            Node n3 = new Node(3);
//            Node n4 = new Node(4);
//            Node n5 = new Node(5);
//            n1.next = n2;
//            n2.next = n3;
//            n3.next = n4;
//            n4.next = n5;
//            Node newNode = rotateList.rotateList(n1,2);
//
//        Interval i1 = new Interval(3,4);
//        Interval i2 = new Interval(2,3);
//        Interval i3 = new Interval(1,2);
//        Interval i4 = new Interval(3,4);

//        Interval[] test = new Interval[3];
//        test[0] = i1;
//        test[1] = i2;
//        test[2] = i3;
////        test[3] = i4;
//        findRightInterval findRightInterval = new findRightInterval();
//        int[] f1 = findRightInterval.findRightInterval(test);
//        for(int i = 0; i < f1.length; i++) {
//            System.out.println(f1[i]);
//        }

//
//        int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
//        fruitIntoBaskets fruitIntoBaskets = new fruitIntoBaskets();
//        int res = fruitIntoBaskets.totalFruit(tree);
//        System.out.println(res);
//        getFactors getFactors = new getFactors();
//        List<List<Integer>> res = new ArrayList<>();
//        res = getFactors.getFactor(12);
//        for (List<Integer> list : res) {
//            for (Integer i : list) {
//                System.out.println(i);
//            }
//            System.out.println("....");
//        }

//            SmallestRange smallestRange = new SmallestRange();
//            int[] A = {2,7,2};
//            int x = smallestRange.smallestRangeI(A, 1);
//        System.out.println(x);
//
//
//        snakesAndLadders snakesAndLadders = new snakesAndLadders();
//        int[] res = snakesAndLadders.calculatePoint(13,6);
//        System.out.println(res[0]);
//        System.out.println(res[1]);

//        subarraySumEqualsK subarraySumEqualsK = new subarraySumEqualsK();
//        int[] sum = {4,5,6};
//        subarraySumEqualsK.subarray(sum, 1);

//        TreeNode n1 = new TreeNode(5);
//        TreeNode n2 = new TreeNode(4);
//        TreeNode n3 = new TreeNode(8);
//        n1.left = n2;
//        n1.right = n3;
//        TreeNode n4 = new TreeNode(11);
//        TreeNode n5 = new TreeNode(13);
//        n2.left = n4;
//        n2.right = n5;
//        TreeNode n6 = new TreeNode(7);
//        TreeNode n7 = new TreeNode(2);
//        n4.left = n6;
//        n4.right = n7;
//        TreeNode n8 = new TreeNode(4);
//        n3.right = n8;
//        TreeNode n9 = new TreeNode(5);
//        TreeNode n10 = new TreeNode(1);
//        n8.left = n9;
//        n8.right = n10;
//        List<List<Integer>> res = new ArrayList<>();
//        pathSumII pathSumII = new pathSumII();
//        res = pathSumII.pathSum(n1, 22);
//        for (List<Integer> list : res) {
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//            System.out.println("////");
//        }

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(-1);
//        list.sort((a1, a2) -> {return a1 - a2;});
//        Collections.sort(list);
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        WeakHashMap weakHashMap = new WeakHashMap();
//        String[] str = {"amazon","apple","facebook","google","leetcode"};
//        String[] B = {"oo", "e"};
//        wordSubsets wordSubsets= new wordSubsets();
//        List<String> res = wordSubsets.wordSubsets(str, B);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }

//        wordLadderii wordLadderii = new wordLadderii();
//        String beginword = "hit";
//        String endword = "cog";
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
//        List<List<String>> f = wordLadderii.findLadders(beginword, endword, wordList);
//        for (List<String> list : f) {
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//            System.out.println("===");
//        }
        int k = 1_000_000;
//        System.out.println(k);
//        String str = "Hello";
//        System.out.println(System.identityHashCode(str));
//
//        str = str + "Java";
//        System.out.println(System.identityHashCode(str));
//        StringBuilder str = new StringBuilder("Hello ");
//        System.out.println(str);
//        System.out.println(System.identityHashCode(str));
//        short st = 5;
//        st += 10;
//        System.out.println(st);
//        st += 90000;
////        System.out.println(st);


//        reverseOnlyLetters reverseOnlyLetters = new reverseOnlyLetters();
//        String a = "a-bC-dEf-ghIj";
//        System.out.println(reverseOnlyLetters.reverseOnlyLetters(a));
//        MaximumSumCircular maximumSumCircular = new MaximumSumCircular();
//        int[] B = {3,-1,2,-1};
////        System.out.println(maximumSumCircular.maxSubarrySumCircular(B));
//        char[][] rect = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };
//        maximalRectangle rectangle = new maximalRectangle();
////        System.out.println(rectangle.maximalRectangle(rect));
//        int[] A = {3,1,2,4};
//        sortArrayByParity sortArrayByParity = new sortArrayByParity();
//        int [] res = sortArrayByParity.sortArrayByParity(A);
//        for (Integer i : A)
//            System.out.println(i);
//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"KFC", "Shogun", "Burger King"};
//        MinimumIndexSum minimumIndexSum = new MinimumIndexSum();
//        String[] res = minimumIndexSum.findRestaurant(list1, list2);
//        for(String a : res) {
//            System.out.println(a);
//        }

//        List<int[]> input = new ArrayList<>();
//        int[] a1 = {1,10};
//        int[] a2 = {9,11};
//        int[] a3 = {12,20};
////        int[] a4 = {4,7};
//        input.add(a1);
//        input.add(a2);
//        input.add(a3);
////        input.add(a4);
//        airbnb airbnb = new airbnb();


//        int max = airbnb.assignRooms1(input);
//        input.forEach(obj -> System.out.println(obj[0]));
//        int[] prices = {1,1,1,4,4,4,5,6,7};
//        int max2 = airbnb.assignroom2(input, prices);
//        System.out.println(max2);

//        String[] dict = {"deer","door","cake","card"};
//        UniqueWordAbbreviation u = new UniqueWordAbbreviation(dict);
//        System.out.println(u.isUnique("dear"));
//
//
//        String[] A = {"abc","acb","bac","bca","cab","cba"};
//        groupSpecialEquivalentString g = new groupSpecialEquivalentString();
//        System.out.println(g.numSpecialEquivGrouops(A));

//        BullsCows cows = new BullsCows();
//        String res = cows.getHing("1807", "7810");
//        System.out.println(res);

//
//
//        LongestSubstringWithoutRepeatingC l = new LongestSubstringWithoutRepeatingC();
//        int res = l.lengthOfLongestSubstring("aabaab!bb");
//        System.out.println(res);
//        System.out.println('!' - 'a');

//           LongestSubstringTwoDistinct two = new LongestSubstringTwoDistinct();
//        int res = two.lengthOfLongestTwoDistinct("eceba");
//        System.out.println(res);

//        SortArray s = new SortArray();
//        int[] A = {4,2,5,7};
//        int[] rets = s.sortArray(A);
//        for (Integer i : rets) {
//            System.out.println(i);
//        }
//        String s = "())";
//        minimumAddParenthesesValid m = new minimumAddParenthesesValid();
////        System.out.println(m.minAddToMakeValid(s));
//        int[] A = {1,1,2,2,3,3,4,4,5,5};
//        int target = 8;
//        threeSumMulti t = new threeSumMulti();
//
//        List<List<Integer>> res = new ArrayList<>();
//        int re = t.threeSumMulti(A, target);
//        System.out.println(re);
//        System.out.println(res.size());
//        for (int i = 0; i < res.size(); i++) {
//            List<Integer> list = res.get(i);
//            if (list.size() == 3) {
//                for (Integer integer : list) {
//                    System.out.println(integer);
//
//                }
//                System.out.println("ll");
//            }
//
//        }
//        dailyTemperatures d = new dailyTemperatures();
//        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] resT = d.dailyTemperatures(temp);
//        for (Integer i : resT){
//            System.out.println(i);
//        }
//        int n =1;
//        List<String> logs = new ArrayList<>();
//        logs.add("0:start:0");
//        logs.add("0:start:1");
//        logs.add("0:start:2");
//        logs.add("0:end:3");
//        logs.add("0:end:4");
//        logs.add("0:end:5");
//        ExclusiveTimeofFunctions e = new ExclusiveTimeofFunctions();
//        int[] res = e.exclusiveTime(n, logs);
//        for (Integer integer : res) {
//            System.out.println(integer);
//        }
//        slidingWindowMax s = new slidingWindowMax();
//        int[] nums = {1,2,2,2,5,3,6,7};
//        int[] res = s.maxSlidingWindow(nums, 3);
//        for (int a : res) {
//            System.out.println(a);
//        }
//        containsDuplicate c = new containsDuplicate();
//        int[] nums = {1,2,3,1,2,3};
//        System.out.println(c.containsNearbyDuplicate(nums, 2));


//        findRightInterval r = new findRightInterval();
//        Interval i1 = new Interval(3,4);
//        Interval i2 = new Interval(2,3);
//        Interval i3 = new Interval(1,2);
//        Interval[] its = new Interval[3];
//        its[0] = i1;
//        its[1] = i2;
//        its[2] = i3;
//        int[] res = r.findRightInterval(its);
//        for (int re : res){
//            System.out.println(re);
//        }
//    }
//        fallingSquare f = new fallingSquare();
//        int[][] position = {{1, 3}, {2,1}, {3, 1}};
//        f.fallingSquares(position);


//        String s = "aaadbbcc";
//        reorganizeString r = new reorganizeString();
//        String res = r.reorganizeString(s, 2);
//        System.out.println(res);

//               wordSearch w = new wordSearch();
//        char[][] board = {{'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        String word = "ABCB";
//        System.out.print(w.exist(board, word));
//            palindromeSubstring p = new palindromeSubstring();
//            int res = p.countSubstrings("abc");
//            System.out.println(res);
//        int[][] matrix = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
//        NumMatrix n = new NumMatrix(matrix);
//        System.out.println(n.sumRegion(1,1,2,2));

//        StringRoller s = new StringRoller();
//        int[] roll = {1,2,3};
//        String res = s.roll("bca", roll);
//        System.out.println(res);
//        int[] input = {6,1,3,46,1,3,9,47};
//        numberOfPairs n = new numberOfPairs();
//        int res = numberOfPairs.numberOfPairs(input, 10);
//        System.out.println(res);
//
//        AddStrings a = new AddStrings();
//        String res = a.addStrings("999", "1");
//        System.out.println(res);
//        reverseWords r = new reverseWords();
//        r.reverseWords(" 1");
//        deleteNextBiggerNumbers d = new deleteNextBiggerNumbers();
//        int[] input = {5,8,10,3,4,2};
//        int[] res = d.deleteNextBigger(input);
//        for (int r : res) {
//            System.out.println(r);
//        }


//        summaryRanges s = new summaryRanges();
//        int[] nums = {0,1,2,4,5,7};
//        List<String> res = s.summaryRanges(nums);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }

//        boldWords b = new boldWords();
//        String[] words = {"ab", "cd"};
//        String s = "aabcd";
//        String res = b.boldWords(words, s);
//        System.out.println(res);

//        numRescueBoats n = new numRescueBoats();
//        int[] people = {3,5,3,4};
//        int limit = 5;
//        int res = n.numRescueBoats(people, limit);
//        System.out.println(res);

//        lastSecondWords l = new lastSecondWords();
//        String n = l.lastSecond("  another    word");
//        System.out.println(n);
//
//        reverseNumberPalindrome r = new reverseNumberPalindrome();
//        int num = r.calculateReverse(10105);
//        System.out.println(num);

//        houseRobberii h = new houseRobberii();
//        int[] nums = {6,6,4,8,4,3,3,10};
//        h.rob(nums);
//        wordBreakII w = new wordBreakII();
//        List<String> word = new ArrayList<>();
//        String[] words = {"cat","cats","and","sand","dog"};
//        word.addAll(Arrays.asList(words));
//        List<String> res = w.wordBreak("catsanddog", word);
//        System.out.println(res.size());
//        for(String worrd : res) {
//            System.out.println(worrd);
//        }
//        Node n1 = new Node(0);
//        n1.next = new Node(1);
//        n1.next.next = new Node(2);
//        n1.next.next.next = new Node(3);
//        n1.next.next.next = new Node(4);
//        int[] G = {0,3,1,4};
//        LinkedListComponents l = new LinkedListComponents();
//        int res = l.numComponents(n1, G);
//        System.out.println(res);
        coinPath c = new coinPath();
        int[]A = {1,2,4,-1,2};

        c.cheapestJump(A,2);

    }
}
