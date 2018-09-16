package com.example.sandeepkumarsingh.rxandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    private Observable<String> mObservable;
    private Observer<String> mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txt);

        mObservable = Observable.just("Hello from Rx Androids....");

        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                txt.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    public void subscribeNow(View view) {
        mObservable.subscribe(mObserver);
    }
    //https://blog.mindorks.com/rxjava-fast-android-networking-6e3d90ee4387
}
