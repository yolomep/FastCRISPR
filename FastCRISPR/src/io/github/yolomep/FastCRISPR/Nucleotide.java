package io.github.yolomep.FastCRISPR;

public class Nucleotide {
	String letter;
	
	public Nucleotide(String l) {
		letter = l.toLowerCase();
	}
	
	public Nucleotide(char l) {
		letter = (l + "").toLowerCase();
	}
	
	public int hashCode() {
		return letter.toUpperCase().charAt(0) - 20;
	}
	
	public boolean equals(Nucleotide other) {
		return other.letter.equalsIgnoreCase(letter);
	}
}
