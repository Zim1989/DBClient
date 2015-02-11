package Panels;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DetailContainer {

    protected ArrayList<JPanel> detailPanel;
    protected JPanel active;
    protected Start.OracleConnector oc;
    protected final PropertyChangeSupport pcs;
   

    public DetailContainer(Start.OracleConnector oc) {
        this.pcs = new PropertyChangeSupport(this);
        this.oc = oc;
        detailPanel = new ArrayList<JPanel>();
        detailPanel.add(new DefaultPanel(this));
        active = detailPanel.get(0);
    }

    public JPanel getActivePanel() {

        return active;
    }

    public void changeActive(String s) {
        
        active = detailPanel.get(0);
        ((DefaultPanel)active).changelabel();
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
