package com.codeliu;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author liu
 * @version 创建时间：2018年3月18日 下午1:01:38
 * 题目描述
 * 科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，
 * 即数字的整数部分只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。
 * 现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。
 * 
 * 输入描述
 * 每个输入包含1个测试用例，即一个以科学计数法表示的实数A。该数字的存储长度不超过9999字节，
 * 且其指数的绝对值不超过9999。
 * 
 * 输出描述
 * 对每个测试用例，在一行中按普通数字表示法输出A，并保证所有有效位都被保留，包括末尾的0。
 * 
 * 输入示例
 * +1.23400E-03
 * 
 * 输出结果
 * 0.00123400
 */
public class 科学计数法 {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		BigDecimal b = read.nextBigDecimal();
		System.out.println(b.toPlainString());
	}
}
