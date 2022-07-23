import java.util.ArrayList;
import java.util.List;

// import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.93%)
 * Likes:    1396
 * Dislikes: 0
 * Total Accepted:    625.2K
 * Total Submissions: 962.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
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
 * -1000 <= Node.val <= 1000
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
/** 
 * hint: 
 *  1 先找树的深度n, 构建一个长度为n的list ls
 *  2 递归树时传入树的深度x,  cls = ls.get(x), cls.add(v) 
 * 
 * 
 * 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ls = new ArrayList<List<Integer>>();
        f(root,0);
        return ls;
    }
}
// @lc code=end

