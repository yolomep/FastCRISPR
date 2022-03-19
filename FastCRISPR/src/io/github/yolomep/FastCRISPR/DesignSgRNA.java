package io.github.yolomep.FastCRISPR;

/**
 * 
 */

import java.util.*;

import static io.github.yolomep.FastCRISPR.Utilities.*;

import java.io.*;

public class DesignSgRNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("sgRNA design tool");
		System.out.println("Select input method: ");
		int input = getInput(in, 0, 1, "[0] From File\n[1] Type Sequence");
		StringBuilder sequence = new StringBuilder();
		if(input == 0) {
			System.out.println("Type full path name: ");
			String fileName = in.nextLine();
			try {
				BufferedReader file = new BufferedReader(new FileReader(new File(fileName)));
				String line;
				while ((line = file.readLine()) != null) {
					  StringTokenizer st = new StringTokenizer(line);
					  while(st.hasMoreTokens()) sequence.append(st.nextToken().toUpperCase());
				}
				
			}
			catch (IOException e) {
				System.out.println("That file does not exist.");
				System.exit(1);
			}
		}
		else {
			System.out.println("Type sequence: ");
			sequence.append(in.next().strip().toUpperCase());
		}
		int index = sequence.substring(20).indexOf("GG");
		boolean atLeast = false;
		while (index >= 0) {
			String toCheck = sequence.substring(index - 20, index);
		    if(valid(toCheck)) {
		    	atLeast = true;
		    	System.out.println(toCheck);
		    }
		    index = sequence.indexOf("GG", index + 1);
		}
		if(!atLeast) {
			System.out.println("No sequences could be found.");
		}
		
	}

	private static boolean valid(String toCheck) {
		if(toCheck.charAt(0) != 'G') return false;
		//check if GC concentration is less than 40-60
		Map<String, Integer> count = new HashMap<>();
		count.put("A", 0);
		count.put("C", 0);
		count.put("G", 0);
		count.put("T", 0);
		for(char c : toCheck.toCharArray()) {
			count.replace(c + "", count.get(c + "") + 1);
		}
		double ratio = (double)(count.get("C") + count.get("G"))/toCheck.length();
		if(ratio >= .4 && ratio <= .6) return true;
		return false;
	}

}
