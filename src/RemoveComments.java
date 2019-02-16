import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/14/18.
 */
public class RemoveComments {
    private boolean incomment;
    private String unfinish;
    private List<String> res;
//    public void addLine(String s) {
//        unfinish = "";
//        res.add(s);
//    }
//
//    public void processComment(String line) {
//        int idx = line.indexOf("*/");
//        if (idx == -1) return;
//        incomment = false;
//        processNotComment(line.substring(idx + 2));
//
//    }
//
//    public void processNotComment(String line) {
//        int idx1 = line.indexOf("/*");
//        int idx2 = line.indexOf("//");
//        if (idx1 == -1 && idx2 == -1) {
//            addLine(unfinish + line);
//            return;
//        }
//        if (idx2 != -1 && (idx1 == -1 || idx2 < idx1)) {
//            addLine(unfinish + line.substring(0, idx1));
//            return;
//        }
//        incomment = true;
//        unfinish += line.substring(0, idx1);
//        processComment(line.substring(idx1 + 2));
//
//    }
//
//    public List<String> removeComments(String[] source) {
//        incomment = false;
//        unfinish = "";
//        res = new ArrayList<>();
//        for (String line: source) {
//            if (incomment) {
//                processComment(line);
//            } else {
//                processNotComment(line);
//            }
//        }
//        return res;
//    }


    private void addLine(String s) {
        unfinish = "";
        res.add(s);
    }
    private void processIncomment(String line) {
        int idx1 = line.indexOf("/*");
        int idx2 = line.indexOf("//");
        if (idx1 == -1 && idx2 == -1) {
            addLine(unfinish + line);
            return;
        }
        if (idx2 != -1 && (idx1 == -1 || (idx1 < idx2)) ) {
            addLine(unfinish + line.substring(0, idx2 + 1));
        }



    }
    private void pricessNotComment(String line) {

    }
    public List<String> removeComment(List<String> comments) {
        incomment = false;
        unfinish = "";
        res = new ArrayList<>();
        for(String line : comments) {
            if (incomment) {
                processIncomment(line);
            } else {
                pricessNotComment(line);
            }
        }
        return res;
    }
}
