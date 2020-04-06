package com.gillotroux;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PersonnelDAOTest {

    @Test
    public void test() {
        
        DAO<Personnel> personnelDAO = new PersonnelDAO();
        LocalDate date=LocalDate.now();
        
        Personnel personnel1=new Personnel.Builder("Gillot-Roux","Raphaël",date).build();
        Personnel personnel2=new Personnel.Builder("Gillot-Roux","Roger",date).build();
        
        System.out.println(personnelDAO.create(personnel1));
        System.out.println(personnelDAO.find("Gillot-Roux"));
        System.out.println(personnelDAO.update(personnel2));

        
        personnelDAO.delete(personnel1);
        
    }

}
