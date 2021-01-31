package com.example.beginners_project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    public static final String TAG="MainActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private int mRes;

    public int getRes() {
        return mRes;
    }

    public void setRes(int res) {
       mRes = res;
    }

    private TextView mQuestionTextView;
    private  Questions[] mQuestionBank = new Questions[]
            {
                    new Questions(R.string.Question_BD,true),
                    new Questions(R.string.Question_In,false),
                    new Questions(R.string.Question_Pak,true),
                    new Questions(R.string.Question_Gre,true),
                    new Questions(R.string.Question_Iraq,true)

            };



    private int mCurrentIndex = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"oncreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
        mQuestionTextView=(TextView) findViewById(R.id.now_show);
        updateQuestion();





//jodi true button press kora hoy

        mTrueButton=(Button)
                findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionBank[mCurrentIndex].isDone()==false)
                {
                    mQuestionBank[mCurrentIndex].setDone(true);
                    checkAnswer(true); // i selected "true"
                }

                else
                {
                    Toast.makeText(MainActivity.this, R.string.dont, Toast.LENGTH_SHORT).show();
                }




            }
        });


//jodi false button press kora hoy

        mFalseButton=(Button)
                findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionBank[mCurrentIndex].isDone()==false)
                {
                    mQuestionBank[mCurrentIndex].setDone(true);
                    checkAnswer(false); // i selected "true"
                }

                else
                {
                    Toast.makeText(MainActivity.this, R.string.dont, Toast.LENGTH_SHORT).show();
                }
            }

        });



        //jodi next button press kora hoy

        mNextButton=(Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        }
        );

        mPrevButton=(Button)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               if(mCurrentIndex==0)
                                               {
                                                   mCurrentIndex=mQuestionBank.length-1;
                                                   updateQuestion();
                                               }
                                               else
                                               {
                                                   mCurrentIndex=(mCurrentIndex-1)%mQuestionBank.length;
                                                   updateQuestion();
                                               }

                                           }
                                       }
        );

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG,"onStart() Called");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume() Called");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"onPause() called");

    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override

    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

    private void updateQuestion()
    {
        int question= mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue)
    {
        boolean answerIsTrue= mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId =0;
        if(userPressedTrue==answerIsTrue)
        {
            setRes(mRes+1);
            messageResId=R.string.correct_toast;
        }

        else
            messageResId=R.string.incorrect_toast;

        Toast t=Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT);t.setGravity(Gravity .TOP|Gravity.TOP,0,320);
        t.show();
    }

    //Log level d








}