package com.monkey01.springbootstart;

import com.demo.SpringbootStartApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStartApplication.class)
public class Test01 {

	/**
	 * 1.已知1~n数组中有一个数字缺失，查找缺失的那个数字
	 */
	public int getLostNum(int[] arr, int n) {
		//方案：
		int sum = (1 + n) * n / 2;
		int resultSum = 0;
		for(int i = 0; i < arr.length; i++) {
			resultSum += arr[i];
		}
		return sum - resultSum;
	}

	/**
	 * 求2亿个数字中最小的10个数（当前仅仅考察20个数，多数据需要分治 + 小顶堆）
	 */
	public int[] getTenMinNumFromArr(int[] arr) {
		//利用最小堆(保证堆顶为最小值)
		int minArr[] = new int[10];
		//先取出10个数，正向排序，作为最小堆
		for(int i = 0; i < minArr.length; i ++) {
			minArr[i] = arr[i];
		}
		Arrays.sort(minArr);
		//从后续继续比较元素
		for(int i = minArr.length; i < arr.length; i++) {
			//构建最小堆
			if(arr[i] < minArr[minArr.length - 1]) {
				minArr[minArr.length - 1] = arr[i];
				Arrays.sort(minArr);
			}
		}
		return minArr;
	}

	public int getMaxLengthArr(int[] arr) {
		int maxResultSum = arr[0];
		int maxEndingIndex = arr[0];
		for(int i = 1; i < arr.length; i++) {
			//获取当前下标数组元素的值与截至当前下表全部元素的和最大值，取较大的值为maxEndingIndex标志位
			maxEndingIndex = Math.max(arr[i], maxEndingIndex + arr[i]);
			//本轮输出结果为：maxEndingIndex标志位与上一轮结果比较，较大的一个值
			maxResultSum = Math.max(maxEndingIndex, maxResultSum);
		}
		return maxResultSum;
	}

	/**
	 * 在一个顺序排序不重复，但是经过旋转的数组中查找一个数是否存在，返回下标（未查询到返回-1）
	 * 要求算法复杂度必须是O(log n)级别
	 */
	public int search01(int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		//先通过二法获取数组最小值，返回下标
		int minIndex = findMinIndex(arr);
		//如果碰巧当前查找到模板目标就是最小值，直接返回结果
		if(target == arr[minIndex]) {
			return minIndex;
		} else if(target < arr[minIndex]) {
			return -1;
		} else {
			int m = arr.length;
			int start = target <= arr[m - 1] ? minIndex : 0;
			int end = target > arr[m - 1] ? minIndex : m - 1;
			while(start <= end) {
				int mid = start + (end - start) / 2;
				if(arr[mid] == target) {
					return mid;
				} else if(target > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 利用二分法获取数组最小值，返回下标
	 */
	private int findMinIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			int mid = start + (end - start) / 2; //从中间分割目标数组
			if(arr[mid] > arr[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

	/**
	 * 利用二分法查找目标数组中指定的值
	 */

	/**
	 * 颜色分类算法排序(颜色固定3种：0 1 2)，顺序排序，相同颜色位置相邻
	 * 目标：{0, 2, 1, 2, 0, 1} -> {0, 0, 1, 1, 2, 2}
	 */
	public int[] colorRebuild(int[] arr) {
		int zeroIndex = 0;
		int twoIndex = arr.length - 1;
		for(int i = 0; i <= twoIndex; ) {
			if(arr[i] == 0 && i > zeroIndex) {
				swap(arr, i, zeroIndex++);
			} else if(arr[i] == 2 && i < twoIndex) {
				swap(arr, i, twoIndex--);
			} else {
				i++;
			}
		}
		return arr;
	}
	/**
	 * 交换指数组指定两个下标的元素位置
	 */
	private void swap(int[] nums, int m, int n) {
		int temp = nums[m];
		nums[m] = nums[n];
		nums[n] = temp;
	}


	/**
	 * 给定一数组，要求找出和为m的全部组合方式，并且要求组合的元素个数必须为k
	 * 例如：{1, 2, 3, 4, 5, 6, 7, 8}中，要求和为8，并且元素个数为3
	 * 输出结果：[[1, 2, 5], [1, 3, 4]]
	 */
	public List<List<Integer>> doFind(int[] data, int k, int m) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> targetList = new ArrayList<>();
		doFindMore(data, 0, k, m, result, targetList);
		return result;
	}
	private void doFindMore(int[] data, int start, int k, int m, List<List<Integer>> result, List<Integer> target) {
		if(m == 0) {
			if(target.size() == k) {
				result.add(new ArrayList<>(target));
			}
		} else if(m > 0) {
			for(int i = start; i < data.length; i++) {
				target.add(data[i]);
				doFindMore(data, i + 1, k, m - data[i], result, target);
			}
		}
		if(target.size() > 0) {
			target.remove(target.size() - 1);
		}
	}

	/**
	 * 遍历二叉树的方式
	 * 中序遍历，使用递归方式
	 * 左 - 中 - 右
	 */
	public List<Integer> inOrderTraversal(TreeNode treeNode) {
		return inOrder(treeNode, new ArrayList<>());
	}
	private List<Integer> inOrder(TreeNode treeNode, List<Integer> result) {
		if(treeNode == null) {
			return result;
		}
		inOrder(treeNode.left, result); //利用递归遍历左节点
		result.add(treeNode.value); //添加左节点结果
		return inOrder(treeNode.right, result); //利用递归遍历右节点
	}

	/**
	 * 遍历二叉树的方式
	 * 前序遍历，使用递归方式（从前面开始向下）
	 * 中 - 左 - 右
	 */
	public List<Integer> inOrderTraversal1(TreeNode treeNode) {
		return inOrder1(treeNode, new ArrayList<>());
	}
	private List<Integer> inOrder1(TreeNode treeNode, List<Integer> result) {
		if(treeNode == null) {
			return result;
		}
		result.add(treeNode.value);
		inOrder1(treeNode.left, result); //利用递归遍历左节点
		inOrder1(treeNode.right, result); //利用递归遍历右节点
		return result;
	}

	/**
	 * 遍历二叉树的方式
	 * 后序遍历，使用递归方式（从后面开始向上）
	 * 左 - 右 - 中
	 */
	public List<Integer> inOrderTraversal2(TreeNode treeNode) {
		return inOrder2(treeNode, new ArrayList<>());
	}
	private List<Integer> inOrder2(TreeNode treeNode, List<Integer> result) {
		if(treeNode == null) {
			return result;
		}
		inOrder2(treeNode.left, result); //利用递归遍历左节点
		inOrder2(treeNode.right, result); //利用递归遍历右节点
		result.add(treeNode.value);
		return result;
	}

	/**
	 * 删除链表倒数第n个节点，n一定有效
	 * 返回链表的头节点
	 */
	public ListNode removeNthFromEnd(ListNode head , int n) {
		ListNode p = head; //尾指针
		ListNode q = head; //头指针
		for(int i = 0; i < n; i++) { //先将头指针相互移动n个位置
			p = p.next;
		}
		if(p == null) { //如果p刚好为空了，那么也就说明当前节点数恰好为n
			head = head.next; //删除倒数第n个，也就是删除首节点
			return head;
		}
		while(p.next != null) { //p不为空，则p和q同时继续向后移
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next; //当p移动到末尾了，那么此时q的位置就是倒数第n个节点
		return head;
	}



	public static void main(String[] args) {
		Test01 test01 = new Test01();
		System.out.println("=================================开始测试=================================");
//		int[] arr0 = {1, 3, 2, 5, 4, 7};
//		System.out.println("已知1~n数组中有一个数字缺失，查找缺失的那个数字: " + test01.getLostNum(arr0, 7));
//
//		int[] arr1={2,1,99,3,4,7,8,33,10,111,12,13,14,15,16,17,18,19,20,6,95};
//		System.out.println("求2亿个数字中最小的10个数: " + Arrays.toString(test01.getTenMinNumFromArr(arr1)));
//
//		int[] arr2 = {99, -1111, 2, 3, 9, -9, -1, 100, -200, 9};
//		System.out.println("最大和数组结果输出: " + test01.getMaxLengthArr(arr2));
//
//		int[] arr3 = {4, 5 ,6, 7, 1, 2, 3};
//		System.out.println("经过旋转的数组中查找一个数是否存在: " + test01.search01(arr3, 6));
//
//		int[] arr4 = {0, 2, 1, 2, 1, 2, 0, 1};
//		System.out.println("求2亿个数字中最小的10个数: " + Arrays.toString(test01.colorRebuild(arr4)));

//		int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8};
//		System.out.println("符合要求的组合为: " + test01.doFind(arr5, 3, 8));

//		TreeNode treeNode = new TreeNode(10);
//		TreeNode leftSecond = new TreeNode(2);
//		leftSecond.right = new TreeNode(5);
//		treeNode.left = leftSecond;
//		TreeNode secondTree = new TreeNode(20);
//		secondTree.left = new TreeNode(15);
//		TreeNode thirdTree = new TreeNode(30);
//		secondTree.right = thirdTree;
//		treeNode.right = secondTree;
//		thirdTree.left = new TreeNode(29);
//		thirdTree.right = new TreeNode(33);
//		System.out.println("中序遍历树的结果为: " + test01.inOrderTraversal(treeNode));
//		System.out.println("前序遍历树的结果为: " + test01.inOrderTraversal1(treeNode));
//		System.out.println("后序遍历树的结果为: " + test01.inOrderTraversal2(treeNode));

		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		System.out.println("原始链表: " + listNode.toString(listNode));
		ListNode newListNode = test01.removeNthFromEnd(listNode, 2);
		System.out.println("删除链表倒数第n个节点，返回头节点: " + newListNode.val);
		System.out.println("删除后的链表: " + listNode.toString(newListNode));

		String a = "a";
		String b = new String("a");
		System.out.println(a == b);

		System.out.println("!23");



		System.out.println("=================================测试结束=================================");

	}



}


class TreeNode//节点结构
{
	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.value = value;
	}
}


class ListNode {
	int val;
	ListNode next;   // 下一个链表对象

	ListNode(int x) { //赋值链表的值
		val = x;
	}
	String toString(ListNode listNode) {
		StringBuilder str = new StringBuilder();
		str.append(listNode.val);
		while(listNode.next != null) {
			str.append(" -> ");
			listNode = listNode.next;
			str.append(listNode.val);
		}
		return str.toString();
	}
}

