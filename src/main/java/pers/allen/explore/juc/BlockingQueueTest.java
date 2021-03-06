package pers.allen.explore.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列：是一个在队列基础上又支持了两个附加操作的队列，阻塞队列常用于生产者和消费者的场景
 * @author lengyul
 * @date 2018年12月12日 上午10:37:23
 * 
 * 	 阻塞队列提供了可阻塞的 put 和 take 方法，以及支持定时的 offer 和 poll 方法；
 * 如果队列已经满了，那么 put 方法将阻塞直到有空间可用，如果队列为空，那么 take 方法将会阻塞直到有元素可用
 * 
 * 队列分为有界和无界（无界队列永远都不会满，put 方法也永远不会被阻塞），JDK提供了7种阻塞队列：
 * 1.ArrayBlockingQueue  数组结构组成的有界阻塞队列
 * 2.LinkedBlockingQueue 链表结构组成的有界阻塞队列(Integer.MAX_VALUE)
 * 3.PriorityBlockingQueue 支持优先级的无界阻塞队列
 * 4.DelayQueue 支持延时获取元素的无界阻塞队列，即可指定多久才能从队列中获取当前元素
 * 5.SynchronousQueue 不存储元素的阻塞队列，每一个put必须等待一个take操作，否则不能继续添加其他操作
 * 6.LinkedTransferQueue 链表结构组成的无界阻塞队列
 * 7.LinkedBlockingDeque 链表结构组成的双向阻塞队列，实现了在队列头和队列尾的高效插入和移除
 */
public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> bq = new LinkedBlockingQueue<>(); //defalut size Integer.MAX_VALUE
		
		//添加元素
		bq.put("a"); //当队列元素满时，等待
		boolean addResult = bq.add("b"); //直接返回结果
		boolean offerResult = bq.offer("c"); //直接返回结果
		System.out.println("add:"+addResult+"\t"+"offer:"+offerResult);
		System.out.println("size:"+bq.size());
		
		//获取删除元素
		String str = null;
		str = bq.take(); //获取并删除队列的头元素，当队列元素为0时，等待
		str = bq.poll(); //获取并删除队列的头元素，当队列元素为0时，返回null
		str = bq.peek(); //获取但不删除队列的头元素，当队列元素为0时，返回null
		str = bq.element(); //获取但不删除队列的头元素，当队列元素为0时，返回 java.util.NoSuchElementException
		System.out.println(str);
		
		List<String> lists = new ArrayList<>();
		bq.drainTo(lists); //队列中所有可用的元素添加到指定集合中并删除
		
		System.out.println("size:"+bq.size());
	}
}
