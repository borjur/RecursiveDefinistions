import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Assignment2 {
	
	

    public static void main(String args[]) {
    	System.out.println("Number 1");
    	int[] numbers1 = {382,749, 2977, 9989, 52878};
    	
        for(int num: numbers1){
            System.out.println("isDivisibleBy7()-- is " + num + " divisible by 7  :" + isDivisibleBy7(num));
           
            System.out.println("-----------------------------------------------------------");
        } 
        System.out.println("Number 2");
        int[] numbers = {128,257, 1023,8192,65536};
     
       
        System.out.println();
        for(int num: numbers){
            System.out.println("isPowerOfTwo()-- is " + num + " power of two  :" + powerOfTwo(num));
           
            System.out.println("-----------------------------------------------------------");
        } 
        System.out.println("Number 3");
        System.out.println();
              
        int[] num = new int[]{12, 51, 137, 364, 589,546,357,7,43};
       
        Map<Integer,Integer> test = new TreeMap<Integer,Integer>();

        for(int i = 0; i < num.length; i++)  {
        	test.put(num[i], i);
        }


        Map<Integer,SumInfo> test2 = new TreeMap<Integer,SumInfo>();

        for(int i = 0; i < num.length; i++)  {
           
           for(int j = i + 1; j < num.length; j++)  {
              int together = num[i] + num[j];

              if(test.containsKey(together))  {
                 
            	  test2.put(test.get(together), new SumInfo(num[i], i, num[j], j));
              }
           }
        }

        Set<Integer> cevap = test2.keySet();
        Iterator<Integer> burek = cevap.iterator();
        while(burek.hasNext())  {
           int hasIt = burek.next();
           SumInfo si = test2.get(hasIt);
           System.out.println("true: " + num[hasIt] + " (element " + hasIt + ")  is the sum of elements " + si.iA + " and " +  /*" (idx=" + si.iIdxA + ") and "*/ + si.iB /*+ " (idx=" + si.iIdxB + ")"*/);
        }
        
        System.out.println("Number 4");
        System.out.println();
       System.out.println( "abaaba is " + oddPalindrome("abaaba") );
       System.out.println( "bbaabbb is " + oddPalindrome("bbaabbb") );
       System.out.println( "abababa is " + oddPalindrome("abababa") );
       System.out.println( "aabcbaa is " + oddPalindrome("aabcbaa") );
       System.out.println( "baabbbaab is " + oddPalindrome("baabbbaab") );
       System.out.println();
       
       System.out.println("Number 5");
       System.out.println();
       System.out.println( "abaaba is " + containsABA("abaaba") );
       System.out.println( "bbaabbb is " + containsABA("bbaabbb") );
       System.out.println( "abababa is " + containsABA("abababa") );
       System.out.println( "aabcbaa is " + containsABA("aabcbaa") );
       System.out.println( "baabbbaab is " + containsABA("baabbbaab") );
       System.out.println("Number 6");
       System.out.println();
       System.out.println( "aba+ba is " + containsABPlus("aba+ba") );
       System.out.println( "b+ba+bb is " + containsABPlus("b+ba+bb") );
       System.out.println( "ab++ba+a is " + containsABPlus("ab++ba+a") );
       System.out.println( "+aab+bba is " + containsABPlus("+aab+bba") );
       System.out.println( "b+abb+ab+ is " + containsABPlus("b+abb+ab+") );
       
    
     }
    
    

  

    private static boolean powerOfTwo(int broj){
        int byTwo = 1;
        while(broj >= byTwo){
            if(broj == byTwo){
                return true;
            }
            byTwo = byTwo*2;
        }
        return false;
    }
    
    public static boolean isDivisibleBy7(int par) {
 		if(par == 0) {
 			return false;
 		}
 		
 		if(par < 0) {
 			par = -1 * par;
 		}
 		
 		int start = 1;
 		int part = par;
 		int temp = part;
 		while(part > 0) {
 			temp = part;
 			part = part - 7 * start;
 			if(part == 0) {
 				return true;
 			}
 			if(part < 0 && start == 1) {
 				return false;
 			} 
 			if(part < 0) {
 				
 				part = temp;
 				start = 1;
 			} else {
 				
 				start = 2*start;
 			}
 		}
 		return false;
 	}
    
    
    public static boolean oddPalindrome(String word)
    {
        if(word.length() == 0 || word.length() == 1)
           //return what its supposed to
            return true; 
        if(word.charAt(0) == word.charAt(word.length()-1))
            // check
            return oddPalindrome(word.substring(1, word.length()-1));

       
        return false;
    }
    
    
    


    
    public static boolean containsABA(String wprd) {
        String abaWord = "aba";

        // Base cases
        if (wprd.length() < abaWord.length()) 
            return false;

        if (wprd.length() == abaWord.length())
        {
            if (wprd.equals(abaWord))
            {
                return true;
            }
            return false;
        }

        int mid = wprd.length()/2;

        
        for (int i = 0; i < abaWord.length(); i++)
        {
            int begin = mid - 1 - i;
            int finish = begin + 3;
            if (begin >= 0)
            {
                String aWord = wprd.substring(begin, finish);
                if (aWord.equals(abaWord))
                {
                    return true;
                }
            }
        }

  
       if(containsABA(wprd.substring(0,mid -1)))
           return true;

       if(containsABA(wprd.substring(mid, wprd.length())))
           return true;

       return false;
  }
  
 

    
    public static boolean containsABPlus(String wprd) {
    	String abaWord1 = "abc";
    	
        String abaWord = "a+b";
     
        String abaWord2 = "ab";
       
        if (wprd.length() < abaWord.length()) 
            return false;

        if (wprd.length() == abaWord.length() )
        {
            if (wprd.equals(abaWord))
            {
                return true;
            }
            return false;
        }

        int mid = wprd.length()/2;

        
        for (int i = 0; i < abaWord.length(); i++)
        {
            int begin = mid - 1 - i;
            int finish = begin + 3;
            abaWord1 = abaWord2;
            
            if (begin >= 0)
            {
                String aWord = wprd.substring(begin, finish);
                if (aWord.equals(abaWord))
                {
                    return true;
                }
            }
        }
        abaWord2 = abaWord1;
  
       if(containsABA(wprd.substring(0,mid -1)))
           return true;

       if(containsABA(wprd.substring(mid, wprd.length())))
           return true;

       return false;
  }
    

    


    


    static class Has  {
    	   public final int one;
    	   public final int two;
    	   public final int three;
    	   public final int four;
    	   public Has(int jedan, int dva, int tri, int cetri)  {
    		   one = jedan;
    		   two = dva;
    		   three = tri;
    		   four = cetri;
    	   }
     
}
}



