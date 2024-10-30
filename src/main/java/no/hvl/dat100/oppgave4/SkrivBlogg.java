package no.hvl.dat100.oppgave4;

import java.io.PrintWriter;

import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try (PrintWriter output = new PrintWriter(mappe + filnavn)) {
			output.print(samling.toString());
			return true;
		}
		catch(Exception e) {
		  e.getStackTrace();
		}
		return false;
	}
}
