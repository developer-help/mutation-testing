package springbootjunit5.unit5;

import org.springframework.stereotype.Component;

@Component
public class Subtractor {

	
	public Integer subtract(Integer a, Integer b) {
		return a - b;
	}
	
	
}
