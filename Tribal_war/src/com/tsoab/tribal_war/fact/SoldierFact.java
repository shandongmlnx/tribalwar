package com.tsoab.tribal_war.fact;

import java.util.List;
import java.util.Random;

import com.tsoab.tribal_war.activity.MainActivity;
import com.tsoab.tribal_war.object.CoordXY;
import com.tsoab.tribal_war.object.Infantry;
import com.tsoab.tribal_war.object.Soldier;

public class SoldierFact {

	public static Random random = new Random(); // Ëæ»úÊý

	public static Infantry getInfantry(List<Soldier> enemySoldierList,
			CoordXY coordXY) {
		Infantry infantry = new Infantry(enemySoldierList);
		infantry.setCoordCurrent(coordXY.getCoordMN());

		System.out.println(coordXY + "   " + coordXY.getCoordMN() + "      "
				+ coordXY.getCoordMN().getCoordXY());
		return infantry;
	}

	public static Infantry getInfantry(List<Soldier> enemySoldierList) {

		CoordXY coordXY = new CoordXY(random.nextInt(MainActivity.Screem_Width),
				random.nextInt(MainActivity.Screem_Heigh));
		return getInfantry(enemySoldierList, coordXY);
	}
}
