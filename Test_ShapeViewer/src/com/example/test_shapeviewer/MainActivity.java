package com.example.test_shapeviewer;




import com.androidbook.simpleshapes.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
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

		};
      
        
        final Button rectButton = (Button) findViewById(R.id.ButtonRect);
        rectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
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
     			}
     				
     			}
        
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    
}
}
