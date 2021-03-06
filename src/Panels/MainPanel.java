/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

/**
 *
 * @author Marco
 */
public class MainPanel extends javax.swing.JPanel implements PropertyChangeListener{

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        
    }
    
    public void initTree(Start.OracleConnector con){
        this.con = con;
        naviPanel2.initTree(con);
    }
    
    public void initDetails(Start.OracleConnector con){
        this.con = con;
        details = new DetailContainer(this.con);
        detailPanel = details.getActivePanel();
        add(detailPanel);
        details.addListener(this.naviPanel2.getTree());
        details.addListener(this);
        this.naviPanel2.getTree().addListener(this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titelPanel1 = new Panels.TitelPanel();
        naviPanel2 = new Panels.NaviPanel();

        setLayout(new java.awt.BorderLayout());
        add(titelPanel1, java.awt.BorderLayout.PAGE_START);
        add(naviPanel2, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panels.NaviPanel naviPanel2;
    private Panels.TitelPanel titelPanel1;
    // End of variables declaration//GEN-END:variables
    private Start.OracleConnector con;
    private DetailContainer details;
    private JPanel detailPanel;
   

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        details.changeActive(evt.getPropertyName());
        this.remove(detailPanel);
        detailPanel = details.getActivePanel();
        this.add(detailPanel);
        this.revalidate();
        this.repaint();
       
    }
}
