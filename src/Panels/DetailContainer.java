package Panels;


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
        detailPanel.add(new DefaultPanel(this));
        active = detailPanel.get(0);
    }
    public String[] getData(String statment) {
        Statement st;
        ResultSet result;
        try {
            st = oc.dbcon.createStatement();
            if(st==null){
                return null;
            }
            result = st.executeQuery("SELECT name FROM Baumassnahme");
            String name;
            while (result.next()) {
                name = result.getString(1);
                System.out.println(name);
            }
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(TreePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public void changeActive(String s) {
        
        String name;
        try {
            name = s.substring(0, s.indexOf("##") );
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            name = "nüscht";
        }
        System.out.println(name);
        active = detailPanel.get(0);
        ((DefaultPanel)active).changelabel();
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
