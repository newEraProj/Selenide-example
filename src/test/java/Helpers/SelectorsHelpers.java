package Helpers;

public class SelectorsHelpers {

    public static String e2eSelector(String ...selectors) {
        String result = "";
        for (String selector: selectors) {
            result += "[e2e-id~=" + selector + "]";
        }
        return result;
    }
}
