import java.util.Arrays;

public class SortingAlgorithm {

    // 交换函数
    protected void swap(int[] array,int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    // 冒泡排序, 时间复杂度O(n^2),空间复杂度O(1)，稳定
    public int[] bubbleSort(int[] originData){
        if (originData.length==0)
            return originData;
        for (int i =0;i<originData.length-1;i++){
            for (int j=0;j<originData.length-i-1;j++){
                if (originData[j]>originData[j+1]){
                    swap(originData, j, j+1);
                }
            }
        }
        return originData;
    }

    // 选择排序，时间复杂度O(n^2),空间复杂度O(1)，不稳定
    public int[] selectionSort(int[] originData){
        if (originData.length==0)
            return originData;
        for (int i=0;i<originData.length-1;i++){
            int minIndex = i;
            for (int j=i;j<originData.length;j++){
                if (originData[j]<originData[minIndex])
                    minIndex = j;
            }
            swap(originData,i,minIndex);
        }
        return originData;
    }

    // 插入排序, 时间复杂度O(n^2),空间复杂度O(1)，稳定
    public int[] insertionSort(int[] originData){
        if (originData.length==0)
            return originData;
        for (int i=0;i<originData.length-1;i++){
            int cur = originData[i+1];
            int curIndex = i;
            while (curIndex>=0 && cur<originData[curIndex]){
                originData[curIndex+1] = originData[curIndex];
                curIndex--;
            }
            originData[curIndex+1] = cur;
        }
        return originData;
    }

    // 希尔排序, 时间复杂度O(nlogn),空间复杂度O(1)，不稳定
    public int[] shellSort(int[] originData){
        if (originData.length==0)
            return originData;
        int gap = originData.length/2;
        while (gap>0){
            for (int i=gap;i<originData.length;i++){
                int temp = originData[i];
                int preIndex = i - gap;
                while (preIndex>=0 && originData[preIndex] > temp){
                    originData[preIndex+gap] = originData[preIndex];
                    preIndex -= gap;
                }
                originData[preIndex+gap] = temp;
            }
            gap /=2;
        }
        return originData;
    }

    // 归并排序,时间复杂度O(nlogn),空间复杂度O(nlogn
    public int[] mergeSort(int[] originData){
        if (originData.length<2)
            return originData;
        int mid = originData.length/2;
        int[] left = Arrays.copyOfRange(originData,0,mid);
        int[] right = Arrays.copyOfRange(originData,mid,originData.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        int index = 0, i = 0, j = 0;
        while(i<left.length || j<right.length){
            if (i==left.length )
                res[index++] = right[j++];
            else if(j==right.length)
                res[index++] = left[i++];
            else if (left[i]<=right[j])
                res[index++] = left[i++];
            else if(left[i]>=right[j] )
                res[index++] = right[j++];
        }
        return res;
    }

    // 快速排序,时间复杂度O(nlogn),空间复杂度O(nlogn)，不稳定
    public int[] quickSort(int[] originData,int start, int end){
        if (originData.length==0)
            return originData;
        int midIndex = partition(originData,start,end);
        if (midIndex > start)
            quickSort(originData, start, midIndex-1);
        if (midIndex < end)
            quickSort(originData, midIndex+1, end);
        return originData;
    }

    public int partition(int[] originData, int start, int end){
        int mid  = (start + end) / 2;
        swap(originData, mid, end);
        int flag = start - 1;
        for (int i=start;i<=end;i++){
            if (originData[i] <= originData[end]){
                flag++;
                if (flag < i)
                    swap(originData, flag, i);
            }
        }
        return flag;
    }

    // 堆排序
    public int[] heapSort(int[] originData){
        if (originData.length==0)
            return originData;
        buildMaxHeap(originData,originData.length);
        for (int i=originData.length;i>0;i--){
            swap(originData,0,i-1);
            buildMaxHeap(originData,i-1);
        }
        return originData;
    }

    public void buildMaxHeap(int[] originData, int heapSize){
        for (int i=(originData.length/2)-1;i>=0;i--)
            maxHeapify(originData,i,heapSize);
    }

    public void maxHeapify(int[] originData, int i, int heapSize){
        int left = 2*i+1, right = 2*i;
        int largest = i;
        if (left<heapSize && originData[left]>originData[i])
            largest = left;
        if (right<heapSize && originData[right]>originData[i])
            largest = right;
        if (largest!=i){
            swap(originData,largest,i);
            maxHeapify(originData,largest,heapSize);
        }
    }
}
