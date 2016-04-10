package com.fm;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 
 * @author Himi
 *
 */






public class MySurfaceView extends SurfaceView implements Callback, Runnable {
	private SurfaceHolder sfh;
	private Paint paint;
	private Thread th;
	private boolean flag;
	private Canvas canvas;
	private int screenW, screenH;
	//首先声明十个容量的位图数组
	private Bitmap fishBmp[] = new Bitmap[10];
	//记录当前播放帧
	private int currentFrame;
	
	private int phoX,phoY;
	
	private int bmpX, bmpY;

	//
	/**
	 * SurfaceView初始化函数
	 */
	public MySurfaceView(Context context) {
		super(context);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		setFocusable(true);
		//将每张小鱼帧图生成位图存入小鱼帧数组中
		for (int i = 0; i < fishBmp.length; i++) {
			fishBmp[i] = BitmapFactory.decodeResource(this.getResources(), R.drawable.fish0 + i);
		}

}

	
	
	
	/**
	 * SurfaceView视图创建，响应此函数
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		bmpX = 250;
		bmpY= 450;
		phoX= 70;
		phoY=70;
		
		screenW = this.getWidth();
		screenH = this.getHeight();
		flag = true;
		//实例线程
		th = new Thread(this);
		//启动线程
		th.start();
	}

	/**
	 * 游戏绘图
	 */

	
	public void myDraw() {
		try {
			canvas = sfh.lockCanvas();

			if (canvas != null) {
				canvas.drawColor(Color.WHITE);
						
				canvas.drawBitmap(fishBmp[currentFrame], bmpX, bmpY, paint);
				canvas.drawBitmap(fishBmp[currentFrame], phoX, phoY, paint);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (canvas != null)
				sfh.unlockCanvasAndPost(canvas);
		}
	}

	/**
	 * 触屏事件监听
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	/**
	 * 按键事件监听
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 游戏逻辑
	 */
	
	//内圈 鱼 顺时针 位移
	private void logic() {
		
		if(phoY==70)
		{
			if(phoX>=70&&phoX<=190)
			{
				phoX+=10;
			}
		}
		if(phoX==200)
		{
			if(phoY>=70&&phoY<=390)
			{
				phoY+=10;
			}	
		}
		if(phoY==400)
		{
			if(phoX>=80&&phoX<=200)
			{
				phoX-=10;
			}
		}
		if(phoX==70)
		{
			if(phoY>=80&&phoY<=400)
			{
				phoY-=10;
			}
		}

	//外圈 鱼 顺时针 位移
	if(bmpY==450)
	{
		if(bmpX>=30&&bmpX<=250)
		{
			bmpX-=10;
			if(bmpX==20)
			{
			}
		}
	}
	if(bmpX==20)
	{
		if(bmpY>=30&&bmpY<=450)
		{
			bmpY-=10;
		}	
	}
	if(bmpY==20)
	{
		if(bmpX>=20&&bmpX<=240)
		{
			bmpX+=10;
		}
	}
	if(bmpX==250)
	{
		if(bmpY>=20&&bmpY<=440)
		{
			bmpY+=10;
		}
	}

		currentFrame++;
		if (currentFrame >= fishBmp.length) {
			currentFrame = 0;

		}
	}

	@Override
	public void run() {
		while (flag) {
			long start = System.currentTimeMillis();
			myDraw();
			logic();
			long end = System.currentTimeMillis();
			try {
				if (end - start < 50) {
					Thread.sleep(50 - (end - start));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * SurfaceView视图状态发生改变，响应此函数
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	/**
	 * SurfaceView视图消亡时，响应此函数
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
	}
}
