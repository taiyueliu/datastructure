package com.csxm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int[] ints = new int[200000];
        for (int i = 0;i<ints.length;i++){
            ints[i] = new Random().nextInt(20000);
        }


        long start = System.currentTimeMillis();
        Arrays.sort(ints);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


    public static void quickSort(int[] a){
        quickSortInternally(a,0,a.length-1);
    }

    public static void quickSortInternally(int[] a,int low,int high){
        if(low < high){
            int partition = partition(a, low, high);
            quickSortInternally(a,low,partition-1);
            quickSortInternally(a,partition+1,high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int point = a[high];
        int i = low;
        for(int j = i;j<high;j++){
            if(a[j] < point){
                if(i == j){
                    i++;
                }else{
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }

        if(i < high){
            int temp = a[i];
            a[i] = a[high];
            a[high] = temp;
        }

        return i;

    }

    public static void mergeSort(int[] a){
        mergeSort(a,0,a.length-1);
    }

    public static void mergeSort(int[] a,int low,int high){
        int mid = (high+low)/2;
        if(low < high){
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    public static void merge(int[] a,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }

        while (i <= mid){
            temp[k++] = a[i++];
        }

        while (j <= high){
            temp[k++] = a[j++];
        }

        for (int x=0;x<temp.length;x++){
            a[low+x] = temp[x];
        }
    }

}
