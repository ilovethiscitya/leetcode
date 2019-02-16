import sun.invoke.util.VerifyAccess;

import java.util.*;

/**
 * Created by jianzhe on 12/2/18.
 */
public class LinkedListComponents {
    public int numComponents(Node head, int[] G) {
        Node cur = head;
        Set<Integer> setG = new HashSet<>();
        for (int i : G) {
            setG.add(i);
        }
        int res = 0;
        while (head != null) {
            if (setG.contains(head.value) && (head.next == null || !setG.contains(head.next.value))) {
                res++;
            }
            head = head.next;
        }
        return res;
    }

}
