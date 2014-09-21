package com.tsoab.tribal_war.object;

public class CoordMN {

	public static final double XChangeParam = 1.0 / Math.sqrt(2);
	public static final double YChangeParam = 1.0 / Math.sqrt(2);

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

	public static CoordXY getCoordXY(CoordMN coordMN) {
		return new CoordXY(XChangeParam * (coordMN.m + coordMN.n), YChangeParam
				* (coordMN.n - coordMN.m));
	}

}
