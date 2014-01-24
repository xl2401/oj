import java.util.ArrayList;

class IdxPair{
    int s1Idx = 0;
    int s2Idx = 0;
    public IdxPair(){
    }
    public IdxPair(int s1, int s2){
        this.s1Idx = s1;
        this.s2Idx = s2;
    }
}

/*
 * Title:
 * Interleaving String
 *
 * Description:
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * Solution:
 * record the idx of s1 and s2, try to find a possible way
 * Note: NOT efficient enough! see InterleaveStrDP.java
 */
public class InterleaveStr {
    public boolean isInterleave(String s1, String s2, String s3) {
        int N = s3.length();
        if (s1.length() + s2.length() != N)
            return false;
        ArrayList<IdxPair> pairList = getIdx(s1, s2, s3, N-1);
        if (pairList == null)
            return false;
        else
            return true;
    }

    public ArrayList<IdxPair> getIdx(String s1, String s2, String s3, int s3Idx){
        if (s3Idx == -1){
            ArrayList<IdxPair> idxList = new ArrayList<IdxPair>();
            idxList.add(new IdxPair());
            return idxList;
        }
        ArrayList<IdxPair> prevIdx = getIdx(s1, s2, s3, s3Idx-1);
        if (prevIdx == null)
            return null;
        ArrayList<IdxPair> curIdx = new ArrayList<IdxPair>();
        char cur = s3.charAt(s3Idx);
        for (IdxPair ip: prevIdx){
            if (ip.s1Idx < s1.length() && cur == s1.charAt(ip.s1Idx))
                curIdx.add(new IdxPair(ip.s1Idx+1, ip.s2Idx));
            if (ip.s2Idx < s2.length() && cur == s2.charAt(ip.s2Idx))
                curIdx.add(new IdxPair(ip.s1Idx, ip.s2Idx+1));
        }
        if (curIdx.size() == 0)
            return null;
        return curIdx;
    }

    public static void main(String[] args){
        InterleaveStr is = new InterleaveStr();
        String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
        String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
        String s3 = "aacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";
        System.out.println(is.isInterleave(s1,s2,s3));
    }
}
