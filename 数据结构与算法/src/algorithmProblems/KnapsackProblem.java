package algorithmProblems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.lang.Math;


public class KnapsackProblem {
    LinkedList<Item> items = new LinkedList<>();
    int capacity;
    int numItems;
    int[] x;
    int[][] res;

    public KnapsackProblem(LinkedList<Item> items, int numItems, int capacity){
        this.items = items;
        this.numItems = numItems;
        this.capacity = capacity;
        this.res = new int[numItems+1][capacity+1];
        for (int i=0;i<numItems+1;i++)
            Arrays.fill(res[i],-1);
        this.x = new int[numItems+1];
        Arrays.fill(x,-1);
    }

    public void getx(int i,int j){
        if (i<1)
            return;
        if (res[i-1][j] < (res[i-1][j-items.get(i-1).getWeight()]+items.get(i-1).getValue())) {
            x[i] = 1;
            getx(i-1,j-items.get(i-1).getWeight());
        }else{
            x[i] = 0;
            getx(i-1,j);
        }
    }

    public void getDecison(){
        getx(numItems,capacity);
        for (int i=1;i<x.length;i++)
            System.out.println(x[i]);
    }

    public int getResult(int i, int j){
        if (i*j==0) {
            res[i][j] = 0;
            return 0;
        }
        int a = getResult(i-1,j);
        int b = 0;
        if ( (j-items.get(i-1).getWeight())>=0)
            b = getResult(i-1,j-items.get(i-1).getWeight())+items.get(i-1).getValue();
        if (a<b){
            res[i][j] = b;
            return b;
        }
        res[i][j] = a;
        return a;

    }

    public int getResult(){
        for (int i=0;i<numItems+1;i++)
            res[i][0] = 0;
        for (int j=0;j<capacity+1;j++)
            res[0][j] = 0;

        for (int j=1;j<capacity+1;j++){
            for (int i=1;i<numItems+1;i++){

                if ( (j-items.get(i-1).getWeight())>=0)
                    res[i][j] = Math.max(res[i-1][j],res[i-1][j-items.get(i-1).getWeight()]+items.get(i-1).getValue());
                else
                    res[i][j] = res[i-1][j];
                System.out.println(i+" "+j+":"+res[i][j]);
            }
        }
        return res[numItems][capacity];

    }
}