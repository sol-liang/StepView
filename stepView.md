
StepView
==========

### 效果图如下
![image](https://github.com/liangxingguo/StepView/blob/master/SAVE_20180315_173847.gif)

当步骤少的时候，如果想把view到两边的距离调大，可以使用自定义属性marginLeft，具体解析见下面代码

#### 使用很简单，直接用即可，如下：
<module.step.com.stepview.StepView<br>
android:id="@+id/stepView"<br>
android:layout_width="wrap_content"<br>
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

    其中，circleColor是大圆圈和小点的颜色，当然是指点亮的颜色，没点亮时默认灰色，circleRadius是大圆圈的半径，count
    是步骤数，marginLeft是View到两边的距离，signCount是两个圆圈之间小点的个数，textColor和textSize是圆圈里面数
    字的大小和颜色

##### 当你在界面想要灵活更新步骤时，可以直接setStep，就像下面这样

    private StepView stepView=(StepView) findViewById(R.id.stepView)；
    stepView.setStep(count);
