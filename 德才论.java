package com.codeliu;
import java.util.*;
/**
 * @author liu
 * @version 创建时间：2018年3月9日 下午6:40:55
 * 题目描述
 * 宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，
 * 才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之小人。
 * 凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”
 * 现给出一批考生的德才分数，请根据司马光的理论给出录取排名。
 * 
 * 输入描述
 * 输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，
 * 即德分和才分均不低于L的考生才有资格被考虑录取；H（<100），
 * 为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；
 * 才分不到但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；
 * 德才分均低于H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，
 * 但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。
 * 随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，
 * 德才分为区间[0, 100]内的整数。数字间以空格分隔。
 * 
 * 输出描述
 * 输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，
 * 考生按输入中说明的规则从高到低排序。当某类考生中有多人总分相同时，按其德分降序排列；
 * 若德分也并列，则按准考证号的升序输出。
 * 
 * 输入例子
 * 14 60 80
 * 10000001 64 90
 * 10000002 90 60
 * 10000011 85 80
 * 10000003 85 80
 * 10000004 80 85
 * 10000005 82 77
 * 10000006 83 76
 * 10000007 90 78
 * 10000008 75 79
 * 10000009 59 90
 * 10000010 88 45
 * 10000012 80 100
 * 10000013 90 99
 * 10000014 66 60
 * 
 * 输出描述
 * 12
 * 10000013 90 99
 * 10000012 80 100
 * 10000003 85 80
 * 10000011 85 80
 * 10000004 80 85
 * 10000007 90 78
 * 10000006 83 76
 * 10000005 82 77
 * 10000002 90 60
 * 10000014 66 60
 * 10000008 75 79
 * 10000001 64 90
 */
public class 德才论 {
	public static  void main(String[] args) {
        
        class Student{
           String ID ;
           int morals;
           int talents;
           Student(String ID,int morals,int talents){
               this.ID = ID;
               this.morals = morals;
               this.talents = talents;
           }
       }

       ArrayList<Student> firstClass = new ArrayList<Student>();
       ArrayList<Student> secondClass = new ArrayList<Student>();
       ArrayList<Student> thirdClass = new ArrayList<Student>();
       ArrayList<Student> fourthClass = new ArrayList<Student>();
       Scanner sc = new Scanner(System.in);
       int num = sc.nextInt();
       int L = sc.nextInt();
       int H = sc.nextInt();
       Student[] student = new Student[num];
       for (int i = 0; i < num; i++) {
           student[i] = new Student(sc.next(),sc.nextInt(),sc.nextInt());
           if (student[i].morals >= H && student[i].talents >= H)
               firstClass.add(student[i]);
           else if (student[i].morals >= H && student[i].talents >= L )
               secondClass.add(student[i]);
           else if (student[i].morals >= L && student[i].talents >= L&&student[i].morals>=student[i].talents)
               thirdClass.add(student[i]);
           else if (student[i].morals >= L && student[i].talents >= L)
               fourthClass.add(student[i]);
       }
       System.out.println(firstClass.size()+secondClass.size()+thirdClass.size()+fourthClass.size());
       Comparator<Student> com = new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               if (o1.morals + o1.talents > o2.morals + o2.talents)
                   return -1;
               else if (o1.morals + o1.talents < o2.morals + o2.talents)
                   return 1;
               else {
                   if (o1.morals > o2.morals)
                       return -1;
                   else if (o1.morals < o2.morals)
                       return  1;
                   else {
                       if (Integer.valueOf(o1.ID) < Integer.valueOf(o2.ID))
                           return -1;
                       else
                           return 1;
                   }
               }
           }
       };
       Collections.sort(firstClass, com );
       Collections.sort(secondClass,com);
       Collections.sort(thirdClass,com);
       Collections.sort(fourthClass,com);
       for (int i = 0; i < firstClass.size(); i++) {
           String id = firstClass.get(i).ID;
           int m = firstClass.get(i).morals;
           int t = firstClass.get(i).talents;
           System.out.println( id+" "+m+" "+t);
       }
       for (int i = 0; i < secondClass.size(); i++) {
           String id = secondClass.get(i).ID;
           int m = secondClass.get(i).morals;
           int t = secondClass.get(i).talents;
           System.out.println( id+" "+m+" "+t);
       }

       for (int i = 0; i < thirdClass.size(); i++) {
           String id = thirdClass.get(i).ID;
           int m = thirdClass.get(i).morals;
           int t = thirdClass.get(i).talents;
           System.out.println( id+" "+m+" "+t);
       }

       for (int i = 0; i < fourthClass.size(); i++) {
           String id = fourthClass.get(i).ID;
           int m = fourthClass.get(i).morals;
           int t = fourthClass.get(i).talents;
           System.out.println( id+" "+m+" "+t);
       }
   }
}
