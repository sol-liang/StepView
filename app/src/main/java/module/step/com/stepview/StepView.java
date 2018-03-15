package module.step.com.stepview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author liangxingguo (xingguo.liang@msxf.com).
 */

public class StepView extends View {
  private float viewWidth;
  private Context context;
  private int count;
  private int signCount;
  private float perWidth;
  private float marginLeft;
  private Paint paint;
  private Paint textPaint;
  private Paint signPaint;
  private Rect textBound;
  private float radius;
  private boolean isLast;
  private int step;
  private float textSize;
  private int textColor;
  private int circleColor;
  private int grayColor;

  public StepView(Context context) {
    this(context, null);
  }

  public StepView(Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public StepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlidingTabs);
    count = typedArray.getInteger(R.styleable.SlidingTabs_count, 3);
    signCount = typedArray.getInteger(R.styleable.SlidingTabs_signCount, count + 2);
    marginLeft = typedArray.getDimension(R.styleable.SlidingTabs_marginLeft, 10);
    textSize = typedArray.getDimension(R.styleable.SlidingTabs_textSize, 30);
    textColor = typedArray.getColor(R.styleable.SlidingTabs_textColor,
        ContextCompat.getColor(context, R.color.white));
    circleColor = typedArray.getColor(R.styleable.SlidingTabs_circleColor,
        ContextCompat.getColor(context, R.color.blue));
    grayColor = ContextCompat.getColor(context, R.color.gray);
    radius = typedArray.getDimension(R.styleable.SlidingTabs_circleRadius, 30);
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setColor(circleColor);
    textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    signPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    textPaint.setTextSize(textSize);
    textPaint.setColor(textColor);
    textBound = new Rect();
    step = 1;
    typedArray.recycle();
  }

  public void setStep(int step) {
    this.step = step;
    invalidate();
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    float widthMode = MeasureSpec.getMode(widthMeasureSpec);
    float heightMode = MeasureSpec.getMode(heightMeasureSpec);
    float viewHeight = MeasureSpec.getSize(heightMeasureSpec);
    viewWidth = MeasureSpec.getSize(widthMeasureSpec);
    perWidth = (viewWidth - marginLeft * 2 - radius * 2) / (count - 1);

    if (heightMode == MeasureSpec.AT_MOST) {
      viewHeight = radius * 2 + 20;
    }

    setMeasuredDimension((int) viewWidth, (int) viewHeight);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    for (int i = 0; i < count; i++) {
      String text = i + 1 + "";
      textPaint.getTextBounds(text, 0, text.length(), textBound);
      float circleX = 0, circleY = getHeight() / 2;
      float textX = 0, textY = circleY + textBound.height() / 2;
      if (i == 0) {
        circleX = marginLeft + radius;
        isLast = false;
      } else if (i == count - 1) {
        circleX = viewWidth - marginLeft - radius;
        isLast = true;
      } else {
        circleX = (marginLeft + radius) + perWidth * i;
        isLast = false;
      }
      if (i < step) {
        paint.setColor(circleColor);
      } else {
        paint.setColor(grayColor);
      }
      textX = circleX - textBound.width() / 2;
      canvas.drawCircle(circleX, circleY, radius, paint);
      canvas.drawText(text, textX, textY, textPaint);

      for (int j = 1; j < signCount && !isLast; j++) {
        float signMargin = (perWidth - radius * 2) / 8;
        float perSighwidth = (perWidth - radius * 2) * 3 / (4 * signCount);
        canvas.drawCircle((circleX + radius) + signMargin + perSighwidth * j, circleY, 3, paint);
      }
    }
  }

  @Override protected Parcelable onSaveInstanceState() {
    Parcelable parcelable = super.onSaveInstanceState();
    SavedState state = new SavedState(parcelable);
    state.currentStep = step;
    return state;
  }

  @Override protected void onRestoreInstanceState(Parcelable state) {
    SavedState savedState = (SavedState) state;
    super.onRestoreInstanceState(savedState.getSuperState());
    step = savedState.currentStep;
  }

  /** saved state */
  static class SavedState extends BaseSavedState {
    public static final Creator<SavedState> CREATOR =
        new Creator<SavedState>() {
          @Override public SavedState createFromParcel(Parcel in) {
            return new SavedState(in);
          }

          @Override public SavedState[] newArray(int size) {
            return new SavedState[size];
          }
        };
    int currentStep;

    public SavedState(Parcelable superState) {
      super(superState);
    }

    private SavedState(Parcel in) {
      super(in);
      currentStep = in.readInt();
    }

    @Override public void writeToParcel(@NonNull Parcel dest, int flags) {
      super.writeToParcel(dest, flags);
      dest.writeInt(currentStep);
    }
  }
}
