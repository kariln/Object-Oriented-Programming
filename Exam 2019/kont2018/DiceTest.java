package kont2018;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

@Test
public class DiceTest extends junit.framework.TestCase{
	Dice t1 = new Dice(Arrays.asList(1,2,2,4));
	Dice t2 = new Dice(Arrays.asList(1,4));
	Dice t3 = new Dice(Arrays.asList(2,3));
	Dice t4 = new Dice(Arrays.asList(1,2,4));
	
	public void contains_true() {
		assertTrue(t1.contains(t2));
	}

}
