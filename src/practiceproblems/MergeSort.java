/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproblems;

/**
 *
 * @author Gunnar
 */
public class MergeSort {
    int[] array, tempMergeArray;
    int length;
    
    public void sort(int[] list) {
        this.array = list;
        this.length = list.length;
        this.tempMergeArray = new int[this.length];
        mergeSort(0, this.length - 1);
        
    }
    
    public void mergeSort(int startIndex, int lastIndex) {
        int middle = 0;
        if (startIndex < lastIndex) {
            middle = startIndex + (lastIndex - startIndex)/2;
            mergeSort(startIndex, middle);
            mergeSort(middle + 1, lastIndex);
            mergeLists(startIndex, middle, lastIndex);
        }
    }
    
    public void mergeLists(int start, int middle, int last) {
        for (int i = start; i < last; i++) {
            this.tempMergeArray[i] = this.array[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= last) {
            if (this.tempMergeArray[i] <= this.tempMergeArray[j]) {
                this.array[k] = this.tempMergeArray[i];
                i++;
            }
            else {
                this.array[k] = this.tempMergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArray[i];
            k++;
            i++;
        }
        
    }
    
}
