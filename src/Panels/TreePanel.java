/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Invader Zim
 */
public class TreePanel extends javax.swing.JPanel implements
        TreeSelectionListener, PropertyChangeListener {

    private JTree naviTree;
    private javax.swing.JScrollPane jScrollPane1;
    private Start.OracleConnector con;
    private ResultSet result;
    private Statement st;
    protected final PropertyChangeSupport pcs;

    public TreePanel() {
        initComponents();
        this.pcs = new PropertyChangeSupport(this);
    }

    public void initTree(Start.OracleConnector con) {
        this.con = con;
        jScrollPane1 = new JScrollPane();
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Projekte");
        createNodes(top);
        naviTree = new JTree(top);
        naviTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        naviTree.addTreeSelectionListener(this);
        jScrollPane1.setViewportView(naviTree);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode projekt;
        DefaultMutableTreeNode view;
        try {
            st = con.dbcon.createStatement();
            if(st==null){
                return;
            }
            result = st.executeQuery("SELECT name FROM Baumassnahme");
            String name;
            while (result.next()) {
                name = result.getString(1);
                projekt = new DefaultMutableTreeNode(name);
                top.add(projekt);
                view = new DefaultMutableTreeNode(KonstantenKlassen.ConstantStrings.SUMMARY);
                projekt.add(view);
                view = new DefaultMutableTreeNode(KonstantenKlassen.ConstantStrings.PERSONS);
                projekt.add(view);
                view = new DefaultMutableTreeNode(KonstantenKlassen.ConstantStrings.MONEY);
                projekt.add(view);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TreePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void deleteNote(String name) {
        //this.naviTree.get
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) naviTree.getLastSelectedPathComponent();

        if (node == null) //Nothing is selected.     
        {
            return;
        }
        String name = (String) node.getUserObject();
        //node.get
        if (!(node.isRoot())) {
            pcs.firePropertyChange("change", null, 1);
        }
    }
    
    public void addListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "change":
                System.out.println("schmu");
                break;
        }
    }
}
