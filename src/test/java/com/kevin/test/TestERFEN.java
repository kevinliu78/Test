package com.kevin.test;

/**
 * @author kevin
 * @version 创建时间: 2018年3月5日上午10:23:54
 * @ClassName 二分查找又称折半查找
 * @Description 
 * 二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好；
 * 其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；
 * 否则利用中间位置记录将表分成前、后两个子表，如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，
 * 否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功。
 * 条件是：
 * 1.必须采用顺序存储结构 
 * 2.必须按关键字大小有序排列。
 */
public class TestERFEN {
	
	public static void main(String[] args) {
		int a[] = {2, 6, 14, 23, 57, 75, 79, 90, 90, 95};
		int tag = 90;
//		int ef = binarySearch(a, tag);
		int ef = binarySearch(a, tag,0,9);
		System.out.println(ef);
	}

	/**
	 * 非递归查找
	 * @param arr
	 * @param tag
	 * @return
	 */
	public static int binarySearch(int[] arr, int tag) {
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (high+low)/2;
			if(tag == arr[mid]) {
				return mid;
			}else if(tag > mid) {
				low = mid +1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}
	
	/**
	 * 递归查找
	 * @param arr
	 * @param tag
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binarySearch(int[] arr,int tag, int low,int high) {
		int mid = (high+low)/2;
		if(tag <arr[low] || tag > arr[high] || low>high) {
			return -1;
		}
		if(arr[mid]<tag) {
			low = mid +1;
			return binarySearch(arr, tag, low, high);
		}else if(arr[mid]>tag){
			high = mid -1;
			return binarySearch(arr, tag, low, high);
		}else {
			return mid;
		}
	}
}
