package com.example.test_simpledrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;


public class DrawGradientActivity extends DrawingActivity  {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithGradient(this));
	}
	
	private static class ViewWithGradient extends View {

		public ViewWithGradient(Context context) {
			super(context);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {

			canvas.drawColor(Color.WHITE);		//底色

			Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);		// 圆形 抗锯齿
			
			LinearGradient linGrad = new LinearGradient(0, 0, 25, 25,	//沿(0,0)->(25,25)梯度方向
					Color.RED, Color.BLACK, Shader.TileMode.MIRROR);  //  MIRROR ：横向和纵向的重复渲染器图片，这个和REPEAT重复方式不一样，他是以镜像方式平铺。
			circlePaint.setShader(linGrad);		//线性渐变
			canvas.drawCircle(100, 100, 100, circlePaint);		//坐标 +半径
			
			
			RadialGradient radGrad = new RadialGradient(250,
					175, 50, Color.GREEN, Color.BLACK,
					Shader.TileMode.MIRROR);
			circlePaint.setShader(radGrad);			//辐射性渐变
			canvas.drawCircle(250, 175, 50, circlePaint);
			
			SweepGradient sweepGrad = new SweepGradient(canvas.getWidth()-175,
					canvas.getHeight()-175, new int[] {
                            Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA }, null);
			circlePaint.setShader(sweepGrad);  //扇形渐变
			canvas.drawCircle(canvas.getWidth()-175,
					canvas.getHeight()-175, 100, circlePaint);

		}
	}

}

	
	

