package leetcode.dynamic;

/**
 * Created by baidu on 16/9/1.
 */
public class ScrambleString87 {
    /*
    87. Scramble String  QuestionEditorial Solution  My Submissions
    Total Accepted: 51681
    Total Submissions: 188135
    Difficulty: Hard
    Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

    Below is one possible representation of s1 = "great":

    great
    /    \
    gr    eat
    / \    /  \
    g   r  e   at
    / \
    a   t
    To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
    /    \
    rg    eat
    / \    /  \
    r   g  e   at
    / \
    a   t
    We say that "rgeat" is a scrambled string of "great".

    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
    /    \
    rg    tae
    / \    /  \
    r   g  ta  e
    / \
    t   a
    We say that "rgtae" is a scrambled string of "great".

    Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

    Subscribe to see which companies asked this question
    */
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return false;
        }
        boolean[][][] result = new boolean[len][len][len];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i =0 ; i < len ; i ++){
            for(int j = 0 ; j < len ; j++){
                result[0][i][j] = (c1[i]==c2[j]);
            }
        }
        return true;
    }
}
