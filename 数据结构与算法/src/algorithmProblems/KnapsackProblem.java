package algorithmProblems;

import java.util.LinkedList;
import java.lang.Math;


public class KnapsackProblem {
    LinkedList<Item> items = new LinkedList<>();
    int capacity;
    int numItems;
    int[][] res = new int[numItems+1][capacity+1];

    public KnapsackProblem(LinkedList<Item> items, int numItems, int capacity){
        this.items = items;
        this.numItems = numItems;
        this.capacity = capacity;
    }

    public int getResult(){
        for (int i=0;i<numItems+1;i++)
            res[i][0] = 0;

        for (int j=1;j<capacity+1;j++){
            for (int i=2;i<numItems+1;i++){

                if ( (j-items.get(i-1).getWeight())>=0)
                    res[i][j] = Math.max(res[i-1][j],res[i-1][j-items.get(i).getWeight()]+items.get(i).getValue());
                else
                    res[i][j] = 0;

            }
        }
        return res[numItems][capacity];

    }
}