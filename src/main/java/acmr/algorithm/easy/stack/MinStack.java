/**
 * 
 */
package acmr.algorithm.easy.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guohz
 * @date 2020年9月28日
 * @description MinStack155
 * 
 * 	设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

	push(x) —— 将元素 x 推入栈中。
	pop() —— 删除栈顶的元素。
	top() —— 获取栈顶元素。
	getMin() —— 检索栈中的最小元素。
	 
	
	示例:
	
	输入：
	["MinStack","push","push","push","getMin","pop","top","getMin"]
	[[],[-2],[0],[-3],[],[],[],[]]
	
	输出：
	[null,null,null,null,-3,null,0,-2]
	
	解释：
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.
	 
	
	提示：
	
	pop、top 和 getMin 操作总是在 非空栈 上调用。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/min-stack
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
public class MinStack {
	private List<Integer> list;
	private int min;
	
	public MinStack() {
		list = new ArrayList<Integer>();
		min = Integer.MAX_VALUE;
	}
	
    public void push(int x) {
    	list.add(x);
    	min = Math.min(min, x);
    }
    
    public void pop() {
    	if(list.size() > 0) {
    		Integer rm = list.get(list.size() - 1);
    		list.remove(list.size() - 1);
    		if(min == rm) {
    			min = Integer.MAX_VALUE;
    			for(int i = 0; i < list.size(); i++) {
    				min = Math.min(min, list.get(i));
    			}
    		}
    	}
    }
    
    public int top() {
    	if(list.size() > 0) {
    		return list.get(list.size() - 1);
    	} else {
    		return Integer.MIN_VALUE;
    	}
    }
    
    public int getMin() {
    	return min;
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < list.size(); i++) {
    		sb.append(list.get(i) + ",");
    	}
    	return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.toString());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.toString());
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

}
