package no.hvl.dat100.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File file = new File(mappe + filnavn);
		System.out.println(file);
		try {
			Blogg blogg;
			try (Scanner scanner = new Scanner(file)) {
				blogg = new Blogg(Integer.parseInt(scanner.nextLine()));
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if (line.equals(TEKST)){
						Tekst tekst = new Tekst(
								Integer.parseInt(scanner.nextLine()),
								scanner.nextLine(),
								scanner.nextLine(),
								Integer.parseInt(scanner.nextLine()),
								scanner.nextLine()
						);
						blogg.leggTil(tekst);
					}
					else if(line.equals(BILDE)){
						Bilde bilde = new Bilde(
								Integer.parseInt(scanner.nextLine()),
								scanner.nextLine(),
								scanner.nextLine(),
								Integer.parseInt(scanner.nextLine()),
								scanner.nextLine(),
								scanner.nextLine()
						);
						blogg.leggTil(bilde);
					}
				}
			}
			return blogg;
		}
		catch(FileNotFoundException e){
			System.err.println(e);
		}
		return new Blogg(0);
	}
}
