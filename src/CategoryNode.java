import java.util.ArrayList;

/**
 * Created by jianzhe on 2/17/19.
 */
public class CategoryNode {
    double max = Double.MIN_VALUE;
    Category maxNode;
    public Category biggestCategory(Category rootCategory) {
        dfsHelper(rootCategory);
        return maxNode;
    }
    private Result dfsHelper(Category root) {
        if(root == null) return null;
        int curNum = 0;
        double curSum = 0.0;
        for(int i = 0; i < root.subCategoryNode.size(); i++) {
            curNum += dfsHelper(root.subCategoryNode.get(i)).num;
            curSum += dfsHelper(root.subCategoryNode.get(i)).avg * curNum;
        }
        curSum += root.value;
        double curAvg = curSum / (curNum + 1);
        if(curAvg > max) {
            max = curAvg;
            maxNode = root;
        }
        return new Result(root, curNum + 1, curAvg);
    }
    public static void main(String[] args) {
        ArrayList<Category> list = new ArrayList<>();

//        Category c = new Category(20, )
    }
    public class Result {
        Category node;
        int num;
        double avg;
        public Result(Category node, int num, double avg) {
            this.node = node;
            this.num = num;
            this.avg = avg;
        }
    }

    public class Category {
        public int value;
        public ArrayList<Category> subCategoryNode;
        public Category() {
            subCategoryNode = new ArrayList<>();
        }
        public Category(int tenure) {
            this.value = tenure;
            this.subCategoryNode = new ArrayList<Category>();
        }
    }
}
