import java.util.*;
import algorithmProblems.KnapsackProblem;
import algorithmProblems.Item;
import algorithmProblems.TSP;

public class Main {
    public static void main(String[] args) {
        // TSP 问题
        int[][] distance = {{10000,10,15,10000},{10,10000,35,25},{15,35,10000,30},{10000,25,30,10000}};
        TSP tsp = new TSP();
        int[][] a = tsp.slove(distance);
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.printf("%-5d    ",a[i][j]);
            System.out.println();
        }


// 背包问题
/*        LinkedList<Item> items = new LinkedList<>();
        int[] weights = {4,5,6,2,2};
        int[] values = {6,4,5,3,6};
        for (int i=0;i<5;i++){
            items.add( new Item(weights[i], values[i]) );
        }

        KnapsackProblem kp = new KnapsackProblem(items,5,10);
        int res = kp.getResult(5,10);
        System.out.println(res);
        kp.getDecison();*/


//        int[] originData = {8,9,1,7,2,3,5,4,6,0};
//        SortingAlgorithm sa = new SortingAlgorithm();
//        int[] res = sa.heapSort(originData);
//        StringBuffer sb = int2String(res);
//        System.out.println(sb);

    }

    // 数组转化为输出格式的字符串
    public static StringBuffer int2String(int[] data){
        StringBuffer sb = new StringBuffer();
        for(int i: data){
            sb.append(i).append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb;
    }



}

