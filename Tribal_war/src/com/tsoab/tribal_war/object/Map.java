package com.tsoab.tribal_war.object;

import com.tsoab.tribal_war.constant.BitmapConstant;

public class Map {

	private static int map[][];
	
	public static void newMap(int width, int heigh){
		map = new int[width][heigh];
	}
	
	public static boolean isEmpty(int coordM, int coordN)
	{
		return map[coordM][coordN] == BitmapConstant.EmptyLocation;
	}
	
}
