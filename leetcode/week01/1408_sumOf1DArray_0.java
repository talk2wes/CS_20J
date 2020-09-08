class Solution{
	static public int[] runningSum(int[] nums){
		int[]	total;

		total = new int[nums.length];
		System.out.println("length = " + nums.length);
		for (int i = 0 ; i < nums.length ; i++){
			System.out.printf("for loop i = %d\n", i);
			if (i > 0){
			System.out.println("loop 1***");
			total[i] += nums[i] + total[i - 1];
			}else{
			System.out.println("loop 2**");
			total[i] += nums[i];
			}
		}
		System.out.println("Reached the end of the loops");
		return total;
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 4, 5 };
		int[] total = runningSum(nums);
		System.out.print("The result is [");
		for (int i = 0; i < total.length; i++)
		{
			System.out.printf("%d",total[i]); 
			if (i != total.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
