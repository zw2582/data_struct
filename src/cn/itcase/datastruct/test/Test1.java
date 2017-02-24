package cn.itcase.datastruct.test;

public class Test1 {
	
	public static void main(String[] args) {
		
		Test1 t = new Test1();
		int[] a = new int[]{1};
		
		int result = t.numSearch(a, 1);
		System.out.println(result);
	}
	
	/**
	 * 第一题：在一个已经排序的Int数组中，查找某个number，
	 * 如果存在这个number，返回在数组的位置，反之返回-1 查看博主面试答案
	 */
	public int numSearch(int[] a, int key) {
		int length = a.length;
		if(length ==0 || key < a[0] || key > a[length-1]) {
			return -1;
		}
		if(length == 1) {
			if(a[0] == key) {
				return 0;
			} else {
				return -1;
			}
		}
		return numSearchimp(a, key, 0, a.length-1);
	}

	public int numSearchimp(int[] a, int key, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = (high + low)/2;
		if(a[mid] > key) {
			return numSearchimp(a, key, low, mid - 1);
		} else if(a[mid] < key) {
			return numSearchimp(a, key, mid+1, high);
		} else {
			return mid;
		}
	}
}
