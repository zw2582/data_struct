package cn.itcase.datastruct.search;

import java.lang.reflect.Array;

import org.omg.CORBA.FREE_MEM;

/**
 * 二叉排序树
 * @author Administrator
 *
 */
public class Btsearch {
	
	public Node T = null;
	
	public int length = 0;

	static class Node{
		int data;
		
		Node lchild;
		Node rchild;
		
	}
	
	public Object[] search(int key) {
		return this.search(this.T, key, null);
	}
	
	/**
	 * 二叉树查询
	 * @param T
	 * @param key
	 * @param p
	 * @return
	 */
	public Object[] search(Node T, int key, Node p) {
		if (T == null) {
			return new Object[]{false, p};
		}
		if(T.data == key) {
			return new Object[]{true, T};
		}
		if(T.data > key) {
			return search(T.lchild, key, T);
		}
		if(T.data < key) {
			return search(T.rchild, key, T);
		}
		return null;
	}
	
	public void insert(int key) {
		Object[] result = this.search(key);
		if(result == null) {
			return;
		}
		if((boolean)result[0] == true) {
			return;
		}
		Node f = (Node)result[1];
		Node s = new Node();
		s.data = key;
		s.lchild = s.rchild = null;
		if(this.length == 0) {
			T = s;
		}else if(f.data > key) {
			f.lchild = s;
		}else if(f.data < key) {
			f.rchild = s;
		}
		this.length ++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		this.bianli(this.T, sb);
		return sb.toString();
	}
	
	public void bianli(Node T, StringBuilder sb) {
		if(T== null) {
			return;
		}
		this.bianli(T.lchild, sb);
		sb.append(T.data+"-->");
		this.bianli(T.rchild, sb);
	}
	
	public void delete(int key) {
		this.delete(this.T, key);
	}
	
	public void delete(Node T, int key) {
		if(T == null) {
			return;
		}else if(T.data == key) {
			deleteBsd(T);
		}else if(T.data > key) {
			delete(T.lchild, key);
		} else {
			delete(T.rchild, key);
		}
	}
	
	public void deleteBsd(Node T) {
		Node q = T;
		if(T.rchild == null) {
			T = T.lchild;
			q = null;
		} else if (T.lchild == null) {
			T = T.rchild;
			q = null;
		} else {
			Node s = T.lchild;
			while(s.rchild != null) {
				q = s; s = s.rchild;
			}
			T.data = s.data;
			if(q != T) {
				q.rchild = s.lchild;
			} else {
				q.lchild = s.rchild;
			}
			s = null;
		}
	}
	
	public static void main(String[] args) {
		Btsearch btsearch = new Btsearch();
		
		btsearch.insert(34);
		btsearch.insert(23);
		btsearch.insert(58);
		btsearch.insert(47);
		btsearch.insert(26);
		btsearch.insert(89);
		
		System.out.println(btsearch);
		
		btsearch.delete(34);
		System.out.println(btsearch);
		
	    Object[] result = btsearch.search(23);
	    Node f = (Node)result[1];
		System.out.println(f.data);
	}
	
}
