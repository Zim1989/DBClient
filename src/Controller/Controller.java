/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Marco
 */
public class Controller {
    
    private Frames.MainFrame frame;
    private Start.OracleConnector connector;
    
    public Controller(Frames.MainFrame frame, Start.OracleConnector connector){
        this.frame = frame;
        this.connector = connector;
    }
}
