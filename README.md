
StepView
==========

### The renderings are shown below
![image](https://github.com/sol-liang/StepView/blob/master/20180316_111517.gif)


[中文版在这里](https://github.com/sol-liang/StepView/blob/master/stepView.md)


When the steps are small, you can use the custom attribute marginLeft if you want to turn
the view to the left of the two sides, and see the code below

#### It is easy to use and can be used directly, as follows:
<module.step.com.stepview.StepView<br>
    android:id="@+id/stepView"<br> 
    android:layout_width="wrap_content" <br>
    android:layout_height="wrap_content"<br>
    android:layout_marginTop="10dp"<br>
    app:circleColor="@color/blue"<br>  
    app:circleRadius="16dip"<br> 
    app:count="5"<br>
    app:marginLeft="10dip"<br>
    app:signCount="7"<br>
    app:textColor="@color/white"<br>
    app:textSize="14sp"<br>
    />

    CircleColor is big circles and the color of the dots, show bright color is, of course,
    don't light up when the default gray, circleRadius is the radius of the big circle, the
    count is the number of steps, marginLeft is the View on both sides of the distance,
    signCount number is smaller between the two circles, textColor and textSize is inside
    the circle Numbers of size and color

##### When you want to update the steps in the interface, you can directly setStep, just like this

    private StepView stepView=(StepView) findViewById(R.id.stepView)；
    stepView.setStep(count);
