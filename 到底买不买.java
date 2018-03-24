package com.codeliu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author liu
 * @version 创建时间：2018年3月20日 下午8:00:35
 * 题目描述
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；
 * 如果不是，那么告诉她缺了多少珠子。为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，
 * YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 * 
 * 输入描述
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 * 
 * 输出描述
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。
 * 其间以1个空格分隔。
 * 
 * 输入示例
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 
 * 输出结果
 * Yes 8
 */
public class 到底买不买 {
	public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String s1 = read.next();
        String s2 = read.next();
        ArrayList<Character> a1 = new ArrayList<Character>();
        ArrayList<Character> a2 = new ArrayList<Character>();
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            a1.add(s1.charAt(i));
        }
        for(int j = 0; j < s2.length(); j++) {
            a2.add(s2.charAt(j));
        }
        int len = a1.size();
        for(int i = 0; i < a2.size(); i++) {
            for(int j = 0; j < a1.size(); j++) {
                if(a1.get(j) == a2.get(i)) {
                    a1.remove(j);
                    j--;
                    count++;
                    break;
                } 
            }
        }
        if(count == a2.size()) {
        	System.out.println("Yes " + (len - a2.size()));
        } else {
            System.out.println("No " + (a2.size() - count));
        }
    }
}
