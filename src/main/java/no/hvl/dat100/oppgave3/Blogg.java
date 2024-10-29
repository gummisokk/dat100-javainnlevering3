package no.hvl.dat100.oppgave3;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		this.innleggstabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		//binærsøk, antar at innleggstabell er sortert etter id, så kan føre til problem TODO
		int venstre = 0;
		int høgre = this.nesteledig;
		while (venstre <= høgre) {
			int mid = venstre + (høgre - venstre) / 2;
			if (this.innleggstabell[mid].equals(innlegg))
				return mid;
			if (this.innleggstabell[mid].getId() < innlegg.getId())
				venstre = mid + 1;
			else
				høgre = mid - 1;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) != -1);
	}

	public boolean ledigPlass() {
		return (this.nesteledig < this.innleggstabell.length);
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || !ledigPlass()){
			return false;
		}
		this.innleggstabell[this.nesteledig] = innlegg;
		this.nesteledig ++;
		return true;
	}
	
	@Override
	public String toString() {
		String str = this.nesteledig + "\n";
		for (int i = 0; i < this.nesteledig; i++) {
			str += this.innleggstabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[this.nesteledig*2];
        System.arraycopy(this.innleggstabell, 0, nyTabell, 0, this.nesteledig);
		this.innleggstabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass() && !finnes(innlegg)){
			utvid();
			return leggTil(innlegg);
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		int sletteposisjon = finnInnlegg(innlegg);
		if (sletteposisjon == -1){
			return false;
		}
		this.nesteledig --;
		for (int i = sletteposisjon; i < this.nesteledig; i++) {
			this.innleggstabell[i] = this.innleggstabell[i+1];
		}	
		this.innleggstabell[this.nesteledig] = null;
		return true;
		}
	
	public int[] search(String keyword) {
		List<Integer> idsContainingKeyword = new ArrayList<>();
		for (int i = 0; i < this.nesteledig; i++) {
			if (this.innleggstabell[i].toString().contains(keyword)){
				idsContainingKeyword.add(i);
			}
		}
		
		int[] ret = new int[idsContainingKeyword.size()];
		for (int i=0; i < ret.length; i++)
		{
			ret[i] = idsContainingKeyword.get(i);
		}
		return ret;

	}
}