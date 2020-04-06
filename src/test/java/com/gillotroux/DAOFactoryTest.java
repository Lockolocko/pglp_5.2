package com.gillotroux;

import static org.junit.Assert.*;

import org.junit.Test;

public class DAOFactoryTest {

    @Test
    public void test() {
        DAO<Personnel> personnelDAO=DAOFactory.getPersonnelDAO();
        System.out.println(personnelDAO.find("Gillot-Roux"));
    }

}
