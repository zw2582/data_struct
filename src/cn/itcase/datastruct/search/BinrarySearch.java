package cn.itcase.datastruct.search;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinrarySearch {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,34,45,55,56,63,78,79,89,90,94,100, 20000};
		BinrarySearch bs = new BinrarySearch();
		
		int key = 233;
		
		int index = bs.search(arr, key);
		System.out.println(index);
		
		index = bs.inSearch(arr, key);
		System.out.println(index);
		
		index = bs.fibonacci_Search(arr, key);
		System.out.println(index);
	}

	/**
	 * 折半查找（二叉查找）
	 * @param a
	 * @param key
	 * @return
	 */
	public int search(int[] a, int key) {
		int low,high,mid;
		low = 0;
		high = a.length - 1;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if(a[mid] < key) {
				low = mid + 1;
			} else if(a[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 插值查找
	 * @param a
	 * @param key
	 * @return
	 */
	public int inSearch(int[] a, int key) {
		int low,high,mid;
		low = 0;
		high = a.length - 1;
		
		while (low <= high) {
			int g = (a[high] - a[low])*(high - low);
			if (g == 0) {
				mid = low;
			} else {
				mid = low + (key - a[low])/g;
			}
			
			if(a[mid] < key) {
				low = mid + 1;
			} else if(a[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 斐波那契查询
	 * @param a
	 * @param key
	 */
	public int fibonacci_Search(int[] a, int key) {
		int n = a.length;
		//定义斐波那契数组
		int[] fi = new int[n];
		fi[0] = 1;
		fi[1] = 1;
		int index = 2;
		while(index < n) {
			fi[index] = fi[index-2] + fi[index - 1];
			index ++;
		}
		
		int k = 0;
		while(n >= fi[k]) {
			k ++;
		}
		
		int[] b = null;
		if(fi[k] > n) {
			b = new int[fi[k]];
			System.arraycopy(a, 0, b, 0, a.length);
			for(int j = n; j < fi[k]; j++) {
				b[j] = b[n-1];
			}
			a = b;
		}
		
		
		int low,high,mid;
		low = 0;
		high = n;
		while(low <= high) {
			mid = low + fi[k-1] -1;
			
			if(key > a[mid]) {
				low = mid + 1;
				k -= 2;
			} else if(key < a[mid]) {
				high = mid -1;
				k -= 1;
			} else {
				if(mid <= n) {
					return mid;
				} else {
					return n -1 ;
				}
			}
		}
		return -1;
	}
	
	
}
