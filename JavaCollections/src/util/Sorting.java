package util;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] nums = {1,5,3,8,10,-2,0};
        String[] names = {"Adam","Joe","Ana","Kevin","Steven"};
        //Java uses quick sort -> primitives, merge sort -> references
        Arrays.sort(nums);
        for(int i: nums){
            System.out.println(i);
        }
        Arrays.sort(names);
        for (String s: names){
            System.out.print(s + " - ");
        }
    }
}
