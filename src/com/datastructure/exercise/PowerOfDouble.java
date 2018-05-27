package com.datastructure.exercise;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。 求base的exponent次方。
 */
public class PowerOfDouble {
	
	public static void main(String[] args) {
		PowerOfDouble test = new PowerOfDouble();
		System.out.println(test.Power(2, -2));
	}

	public double Power(double base, int exponent) {
		if(exponent == 0){
			return 1;
		}
		if(exponent > 0){
			if(base == 0){
				return 0;
			}
			double a = base;
			for(int i=1;i<exponent;i++){
				a *= base;
			}
			return a;
		}else{
			if(base == 0){
				return 0;
			}else{
				double a = base;
				int e = -exponent;
				for(int i=1;i<e;i++){
					a *= base;
				}
				return 1/a;
			}
		}
		
	}

}
