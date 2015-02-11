/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Panels.DetailContainer;
import Panels.TreePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noito_000
 */
public class DefaultPanel extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form DefaultPanel
     */
    private DetailContainer dc;
    private Start.OracleConnector oc;
    private String objekt;
    
    public DefaultPanel(DetailContainer dc) {
        this.dc = dc;
        oc = dc.getOracleConnector();
        
        initComponents();
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
        jLabel11.setText("");
    }
    public void setString(String o) {
        objekt = o;
    }
    public void callDb() {
        Statement st;
        ResultSet result;
        try {
            st = oc.dbcon.createStatement();
            if(st==null){
                return;
            }
            result = st.executeQuery("select a.NAME, b.name, c.name, d.name from BAUMASSNAHME a, objekt b, auftragnehmer c, fachamt d where a.OBJEKT_IDOBJEKT=b.IDOBJEKT and a.AUFTRAGNEHMER_IDAUFNEHMER =c.IDAUFNEHMER and a.FACHAMT_IDAMT = d.IDAMT and a.name = '"+objekt+"'");
            String name;
            while (result.next()) {
                name = result.getString(1);
                jLabel1.setText(name);
                jLabel6.setText(result.getString(2));
                jLabel13.setText(result.getString(4));
                jLabel12.setText(result.getString(3));
                System.out.println(name);
            }
//            st.close();
            result = st.executeQuery("select b.name from MITARBEITER b, BAUMASSNAHME a where a.name='"+objekt+"' and  a.IDMASSNAHME = b.BAUMASSNAHME_IDMASSNAHME");
            int counter = 7;

                
            while (result.next()) {
                name = result.getString(1);
                switch(counter++) {
                    case 7:
                        jLabel7.setText(result.getString(1));
                        break;
                    case 8:
                        jLabel8.setText(result.getString(1));
                        break;
                    case 9:
                        jLabel9.setText(result.getString(1));
                        break;
                    case 10:
                        jLabel10.setText(result.getString(1));
                        break;
                    case 11:
                        jLabel11.setText(result.getString(1));
                        break;
                }                
            }
            st.close();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(TreePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void changelabel(String s){
        
        //count++;
        //this.lblDefaultpanel.setText(s);//""+count+"");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dc.changed();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(5, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Titel");
        add(jLabel1);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Objektname");
        jPanel4.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fachamt");
        jPanel4.add(jLabel3, java.awt.BorderLayout.PAGE_END);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel6");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, java.awt.BorderLayout.CENTER);

        add(jPanel4);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Auftragnehmer");
        jPanel1.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mitarbeiter");
        jPanel3.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.GridLayout(1, 5));

        jLabel7.setText("jLabel7");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel7);

        jLabel8.setText("jLabel8");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel8);

        jLabel9.setText("jLabel9");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel9);

        jLabel10.setText("jLabel10");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10);

        jLabel11.setText("jLabel11");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        if(jLabel7.getText()=="") {
            return;
        }
        dc.changeActive(jLabel1.getText()+"$$"+jLabel7.getText()+"##Mitarbeiter" );
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if(jLabel8.getText()=="") {
            return;
        }
        dc.changeActive(jLabel1.getText()+"$$"+jLabel8.getText()+"##Mitarbeiter" );
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(jLabel9.getText()=="") {
            return;
        }
        dc.changeActive(jLabel1.getText()+"$$"+jLabel9.getText()+"##Mitarbeiter" );
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if(jLabel10.getText()=="") {
            return;
        }
        dc.changeActive(jLabel1.getText()+"$$"+jLabel10.getText()+"##Mitarbeiter" );
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        if(jLabel11.getText()=="") {
            return;
        }
        dc.changeActive(jLabel1.getText()+"$$"+jLabel11.getText()+"##Mitarbeiter" );
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if(jLabel6.getText()=="") {
            return;
        }
        dc.changeActive(jLabel6.getText()+"$$"+jLabel1.getText()+"##Mitarbeiter" );

     }//GEN-LAST:event_jLabel6MouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
