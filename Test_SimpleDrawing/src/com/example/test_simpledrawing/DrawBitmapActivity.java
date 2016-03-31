package com.example.test_simpledrawing;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;

public class DrawBitmapActivity extends DrawingActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithBitmap(this));
	}

	 private static class ViewWithBitmap extends View {
	        
	        public ViewWithBitmap(Context context) {	//以位图形式 画View
	            super(context);
	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            canvas.drawColor(Color.BLUE);					//canvas画布 背景 取蓝色
	            
	            Bitmap jayPic = BitmapFactory.decodeResource(getResources(), R.drawable.bluejay);  //bluejay来自drawble文件夹 在R文件里生成了ID 调用
	            
	            // Draw the big middle jay
	            Bitmap jayPicMedium= Bitmap.createScaledBitmap(jayPic, 200, 300, false);    //画鸟——大图    
	            canvas.drawBitmap(jayPicMedium, 60, 75, null);	// 放的位置
	            
	            // Create the thumbnail jay
	            Bitmap jayPicSmall= Bitmap.createScaledBitmap(jayPic, 50, 75, false);     //四角 鸟-小图
	         
	            Matrix maxTopLeft = new Matrix();  //旋转30度 左上角 顺时针
	            maxTopLeft.preRotate(30);

	            Matrix maxBottomLeft = new Matrix();  //旋转-30度 左下角
	            maxBottomLeft.preRotate(-30);
	            
	            Matrix maxTopRight = new Matrix();
	            maxTopRight.preRotate(-30);			// tilt 30 degrees left
	            maxTopRight.preScale(-1, 1);		// mirror image  镜面
	            
	            Matrix maxBottomRight = new Matrix();
	            maxBottomRight.preRotate(30);		// tilt 30 degrees right
	            maxBottomRight.preScale(-1, 1);		// mirror image

	            Bitmap jayPicTopLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopLeft, false);
	            Bitmap jayPicBottomLeft = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomLeft, false);

	            Bitmap jayPicTopRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxTopRight, false);		//创建四角小鸟图
	            Bitmap jayPicBottomRight = Bitmap.createBitmap(jayPicSmall, 0, 0, jayPicSmall.getWidth(), jayPicSmall.getHeight(), maxBottomRight, false);
		           
	            // Free up some memory by dumping bitmaps we don't need anymore
	            jayPicSmall.recycle();			//释放空间
	            jayPic.recycle();
	            
	            canvas.drawBitmap(jayPicTopLeft, 30, 30, null);
	            canvas.drawBitmap(jayPicBottomLeft, 30, 325, null);
	            canvas.drawBitmap(jayPicTopRight, 225, 30, null);  		//绘画
	            canvas.drawBitmap(jayPicBottomRight, 225, 325, null);
	            
	            
	        }
	    }

}
