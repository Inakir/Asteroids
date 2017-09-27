package asteroids;

import java.io.*;

public class MergeSort 
{

    private int[] arr; //stores array of elements
    private int[] temp; //used for temporarily storing elements
    private int num; //number of elements

    public MergeSort(int[] array, int length)
    {
        arr = array;
        num = length;
        temp = new int[length];
    }

    public int[] getArray() 
    {
        mergeSort(0, num - 1);
        return arr;
    }

    public void mergeSort(int low, int high) 
    {
        if (low < high) 
        {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public void merge(int low, int mid, int high) 
    {
        for (int i = low; i <= high; i++) 
        {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        
        while (i <= mid && j <= high) 
        {
            if (temp[i] >= temp[j]) 
            {
                arr[k++] = temp[i];
                i++;
            } else {
                arr[k++] = temp[j];
                j++;
            }
        }
        
        while (i <= mid) 
        {
            arr[k++] = temp[i++];
        }
    }
}