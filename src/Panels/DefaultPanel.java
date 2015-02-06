package Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JButton;

public class DefaultPanel extends JPanel implements ActionListener {

    /**
     * Create the panel.
     */
    protected int count = 0;
    JLabel lblDefaultpanel;
    JButton jimmini;
    private DetailContainer dc;
    
    public DefaultPanel(DetailContainer dc) {
        this.dc = dc;
        this.setLayout(new BorderLayout());
        lblDefaultpanel = new JLabel("DefaultPanel");
        jimmini = new JButton("start event");
        lblDefaultpanel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        add(lblDefaultpanel, BorderLayout.NORTH);
        add(jimmini, BorderLayout.CENTER);
        setPreferredSize(new Dimension(300, 500));
        jimmini.addActionListener(this);

    }
    
    public void changelabel(){
        count++;
        this.lblDefaultpanel.setText(""+count+"");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dc.changed();
    }
    
   

}
