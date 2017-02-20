package cn.itcase.datastruct.sort;

public class MergeSort {
	
	public void sort(int[] l) {
		int length = l.length;
		int[] TR = new int[length];
		
		int k = 1;
		while(k<length) {
			
		}
	}
	
	public void mergePass(int SR[], int TR[], int s, int n) {
		int i =1;
		int j;
		
		while(i <= n-2*s+1) {
			
		}
	}
	
	public void merge(int SR[], int TR[], int i, int m, int n) {
		int j,k,l;
		
		for(j = m+1,k=i;i<=m && j<=n;k++) {
			if(SR[i] < SR[j]) {
				TR[k] = SR[i++];
			}else {
				TR[k] = SR[j++];
			}
		}
		
		if(i < m) {
			for(l = 0;l <m-i;l++) {
				TR[k+l] = SR[i+1];
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(4^1^6);
	}
}
