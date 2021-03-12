package com.csxm.sort;

/**
 * @description: 快速排序
 * @author: liutaiyue
 * @time: 2021/3/11 17:36
 * @Version 1.0
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        quickSortInternally(a, 0, a.length-1);
    }


    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        if(i < r){
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] ints = {3,2,6,1,32,7,8,9};
        quickSort(ints);
        for (int i:ints) {
            System.out.println(i);
        }

    }
}
