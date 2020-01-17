package kont2018;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestDice extends junit.framework.TestCase{

	@Test
	void test() {
		Dice t1 = new Dice(Arrays.asList(1,2,2,4));
		Dice t2 = new Dice(Arrays.asList(1,4));
		Dice t3 = new Dice(Arrays.asList(2,3));
		Dice t4 = new Dice(Arrays.asList(1,2,4));
		
		assertTrue(t1.contains(t2));
		assertTrue(1<2);
	}

}
