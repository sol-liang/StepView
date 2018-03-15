package module.step.com.stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  private StepView stepView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    stepView= (StepView) findViewById(R.id.stepView);
  }

  public void setStep1(View view) {
    stepView.setStep(1);
  }
  public void setStep2(View view) {
    stepView.setStep(2);
  }
  public void setStep3(View view) {
    stepView.setStep(3);
  }
  public void setStep4(View view) {
    stepView.setStep(4);
  }
  public void setStep5(View view) {
    stepView.setStep(5);
  }

}
