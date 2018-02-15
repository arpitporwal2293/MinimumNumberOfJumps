//dynamic programming problem
public class MinimumNumberOfJumps {

	//recursive approach
	public static int noOfJumps(int[] arr,int jumps,int len){
		if(jumps == len)
			return 0;
		if(arr[jumps]==0){
			return Integer.MAX_VALUE;
		}
		int min = Integer.MAX_VALUE;
		for(int i=jumps+1;i<=len && i<=jumps + arr[jumps];i++){
			int j = noOfJumps(arr, i, len);
			if(j!=Integer.MAX_VALUE && j+1<min){
				min = j+1;
			}
		}
		return min;
	}

	//Solution using dp
	public static int noOfJumpsDP(int[] arr,int jumps,int len){
		int[] dpArr = new int[len];
		if(len==0 || arr[0] == 0)
			return 0;
		dpArr[0] = 0;
		for(int i=1;i<len;i++){
			dpArr[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(i<=j+arr[j] && dpArr[j]!=Integer.MAX_VALUE){
					dpArr[i] = Math.min(dpArr[i],dpArr[j]+1);
					break;
				}
			}
		}
		
		return dpArr[len-1];
	}
	
	public static void main(String[] args) {
		//int[] arr = {2,3,1,1,4};
		int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
		System.out.println(noOfJumps(arr, 0, arr.length-1));
		System.out.println(noOfJumpsDP(arr, 0, arr.length));
	}

}
