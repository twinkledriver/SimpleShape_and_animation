package com.example.test_shapeviewer;





import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button lineButton = (Button) findViewById(R.id.ButtonLine);
        lineButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		
        		// Create a line from a rectangle
        		
        		ShapeDrawable d = new ShapeDrawable(new RectShape());
        		d.setIntrinsicHeight(2);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.MAGENTA);
				setShapeByDrawable(d);	
        	}
        });
        
        final Button ovalButton = (Button) findViewById(R.id.ButtonOval);
        ovalButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShapeDrawable d = new ShapeDrawable(new OvalShape());
        		d.setIntrinsicHeight(40);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.RED);
				setShapeByDrawable(d);
			}
		});
      
        
		final Button rectButton = (Button) findViewById(R.id.ButtonRect);
		rectButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setShapeByResourceId(R.drawable.green_rect);
			}
		});
        
        final Button roundRectButton = (Button) findViewById(R.id.ButtonRoundRect);
        roundRectButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
						new float[] { 5, 5, 5, 5, 5, 5, 5, 5 }, null, null));
				d.setIntrinsicHeight(50);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.CYAN);
	
			}
		});
        
        
     // Handle Round Rectangle 2Button
     		final Button roundRectButton2 = (Button) findViewById(R.id.ButtonRoundRect2);
     		roundRectButton2.setOnClickListener(new View.OnClickListener() {
     			public void onClick(View v) {
     				
     				float[] outerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
     	            RectF   insetRectangle = new RectF(8, 8, 8, 8);
     	            float[] innerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
     	            
     	           ShapeDrawable d = new ShapeDrawable(new RoundRectShape(outerRadii,insetRectangle , innerRadii));
     	           d.setIntrinsicHeight(50);
     	           d.setIntrinsicWidth(100);
     	           d.getPaint().setColor(Color.WHITE);
     	           setShapeByDrawable(d);
   			}
   		});

	final Button pathButton=(Button) findViewById(R.id.ButtonPath);
	pathButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Path p = new Path(); // pretty star, filled
			p.moveTo(50, 0);
			p.lineTo(25,100);
			p.lineTo(100,50);
			p.lineTo(0,50);
			p.lineTo(75,100);
			p.lineTo(50,0); 
			
			ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
			d.setIntrinsicHeight(100);
			d.setIntrinsicWidth(100);
			d.getPaint().setColor(Color.YELLOW);
			setShapeByDrawable(d);
	
		}
	});
	
		final Button path2button=(Button) findViewById(R.id.ButtonPath2);
		path2button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Path p = new Path();
				
				p.setFillType(Path.FillType.EVEN_ODD); // EVEN_ODD 意味着如果用一条直线横贯图形时，外部和内部交替出现。另外还有效果：WINDING 
				p.moveTo(50, 0);
				p.lineTo(25,100);
				p.lineTo(100,50);
				p.lineTo(0,50);
				p.lineTo(75,100);
				p.lineTo(50,0);  
				
				ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.YELLOW);
				setShapeByDrawable(d);
			}
		});
     		
     	final Button path3button=(Button) findViewById(R.id.ButtonPath3);
     	path3button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Path p = new Path();
				p.moveTo(50, 0);
				p.lineTo(25,100);
				p.lineTo(100,50);
				p.lineTo(0,50);
				p.lineTo(75,100);
				p.lineTo(50,0);  
				
				ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.YELLOW);
				d.getPaint().setStyle(Paint.Style.STROKE); // Line drawing
				
				setShapeByDrawable(d);
	
			}
		});
     	
    	final Button arcButton = (Button) findViewById(R.id.ButtonArc);
		arcButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 345));
				d.setIntrinsicHeight(100);
				d.setIntrinsicWidth(100);
				d.getPaint().setColor(Color.MAGENTA);
				setShapeByDrawable(d);
			}
		});
		
}
 
        
        private void setShapeByResourceId(int resourceId) {
    		// We will animate the imageview
    		ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForShape);
    		reusableImageView.setImageResource(resourceId);
    	}
        
    	private void setShapeByDrawable(Drawable drawable) {
    		// We will animate the imageview
    		ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForShape);
    		reusableImageView.setImageDrawable(drawable);
    	}
  }



