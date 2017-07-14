package com.ocean.quiz;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvTimer;
    private TextView tvQuestion;
    private Button btNext,btPrevious;
    private RadioGroup radioGroup;
    private RadioButton rbOptA,rbOptB,rbOptC;
    RadioButton selectChoice;
    String getChoice;

    public static String mQuestion[] = {"1) How to kill an activity in Android ?",
            "2) What is splash screen in android ?","3) How many threads are there in asyncTask in android ?",
            "4) What is the time limit of broadcast receiver in android ?","5) How to get current location in android ?"};

    public String mCorrectAnswer[] = {"A & B","Initial method of an application","Only one","10 Sec","A & B"};

    public String mChoice[] = {"finish()","finishActivity(int requestCode)","A & B",
            "Initial activity of an application","Initial service of an application","Initial method of an application",
            "Two","Only one","AsyncTask doesn't have tread",
            "10 Sec","15 Sec","5 Sec","Using with GPRS","Using location provider","A & B"};

    public int position = 0;
    public static int correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimer = (TextView)findViewById(R.id.textViewTimer);
        tvQuestion = (TextView)findViewById(R.id.textViewQuestion);
        btNext = (Button)findViewById(R.id.buttonNextQue);
        btPrevious = (Button)findViewById(R.id.buttonPreviousQues);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rbOptA = (RadioButton)findViewById(R.id.radioButtonOptA);
        rbOptB = (RadioButton)findViewById(R.id.radioButtonOptB);
        rbOptC = (RadioButton)findViewById(R.id.radioButtonOptC);

        tvQuestion.setText(mQuestion[position]);
        //using three options in each question
        //so we multiple with 3
        rbOptA.setText(mChoice[position*3]);    //0
        rbOptB.setText(mChoice[position*3+1]);  //1
        rbOptC.setText(mChoice[position*3+2]);  //2


        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    selectChoice = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                    getChoice = selectChoice.getText().toString();
                    if (getChoice.equals(mCorrectAnswer[position])){
                        correct++;
                    }
                    position++;
                    if (position < mQuestion.length){
                        tvQuestion.setText(mQuestion[position]);    // position = 1, 2, 3,  4
                        //uncheckedRadioButton();
                        rbOptA.setText(mChoice[position*3]);       //3, 6,  9,  12
                        rbOptB.setText(mChoice[position*3+1]);     //4, 7,  10  13
                        rbOptC.setText(mChoice[position*3+2]);     //5, 8,  11  14
                        radioGroup.clearCheck();    // clear the selection
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this,Result.class);
                        startActivity(intent);
                    }
                }catch (Exception e){

                }

            }
        });

        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if ( position == 0){
//                    Snackbar snackbar = Snackbar
//                            .make(v, "You are already stayed in first question", Snackbar.LENGTH_LONG);
//                    snackbar.show();
//                }
                if (position > 0){
                    position--;
                    tvQuestion.setText(mQuestion[position]);
                    rbOptA.setText(mChoice[position*3]);    //0
                    rbOptB.setText(mChoice[position*3+1]);  //1
                    rbOptC.setText(mChoice[position*3+2]);
                    radioGroup.clearCheck();
                }

            }
        });



    }

    private void uncheckedRadioButton() {
        rbOptA.setChecked(false);
        rbOptB.setChecked(false);
        rbOptC.setChecked(false);
    }


}
