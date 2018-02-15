package leet.problem_553;

public class OptimalDivision {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new OptimalDivision().optimalDivision(nums));
    }

    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1)
            return sb.append(nums[0]).toString();
        else if (nums.length == 2)
            return sb.append(nums[0]).append("/").append(nums[1]).toString();
        sb.append(nums[0]).append("/").append(nums[1]).append("/(");
        for (int i = 2; i < nums.length; i++) {
            sb.append(nums[i]).append((i == nums.length - 1) ? "" : "/");
        }
        sb.append(")");
        return sb.toString();
    }

}
