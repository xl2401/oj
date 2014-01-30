import java.util.LinkedList;

/*
 * Title: Simplify Path 
 * Description:
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Solution:
 * use a stack to push and pop(when ..),
 * the linkedlist impl put element to the head of the list when push!!
 *
 * pay attention to some special occasion:
 * "/../../../ = /"
 * "/////// = /"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path.length() == 1){
            return path;
        }
        LinkedList<String> stack = new LinkedList<String>();
        int idx = 1;
        while (true){
            String str = getNextStr(path, idx);
            if (str == null){// end of str
                break;
            }
            if (str.equals("..")){
                // return to last dir
                // if stack is empty, do nothing, still root dir
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            // special attention, due to "/////", the str length should not be 0
            else if (!str.equals(".") && str.length() != 0){
                stack.push(str);
            }
            idx += str.length() + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        for (int i = stack.size() - 1; i >= 0; i--){
            sb.append(stack.get(i));
            if (i != 0){
                sb.append('/');
            }
        }
        return sb.toString();
    }

    /*
     * From idx, get the string util / or the end of the str
     */
    private String getNextStr(String path, int idx){
        if (idx >= path.length()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true){
            char c = path.charAt(idx);
            if (c == '/'){
                break;
            }
            sb.append(c);
            idx++;
            if (idx == path.length()){
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/a/b"));
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));
        System.out.println(sp.simplifyPath("/.."));
        System.out.println(sp.simplifyPath("///"));
        System.out.println(sp.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
