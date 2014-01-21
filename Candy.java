/*
 * Title: Candy 
 * Description:
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Solution:
 * I maintain descend status and add by rule
 * there is a much more simple method use sequential pass and reverse pass,
 * refer to: http://www.cnblogs.com/TenosDoIt/p/3389479.html
 */
 public class Candy {
    public int candy(int[] ratings) {
        int prevCandy = 1;
        int sum = 1;
        int peakValue = 0;
        int accumu = 0;
        boolean descend = false;
        for (int i = 1; i < ratings.length; i++){
            int curCandy = 0;
            if (ratings[i] > ratings[i-1]){
                descend = false;
                curCandy = prevCandy + 1;
                accumu = 0;
            }
            else if (ratings[i] == ratings[i-1]){
                descend = false;
                accumu = 0;
                curCandy = 1;
            }
            else{
                if (descend == false){// previous ascend
                    peakValue = prevCandy;
                }
                sum += accumu;
                if (accumu + 1 >= peakValue)
                    sum++;
                accumu++;
                descend = true;
                curCandy = 1;
            }
            sum += curCandy;
            prevCandy = curCandy;
        }
        return sum;
    }

    public static void main(String[] args){
        Candy c = new Candy();
        int[] A = {3,2,2,1};
        System.out.println(c.candy(A));
    }
}
