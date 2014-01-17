/*
 * Title:
 * Gas Station 
 * Description:
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 *
 * Solution:
 * If the route is from i ... j and it fails in j, then every station between i and j are not legal
 * because the value in i should always be positive and if we start in the middle, it will always fail at j
 *
 * Another proof I dit not figure out, when the loop finish,
 * if there is a valid solution, we know the validity from startIdx .. N-1
 * given total >=0, the validity is guraenteed?
 * how to prove?
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int M = cost.length;
        if (N != M) return -1;
        int total = 0;
        int sum = 0;
        int startIdx = 0;
        for (int i = 0; i < N; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0){
                startIdx = i+1;
                sum = 0;
            }
        }
        return total >= 0? startIdx: -1;
    }

    public static void main(String[] args){
        int[] gas = {1,2,3,4};
        int[] cost = {2,0,2,6};
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
