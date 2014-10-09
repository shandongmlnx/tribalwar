package com.tsoab.tribal_war.fact;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.TribalWarApp;
import com.tsoab.tribal_war.constant.BitmapConstant;

public class BitmapFact extends BitmapConstant {

	private static TribalWarApp tribalWarApp;

	private static Bitmap[][] infantryBitmapss;

	private static Bitmap tree;

	public static void setTribalWarApp(TribalWarApp tribalWarApp) {
		BitmapFact.tribalWarApp = tribalWarApp;
	}

	private static Bitmap[][] getAllBitmapss(Bitmap src, int rows, int lines) {

		int singleBitmapwidth = src.getWidth() / lines;
		int singleBitmapheigh = src.getHeight() / rows;

		Bitmap[][] bitmapss = new Bitmap[rows][];

		for (int i = 0; i < rows; i++) {
			Bitmap[] bitmaps = new Bitmap[lines];
			for (int j = 0; j < lines; j++) {
				bitmaps[j] = Bitmap.createBitmap(src, singleBitmapwidth * j,
						singleBitmapheigh * i, singleBitmapwidth,
						singleBitmapheigh);
			}
			bitmapss[i] = bitmaps;
		}

		return bitmapss;
	}

	public static Bitmap[][] getinfantryBitmapss() {

		if (infantryBitmapss == null) {
			Bitmap bubingBitmap = BitmapFactory.decodeResource(
					tribalWarApp.getResources(), R.drawable.bubing);
			infantryBitmapss = getAllBitmapss(bubingBitmap, InfantryBitmapRows,
					InfantryBitmapLines);
			if (!bubingBitmap.isRecycled())
				bubingBitmap.recycle();
		}

		return infantryBitmapss;
	}

	/**
	 * get tree bitmap
	 * 
	 * @return tree bitmap
	 */
	public static Bitmap getTree() {
		if (tree == null)
			tree = BitmapFactory.decodeResource(tribalWarApp.getResources(),
					R.drawable.tree);
		return tree;
	}

	/**
	 * 
	 * @param dstWidth 	destion width bitmap
	 * @param dstHeight	destion heigh bitmap
	 * @return tree bitmap
	 */
	public static Bitmap getTree(int dstWidth, int dstHeight) {
		if (tree == null)
			tree = Bitmap.createScaledBitmap(getTree(), dstWidth, dstHeight, true);
		return tree;
	}
}
