package org.example;

public class Main {
    public static void main(String[] args) {
        Get_array();
        Get_array_thead();
    }
    public static void Get_array(){
        final int size = 10000000;
        final int half = size /2;
        float [] arr = new float [size];
        for (int i=0; i<arr.length; i++)
        {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i=0; i< size; i++)
        {
            arr [i ]=(float )(arr [i ]*Math . sin (0.2f+i /5f)*Math . cos (0.2f+i  /5f)*Math . cos (0.4f+i  /2f));
        }
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
        System.out.println(System.currentTimeMillis() - a);
    }
    public static void Get_array_thead(){
        final int size = 10000000;
        final int half = size /2;
        float [] arr = new float [size];
        for (int i=0; i<arr.length; i++)
        {
            arr[i]=1;
        }
        float [] a1= new float[half];
        float [] a2= new float[half];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);
        Test t1 = new Test( a1);
        Test t2 = new Test( a2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a1 = t1.getArr();
        a2 = t2.getArr();

        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, half);

        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
        System.out.println(System.currentTimeMillis() - a);
    }

}