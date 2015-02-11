package Panels;


import KonstantenKlassen.ConstantStrings;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;


public class DetailContainer {

    protected ArrayList<JPanel> detailPanel;
    protected JPanel active;
    protected Start.OracleConnector oc;
    protected final PropertyChangeSupport pcs;
    private ResultSet result;
    private Statement st;
   

    public DetailContainer(Start.OracleConnector oc) {
        this.pcs = new PropertyChangeSupport(this);
        this.oc = oc;
        detailPanel = new ArrayList<JPanel>();
        
        detailPanel.add(new Panels.DefaultPanel(this));
        detailPanel.add(new FinanzPanel());
        detailPanel.add(new BeteiligetePanel());
        detailPanel.add(new MitarbeiterPanel(this));
        active = detailPanel.get(0);
    }
  
    public void dbTest() {
        Statement st;
        ResultSet result;
        try {
            st = oc.dbcon.createStatement();
            if(st==null){
                return;
            }
            result = st.executeQuery("SELECT name FROM Baumassnahme");
            String name;
            while (result.next()) {
                name = result.getString(1);
                System.out.println(name);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TreePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public JPanel getActivePanel() {
        return active;
    }

    public Start.OracleConnector getOracleConnector() {
        return oc;
    }
    public void changeActive(String s) {
        
        String name;
        String view;
        try {
            name = s.substring(0, s.indexOf("##") );
            System.out.println("---||"+name);
            view = s.substring(s.indexOf("##")+2, s.length());
            switch(view){
                case "Allgemein":
                    System.out.println(">HHHHH");
                    active = detailPanel.get(0);
                    ((DefaultPanel)active).setString(name);
                    ((DefaultPanel)active).callDb();
                    changed();
                    break;
                case "Beteiligte":                    
                    active = detailPanel.get(3);
                    ((MitarbeiterPanel)active).setName("Simon Horn", name);
                    ((MitarbeiterPanel)active).callDb();
                    changed();
                    break;
                case "Finanzen":
                    active = detailPanel.get(1);
                    changed();
                    break;
                default:
                    active = detailPanel.get(0);
                    changed();
            }
            active.repaint();
            //((DefaultPanel)active).changelabel(name);
            
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            name = "nüscht";
            view = "keine";
        }
        System.out.println(name);
        System.out.println(view);
            
        //dbTest();
		//new JDialog(null, "test");
        //JOptionPane.showMessageDialog(null, "Test", "Test Titel", JOptionPane.OK_CANCEL_OPTION);
    }
    
    public void changed(){
        pcs.firePropertyChange("change", active, 1);
    }
    
     public void addListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }
}
