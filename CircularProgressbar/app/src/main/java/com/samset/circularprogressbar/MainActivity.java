/*
 * Copyright (C) 2016 Sanjay singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samset.circularprogressbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.samset.circularprogressbar.custom_views.circularprogressbar.CircularProgressBar;

public class MainActivity extends AppCompatActivity {
    private CircularProgressBar c1;
    private CircularProgressBar c2;
    private CircularProgressBar c3;
    private CircularProgressBar c4;
    private CircularProgressBar c5;
    private CircularProgressBar c6;

    private TextView tv_result;
    private MyCountDownTimer countDownTimer;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result= (TextView) findViewById(R.id.txtresult);
        c1();
        c2();
        c3();
        c4();
        c5();
        c6();

        countDownTimer = new MyCountDownTimer(10000, 100);
        countDownTimer.start();

    }

    private void c1() {
        c1 = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
        c1.setProgress(45);

    }

    private void c2() {
        c2 = (CircularProgressBar) findViewById(R.id.circularprogressbar2);
        c2.animateProgressTo(0, 77, new CircularProgressBar.ProgressAnimationListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationFinish() {
                c2.setSubTitle("done");
            }

            @Override
            public void onAnimationProgress(int progress) {
                c2.setTitle(progress + "%");
            }
        });

    }

    private void c3() {
        c3 = (CircularProgressBar) findViewById(R.id.circularprogressbar3);
        c3.setTitle("Sam");
        c3.setSubTitle("set");
        c2.setProgress(34);
    }

    private void c4() {
        c4 = (CircularProgressBar) findViewById(R.id.circularprogressbar4);
        c4.setProgress(58);
    }

    private void c5() {
        c5 = (CircularProgressBar) findViewById(R.id.circularprogressbar5);
        c4.setProgress(15);
    }

    private void c6() {
        c6 = (CircularProgressBar) findViewById(R.id.circularprogressbar6);
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {


            progress = (int) (millisUntilFinished / 100);
            //You can change progressbar background color and front color
            c6.setProgressbarBackgroundColor(getResources().getColor(R.color.pb_background));
            c6.setProgressbarColor(getResources().getColor(R.color.colorAccent));

            c6.setProgress(progress);
            tv_result.setText("" + progress);
        }

        @Override
        public void onFinish() {
            //onfinish you write your code
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }
}
