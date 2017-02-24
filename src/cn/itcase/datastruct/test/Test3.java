package cn.itcase.datastruct.test;

/**
 * 将一个未排序的整形数组进行归置，数组中的负数移动到数组的左边，正数移动到数组的右边。0不动
 * {5,0,0,3,-1,3,0,0,4}
 *  {5,3,0,0,-1,0,0,3,4}
 *  {5,3,0,-1,3,4}
 *  @todo 失败
 */
public class Test3 {
	
	public static void main(String[] args) {
		int[] a = new int[]{2,0,-2,0,-1};
		
		Test3 t = new Test3();
		
		t.sort(a, 0, a.length-1);
		
		for(int i : a) {
			System.out.print(i+",");
		}
	}

	public void sort(int[] a, int low, int high) {
		
		int zero=-1;
		boolean flag = false;
		
		while(low < high){
			while(low < high && a[high]>=0) {
				if(a[high] == 0 && !flag) {
					flag = true;
					zero = 1;
					break;
				}
				high--;
			}
			
			if(low < high && flag && zero == 2) {
				int temp = a[high];
				a[high] = a[low];
				a[low] = temp;
			}
			
			while(low < high && a[low] <= 0) {
				if(a[low] == 0 && !flag) {
					flag = true;
					zero = 2;
					break;
				}
				low ++;
			}
			
			if(flag && zero == 1) {
				zero = 2;
			}
			if(low < high) {
				int temp = a[high];
				a[high] = a[low];
				a[low] = temp;
			}
		}
		
	}
}
