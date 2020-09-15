class Solution{
	public int[] runningSum(int[] nums){
		int[]	total;

		total = new int[nums.length];
		for (int i = 0 ; i < nums.length ; i++){
			if (i > 0){
			total[i] += nums[i] + total[i - 1];
			}else{
			total[i] += nums[i];
			}
		}
		return total;
	}
/*
	public static void main(String[] args){
		int[] nums = {1, 2, 4, 5 };
		int[] total = runningSum(nums);
		System.out.print("[");
		for (int i = 0; i < total.length; i++)
		{
			System.out.printf("%d",total[i]); 
			if (i != total.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	*/ 

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 3, 4};
		Solution total = new Solution();
		int[] total = total.runningSum(num);
	}
}
