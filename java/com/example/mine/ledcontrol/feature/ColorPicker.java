package com.example.mine.ledcontrol.feature;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class ColorPicker extends View {

    private final int paramOuterPadding = 2;
    private final int paramInnerPadding = 5;
    private final int paramValuesSliderWidth = 10;
    private final int paramArrowPointerSize = 4;

    private Paint colorWheelPaint;
    private Paint valueSliderPaint;

    private Paint colorViewPaint;

    private Paint colorPointerPaint;
    private RectF colorPointerCoords;

    private Paint valuePointerPaint;
    private Paint valuePointerArrowPaint;

    private RectF outerWheelRect;
    private RectF innerWheelRect;

    private Path colorViewPath;
    private Path valueSliderPath;
    private Path arrowPointerPath;

    private Bitmap colorWheelBitmap;

    private int valueSliderWidth;
    private int innerPadding;
    private int outerPadding;

    private int arrowPointerSize;
    private int outerWheelRadius;
    private int innerWheelRadius;
    private int colorWheelRadius;

    private Matrix gradientRotationMatrix;

    private float[] colorHSV = new float[] {0f, 0f, 1f};;

    public ColorPicker(Context context, AttributeSet attrs, int defStyle){

        super(context, attrs, defStyle);
        init();
    }

    public ColorPicker(Context context, AttributeSet attrs){

        super(context, attrs);
        init();
    }

    public ColorPicker(Context context){

        super(context);
        init();
    }

    private void init(){

        colorPointerPaint = new Paint();
        colorPointerPaint.setStyle(Style.STROKE);
        colorPointerPaint.setStrokeWidth(2f);
        colorPointerPaint.setARGB(128,0,0,0);

        valuePointerPaint = new Paint();
        valuePointerPaint.setStyle(Style.STROKE);
        valuePointerPaint.setStrokeWidth(2f);

        valuePointerArrowPaint = new Paint();

        colorWheelPaint = new Paint();
        colorWheelPaint.setAntiAlias(true);
        colorWheelPaint.setDither(true);

        valueSliderPaint = new Paint();
        valueSliderPaint.setAntiAlias(true);
        valueSliderPaint.setDither(true);

        colorViewPaint = new Paint();
        colorViewPaint.setAntiAlias(true);

        colorViewPath = new Path();
        valueSliderPath = new Path();
        arrowPointerPath = new Path();

        outerWheelRect = new RectF();
        innerWheelRect = new RectF();

        colorPointerCoords = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(widthSize, heightSize);
        setMeasuredDimension(size, size);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas){

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        /**
         * drawing color wheel
         */

        canvas.drawBitmap(colorWheelBitmap, centerX - colorWheelRadius, centerY - colorWheelRadius, null);

        /**
         * drawing color view
         */

        colorViewPaint.setColor(Color.HSVToColor(colorHSV));
        canvas.drawPath(colorViewPath, colorViewPaint);

        /**
         * drawing value slider
         */

        float[] hsv = new float[] {colorHSV[0], colorHSV[1], 1f};

        SweepGradient sweepGradient = new SweepGradient(centerX, centerY, new int[] {Color.BLACK, Color.HSVToColor(hsv), Color.WHITE}, null);
        sweepGradient.setLocalMatrix(gradientRotationMatrix);
        valueSliderPaint.setShader(sweepGradient);

        canvas.drawPath(valueSliderPath, valueSliderPaint);

        /**
         * drawing color wheel pointer
         */

        float hueAngle = (float) Math.toRadians(colorHSV[0]);
        int colorPointX = (int) (-Math.cos(hueAngle) * colorHSV[1] * colorWheelRadius) + centerX;
        int colorPointY = (int) (-Math.sin(hueAngle) * colorHSV[1] * colorWheelRadius) + centerY;

        float pointerRadius = 0.0075f * colorWheelRadius;
        int pointerX = (int) (colorPointX - pointerRadius / 2);
        int pointerY = (int) (colorPointY - pointerRadius / 2);

        colorPointerCoords.set(pointerX, pointerY, pointerX + pointerRadius, pointerY + pointerRadius);
        canvas.drawOval(colorPointerCoords, colorPointerPaint);

        /**
         * drawing value pointer
         */

        valuePointerPaint.setColor(Color.HSVToColor(new float[] {0f, 0f, 1f - colorHSV[2]}));

        double valueAngle = (colorHSV[2] - 0.5f) * Math.PI;
        float valueAngleX = (float) Math.cos(valueAngle);
        float valueAngleY = (float) Math.sin(valueAngle);

        canvas.drawLine(valueAngleX * innerWheelRadius + centerX, valueAngleY * innerWheelRadius + centerY,
                valueAngleX * outerWheelRadius + centerX, valueAngleY * outerWheelRadius + centerY, valuePointerPaint);

        /**
         * drawing pointer arrow
         */

        if(arrowPointerSize > 0){

            drawPointerArrow(canvas);
        }
    }

    private void drawPointerArrow(Canvas canvas){

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        double tipAngle = (colorHSV[2] - 0.5f) * Math.PI;
        double leftAngle = tipAngle + Math.PI / 96;
        double rightAngle = tipAngle - Math.PI / 96;

        double tipAngleX = Math.cos(tipAngle) * outerWheelRadius;
        double tipAngleY = Math.sin(tipAngle) * outerWheelRadius;
        double leftAngleX = Math.cos(leftAngle) * (outerWheelRadius + arrowPointerSize);
        double leftAngleY = Math.sin(leftAngle) * (outerWheelRadius + arrowPointerSize);
        double rightAngleX = Math.cos(rightAngle) * (outerWheelRadius + arrowPointerSize);
        double rightAngleY = Math.sin(rightAngle) * (outerWheelRadius + arrowPointerSize);

        arrowPointerPath.reset();
        arrowPointerPath.moveTo((float) tipAngleX + centerX, (float) tipAngleY + centerY);
        arrowPointerPath.lineTo((float) leftAngleX + centerX, (float) leftAngleY + centerY);
        arrowPointerPath.lineTo((float) rightAngleX + centerX, (float) rightAngleY + centerY);
        arrowPointerPath.lineTo((float) tipAngleX + centerX, (float) tipAngleY + centerY);

        valuePointerArrowPaint.setColor(Color.HSVToColor(colorHSV));
        valuePointerArrowPaint.setStyle(Style.FILL);
        canvas.drawPath(arrowPointerPath, valuePointerArrowPaint);

        valuePointerArrowPaint.setStyle(Style.STROKE);
        valuePointerArrowPaint.setStrokeJoin(Join.ROUND);
        valuePointerArrowPaint.setColor(Color.BLACK);
        canvas.drawPath(arrowPointerPath, valuePointerArrowPaint);
    }

    @Override
    protected  void onSizeChanged(int width, int height, int oldw, int oldh){

        int centerX = width / 2;
        int centerY = height / 2;

        innerPadding = (int) (paramInnerPadding * width / 100);
        outerPadding = (int) (paramOuterPadding * width / 100);
        arrowPointerSize = (int) (paramArrowPointerSize * width / 100);
        valueSliderWidth = (int) (paramValuesSliderWidth * width / 100);

        outerWheelRadius = width / 2 - outerPadding - arrowPointerSize;
        innerWheelRadius = outerWheelRadius - valueSliderWidth;
        colorWheelRadius = innerWheelRadius - innerPadding;

        outerWheelRect.set(centerX - outerWheelRadius, centerY - outerWheelRadius, centerX + outerWheelRadius, centerY + outerWheelRadius);
        innerWheelRect.set(centerX - innerWheelRadius, centerY - innerWheelRadius, centerX + innerWheelRadius, centerY + innerWheelRadius);

        colorWheelBitmap = createColorWheelBitmap(colorWheelRadius * 2, colorWheelRadius * 2);

        gradientRotationMatrix = new Matrix();
        gradientRotationMatrix.preRotate(270, width / 2, height / 2);

        colorViewPath.arcTo(outerWheelRect, 270, -180);
        colorViewPath.arcTo(innerWheelRect, 90, 180);

        valueSliderPath.arcTo(outerWheelRect, 270, 180);
        valueSliderPath.arcTo(innerWheelRect, 90, -180);

    }

    private Bitmap createColorWheelBitmap(int width, int height){

        Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888); //this configuration may need to be changed to just RGB so use RGB_565 config maybe?
        int colorCount = 12;
        int colorAngleStep = 360 / 12;
        int colors[] = new int[colorCount + 1];
        float hsv[] = new float[] {0f, 1f, 1f};
        for(int i = 0; i < colors.length; i++){

            hsv[0] = (i * colorAngleStep + 180) % 360;
            colors[i] = Color.HSVToColor(hsv);
        }
        colors[colorCount] = colors[0];

        SweepGradient sweepGradient = new SweepGradient(width / 2, height / 2, colors, null);
        RadialGradient radialGradient = new RadialGradient(width / 2, height / 2, colorWheelRadius, 0xFFFFFFFF, 0x00FFFFFF, TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(sweepGradient, radialGradient, PorterDuff.Mode.SRC_OVER);

        colorWheelPaint.setShader(composeShader);

        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(width / 2, height / 2, colorWheelRadius, colorWheelPaint);

        return bitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = event.getAction();
        switch (action){

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:

                int x = (int) event.getX();
                int y = (int) event.getY();
                int cx = x - getWidth() / 2;
                int cy = y - getHeight() / 2;
                double d = Math.sqrt(cx * cx + cy * cy);

               if(d <= colorWheelRadius){

                   colorHSV[0] = (float) (Math.toDegrees(Math.atan2(cy, cx)) + 180f);
                   colorHSV[1] = Math.max(0f, Math.min(1f, (float) (d / colorWheelRadius)));

                   invalidate();

               } else if(x >= getWidth() / 2 && d >= innerWheelRadius){

                   colorHSV[2] = (float) Math.max(0, Math.min(1, Math.atan2(cy, cx) / Math.PI + 0.5f));

                   invalidate();
               }

               return true;
        }

        return super.onTouchEvent(event);

    }

    public void setColor(int color){

        Color.colorToHSV(color, colorHSV);
    }

    @TargetApi(19)
    public int getColor(){

        int red = red(Color.HSVToColor(colorHSV));
        int blue = blue(Color.HSVToColor(colorHSV));
        int green = green(Color.HSVToColor(colorHSV));

        return Color.HSVToColor(colorHSV);
    }

    @Override
    protected Parcelable onSaveInstanceState(){

        Bundle state = new Bundle();
        state.putFloatArray("color", colorHSV);
        state.putParcelable("super", super.onSaveInstanceState());
        return state;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state){

        if(state instanceof Bundle){

            Bundle bundle = (Bundle) state;
            colorHSV = bundle.getFloatArray("color");
            super.onRestoreInstanceState(bundle.getParcelable("super"));
        } else {

            super.onRestoreInstanceState(state);
        }
    }
}









