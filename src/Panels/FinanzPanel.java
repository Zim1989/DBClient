/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;


import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;

/**
 *
 * @author Marco
 */
public class FinanzPanel extends javax.swing.JPanel {

    /**
     * Creates new form FinanzPanel
     */
    private DefaultPieDataset pieDataset;
    private JFreeChart chart1;
    private ChartPanel chartPanel2;
    
    public FinanzPanel() {
        initComponents();
        
    /*pieDataset.setValue("vorhanden", 75);
    pieDataset.setValue("ausgegeben", 25);
    chart1 = new ChartFactory.createPieChart("test", pieDataset, true, false,false);
    chartPanel2 = new ChartPanel(chart1);
    this.add(chartPanel2, BorderLayout.NORTH);*/
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
}
