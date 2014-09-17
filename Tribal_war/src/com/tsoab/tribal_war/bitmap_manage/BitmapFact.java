package com.tsoab.tribal_war.bitmap_manage;

import android.R.bool;
import android.graphics.Bitmap;

public class BitmapFact {

	/**
	 * 
	 * @param src
	 *            ԭʼͼ��
	 * @param row
	 *            ԭʼͼ������
	 * @param line
	 *            ԭʼͼ������
	 * @param findRow
	 *            ��ԭʼͼ����Ѱ�ҵ��к� ��0��ʼ
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
