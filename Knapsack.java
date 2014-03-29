import java.util.ArrayList;

/*
 * Title: Knapsack Problem - 0-1
 * Description:
 * See AA textbook P. 427
 *
 * Solution:
 * recursive. Is there a DP solution??
 */
public class Knapsack{
    public int maxValue(ArrayList<Integer> weiList, ArrayList<Integer> valList, int W){
        int max = 0;
        for (int i = 0; i < weiList.size(); i++){
            int curWei = weiList.get(i);
            int curVal = valList.get(i);
            if (curWei <= W){
                ArrayList<Integer> subWeiList = new ArrayList<Integer>(weiList);
                ArrayList<Integer> subValList = new ArrayList<Integer>(valList);
                subWeiList.remove(i);
                subValList.remove(i);
                int subMax = maxValue(subWeiList, subValList, W - curWei);
                if (subMax + curVal > max)
                    max = subMax + curVal;
            }
        }
        return max;
    }

    public static void main(String[] args){
        ArrayList<Integer> weiList = new ArrayList<Integer>();
        ArrayList<Integer> valList = new ArrayList<Integer>();
        weiList.add(10);
        weiList.add(20);
        weiList.add(30);
        valList.add(60);
        valList.add(100);
        valList.add(120);
        Knapsack ks = new Knapsack();
        System.out.println(ks.maxValue(weiList,valList, 50));
    }
}
