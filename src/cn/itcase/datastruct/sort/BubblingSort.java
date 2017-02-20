package cn.itcase.datastruct.sort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class BubblingSort {
	
	public static void main(String[] args) {
		int zhongzi = 1000000;
		int[] l = new int[zhongzi];
		int index = 0;
		Random random = new Random(5);
		for(int i = zhongzi; i > 1; i--) {
			l[index++] = random.nextInt(zhongzi);
		}
//		l = new int[]{5,4,3,2,1};
		
		BubblingSort bs = new BubblingSort();
		long currentTimeMillis1 = System.currentTimeMillis();
//		bs.simpleSort(l);	//146毫秒
		
//		bs.secondSort(l);	//57毫秒
		
//		bs.threeSort(l);	//7毫秒
		
//		bs.simleChooseSort(l);	//33毫秒
		
//		bs.insertSort(l);	//35毫秒
		
//		bs.shellSort(l);	//5毫秒
		
//		bs.heapSort(l);		//7毫秒
		
		/*QuickSort qs = new QuickSort();
		qs.sort(l, 0, l.length-1);*/
		
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2 - currentTimeMillis1);
		/*for(int i : l) {
			System.out.print(i+"\t");
		}*/
	}

	/**
	 * 简单排序
	 * @param l
	 */
	public void simpleSort(int[] l) {
		for(int i = 0; i < l.length; i ++) {
			for(int j = i + 1; j < l.length; j++) {
				if (l[i] > l[j]) {
					swap(l, i, j);
				}
			}
		}
	}
	
	/**
	 * 优化排序
	 * @param l
	 */
	public void secondSort(int[] l) {
		for(int i = 0; i < l.length; i++) {
			for(int j = l.length - 1; j > i; j--) {
				if (l[j-1] > l[j]) {
					swap(l, j-1, j);
				}
			}
		}
	}
	
	/**
	 * 终极优化排序
	 * @param l
	 */
	public void threeSort(int[] l) {
		boolean flag = true;
		for(int i = 0; i< l.length && flag; i++) {
			flag = false;
			for(int j = l.length -1; j > i; j--) {
				if (l[j-1] > l[j]) {
					swap(l, j-1, j);
					flag = true;
				}
			}
		}
	}
	
	/**
	 * 简单选择排序
	 * 选出从i开始到n之间最小的元素，并与i替换
	 * @param l
	 */
	public void simleChooseSort(int[] l) {
		for(int i = 0; i < l.length; i++) {
			int min = i;
			for(int j = i + 1; j < l.length; j++) {
				if(l[min] > l[j]) {
					min = j;
				}
			}
			if(i != min) {
				swap(l, i, min);
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param l
	 */
	public void insertSort(int[] l) {
		int i,j,d;
		for(i = 1; i < l.length; i++) {
			if(l[i] < l[i - 1]) {
				d = l[i];
				for(j = i - 1; j >= 0 && l[j] > d; j--) {
					l[j + 1] = l[j];
				}
				l[j + 1] = d;
			}
		}
	}
	
	/**
	 * 希尔排序
	 * 是第一个脱离O(n2)的排序算法
	 * 时间复杂度O(n3/2)
	 * @param l
	 */
	public void shellSort(int[] l) {
		int inc = l.length;
		int i,j,d;
		do {
			inc = inc / 3 +1;
			
			for (i = inc +1; i < l.length; i++) {
				if(l[i] < l[i - inc]) {
					d = l[i];
					for(j = i - inc; j >=0 && l[j] > d; j-=inc) {
						l[j + inc] = l[j];
					}
					l[j + inc] = d;
				}
			}
		}while(inc > 1);
	}
	
	/**
	 * 堆排序
	 * 时间复杂度：O(nlogn)
	 * @param l
	 */
	public void heapSort(int[] l) {
		int length = l.length;
		for(int i = length /2; i>=0; i--) {
			heapadjust(l, i, length-1);
		}
		
		for(int i = l.length-1; i>=0 ; i--) {
			swap(l, 0, i);
			heapadjust(l, 0, i-1);
		}
	}
	
	public void heapadjust(int[] l, int s, int m) {
		int j,temp;
		temp = l[s];
		for(j = 2*s; j <= m; j *= 2) {
			if(j < m && l[j] < l[j+1]) {
				j++;
			}
			
			if(l[j] <= temp) {
				break;
			}
			l[s] = l[j];
			s = j;
		}
		l[s] = temp;
	}
	
	private void swap(int[] l, int i, int j) {
		int temp = l[i];
		l[i] = l[j];
		l[j] = temp;
	}
}
