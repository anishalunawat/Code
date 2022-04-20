import java.io.*;
import java.util.*;
class WordBreak{

	public static void main(String args[]) {
		String str="ab";
		List<String> wordDict = new ArrayList<String>(Arrays.asList("a", "b"));
		if(wordBreak(str, wordDict)) {
			System.out.println("true");
		} else
			System.out.println("false");
		
	}
	 public static boolean wordBreak(String s, List<String> wordDict) {
          if(s.length()==0) {
            return true; 
        }
        Set<String> dict = new HashSet<String>();
        for(String entry:wordDict) {
            dict.add(entry);
        }
        boolean[][] inDictionary = new boolean[s.length()][s.length()];
        for(int l=0;l<s.length();l++) {
            for(int i=0, j=i+l; i<s.length()-l; i++,j++) {
                if(dict.contains(s.substring(i,j+1)))
                    inDictionary[i][j] = true;
                else {
                    for(int k=i+1; k<=j; k++) {
						System.out.println(inDictionary[i][k-1] +" "+ inDictionary[k][j] +" "+k);
                        if(inDictionary[i][k-1] && inDictionary[k][j]) {
                            inDictionary[i][j] = true;
                        }
                    }
                }
             System.out.println(s.substring(i,j+1) +" "+i +" "+j +inDictionary[i][j]);
            }
        }
      /*  for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                System.out.print(inDictionary[i][j]+" ");
            }
            System.out.println();
        }*/
        return inDictionary[0][s.length()-1];
    }
	
}