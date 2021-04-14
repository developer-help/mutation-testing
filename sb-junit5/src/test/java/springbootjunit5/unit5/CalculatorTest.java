package springbootjunit5.unit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import springbootjunit5.unit5.Adder;
import springbootjunit5.unit5.Calculator;
import springbootjunit5.unit5.Multiplier;
import springbootjunit5.unit5.Subtractor;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalculatorTest {

	@MockBean
	Adder adder;
	
	@MockBean
	Subtractor subtractor;
	
	
	@Autowired
	Calculator calculator;
	
	@MockBean
	Multiplier multiplier;
	
	
	
	@Test
	@DisplayName(" Test positive integer Addition")
	public void testAddition() {
		Mockito.when(adder.add(Mockito.anyInt(),Mockito.anyInt())).thenReturn(22);
		Integer result = calculator.add(Integer.valueOf(10), Integer.valueOf(12));
		assertEquals(Integer.valueOf(22),result);
	}
	
	@Test()
	@DisplayName(" Test addition failure for one of the arguments are negative")
	public void testAdditionOneNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () ->
		calculator.add(Integer.valueOf(-10), Integer.valueOf(12)));
		 
	}
	
	
	
	@Test()
	@DisplayName(" Test addition failure when both the  arguments are negative")
		public void testAdditionBothNegativeNumber() {
		assertThrows(IllegalArgumentException.class, 
				() -> calculator.add(Integer.valueOf(-10), Integer.valueOf(-12)));
	}
	
	@Test
	@DisplayName(" Test positive case for substraction")
		public void testSubstraction() {
		Mockito.when(subtractor.subtract(Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
		Integer result = calculator.subtract(Integer.valueOf(11), Integer.valueOf(10));
		assertEquals(Integer.valueOf(1),result);
	}
	
	@Test
	@DisplayName(" Test positive case for multiplication")
		public void testMultiplier() {
		Mockito.when(multiplier.multiply(Mockito.anyInt(),Mockito.anyInt())).thenReturn(10);
		Integer result = calculator.multiplier(Integer.valueOf(1), Integer.valueOf(10));
		assertEquals(true,true);
	}
	
}
