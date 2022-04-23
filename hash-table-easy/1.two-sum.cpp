#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 * 
 * 写一个hashMap, 先读取target9,逐个读取nums,
 * map[9-2]=index表示7的配对2存在；到7的时候，
 * 判断一下map[7]是否有值，有的话就返回索引
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> mp;
        vector<int> ans;
        for(int i=0;i<nums.size();i++){
            if(mp.count(nums[i])==1){// match exists
                ans.push_back(mp[nums[i]]);
                ans.push_back(i);
                break;
            }else{// match not exists
               mp[target-nums[i]]=i; 
            }
            
        }
        return ans;
    }
};
// @lc code=end

