package com.gillotroux;

import java.time.LocalDate;

import org.junit.Test;

public class TestPersonnel {

	@Test
	public void test() {
		LocalDate date=LocalDate.now();
		
		// Creation de personnel
		Personnel personnel6=new Personnel.Builder("Gillot-Roux","Raphaël",date).build();
		Personnel personnel7=new Personnel.Builder("Dupont","Roger",date).build();
		Personnel personnel2=new Personnel.Builder("Hrar","Huy",date).build();
		Personnel personnel5=new Personnel.Builder("Jsry","Martin",date).build();
		
		// Creation liste personnel
		CompositePersonnels liste4=new CompositePersonnels(4);
		CompositePersonnels liste3=new CompositePersonnels(3);
		CompositePersonnels liste1=new CompositePersonnels(1);
		
		// Création de la hierarchie
		liste4.add(personnel6);
		liste4.add(personnel7);
		
		//liste4.print();
		
		liste3.add(personnel5);
		liste3.add(liste4);
		
		//liste3.print();
		
		liste1.add(personnel2);
		liste1.add(liste3);
		
		//liste1.print();
		
		AffichageParGroupe affGrp = new AffichageParGroupe(liste1);
		for(Iterator iter = affGrp.getIterator();iter.hasNext();) {
		    iter.next().print();
		}
		
	}

}
