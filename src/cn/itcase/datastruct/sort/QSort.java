package cn.itcase.datastruct.sort;

public class QSort {
	
	public static void main(String[] args) {
		int[] i = new int[]{8,9,10,13,12,11};
		
		/*QSort qSort = new QSort();
		qSort.sort(i, 0, i.length - 1);*/
		
		BubblingSort bs = new BubblingSort();
		bs.threeSort(i);
		
		for(int g : i) {
			System.out.print(g+"-");
		}
	}

	public void sort(int[] i, int low, int high) {
		int start = low;
		int end = high;
		int key = i[low];
		
		while(start < end) {
			while(start < end && i[end] >= key)
				end--;
			if(i[end] < key) {
				int temp = i[end];
				i[end] = i[start];
				i[start] = temp;
			}
			
			while(start < end && i[start] <= key)
				start++;
			if(i[start] > key) {
				int temp = i[start];
				i[start] = i[end];
				i[end] = temp;
			}
		}
		
		if(start > low) sort(i, low, start-1);
		if(end < high) sort(i, end+1, high);
	}
}
