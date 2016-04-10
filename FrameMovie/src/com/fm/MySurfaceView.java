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
	//��������ʮ��������λͼ����
	private Bitmap fishBmp[] = new Bitmap[10];
	//��¼��ǰ����֡
	private int currentFrame;
	
	private int phoX,phoY;
	
	private int bmpX, bmpY;

	//
	/**
	 * SurfaceView��ʼ������
	 */
	public MySurfaceView(Context context) {
		super(context);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		setFocusable(true);
		//��ÿ��С��֡ͼ����λͼ����С��֡������
		for (int i = 0; i < fishBmp.length; i++) {
			fishBmp[i] = BitmapFactory.decodeResource(this.getResources(), R.drawable.fish0 + i);
		}

}

	
	
	
	/**
	 * SurfaceView��ͼ��������Ӧ�˺���
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
		//ʵ���߳�
		th = new Thread(this);
		//�����߳�
		th.start();
	}

	/**
	 * ��Ϸ��ͼ
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
	 * �����¼�����
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	/**
	 * �����¼�����
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * ��Ϸ�߼�
	 */
	
	//��Ȧ �� ˳ʱ�� λ��
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

	//��Ȧ �� ˳ʱ�� λ��
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
	 * SurfaceView��ͼ״̬�����ı䣬��Ӧ�˺���
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	/**
	 * SurfaceView��ͼ����ʱ����Ӧ�˺���
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
	}
}
