package kz.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int SIZE = 10000000;
    public static final int H = SIZE / 2;
    private static final int THREAD_LIMIT = 2;
    private static final float[] arr = new float[SIZE];
    public static float[] arr2 = new float[SIZE];
    private static final List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        initArray();

        initArrayByThreads();
        System.out.println(Arrays.equals(arr, arr2));
    }

    public static void initArray() {
        long startTime = System.currentTimeMillis();
//        initWithOnes();
        initByFormula();
        long endTime = System.currentTimeMillis();
        printTimeResult(startTime, endTime);
    }

    public static void initArrayByThreads() {
        long startTime = System.currentTimeMillis();
        try {
            for (int i = 0, startIndex = 0; i < THREAD_LIMIT; i++, startIndex +=H) {
                startThread(startIndex);
            }

            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        printTimeResult(startTime, endTime);
    }

    public static void startThread(int startIndex) {
        SimpleThread th = new SimpleThread(new float[H], startIndex);
        Thread thread = new Thread(th);
        threads.add(thread);
        thread.start();
    }

    private static void initWithOnes() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    private static void initByFormula() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void printTimeResult(final long startTime, final long endTime) {
        long millis = endTime - startTime;
        String res = String.format("%d sec, %d ms",
                TimeUnit.MILLISECONDS.toSeconds(millis),
                TimeUnit.MILLISECONDS.toMillis(millis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))
        );
        System.out.println("Time: " + res);
    }
}
