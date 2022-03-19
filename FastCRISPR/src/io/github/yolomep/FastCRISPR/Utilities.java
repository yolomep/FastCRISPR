package io.github.yolomep.FastCRISPR;
import java.util.*;

public class Utilities {
	public static String leftPad(String input, char ch, int L) { 
        return String.format("%" + L + "s", input) .replace(' ', ch);
    } 
  
    // lol JS padEnd copy
    public static String padEnd(String input, char ch, int L) { 
        return String.format("%" + (-L) + "s", input).replace(' ', ch); 
    } 
    
    public static String padEnd(String input, int L) { 
        return String.format("%" + (-L) + "s", input); 
    } 
    
	public static int[] getRandom(int[] arr, int n) {
		int[] result = new int[n];
	    int len = arr.length;
	   int[] taken = new int[len];
	    while (n-- > 0) {
	         int x = (int) Math.floor(Math.random() * len);
	         result[n] = arr[check(x, taken) ? taken[x] : x];
	         taken[x] = check(--len, taken) ? taken[len] : len;
	    }
	    return result;
	}
	
	public static boolean check(String toCheck, String[] avalible) {
		for(String s: avalible) 
			if(s.equals(toCheck)) return true;
		
		return false;
	}
	
	public static boolean check(int toCheck, int[] avalible) {
		
		for(int s: avalible) 
			if(s == toCheck) return true;
		
		return false;
	}
	
	
	public static void dprintln(String s) throws InterruptedException {
		for(char c : s.toCharArray()) {
			System.out.print(c);
			Thread.sleep(30);
		}
		System.out.println();
		Thread.sleep(100);
	}
	/**
	 * 
	 * @param s
	 * @param delay (ms)
	 */
	public static void dprintln(String s, int delay) throws InterruptedException {
		for(char c : s.toCharArray()) {
			System.out.print(c);
			Thread.sleep(delay);
		}
		System.out.println();
		Thread.sleep(100);
	}
	
	public static void dprint(String s) throws InterruptedException {
		for(char c : s.toCharArray()) {
			System.out.print(c);
			Thread.sleep(30);
		}
	}
	
	public static void dprint(String s, int delay) throws InterruptedException {
		for(char c : s.toCharArray()) {
			System.out.print(c);
			Thread.sleep(delay);
		}

	}
	
	//pretty much useless now
	public static String getInput(Scanner in, String[] type, String text) {
		System.out.println(text);
		String input = in.nextLine();
		while(!check(input, type)) {
			System.out.println("This isn't valid input. Try again.");
			System.out.println(text);
			input = in.nextLine();
		}
		return input;
	}
	//also useless
	public static boolean getInput(Scanner in) {
		System.out.println("Yes or No?");
		String input = in.nextLine();
		String[] type = new String[] {"Yes", "No", "Y", "N", "n", "y", "YES", "NO", "yeah", "YEH", "YEAH", "Yeah", "Ya", "ya", "Nope", "nope", "Ye", "no", "yes"};
		while(!check(input, type)) {
			System.out.println("This isn't valid input. Try again.");
			System.out.println("Yes or No?");
			input = in.nextLine();
		}
		type = new String[] {"No", "N", "n", "NO", "nope", "no", "Nope"};
		if(check(input, type)) return false;
		return true;
	}
	//now both functions are safe lol, had to sacrifice nextInt() rip
	public static int getInput(Scanner in, int[] type, String text) {
		System.out.println(text);
		int input;
		while(true) {
			String s = in.next();
			try {
		        input = Integer.parseInt(s);
		    } catch (final NumberFormatException e) {
		    	System.out.println("This isn't valid input. Try again.");
				System.out.println(text);
				continue;
		    }
			if(check(input, type)) break;
			System.out.println("This isn't valid input. Try again.");
			System.out.println(text);
		}
		in.nextLine();
		return input;
	}
	//now both functions are safe lol, had to sacrifice nextInt() rip
	public static int getInput(Scanner in, int min, int max, String text) {
		System.out.println(text);
		int input;
		while(true) {
			String s = in.next();
			try {
		        input = Integer.parseInt(s);
		    } catch (final NumberFormatException e) {
		    	System.out.println("This isn't valid input. Try again.");
				System.out.println(text);
				continue;
		    }
			if(input >= min && input <= max) break;
			System.out.println("This isn't valid input. Try again.");
			System.out.println(text);
		}
		in.nextLine();
		return input;
	}
	
	public static class Pair<F, S> {
		/**
		 * Container to ease passing around a tuple of two objects. This object provides a sensible
		 * implementation of equals(), returning true if equals() is true on each of the contained
		 * objects.
		 */
	    public final F first;
	    public final S second;

	    /**
	     * Constructor for a Pair.
	     *
	     * @param first the first object in the Pair
	     * @param second the second object in the pair
	     */
	    public Pair(F first, S second) {
	        this.first = first;
	        this.second = second;
	    }

	    /**
	     * Checks the two objects for equality by delegating to their respective
	     * {@link Object#equals(Object)} methods.
	     *
	     * @param o the {@link Pair} to which this one is to be checked for equality
	     * @return true if the underlying objects of the Pair are both considered
	     *         equal
	     */
	    @Override
	    public boolean equals(Object o) {
	        if (!(o instanceof Pair)) {
	            return false;
	        }
	        Pair<?, ?> p = (Pair<?, ?>) o;
	        try {
	        	return p.first.equals(first) && p.second.equals(second);
	        }
	        catch(Exception e) {
	        	return p.first == first && p.second == second;
	        }
	    }

	    /**
	     * Compute a hash code using the hash codes of the underlying objects
	     *
	     * @return a hashcode of the Pair
	     */
	    @Override
	    public int hashCode() {
	        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
	    }

	    /**
	     * Convenience method for creating an appropriately typed pair.
	     * @param a the first object in the Pair
	     * @param b the second object in the pair
	     * @return a Pair that is templatized with the types of a and b
	     */
	    public static <A, B> Pair <A, B> create(A a, B b) {
	        return new Pair<A, B>(a, b);
	    }
	
	}


}
