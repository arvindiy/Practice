package test;

public class RotateArray {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int index = 4;
		System.out.println(4 % a.length);
		//a = rotateRecursive(a, a.length);
		a = rotate(a, index);
		System.out.println(a);
	}
	
    private static int[] rotate(int[] a, int index) {
    	
    		for (int i = 0; i < index; i++) {
    			int tmp = a[0];
    			for (int j = 1; j < a.length; j++) {
    				int k = a[j];
    				a[j-1] = k;				
    			}
    			a[a.length-1] = tmp;
    		}
    		
		return a;
	}

	public static int[] rotateRecursive(int[] a, int index){
        if(index == 0) {
        		return a;
        }else {
        		rotateRecursive(a,index-1);
        }
        int tmp = a[0];
        for (int i = 1; i < a.length; i++) {
			int j = a[i];
			a[i-1] = j;
		}
        a[a.length-1] = tmp;
        return a;
    }
}
