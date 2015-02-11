/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import Controller.Controller;
import Frames.MainFrame;
import KonstantenKlassen.ConnectionInfo;
import java.sql.SQLException;

/**
 *
 * @author Marco
 */
public class BauProjektVerwaltung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        OracleConnector c = new OracleConnector(ConnectionInfo.PUTTY_CONNECTION);
        MainFrame frame = new MainFrame(c);
        
        //Controller controller = new Controller(frame, c);
        //c.dbcon.close();
    }
    
}
