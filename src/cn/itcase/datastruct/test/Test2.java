package cn.itcase.datastruct.test;

/**
 * 第二题：{"12,bob","3,sky","6,cool","1,good","22,go"}，按元素第一列排序 
 */
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test2 t = new Test2();
		
		String[] a = new String[]{"12,bob","3,sky","6,cool","1,good","22,go"};
		
		t.sort(a);
		
		for(String b:a) {
			System.out.print(b+"-");
		}
	}
	
	public void sort(String[] a) {
		int[] b = new int[a.length];
		int i,j,temp;
		String tempStr;
		
		//将字符串中的前缀int数字提取出来，储存在一个数字索引中
		for(i = 0; i< a.length; i++) {
			temp = Integer.valueOf(a[i].split(",")[0]);
			b[i] = temp;
		}
		
		//设置标识，避免掉去排列已经是排列好的顺序
		boolean flag = true;
		
		for(i = 0; i<b.length && flag; i++) {
			flag = false;
			for(j = b.length-1; j>i; j--) {
				
				//排列数字索引的同时，排列原字符串数组
				if(b[j] < b[j-1]) {
					flag = true;
					temp = b[j-1];
					b[j-1] = b[j];
					b[j] = temp;
					
					tempStr = a[j-1];
					a[j-1] = a[j];
					a[j] = tempStr;
				}
			}
		}
	}

}
