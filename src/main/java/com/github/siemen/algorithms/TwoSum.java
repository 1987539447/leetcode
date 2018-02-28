/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

package com.github.siemen.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 整数数组中两元素之和等于目标值，不能为同一个元素相加，仅返回一个结果
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 7, 9};
        int target = 9;
        int[] result = loop(nums, target);
        System.out.println(result[0] + "--" + result[1]);
        result = useHash(nums, target);
        System.out.println(result[0] + "--" + result[1]);
        result = onePass(nums, target);
        System.out.println(result[0] + "--" + result[1]);
    }

    /**
     * 嵌套两层循环，相加比较
     * O(n2)复杂度
     * */
    private static int[] loop(int[] nums, int target){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                   return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solutions");
    }

    /**
     * 借助HashMap，一遍循环转存数据，一遍循环，通过hash查找匹配值
     * O(n)复杂度
     * */
   private static int[] useHash(int[] nums, int target){
       Map<Integer,Integer> tempMap = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           tempMap.put(nums[i], i);
       }
       for (int i = 0; i < nums.length; i++) {
           int otherPart = target - nums[i];
           if (tempMap.containsKey(otherPart) && tempMap.get(otherPart) != i) {
               return new int[]{i,tempMap.get(otherPart)};
           }
       }
       throw new IllegalArgumentException("No two sum solutions");

   }

    /**
     * 借助HashMap，一遍循环，通过hash查找匹配值-只与前面的值匹配
     * O(n)复杂度
     * */
   private static int[] onePass(int[] nums, int target) {
       Map<Integer,Integer> tempMap = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           int otherPart = target - nums[i];
           if(tempMap.containsKey(otherPart)) {
               return new int[]{tempMap.get(otherPart), i};
           }
           tempMap.put(nums[i],i);
       }
       throw new IllegalArgumentException("No two sum solutions");
   }


}