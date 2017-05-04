import java.util.ArrayList;
import java.util.HashMap;

public class GorillaMain {
	private ArrayList<String> blosumChars = new ArrayList<String>();
//		FOR i = 0 TO m
//			M[i,0] <-- i * delta
//		FOR j = 0 TO n
//			M[0,j] <-- j * delta

//		FOR i = 1 TO m
//			FOR j=1 TO n
//				M[i,j] <-- min {alpha[xi, yj] + M[i-1, j-1],
//								delta + M[i-1, j], delta + M[i, j-1])

//		RETURN M[m,n]
	char[] ALPHABET = "ARNDCQEGHILKMFPSTWYVBZX".toCharArray();
	HashMap<Character, Integer> char2id = new HashMap<Character, Integer>();
	for(int i = 0; i < ALPHABET.length; i++) {
		char2id.put(ALPHABET[i], i);
	}
	
	public void SequenceAlignment (DNA dna_1, DNA dna_2) {
		int delta = -4;
		int m = dna_1.getDNA().length();
		int n = dna_2.getDNA().length();
		int M[][] = new int[m + 1][n + 1];
		int alpha[][] = null;
		
		for (int i = 0; i <= m; i++) {
			M[i][0] = i * delta;
		}
		
		for (int j = 0; j <= n; j++) {
			M[0][j] = j * delta;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// Beh�ver komma �t bokst�verna som skall j�mf�ras f�r alpha
				char currRowLetter = dna_1.getDNA().charAt(i-1);
				char currColLetter = dna_2.getDNA().charAt(j-1);
				// Beh�ver komma �t bokst�vernas index i blossummatrisen
				int rowInd = blosumChars.indexOf(currRowLetter);
				int colInd = blosumChars.indexOf(currColLetter);
				M[i][j] = maxVal(alpha[rowInd][colInd] + M[i - 1][j - 1],
								delta + M[i - 1][j], delta + M[i][j - 1]);
			}
		}
	}
	
	private int maxVal (int a, int b, int c) {
		int high = Math.max(a, b);
		int highest = Math.max(high, c);
		return highest;
	}
	
	

}