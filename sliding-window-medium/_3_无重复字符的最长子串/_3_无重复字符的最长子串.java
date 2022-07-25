package _3_无重复字符的最长子串;

import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (38.91%)
 * Likes:    7881
 * Dislikes: 0
 * Total Accepted:    1.9M
 * Total Submissions: 4.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */
/*
 * //todo 查看题解
 */
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> cSet = new HashSet<Character>();
        int n = s.length();
        int start = 0;//子串起始位置
        int end = 0;//子串结束位置
        int maxLen = 0;
        while(start<n){//"abcabcbb"
            //搜寻区间[start,end), 表示最大无重复子串的区间
            while(end<n&&!cSet.contains(s.charAt(end))){
                cSet.add(s.charAt(end));
                end++;
            }//end指向一个与cSet重复的字符时退出
            //所以(end-1)指向子串结尾
            maxLen = Math.max(maxLen,cSet.size());
            //此时[start,end-1]区间内的子串都是无重复的
            cSet.remove(s.charAt(start));
            start++;
        }
        return maxLen;
    }
}
// @lc code=end

public class _3_无重复字符的最长子串{
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}