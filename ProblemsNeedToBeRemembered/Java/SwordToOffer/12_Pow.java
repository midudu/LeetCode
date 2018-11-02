/* 

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 */

/* Method 1: Call Lib function of Java */
/* public class Solution {
    public double Power(double base, int exponent) {
        
        return Math.pow(base, exponent);
  }
} */


/* Method 2: O(logn) */
public class Solution {
 
    public double Power(double base, int exponent) {
        
        if ( exponent == 0 ) {
			if ( Double.compare(0.0, base) == 0 ) {
				throw new RuntimeException();
			} else {
				return 1.0;
			}
		} else if ( exponent == 1 ) {
			return base;
		} else if ( exponent == -1 ) {
			return 1.0 / base;
		} else {
			
			if ( exponent % 2 == 0 ) {
				return Power(base, exponent/2);
			} else {
				
				int a = exponent / 2;
				int b = exponent - a * 2;
				
				return Power(base, a) * Power(base, a) * Power(base, b);
			}
		}
    }
}