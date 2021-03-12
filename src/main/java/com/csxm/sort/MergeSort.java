package com.csxm.sort;

/**
 * @description: 归并排序
 * @author: liutaiyue
 * @time: 2021/3/11 17:38
 * @Version 1.0
 */
public class MergeSort {

    public static void sort(int[] a){
        mergeSort(a,0,a.length-1);
    }

    private static void mergeSort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] ints = {3,2,6,1,32,7,8,9};
        sort(ints);
        for (int i:ints) {
            System.out.println(i);
        }

    }
}
