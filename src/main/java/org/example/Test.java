package org.example;

public class Test extends Thread{
    private static float[] arr;

    public Test (float[] arr ){
        this.arr=arr;

    }
    public static float[] getArr(){
        return arr;
    }
    @Override
    public void run(){
        for (int i=0; i<arr.length; i++)
        {
            arr [i ]=(float )(arr [i ]*Math . sin (0.2f+i /5f)*Math . cos (0.2f+i  /5f)*Math . cos (0.4f+i  /2f));

        }
    }

}
