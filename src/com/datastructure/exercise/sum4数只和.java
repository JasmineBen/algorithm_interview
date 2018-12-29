package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sum4数只和 {
	
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		new sum4数只和().fourSum(nums, 0);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums != null && nums.length > 3) {
			sort(nums, 0, nums.length - 1);
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Result> result2 = new ArrayList<Result>();
			for (int i = 0; i < nums.length; i++) {
				int find = target - nums[i];
				List<List<Integer>> list = threeSum(nums, i, find);
				if (list != null && list.size() > 0) {
					for(List<Integer> item : list) {
						Result rr = new Result(item.get(0), item.get(1), item.get(2), item.get(3));
						if(!result2.contains(rr)) {
							result2.add(rr);
							result.add(item);
						}
					}
				}
			}
			return result;
		}
		return null;

	}

	private List<List<Integer>> threeSum(int[] nums, int except, int target) {
		List<List<Integer>> threeSums = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (i != except) {
				List<List<Integer>> twoSums = twoSum(nums, except, i, target - nums[i]);
				if (twoSums != null && twoSums.size() > 0) {
					threeSums.addAll(twoSums);
				}
			}
		}
		return threeSums;
	}

	private List<List<Integer>> twoSum(int[] nums, int except1, int except2, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (start != except1 && start != except2 && end != except1 && end != except2) {
				if (nums[start] + nums[end] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[start]);
					list.add(nums[end]);
					list.add(nums[except1]);
					list.add(nums[except2]);
					Collections.sort(list, new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o1-o2;
						}; 
					});
					result.add(list);
					start++;
					end--;
				} else if (nums[start] + nums[end] > target) {
					end--;
				} else {
					start++;
				}
			} else if (start == except1 || start == except2) {
				start++;
			} else if (end == except1 || end == except2) {
				end--;
			}
		}
		return result;
	}

	private void sort(int[] nums, int start, int end) {
		if (start < end) {
			int partion = partion(nums, start, end);
			sort(nums, start, partion);
			sort(nums, partion + 1, end);
		}
	}

	private int partion(int[] nums, int start, int end) {
		int key = nums[start];
		while (start < end) {
			while (start < end && nums[end] >= key) {
				end--;
			}
			nums[start] = nums[end];
			while (start < end && nums[start] <= key) {
				start++;
			}
			nums[end] = nums[start];
		}
		nums[end] = key;
		return end;
	}
	
	public class Result{
		int num1,num2,num3,num4;

		public Result(int num1, int num2, int num3, int num4) {
			super();
			this.num1 = num1;
			this.num2 = num2;
			this.num3 = num3;
			this.num4 = num4;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj != null && obj instanceof Result) {
				Result other = (Result)obj;
				return other.num1 == this.num1 && other.num2 == this.num2 
						&& other.num3 == this.num3 && other.num4 == this.num4;
			}
			return super.equals(obj);
		}
		
	}
}
