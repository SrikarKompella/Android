package com.srikar.history20;

/**
 * Created by prasadkompella on 05/04/17.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * This class extends the View class and is designed draw the heartbeat image.
 *
 *
 */
public class Heartbeatview extends View {

    private static final Matrix matrix = new Matrix();
    private static final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static Bitmap greenBitmap = null;
    private static Bitmap redBitmap = null;

    private static int parentWidth = 0;
    private static int parentHeight = 0;

    public Heartbeatview(Context context, AttributeSet attr) {
        super(context, attr);

        greenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green_icon);
        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);
    }

    public Heartbeatview(Context context) {
        super(context);

        greenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green_icon);
        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas == null) throw new NullPointerException();

        Bitmap bitmap = null;
        if (HeartBeat.getCurrent() == HeartBeat.TYPE.GREEN) bitmap = greenBitmap;
        else bitmap = redBitmap;

        int bitmapX = bitmap.getWidth() / 2;
        int bitmapY = bitmap.getHeight() / 2;

        int parentX = parentWidth / 2;
        int parentY = parentHeight / 2;

        int centerX = parentX - bitmapX;
        int centerY = parentY - bitmapY;

        matrix.reset();
        matrix.postTranslate(centerX, centerY);
        canvas.drawBitmap(bitmap, matrix, paint);
    }
}
