package com.xiangtan.test;

public class Learning {
	public static void main(String[] args) {
		// StringBuffer strb = new StringBuffer();

		// TODO Auto-generated method stub
//		StringTest test = new StringTest();
		// test.Testlength();
		// test.Testequals();
		// test.TeststartWithandendWith();
		// test.TestregionMatchs();
		// test.TestCompareTo();
		// StringBufferTest testb = new StringBufferTest();
		// testb.testLenth();
		// testb.testCapacity();
		StringBuffer strb = new StringBuffer(12);
		String s = "Hello,World!";
		strb.append(s);
		System.out.println(strb.length());//12
		System.out.println(strb.capacity());//12
		strb.append(s);
		System.out.println(strb.length());//24
		System.out.println(strb.capacity());//26
		strb.append(s);
		System.out.println(strb.length());//36
		System.out.println(strb.capacity());//54
//		26+2  = 28   28+26=54
		
		strb.append(s);
		System.out.println(strb.length());//48
		System.out.println(strb.capacity());//54
		//增加的长度是前面所有的长度+2
		
		strb.append(s);
		System.out.println(strb.length());//60
		System.out.println(strb.capacity());//110
		//54+2=56    54+56=110
	}
}
