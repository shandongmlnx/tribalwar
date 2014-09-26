package com.tsoab.tribal_war.fact;

import java.util.List;

import com.tsoab.tribal_war.object.CoordXY;
import com.tsoab.tribal_war.object.Soldier;
import com.tsoab.tribal_war.object.Infantry;

public class SoldierFact {

	public static Infantry getInfantry(List<Soldier> enemySoldierList,
			CoordXY coordXY) {
		Infantry infantry = new Infantry(enemySoldierList);
		infantry.setCoordCurrent(coordXY.getCoordMN());

		System.out.println(coordXY + "   " + coordXY.getCoordMN() + "      "
				+ coordXY.getCoordMN().getCoordXY());
		return infantry;
	}
}
