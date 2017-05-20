package pp.block2.cp.test;

import nl.utwente.pp.cp.junit.ConcurrentRunner;
import nl.utwente.pp.cp.junit.Threaded;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pp.block2.cp.queue.LinkedQueue;
import pp.block2.cp.queue.Node;

@RunWith(ConcurrentRunner.class)
public class LinkedQueueTest {

	/**
	 * The amount of threads used in each test.
	 */
	private static final int AMOUNT_OF_THREADS = 7;

	private LinkedQueue testObject;
	private int runs = 11;
	private int init = 100;
	private boolean addtest = false;
	private boolean pushTest = false;

	/**
	 * If you need to setup some object before the multithreaded tests start, you can do it in a method annotated with
	 * {@link Before}. This methods are always executed single threaded.
	 */
	@Before
	public void before() {
		this.testObject = new LinkedQueue();
		for (int i = 0; i < init; i++) {
			testObject.addNode(new Node (i));
		}
	}

	/**
	 * Simple multi threaded test which performs reads and writes to a queue from the same threads. There is no
	 * difference between the task of each thread.
	 */
	@Test
	@Threaded(count = AMOUNT_OF_THREADS)
	public void addNodeMultiThreadedTest() throws InterruptedException {
		for (int i = init; i < runs+init; i++) {
			testObject.addNode(new Node(i));
		}
		addtest = true;
	}

	/**
	 * This test is missing the {@link Threaded} annotation, so it will run single threaded, like a normal JUnit test
	 * would, which does not run on separate threads at all.
	 */
	@Test
	public void addNodeSingleThreadedTest() {
		for (int i = init; i < runs * AMOUNT_OF_THREADS+init; i++) {
			testObject.addNode(new Node(i));
		}
		addtest = true;
	}

	/**
	 * Simple multi threaded test which performs reads and writes to a queue from the same threads. There is no
	 * difference between the task of each thread.
	 */
	@Test
	@Threaded(count = AMOUNT_OF_THREADS)
	public void pushMultiThreadedTest() throws InterruptedException {
		for (int i = 0; i < runs; i++) {
			testObject.push(testObject.getLastNode());
		}
		pushTest = true;
	}

	/**
	 * This test is missing the {@link Threaded} annotation, so it will run single threaded, like a normal JUnit test
	 * would, which does not run on separate threads at all.
	 */
	@Test
	public void pushNodeSingleThreadedTest() {
		for (int i = 0; i < runs*AMOUNT_OF_THREADS; i++) {
			testObject.push(testObject.getLastNode());
		}
		pushTest = true;
	}

	/**
	 * If you want to assert something about the state of the class after all threads are ended, you can annotate
	 * a method with {@link After} and assert in there. Methods annotated with {@link After} always run single threaded.
	 */
	@After
	public void after() {
		//Assert the queue is empty.
		if (addtest) {
			System.out.println("Test was an addtest!");
			Assert.assertEquals(runs*AMOUNT_OF_THREADS + init, testObject.getLength());
		}
		if (pushTest) {
			System.out.println("Test was a pushtest!");
			System.out.println("Last node in the queue = " + testObject.getLastNode().getValue());
			Assert.assertEquals(init - 1, testObject.getLastNode().getValue());
		}
		System.out.println("Test finished with the following result:");
		System.out.println(testObject);
	}

}
