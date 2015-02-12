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
        
        detailPanel.add(new Panels.DefaultPanel(this)); //0
        detailPanel.add(new FinanzPanel(this)); //1
        detailPanel.add(new BeteiligetePanel()); //2
        detailPanel.add(new MitarbeiterPanel(this)); //3
        detailPanel.add(new ObjektPanel(this)); //4
        detailPanel.add(new FachamtPanel(this)); //5
        detailPanel.add(new AuftragnehmerPanel(this)); //6
        detailPanel.add(new FinanzplanPanel(this)); //7
        
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
                    active = detailPanel.get(0);
                    ((DefaultPanel)active).setString(name);
                    ((DefaultPanel)active).callDb();
                    changed();
                    break;
                case "Objekt":
                    String objekt = s.substring(s.indexOf("$$")+2, s.indexOf("##"));
                    name = s.substring(0, s.indexOf("$$"));
                    active = detailPanel.get(4);
                    ((ObjektPanel)active).setName(objekt, name);
                    ((ObjektPanel)active).callDb();
                    changed();
                    break;
             case "Mitarbeiter":
                    String mitarbeiter = s.substring(s.indexOf("$$")+2, s.indexOf("##"));
                    name = s.substring(0, s.indexOf("$$"));
                    active = detailPanel.get(3);
                    ((MitarbeiterPanel)active).setName(mitarbeiter, name);
                    ((MitarbeiterPanel)active).callDb();
                    changed();
                    break;
                case "Fachamt":
                    String fachamt = s.substring(s.indexOf("$$")+2, s.indexOf("##"));
                    name = s.substring(0, s.indexOf("$$"));
                    active = detailPanel.get(5);
                    ((FachamtPanel)active).setName(name, fachamt);
                    ((FachamtPanel)active).callDb();
                    changed();
                    break;
                case "Auftragnehmer":
                    String auftragnehmer = s.substring(s.indexOf("$$")+2, s.indexOf("##"));
                    name = s.substring(0, s.indexOf("$$"));
                    active = detailPanel.get(6);
                    ((AuftragnehmerPanel)active).setName(name, auftragnehmer);
                    ((AuftragnehmerPanel)active).callDb();
                    changed();
                    break;
/*                case "Beteiligte":                    
                    active = detailPanel.get(3);
                    ((MitarbeiterPanel)active).setName("Simon Horn", name);
                    ((MitarbeiterPanel)active).callDb();
                    changed();
                    break;
*/                case "Finanzen":
                    active = detailPanel.get(7);
                    ((FinanzplanPanel)active).setName(name);
                    ((FinanzplanPanel)active).callDb();
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
