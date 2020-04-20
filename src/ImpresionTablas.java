import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.GridLayout;

import java.util.ArrayList;

public class ImpresionTablas extends JPanel {

    public ImpresionTablas(ArrayList<Micro> micros) {
        
        super(new GridLayout(micros.size(),0));

        ArrayList<Micro> microsList = micros;
        ArrayList<Proceso> procesos = new ArrayList<>();

        String[] columnNames = {"Proceso", "TCC", "TE", "TVC", "TB", "TT", "TI", "TF"};


        for(Micro m: microsList){
            
            String microId = Integer.toString(m.getId());
            
            JPanel panel = new JPanel ();
            panel.setBorder (BorderFactory.createTitledBorder 
                                (BorderFactory.createEtchedBorder (),
                                                "Micro " + microId,
                                                TitledBorder.CENTER,
                                                TitledBorder.TOP));
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            procesos = m.getTerminados();
            String proceso;
            int tcc, te, tvc, tb, tt, ti, tf;
            for(Proceso p: procesos){
                proceso = p.getId();
                tcc = p.getTCC();
                te = p.getExeTime();
                tvc = p.getTVC(); 
                tb = p.getTB();
                tt = p.getTotal(); 
                ti = p.gettInicial();
                tf = p.gettFinal();
                Object[] tableRow = {proceso,tcc,te,tvc,tb,tt,ti,tf};
                tableModel.addRow(tableRow);
            }
            

            final JTable table = new JTable();
            table.setModel(tableModel);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);
            
            panel.add(scrollPane);
            panel.setBackground(new Color(115, 185, 255));
            JScrollPane scrollPaneForPanel = new JScrollPane(panel);
            add(scrollPaneForPanel);
        }

    }

    public void createAndShowGUI(ArrayList<Micro> microsListCreate) {
        //Create and set up the window.
        JFrame frame = new JFrame("Despachador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Create and set up the content pane.
        ImpresionTablas newContentPane = new ImpresionTablas(microsListCreate);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
