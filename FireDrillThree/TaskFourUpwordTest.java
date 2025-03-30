import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskFourUpwordTest{

	TaskFourUpword getFunction = new TaskFourUpword();

	@Test
	public void testMyFunctionIsValid4(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int[] actual = getFunction.taskFour(arrays);
	int[] result = {2,4,6,8,10};
	assertArrayEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid5(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int[] actual = getFunction.taskFive(arrays);
	int[] result = {1,3,5,7,9};
	assertArrayEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid6(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskSix(arrays);
	int result = 30;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid7(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskSeven(arrays);
	int result = 25;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid8(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskEight(arrays);
	int result = 2;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid9(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskNine(arrays);
	int result = 1;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid10(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskTen(arrays);
	int result = 10;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid11(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int actual = getFunction.taskEleven(arrays);
	int result = 9;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid12(){
	int[] arrays = {1,2,3,4,5,6,7,8,9,10};
	int[] actual = getFunction.taskTwelve(arrays);
	int[] result = {2,1,4,3,6,5,8,7,10,9};
	assertArrayEquals(actual, result);
	}

}

