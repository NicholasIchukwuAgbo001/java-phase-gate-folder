import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskFourUpwordTest{

	TaskFourUpword getFunction = new TaskFourUpword();

	@Test
	public void testMyFunctionIsValid4(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int[] actual = getFunction.taskFour(arrays);
	int[] result = {4,2,3,6,11};
	assertArrayEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid5(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int[] actual = getFunction.taskFive(arrays);
	int[] result =  {9,8,5,7};
	assertArrayEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid6(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskSix(arrays);
	int result = 26;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid7(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskSeven(arrays);
	int result = 29;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid8(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskEight(arrays);
	int result = 2;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid9(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskNine(arrays);
	int result = 5;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid10(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskTen(arrays);
	int result = 11;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid11(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int actual = getFunction.taskEleven(arrays);
	int result = 9;
	assertEquals(actual, result);
	}

	@Test
	public void testMyFunctionIsValid12(){
	int[] arrays = {4,9,2,8,3,5,6,7,11};
	int[] actual = getFunction.taskTwelve(arrays);
	int[] result = {9,4,8,2,5,3,7,6,11};
	assertArrayEquals(actual, result);
	}

}

