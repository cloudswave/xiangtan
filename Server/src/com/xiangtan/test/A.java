package com.xiangtan.test;

public class A {
	public static int X = B.Y;
	static{
		++X;
	}
}
