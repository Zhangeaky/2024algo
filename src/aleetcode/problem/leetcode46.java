package aleetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <a href="https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked">全排列</a>
 */
public class leetcode46 {

    static class Solution {


        private List<List<Integer>> resultList = new ArrayList<>();


        public List<List<Integer>> permute(int[] nums) {

            if (nums == null) {
                return resultList;
            }



            generate(new ArrayList<>(), nums);

            return resultList;
        }


        private void generate(List<Integer> road, int[] given) {

            if (road.size() == given.length) {
                resultList.add(new ArrayList<>(road));
                return;
            }

            for (Integer integer : given) {
                // 做出选择
                if (!road.contains(integer)) {
                    road.add(integer);
                } else {
                    continue;
                }
                // 进入下一层
                generate(road, given);
                // 撤销上一次选择
                road.remove(road.size()-1);
            }
        }

        public static void main(String[] args) {

            int[] input = new int[] {1, 2, 3};

            Solution solution = new Solution();
            List<List<Integer>> permute = solution.permute(input);
            System.out.println(permute);

        }
    }
}
