package com.gillotroux;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import org.junit.Test;

public class SerializableTest {

    @Test
    public void test() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        LocalDate date=LocalDate.now();
        
         Personnel personnel5=new Personnel.Builder("Jsry","Martin",date).build();
        
        // Creation liste personnel
        CompositePersonnels liste4=new CompositePersonnels(4);
        
        liste4.add(personnel5);
        
        AffichageParGroupe affGrp = new AffichageParGroupe(liste4);
        
        try(ObjectOutputStream out = new ObjectOutputStream(
new BufferedOutputStream(
new FileOutputStream("./objectSerialisable")))) {
            out.writeObject(new Personnel.Builder("Gillot-Roux","Raphaël",date).build());
            out.writeObject(liste4);
            out.writeObject(affGrp);
        }
        
        
        try(ObjectInputStream in = new ObjectInputStream(
new BufferedInputStream(
new FileInputStream("./objectSerialisable")))) {
            Personnel p1=(Personnel)in.readObject();
            System.out.println(p1);
        }
        
    }
    

}
