package com.example.beginners_project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cheat extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE="com.beginners.quiz.asnwer_is_true";
    private static final String EXTRA_ANSWER_IS_SHOWN="com.beginners.quiz.asnwer_is_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextview;
    private Button mShowAnswerButton;
    @org.jetbrains.annotations.NotNull
    public static Intent newIntent(Context packageContext, boolean answerIsTrue)
    {
        Intent intent= new Intent (packageContext,Cheat.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }

    public static boolean wasAnswerShown(Intent result)
    {
        return  result.getBooleanExtra(EXTRA_ANSWER_IS_SHOWN,false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue= getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerTextview=(TextView)findViewById(R.id.answer_text_view);
        mShowAnswerButton=(Button)findViewById(R.id.show_answer_button);


        //show answer button wiring

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button er kaj

                if(mAnswerIsTrue)
                {
                    mAnswerTextview.setText(R.string.true_button);
                }

                else
                    mAnswerTextview.setText(R.string.false_button);

                setAnswerShownResult(true);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data= new Intent();
        data.putExtra(EXTRA_ANSWER_IS_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }


}