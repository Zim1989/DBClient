/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noito_000
 */
public class FachamtPanel extends javax.swing.JPanel {

    /**
     * Creates new form FachamtPanel
     */
    private DetailContainer dc;
    private String name;
    private String projekt;
    private ResultSet result;
    private Statement st;
    
    public FachamtPanel(DetailContainer dc) {
        this.dc = dc;
        initComponents();
    }
    
    public void setName(String name, String projekt) {
        this.projekt = projekt;
        this.name = name;
        //System.out.println("..."+name);
        //System.out.println("..."+projekt);
        
    }
    
    public void callDb() {
        try {
            st = this.dc.getOracleConnector().dbcon.createStatement();
            
            result = st.executeQuery("select name, adresse" +
                    " from fachamt where name = '"+name+"'");
            while(result.next()){ 
                this.jTextField1.setText(result.getString(1));
                this.jTextField2.setText(result.getString(2));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MitarbeiterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Fachamt");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(4, 0));

        jTextField1.setText("Name");
        jPanel1.add(jTextField1);

        jTextField2.setText("Adresse");
        jPanel1.add(jTextField2);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        jButton2.setText("Abbrechen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton1.setText("Speichern");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dc.changeActive(projekt+KonstantenKlassen.ConstantStrings.SEPARATOR+KonstantenKlassen.ConstantStrings.SUMMARY);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            st = this.dc.getOracleConnector().dbcon.createStatement();
            int i = st.executeUpdate("update fachamt set name='"+this.jTextField1.getText()+"', adresse='"+this.jTextField2.getText()+
                    "' where name='"+name+"'");
            dc.changeActive(projekt+KonstantenKlassen.ConstantStrings.SEPARATOR+KonstantenKlassen.ConstantStrings.SUMMARY);
        } catch (SQLException ex) {
            Logger.getLogger(MitarbeiterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
