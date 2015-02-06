/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Marco
 */
public class OracleConnector {

// private variables to encapsulate database tier
    public Connection dbcon;
    public boolean verbunden;

    public OracleConnector(String info) {

// create database connection and a statement object to sent queries
        System.out.println("Checking if Driver is registered with DriverManager.");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Couldn't find the driver!");
            System.out.println("Let's print a stack trace, and exit.");
            cnfe.printStackTrace();
            return;
        }

        System.out.println("Registered the driver ok, so let's make a connection.");

        try {
    // The second and third arguments are the username and password,
            // respectively. They should be whatever is necessary to connect
            // to the database.
            //psql -h db.f4.htw-berlin.de _s0531362__db2_projekt s0531362
            dbcon = DriverManager.getConnection(info, "christmann",
					"student");
            
        } catch (SQLException se) {
            System.out.println("Couldn't connect: print out a stack trace and exit.");
            se.printStackTrace();
        }

        if (dbcon != null) {
            System.out.println("Hooray! We connected to the database!");
        } else {
            System.out.println("We should never get here.");
        }
    }

}
