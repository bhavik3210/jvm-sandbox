package com.kotlin.dojo.leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
  val result = IntArray(2)
  val map = hashMapOf<Int, Int>()
  for (i in nums.indices) {
    if (!map.containsKey(nums[i])) {
      map[target - nums[i]] = i
    } else {
      result[0] = i
      result[1] = map[nums[i]] ?: 0
      break
    }
  }
  return result
}