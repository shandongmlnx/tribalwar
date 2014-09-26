package com.tsoab.tribal_war.object;

public class CoordMN {

	public static final float XChangeParam = (float) (1.0 / Math.sqrt(2));
	public static final float YChangeParam = (float) (1.0 / Math.sqrt(2));

	public int m;
	public int n;

	public CoordMN() {

		this(0, 0);
	}

	public CoordMN(int m, int n) {
		super();
		this.m = m;
		this.n = n;
	}

	public static double distance(CoordMN coord1, CoordMN coord2) {
		return Math.sqrt((coord1.m - coord2.m) * (coord1.m - coord2.m)
				+ (coord1.n - coord2.n) * (coord1.n - coord2.n));
	}

	public CoordXY getCoordXY() {
		return new CoordXY((int) (XChangeParam * (n + m)),
				(int) (YChangeParam * (n - m)));
	}

	public boolean validCoord() {
		return getCoordXY().validCoord();
	}

	@Override
	public String toString() {

		return "(" + m + "," + n + ")";
	}

}
