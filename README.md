
StepView
==========

### The renderings are shown below
![image](https://github.com/liangxingguo/StepView/blob/master/SAVE_20180315_173847.gif)


[中文版在这里](https://github.com/zhangxuyang321/StepView/blob/master/StepView.md)


When the steps are small, you can use the custom attribute marginLeft if you want to turn
the view to the left of the two sides, and see the code below

#### It is easy to use and can be used directly, as follows:
<module.step.com.stepview.StepView
    android:id="@+id/stepView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    app:circleColor="@color/blue"
    app:circleRadius="16dip"
    app:count="5"
    app:marginLeft="10dip"
    app:signCount="7"
    app:textColor="@color/white"
    app:textSize="14sp"
    />

    CircleColor is big circles and the color of the dots, show bright color is, of course,
    don't light up when the default gray, circleRadius is the radius of the big circle, the
    count is the number of steps, marginLeft is the View on both sides of the distance,
    signCount number is smaller between the two circles, textColor and textSize is inside
    the circle Numbers of size and color

##### When you want to update the steps in the interface, you can directly setStep, just like this

    private StepView stepView=(StepView) findViewById(R.id.stepView)；
    stepView.setStep(count);