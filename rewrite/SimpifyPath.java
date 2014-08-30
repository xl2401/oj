public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> s = new Stack<String>();
        for (String token : tokens) {
            if (token.equals("..")) {
                if (!s.isEmpty()) s.pop();
                else continue;
            }
            else if (token.length() == 0 || token.equals(".")) continue;
            else s.push(token);
        }
        StringBuilder sb = new StringBuilder();
        for (String token: s) {
            sb.append("/");
            sb.append(token);
        }
        String res = sb.toString();
        return res.length() == 0 ? "/" : res;
    }
}