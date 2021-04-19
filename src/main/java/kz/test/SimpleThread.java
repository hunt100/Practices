package kz.test;

public class SimpleThread implements Runnable {

    private final float[] arr;
    private final int startIndex;

    public SimpleThread(float[] arr, int startIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
    }

    public float[] getArr() {
        return arr;
    }

    @Override
    public void run() {
        for (int i = 0; i <  arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + startIndex) / 5) * Math.cos(0.2f + (i + startIndex) / 5) * Math.cos(0.4f + (i + startIndex) / 2));
        }

        System.arraycopy(getArr(), 0, Main.arr2, startIndex, Main.H);
    }
}
