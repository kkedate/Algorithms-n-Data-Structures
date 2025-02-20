package lab2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] array = new int[2];
            if(list.get(list.size()-1)[1] >= intervals[i][0]){
                array[0] = Math.min(list.get(list.size()-1)[0],intervals[i][0]);
                array[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
                list.set(list.size()-1,array);
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество интервалов: ");
        int num = scanner.nextInt();
        int[][] intervals = new int[num][2];
        System.out.print("Введите интервалы: ");
        for (int i = 0; i < num; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        mergeIntervals mergeIntervals = new mergeIntervals();
        int[][] mergedIntervals = mergeIntervals.merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
        scanner.close();
    }
}
