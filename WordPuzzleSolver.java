package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {
	private int row;
	private int col;
	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
		try {
			Scanner weird = new Scanner(System.in);
			String dicFile = weird.next();
			String gridFile = weird.next();
			weird.close();
			new WordPuzzleSolver().solve(dicFile, gridFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* Solve the puzzle */
	private String getString(char[][] grid, int R, int C, int D, int L) {
	
		String z = "";
		if(D ==0) {
			z = getStringN(grid,R,C,L);
		}
		if(D==1) {
			z = getStringNE(grid,R,C,L);
		}
		if(D == 2) {
			z = getStringE(grid, R, C, L);
		}
		if(D ==3) {
			z = getStringSE(grid,R,C,L);
		}
		if(D ==4) {
			z = getStringS(grid,R,C,L);
		}
		if(D==5) {
			z = getStringSW(grid,R,C,L);
		}
		if(D == 6) {
			z = getStringW(grid,R,C,L);
		}
		if(D==7) {
			z = getStringNW(grid,R,C,L);
		}
		
		
		
		return z;
	}
	private String getStringE(char[][] grid, int R, int C,int L) {
		String a = "";
		if(this.col >= L+C)
		for(int i = 0; i< L; i++) {
			a += grid[R][C];
			C += 1;
		}
	return a;
	}
	private String getStringW(char[][] grid, int R, int C,int L) {
		String a = "";
		if(0<= C-L+1)
		for(int i = 0; i< L; i++) {
			a += grid[R][C];
			C -= 1;
		}
	return a;
	}
	private String getStringS(char[][] grid, int R, int C,int L) {
		String a = "";
		if(this.row >= L+R)
		for(int i = 0; i< L; i++) {
			a += grid[R][C];
			R += 1;
		}
	return a;
	}
	private String getStringN(char[][] grid, int R, int C,int L) {
		String a = "";
		if(0<= R-L+1)
		for(int i = 0; i< L; i++) {
			a += grid[R][C];
			R -= 1;
		}
	return a;
	}
	private String getStringSE(char[][] grid, int R, int C,int L) {
		String a = "";
		
		 {
			if((this.row >= (R + L)) && (this.col - C +1 > L)){
			for(int i = 0; i< L; i++) {
				a += grid[R][C];
				R += 1;
				C += 1;
			}
			}
			return a;
		}
		
	}
	private String getStringNE(char[][] grid, int R, int C,int L) {
		String a = "";
		
		
			
			if((0 <= (R + 1 -L)) && (this.col-C >= L)) {
				
			for(int i = 0; i< L; i++) {
				a += grid[R][C];
				
				R -= 1;
				C += 1;
			}
			}
	
	return a;
	}
	
	private String getStringSW(char[][] grid, int R, int C,int L) {
		String a = "";
		
		 {
			if((this.row - R >= L) && (0>=L-C-1)){
			for(int i = 0; i< L; i++) {
				a += grid[R][C];
				R += 1;
				C -= 1;
			}
			}
			return a;
		}
	}
	private String getStringNW(char[][] grid, int R, int C,int L) {
		String a = "";
		
		
			
			if((0 <= (R + 1 -L)) && (0 >= L-C -1)) {
				
			for(int i = 0; i< L; i++) {
				a += grid[R][C];
				
				R -= 1;
				C -= 1;
			}
			}
	
	return a;
	}
		 
	private void solve(String dictFile, String gridFile) throws IOException {
		int count = 0;
		int north = 0;
		int northeast = 0;
		int east = 0;
		int southeast = 0;
		int south = 0;
		int southwest = 0;
		int west = 0;
		int northwest = 0;
		/* Implement this method. Open the files and solve the word puzzle!! */
		
		BufferedReader in = new BufferedReader ( new FileReader (gridFile));
		String width = in . readLine (); // reads the next line
		String height = in . readLine ();
		String str = in.readLine();
		in.close ();
		
		BufferedReader dict = new BufferedReader ( new FileReader (dictFile));
		String s;
		hash.HashTable<String, String> stud = new hash.HashTable<String, String>();
		while((s = dict.readLine())!=null) {
			
			stud.insert(s, s);
		}
		dict.close();
		
		
		
		
		
		int row = Integer.parseInt(width);
		this.row = row;
		int col = Integer.parseInt(height);
		this.col =col;
		int k = 0;
		char[][] grid = new char [row][col];
		for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if(k < str.length())
                    grid[i][j] = str.charAt(k);
                k++;
            }
        }
		
		
		for(int i = 0; i<row; i++) {
			for(int j = 0; j< col; j++) {
				for(int dir = 0; dir<8; dir++) {
					for(int l = 3; l<= 22; l++) {
						String gridString = getString(grid, i, j, dir, l);
						
						if(gridString!=null) {
							
							if(stud.contains(gridString)){
							count+=1;
							
//							System.out.println(gridString + " " + dir);
							if(dir ==0) {
								north+=1;
							}
							if(dir==1) {
								northeast+=1;
							}
							if(dir == 2) {
								east+=1;
							}
							if(dir ==3) {
								southeast+=1;
							}
							if(dir ==4) {
								south+=1;
							}
							if(dir==5) {
								southwest+=1;
							}
							if(dir == 6) {
								west+=1;
							}
							if(dir==7) {
								northwest+=1;
							}
							}
						}
					}
				}
			}
		}
		
		System.out.println(count + " words found");

//		System.out.println("north = " + north);
//		System.out.println("northeast = " + northeast);
//		System.out.println("east = " + east);
//		System.out.println("south = " + south);
//		System.out.println("southeast = " + southeast);
//		System.out.println("southwest = " + southwest);
//		System.out.println("west = " + west);
//		System.out.println("northwest = " + northwest);
		

		
	}
}
