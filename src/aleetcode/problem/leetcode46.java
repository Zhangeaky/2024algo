package aleetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class leetcode46 {

    static class Solution {

        private int length;


        public List<List<Integer>> permute(int[] nums) {

            this.length = nums.length;




            return null;
        }


        private void f(int i, int j) {

            if (i == length) {

            }

        }

        public static void main(String[] args) {

            List<List<Integer>> result = new ArrayList<>();

            List<Integer> one = new ArrayList<>();
            one.add(1);
            one.add(2);
            one.add(3);

            result.add(one);
            System.out.println(result);
            one.remove(2);
            System.out.println(result);


        }
    }
}
