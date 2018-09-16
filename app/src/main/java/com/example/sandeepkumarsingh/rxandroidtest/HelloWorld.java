package com.example.sandeepkumarsingh.rxandroidtest;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        // step1
        //Flowable.just("Hello world").subscribe(System.out::println);

        // step2
//        Flowable.just("Hello world")
//                .subscribe(new Consumer<String>() {
//                    @Override public void accept(String s) {
//                        System.out.println(s);
//                    }
//                });


        //step3
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish

        //step4
        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        });

        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());

        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());

        showForeground.subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000);
    }
}
