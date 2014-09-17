package com.tsoab.tribal_war.bitmap_manage;

import android.R.bool;
import android.graphics.Bitmap;

public class BitmapFact {

	/**
	 * 
	 * @param src
	 *            原始图像
	 * @param row
	 *            原始图像行数
	 * @param line
	 *            原始图像列数
	 * @param findRow
	 *            从原始图像中寻找的行号 从0开始
	 * @return
	 */
	public static Bitmap[] GetRowBitmaps(Bitmap src, int row, int line,
			int findRow) {

		int singleBitmapwidth = src.getWidth() / line;
		int singleBitmapheigh = src.getHeight() / row;

		Bitmap[] bitmaps = new Bitmap[line];

		for (int i = 0; i < line; i++) {
			bitmaps[i] = Bitmap.createBitmap(src, singleBitmapwidth * i,
					singleBitmapheigh * findRow, singleBitmapwidth,
					singleBitmapheigh);
		}

		return bitmaps;
	}
}
