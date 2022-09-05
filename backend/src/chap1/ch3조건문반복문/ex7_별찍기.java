package chap1.ch3조건문반복문;

import java.util.Scanner;

public class ex7_별찍기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
		System.out.println("문제1 입력받은만큼 별찍기");
		int s1 = sc.nextInt();
		for(int i = 1 ; i<=s1 ; i++) {
			System.out.print("*");
		}
		
		System.out.println("문제2 입력받은만큼 별찍기");
		int s2 = sc.nextInt();
		for(int i = 1; i <= s2; i++) {
			System.out.print("*");
			if(i%3==0) {System.out.println();}
		}
		
	/*별문제3 : 입력받은 줄 만큼 출력
		
		*		
		**		
		***		
		****	
		***** 	
	*/
		System.out.println("문제3 입력받은만큼 별찍기");
		
		int s3 = sc.nextInt();	
		for(int i =1 ; i<=s3; i++) {
			for(int s=1 ; s<=i ; s++) {
				System.out.print("*");
			}
			System.out.println();
			}
		
		
				
	/*별문제4 : 입력받은 줄 만큼 출력
				
		*****	i=1   s=5
		****	i=2	  s=4	
		***		i=3	  s=3
		**		i=4	  s=2
		*		i=5   s=1
	*/	
		System.out.println("문제4 입력받은만큼 별찍기");
		
		int s4 = sc.nextInt();	
		for(int i =1 ; i<=s4; i++) {
			for(int s=1 ; s<=s4-i+1 ; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
	/*별문제5 : 입력받은 줄 만큼 출력

	        *		
	       **		
	      ***		
	     ****		
	    *****		
	*/
		System.out.println("문제5 입력받은만큼 별찍기");
		int s5 = sc.nextInt();	
		for(int i =1 ; i<=s5; i++) {
			for(int s=1 ; s<=s5-i+1 ; s++) {
				System.out.print(" ");
			}
			for(int s=1 ; s<=i ; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	/*별문제6 : 입력받은 줄 만큼 출력

		*****	 	
		 ****		
		  ***		
		   **		
		    *		
	*/
		System.out.println("문제6 입력받은만큼 별찍기");
		int s6 = sc.nextInt();	
		for(int i =1 ; i<=s6; i++) {
			for(int s=1 ; s<=i ; s++) {
				System.out.print(" ");
			}
			for(int s=1 ; s<=s6-i+1 ; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	/*별문제7 : 입력받은 줄 만큼 출력
			
	        *		
	       ***		
	      *****		
	     *******	
		*********
	*/
		System.out.println("문제7 입력받은만큼 별찍기");
		int s7 = sc.nextInt();	
		for(int i =1 ; i<=s7; i++) {
			for(int s=0 ; s<=s7-i ; s++) {
				System.out.print(" ");
			}
			for(int s=1 ; s<=i*2-1 ; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	/*별문제8 : 입력받은 줄만큼 출력 
		    1
	       222
	      33333
	     4444444
		555555555
	*/	
		System.out.println("문제7 입력받은만큼 별찍기");
		int s8 = sc.nextInt();	
		for(int i =1 ; i<=s8; i++) {
			for(int s=0 ; s<=s8-i ; s++) {
				System.out.print(" ");
			}
			for(int s=1 ; s<=i*2-1 ; s++) {
				System.out.print(i);
			}
			System.out.println();
		}
	/*별문제9 : 입력받은 줄만큼 출력

		*********		i=1   s=1     s=9
		 *******		i=2	  s=2	  s=7
		  *****			i=3	  s=3     s=5
		   ***			i=4   s=4     s=3
		    *			i=5   s=5     s=1
	*/    
		System.out.println("문제9 입력받은만큼 별찍기");
		int s9 = sc.nextInt();	
		for(int i =1 ; i<=s9; i++) {
			for(int s=0 ; s<=i ; s++) {
				System.out.print(" ");
			}
			for(int s=1 ; s<=(s9-i)*2+1 ; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	/*별문제10 : 입력받은 줄만큼 출력
	        *
	       ***
	      *****
		 *******
		*********
		 *******
		  *****
		   ***
		    *
	*/
		System.out.println("문제10 입력받은만큼 별찍기");
		int s10 = sc.nextInt();	
		for(int i =1 ; i<=s10; i++) {
			for(int s=0 ; s<=s10-i ; s++) {
				System.out.print(" ");
				}
			for(int s=1 ; s<=i*2-1 ; s++) {
				System.out.print("*");
				}
			System.out.println();
		}	
			
		for(int ii =1 ; ii<=s10; ii++) {
			for(int s=0 ; s<=ii ; s++) {
				System.out.print(" ");
				}
			for(int s=1 ; s<=(s10-ii)*2-1 ; s++) {
				System.out.print("*");
				}
			System.out.println();
		}
		
		
	/*별문제11 : 입력받은 줄만큼 출력 [ 입력받은 행/열 동일 ] 
		*     *		i=1    	1공백5    별2
		 *   *		i=2	   	2공백3    별2
		  * *		i=3    	3공백1    별2
		   *		i=1	   4별1
	      * *		i=2    3공백1
	     *   *		i=3	   2공백3
	    *     *		i=4	   1공백5
	*/
		System.out.println("문제11 입력받은만큼 별찍기");
		int s11 = sc.nextInt();	
		//위에
		for(int i =1 ; i<=s11; i++) {
			for(int s=1 ; s<=i-1 ; s++) {
				System.out.print(" ");
				}
			System.out.print("*");
			for(int s=0 ; s<=(s11-i)*2 ; s++) {
				System.out.print(" ");
				}
			System.out.print("*");
			System.out.println();
		}	
		//가운데
		for(int b=1; b<s11+1; b++) {
			System.out.print(" ");
		}
			System.out.print("*");
			System.out.println();
		
		//아래
		for(int i =1 ; i<=s11; i++) {
			for(int s=0 ; s<=s11-i-1 ; s++) {
				System.out.print(" ");
				}
			System.out.print("*");
			for(int s=0 ; s<=i*2-2 ; s++) {
				System.out.print(" ");
				}
			System.out.print("*");
			System.out.println();
		}
		
	/*별문제12 : 입력받은 줄만큼 출력
		*        *
		**      **
		***    ***
		****  ****
		**********
		****  ****
		***    ***
		**      **
		*        *
	*/
		System.out.println("문제11 입력받은만큼 별찍기");
		int s12 = sc.nextInt();	
		//위에
		for(int i =1 ; i<=s12; i++) {
			for(int s=1 ; s<=i ; s++) {
				System.out.print("*");
				}
			for(int s=1 ; s<=s12*2-i*2 ; s++) {
				System.out.print(" ");
				}
			for(int s=1 ; s<=i ; s++) {
				System.out.print("*");
				}
			System.out.println();
		}	

		//아래
		for(int i =1 ; i<=s12; i++) {
			for(int s=0 ; s<=s12-i-1 ; s++) {
				System.out.print("*");
				}
			for(int s=0 ; s<=i*2-1 ; s++) {
				System.out.print(" ");
				}
			for(int s=0 ; s<=s12-i-1 ; s++) {
				System.out.print("*");
				}
			System.out.println();
		}
		
	/*별문제13 : 입력받은 줄만큼 출력
           *                        i=1      2공백1별
          * *                       i=2		 1공백1별1공백1별
         *****                      i=3      i*2-1
        *     *                     i=4     
       * *   * *                    i=5
      ***** *****                   i=6
     *           *                  
    * *         * *                 
   *****       *****                
  *     *     *     *               
 * *   * *   * *   * *              
***** ***** ***** *****             

	*/	
		System.out.println("문제13 입력받은만큼 별찍기");
		int s13 = sc.nextInt();	
		//위에
		for(int i =1 ; i<=s13; i++) {
			{System.out.println("  *");}
			{System.out.println(" * *");}
			{System.out.println("*****");}
		}	

		
		
		
		
	}
}
