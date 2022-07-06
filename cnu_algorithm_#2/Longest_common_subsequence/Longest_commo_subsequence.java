package Longest_common_subsequence;

public class Longest_commo_subsequence {
	
	// static value
	static int max, index;
	static int dp[][], maxCheckTableSide[][], maxCheckTableLine[][], path[][];
	static char x[], y[];
	static String findPath;
	static String s1, s2;
	static int pathCount = 1;
	
	// main
	public static void main(String[] args) {

		// variable
		int q = -2;

		// string
		s1 = "tcatagttaaca";
		s2 = "tcagaagtacc";

		// String -> char
		x = new char[s1.length() + 1];
		x = s1.toCharArray();
		y = new char[s2.length() + 1];
		y = s2.toCharArray();

		// maxCheckTable
		maxCheckTableSide = new int[s2.length() + 1][s1.length() + 1];
		maxCheckTableLine = new int[s2.length() + 1][s1.length() * 2 + 1];

		// LCS table
		dp = new int[s2.length() + 1][s1.length() + 1];

		for (int i = 0; i < s2.length() + 1; i++) {
			maxCheckTableLine[i][0] = (i + 1) * q;
		}
		for (int j = 0; j < s1.length() + 1; j++) {
			maxCheckTableSide[0][j] = (j + 1) * q;
		}
		// LCS table fin

		// path table
		path = new int[s2.length() + 1][s1.length() + 1];
		
		for (int i = 0; i < s2.length() + 1; i++) {
			path[i][0] = 4;
		}
		for (int j = 0; j < s1.length() + 1; j++) {
			path[0][j] = 2;
		}// path table fin
		

		// LCS
		for (int i = 0; i < s2.length() + 1; i++) {
			dp[i][0] = i * q;
		}
		for (int j = 0; j < s1.length() + 1; j++) {
			dp[0][j] = j * q;
		}

		for (int k = 1; k < s2.length() + 1; k++) {
			for (int l = 1; l < s1.length() + 1; l++) {
				dp[k][l] = max(k, l);
			}
		}// LCS fin
		
		
		// print
		System.out.println("x: " + s1 + " / " + "y : " + s2);
		
		// table print
		for (int k = 0; k < s2.length() + 1; k++) {
			for (int l = 0; l < s1.length() + 1; l++) {

				if (l == s1.length()) {
					System.out.printf("%5d*", dp[k][l]);
				} else {
					System.out.printf("%5d* %5d", dp[k][l], maxCheckTableSide[k][l]);
				}

			}
			System.out.println();

			for (int l = 0; l < s1.length() * 2 + 1; l++) {
				if (k != s2.length()) {
					System.out.printf("%5d ", maxCheckTableLine[k][l]);
				}
			}
			System.out.println();

		} // table print fin

	
		
		
		//path print
		pathfind(s2.length(), s1.length(), "");
		
		//print fin
		
		
		
		
		

	}// main fin

	// max method
	static int max(int k, int l) {
		// pcheck = 1 if same word
		int pCheck = (k == 0 || l == 0) ? 0 : ((x[l - 1] == y[k - 1]) ? 1 : -1);

		// max value
		// one out of three
		max = (dp[k][l - 1] - 2 > dp[k - 1][l - 1] + pCheck) && (dp[k][l - 1] - 2 > dp[k - 1][l] - 2) ? dp[k][l - 1] - 2
				: (dp[k - 1][l] - 2 > dp[k - 1][l - 1] + pCheck ? dp[k - 1][l] - 2 : dp[k - 1][l - 1] + pCheck);

		// maxchecktable set

		maxCheckTableSide[k][l - 1] = dp[k][l - 1] - 2;
		maxCheckTableLine[k - 1][2 * l - 1] = dp[k - 1][l - 1] + pCheck;
		maxCheckTableLine[k - 1][2 * l] = dp[k - 1][l] - 2;

		// maxchecktable set fin

		// path bit mask
		int bitMask = 0;

		if (max == dp[k][l - 1] - 2) {
			bitMask += 2;
		}
		if (max == dp[k - 1][l] - 2) {
			bitMask += 4;
		}
		if (max == dp[k - 1][l - 1] + pCheck) {
			bitMask += 1;
		}

		path[k][l] = bitMask;
		//path bit mask fin
		
		return max;

	}// max method fin
	
	//pathfind
	static void pathfind(int y1, int x1, String find) {
		
		
		
		if(x1 == 0 && y1 == 0) {
			System.out.println("경로 "+pathCount +": "+s1+" "+find);
			System.out.println("점수: " + dp[y.length][x.length]);
			pathCount++;
			
		}
		if(x1 == 0 || y1 == 0) {
			return;
		}
		
		int tep = path[y1][x1];
		
		if(tep % 2 == 1) {
			pathfind(y1-1, x1-1, s2.charAt(y1-1) + find);
			
		}
		
		tep /= 2;
		
		if(tep % 2 == 1) {
			
			pathfind(y1, x1-1, "-" + find);
			
		}
		
		tep /= 2;
		
		if(tep % 2 == 1) {
			find = s2.charAt(y1-1) + find;
			pathfind(y1-1, x1, s2.charAt(y1-1) + find);
			
		}
		
		
	}
	//pathfind fin
	
	

}
