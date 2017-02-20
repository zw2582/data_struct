package cn.itcase.datastruct.sort;

public class QuickSort {

	public void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];
		
		while(end > start) {
			while(end > start && a[end] >= key) 
				end --;
			if(a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			
			while(end > start && a[start] <= key) 
				start ++;
			if(a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
		}
		
		if(start > low) sort(a,low,start-1);
		if(end <high) sort(a, end+1, high);
	}
}
