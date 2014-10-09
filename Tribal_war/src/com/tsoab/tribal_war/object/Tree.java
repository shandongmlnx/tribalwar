package com.tsoab.tribal_war.object;

import com.tsoab.tribal_war.fact.BitmapFact;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Tree {

	private CoordXY drawRoot;
	private CoordXY size;

	private Bitmap tree;

	public Tree(CoordXY drawRoot, CoordXY size) {
		super();
		this.drawRoot = drawRoot;
		this.size = size;
	}

	public void drawSelf(Canvas canvas) {
		if (tree == null)
			tree = BitmapFact.getTree(Map.Cell_Width * size.x, Map.Cell_Heigh
					* size.y);
		canvas.drawBitmap(tree, Map.Cell_Width * drawRoot.y, Map.Cell_Heigh
				* (drawRoot.x - size.y), null);
		
	}
}
