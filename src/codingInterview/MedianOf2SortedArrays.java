package codingInterview;

public class MedianOf2SortedArrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
    	int m = nums1.length;
    	int n = nums2.length;
    	int total = m + n;
    	if((total & 0x1) != 0)//奇数
    	{
    		return find_kth(nums1 , 0, m-1 , nums2 , 0, n-1, total/2+1);
    	}
    	else//偶数
    	{
    		return (find_kth(nums1,  0, m-1, nums2, 0, n-1 ,total/2)+find_kth(nums1, 0, m-1, nums2,  0, n-1, total/2+1))/2.0;
    	}
    }
    
    //找到第k个数
    private static int find_kth(int A[] , int aStart, int aEnd , int B[] , int bStart , int bEnd ,int k)
    {
    	int alength = A.length;
    	int blength = B.length;
    	int alen = aEnd - aStart + 1;
    	int blen = bEnd - bStart + 1;
    	//确保alen小于或等于blen
    	if(alen > blen) return find_kth(B , bStart, blength-1 , A , aStart, alength-1 , k);
    	if(alen == 0) return B[k-1];
    	if(k == 1) return Math.min(A[aStart] , B[bStart]);
    	
    	//divide k into two parts
    	int ia = Math.min(k / 2, alen) ;
    	int ib = k - ia;
    	
    	if(A[ia+aStart - 1] < B[ib+bStart - 1])
    	{
    		return find_kth(A, ia+aStart, alength-1,  B, bStart , blength - 1 , k - ia);
    	}
    	else if(A[ia+aStart - 1] > B[ib+bStart - 1])
    	{
    		return find_kth(A , aStart , alength -1  , B , ib+bStart , blength -1 , k -ib);
    	}
    	else//递归退出条件 A[k/2-1] == B[k/2-1]
    	{
    		//System.out.println(A[ia-1]);
    		return A[ia+aStart - 1];
    	}
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MedianOf2SortedArrays solution = new MedianOf2SortedArrays();
		
		int[] nums1 = new int[]{1,2,3,4,5,12};
		int[] nums2 = new int[]{7,8,9,10};
		
		//System.out.println("R:"+MedianOf2SortedArrays.find_kth(nums1, 0, 3, nums2, 0, 3, 5));
		
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}

}
