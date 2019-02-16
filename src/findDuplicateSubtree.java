import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 9/27/18.
 */
public class findDuplicateSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, res, new HashMap<>());
        return res;
    }
    private String postorder(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if(root == null) return "#";
        String serial = root.val + "," + postorder(root.left, res, map) + postorder(root.right, res, map);
        if (map.getOrDefault(serial,0) == 1) res.add(root);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
