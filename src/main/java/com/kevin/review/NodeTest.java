package com.kevin.review;
/**
 * @author kevin
 * @version 创建时间: 2018年8月7日上午9:46:46
 * @ClassName 类名称
 * @Description 类描述
 */
public class NodeTest {
	//定义一个头结点
	public Node head;
	
	public void addNode(Node node) {
		if(head == null) {
//			System.out.println("head====111======"+head);
			head = node;
		}else {
//			System.out.println("head====2222======"+head);
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	/**
	 * 指定位置增加节点
	 */
	public void addNode(Node node, int index) {
		if(index < 1 || index > length()) {
			System.out.println("error");
			return;
		}
		if(head != null) {
			Node temp = head;
			int count = 1;
			while(temp.next != null) {
				count++;
				if(count == index) {
					node.next = temp.next;
					temp.next = node;
					return;
				}
				temp = temp.next;
			}
		}
	}
	
	/**
	 * 计算单链表长度
	 */
	public int length() {
		if(head != null) {
			int length = 1;
			Node temp = head;
			while(temp.next != null) {
				length++;
				temp = temp.next;
			}
			return length;
		}else {
			return 0;
		}
	}
	
	/**
	 * 打印链表
	 */
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+",");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/**
	 * 删除节点
	 */
	public void deleteNode(int index) {
		if(index < 1 || index > length()) {
			System.out.println("error");
			return;
		}
		if(head != null) {
			Node temp = head;
			int count = 1;
			while(temp.next != null) {
				count++;
				if(count == index) {
					temp.next = temp.next.next;
					return;
				}
				temp = temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		NodeTest n  = new NodeTest();
		n.addNode(new Node(1));
		n.addNode(new Node(2));
		n.addNode(new Node(3));
		n.addNode(new Node(4));
		n.addNode(new Node(5));
		n.addNode(new Node(6));
		n.addNode(new Node(7));
		n.addNode(new Node(8));
		n.print();
		System.out.println(n.length());
		n.deleteNode(3);
		n.print();
		System.out.println(n.length());
		n.addNode(new Node(10), 3);
		n.print();
		System.out.println(n.length());
	}
}
