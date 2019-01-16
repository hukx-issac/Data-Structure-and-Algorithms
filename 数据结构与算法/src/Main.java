import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] originData = {8,9,1,7,2,3,5,4,6,0};
        SortingAlgorithm sa = new SortingAlgorithm();
        int[] res = sa.heapSort(originData);
        StringBuffer sb = int2String(res);
        System.out.println(sb);

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

