import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Title: Knapsack Problem - with Fraction
 * Description:
 * See AA textbook P. 427
 *
 * Solution:
 * This is a greedy algo. Making choice based on average value
 */
class Item{
    int wei;
    int val;
    public Item(int wei, int val){
        this.wei = wei;
        this.val = val;
    }
}

public class KnapsackFrac{
    public ArrayList<Item> buildSortedItemList(int[] weiArray, int[] valArray){
        ArrayList<Item> res = new ArrayList<Item>();
        for (int i = 0; i < weiArray.length; i++){
            int wei = weiArray[i];
            int val = valArray[i];
            res.add(new Item(wei, val));
        }
        // sort
        Collections.sort(res, new Comparator<Item>(){
            public int compare(Item a, Item b){
                double cmpVal = (1.0 * b.val / b.wei - 1.0 * a.val / a.wei);
                if (cmpVal > 0) return 1;
                else if (cmpVal < 0) return -1;
                else return 0;
            }
        });
        return res;
    }

    public double getMaxVal(ArrayList<Item> itemList, int W){
        double maxVal = 0;
        for (Item item: itemList){
            int wei = item.wei;
            int val = item.val;
            System.out.println(wei);
            if (W < wei){// last frac
                maxVal += 1.0 * val / wei * W;
                break;
            }
            else{
                W -= wei;
                maxVal += val;
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        KnapsackFrac ks = new KnapsackFrac();
        int[] weiArray = {10, 20, 30};
        int[] valArray = {60, 100, 120};
        ArrayList<Item> itemList = ks.buildSortedItemList(weiArray, valArray);
        System.out.println(ks.getMaxVal(itemList, 50));
    }
}
