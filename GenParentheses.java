import java.util.ArrayList;

public class GenParentheses{
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        brackets(result, "", 0, 0, n);
        return result;
    }

    private void brackets(ArrayList<String> result, String output, int open, int close, int pairs){
        if((open == pairs)&&(close == pairs)){
            result.add(output);
        }
        else{
            if(open<pairs)
                brackets(result, output + "(", open+1, close, pairs);
            if(close<open)
                brackets(result, output + ")", open, close+1, pairs);
        }
    }

    public static void main(String[] args){
        ArrayList<String> result = new GenParentheses().generateParenthesis(4);
        for (String s: result){
            System.out.println(s);
        }
    }
}
