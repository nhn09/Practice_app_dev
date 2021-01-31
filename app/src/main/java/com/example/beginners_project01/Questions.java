package com.example.beginners_project01;

public class Questions {
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mDone;



    public Questions(int textResId, boolean answerTrue)
    {
        mTextResId=textResId;
        mAnswerTrue=answerTrue;
        mDone=false;
    }

    public boolean isDone() {
        return mDone;
    }

    public void setDone(boolean done) {
        mDone = done;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
