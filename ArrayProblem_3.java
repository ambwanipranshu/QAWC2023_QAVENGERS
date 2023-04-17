package programming;

class ArrayOperation{
	static boolean isExpectedResult(int arr[],int arbNumber) {
		boolean result=false;
		
		int sumFirstFour=getSumFirstFour(arr);
		int sumLastFour=getSumLastFour(arr);
		
		//Step-1
		if(sumFirstFour>sumLastFour) {
			swapOddIndexes(arr);
			getAbsoluteArray(arr);
			if(isArrayPalinDrome(arr)) {
				result=true;
			}
			else {
				int sumAll=getSumAllElement(arr);
				int perfectSquare=getPerfectSquareLessArbNumber(arbNumber);
				int productNumber=sumAll*perfectSquare;
				int newArr[]=convertIntegerToArray(productNumber);
				if(isArrayPalinDrome(newArr)) {
					result=true;
				}
				else {
					swapEvenIndexes(arr);
				}
			}
		}
		
		
		return result;
		
	}
	
	
	static int[] convertIntegerToArray(int number) {
		String str = Integer.toString(number);
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			arr[i] = str.charAt(i) - '0';
		}
		return arr;
	}
	
	static void printArray(int arr[]) {
		for(int element:arr) {
			System.out.print(element+" ");
		}
	}
	
	static void getAbsoluteArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=Math.abs(arr[i]);
		}
	}
	static void swapOddIndexes(int arr[]) {
		
		arr[1]=arr[1]+arr[5];
		arr[5]=arr[1]-arr[5];
		arr[1]=arr[1]-arr[5];
		
		arr[3]=arr[3]+arr[7];
		arr[7]=arr[3]-arr[7];
		arr[3]=arr[3]-arr[7];
		
		
		System.out.println();
		
	}
	static void swapEvenIndexes(int arr[]) {
		
		arr[0]=arr[0]+arr[4];
		arr[4]=arr[0]-arr[4];
		arr[0]=arr[0]-arr[4];
		
		arr[2]=arr[2]+arr[6];
		arr[6]=arr[2]-arr[6];
		arr[2]=arr[2]-arr[6];
		
		
		System.out.println();
		
	}
	
	static int getSumAllElement(int arr[]) {
		int s=0;
		for(int i=0;i<=arr.length;i++) {
			s=s+arr[i];
		}
		return s;
	}
	
	static int getSumFirstFour(int arr[]) {
		int s=0;
		for(int i=0;i<=3;i++) {
			s=s+arr[i];
		}
		return s;
	}
	static int getSumLastFour(int arr[]) {
		int s=0;
		for(int i=4;i<arr.length;i++) {
			s=s+arr[i];
		}
		return s;
	}
	static int getPerfectSquareLessArbNumber(int number)
	{
	    double sqRoot = Math.floor(Math.sqrt(number));
	  if (sqRoot * sqRoot == number)
		  sqRoot -= 1;
	 
	    return (int)(sqRoot * sqRoot);
	}
	
	static boolean checkDataNotContainingZero(int arr[]) {
		boolean isContainingZero=false;
		for(int i:arr) {
			if(i==0)
			{
				isContainingZero=true;
			}
		}
		return isContainingZero;
	}
	
	static boolean isArrayPalinDrome(int arr[])
	  {
	    String arrstr = new String();
	    for (int i = 0; i < arr.length; i++) {
	      arrstr += arr[i];
	    }
	    int zeroArray[] = new int[256];
	    for (int i = 0; i<arrstr.length(); i++) {
	    	zeroArray[arrstr.charAt(i)]++;
	    }
	    int count = 0;
	    for (int i = 0; i < 256; i++) {
	      if ((zeroArray[i] & 1)!=0) {
	        count++;
	      }
	      if (count > 1) {
	        return false;
	      }
	    }
	    return true;
	  }
	
}



public class ArrayProblem_3 {

	public static void main(String[] args) {
			int arr1[]= {1, 2, 3, 4, -1, -2, -3, -4};
			int arr2[]= {-1, 3, 2, 1, 1, 2, 3, 4};
			
			//Example-1 - Tested
			if(!ArrayOperation.checkDataNotContainingZero(arr1)) {
				boolean result=ArrayOperation.isExpectedResult(arr1, 1000);
				System.out.println("Result : "+result);
			}
			else {
				System.out.println("Please make sure Array Data not containing Zero, Thanks");	
			}
			
			//Example-2 - Tested
			if(!ArrayOperation.checkDataNotContainingZero(arr2)) {
				boolean result=ArrayOperation.isExpectedResult(arr2, 325);
				System.out.println("Result : "+result);
			}
			else {
				System.out.println("Please make sure Array Data not containing Zero, Thanks");	
			}
			
		
		

	}

}
