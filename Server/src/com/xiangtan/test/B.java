package com.xiangtan.test;

public class B {
	public static int Y = A.X;
	static {
		++Y;
	}
}
