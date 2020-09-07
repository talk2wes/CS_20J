class Solution{
	static public int[] runningSum(int[] nums){
		int[]	total;

		total = new int[nums.length];
		System.out.println("length = " + nums.length);
		for (int i = 0 ; i < nums.length ; i++){
			System.out.printf("for loop i = %d\n", i);
			total[0] += nums[i];
		}
		System.out.println("Reached the end of the loops");
		return total;
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 4, 5 };
		int[] total = runningSum(nums);
		System.out.printf("The total is \n"); 
	}
}
