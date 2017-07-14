package com.ocean.quiz;

public class QuestionLibrary {
    String question;
    String choice0,choice1,choice2,answer;
    private String mQuestion[] = {"1) How to kill an activity in Android ?",
            "2) What is splash screen in android ?","3) How many threads are there in asyncTask in android ?",
            "4) What is the time limit of broadcast receiver in android ?","5) How to get current location in android ?"};

    private String mChoice[][] = {{"finish()","finishActivity(int requestCode)","A & B"},
            {"Initial activity of an application","Initial service of an application","Initial method of an application"},
            {"Two","Only one","AsyncTask doesn't have tread"},
            {"10 Sec","15 Sec","5 Sec"},{"Using with GPRS","Using location provider","A & B"}};

    private String mCorrectAnswer[] = {"A & B","Initial method of an application","Only one","10 Sec","A & B"};

    public String getQuestion(int a) {
        if (a < mQuestion.length){
            question = mQuestion[a];
        }
        return question;
    }

    public String getChoice1(int a){
        if (a < mChoice.length){
            choice0 = mChoice[a][0];
        }
        return choice0;
    }

    public String getChoice2(int a){
       if (a < mChoice.length){
           choice1 = mChoice[a][1];
       }
       return choice1;
    }

    public String getChoice3(int a){
        if (a < mChoice.length){
            choice2 = mChoice[a][2];
        }
        return choice2;
    }

    public String getCorrectAnswer(int a){  // a = 0, a = 1,
        if (a < mCorrectAnswer.length){
            answer = mCorrectAnswer[a];
        }
        return answer;
    }
}
