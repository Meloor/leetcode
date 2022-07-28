package _103_二叉树的锯齿形层序遍历;

import java.util.*;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.34%)
 * Likes:    674
 * Dislikes: 0
 * Total Accepted:    254.2K
 * Total Submissions: 443.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */
  class TreeNode {
    int val;
    TreeNode left; 
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
hint: //todo 查看题解
Accepted
33/33 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.37 % of java submissions (39.9 MB)
 */
class Solution {
    private List<List<Integer>> ls;
    private void f(TreeNode node,Integer deep){
        if(node==null)
            return;
        //如果列表长度小于深度(deep从0开始), 则给增加列表长度
        while (ls.size() < deep+1)
            ls.add(new ArrayList<Integer>());
        //更新本层的遍历插入到列表
        List<Integer> cls = ls.get(deep);
        cls.add(node.val);
        ls.set(deep,cls);

        f(node.left,deep+1);
        f(node.right,deep+1);           
    }
    private void reverse(List<List<Integer>> ls){
        // List<Integer> tls = null;
        for(int i=0;i<ls.size();i++){
            if(i%2==1){
                Collections.reverse(ls.get(i));
                // tls = ls.get(i);//经测试, get(i)传的是List的引用
                // for(int j=0;j<tls.size()/2;j++){//0,1,2,3: 4/2=2, 3/2=1,
                //     Collections.swap(tls,j,tls.size()-j-1);                
                // }
                // ls.set(i,tls);
            }
        }
        // return ls;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ls = new ArrayList<List<Integer>>();
        f(root,0);
        reverse(ls);
        return ls;
    }
}
// @lc code=end

