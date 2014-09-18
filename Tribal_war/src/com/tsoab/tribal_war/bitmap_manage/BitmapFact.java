package com.tsoab.tribal_war.bitmap_manage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tsoab.tribal_war.Constant;
import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.TribalWarApp;

public class BitmapFact extends Constant{
	
	private static TribalWarApp tribalWarApp;
	
	private Bitmap[][] infantryBitmapss;
	
	
	public static void setTribalWarApp(TribalWarApp tribalWarApp) {
		BitmapFact.tribalWarApp = tribalWarApp;
	}

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
	private static Bitmap[] GetRowBitmaps(Bitmap src, int row, int line,
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
	
	private Bitmap[][] getAllBitmapss(int rows, int lines)
	{
		Bitmap bubingBitmap = BitmapFactory.decodeResource(
				tribalWarApp.getResources(), R.drawable.bubing);
		for (int i = 0; i < InfantryBitmapRows; i++) {
			bitmaps[i] = BitmapFact.GetRowBitmaps(bubingBitmap,
					InfantryBitmapRows, InfantryBitmapLines, i);

		}
		return null;
	}
	
	private Bitmap[] getinfantryBitmaps(int findRow)
	{
		if (infantryBitmapss == null)
			infantryBitmapss = getAllBitmapss(InfantryBitmapRows, InfantryBitmapLines);
		return infantryBitmapss[findRow];
	}
}
