
package ticTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thilini
 */
public class StatWindow extends JFrame{
    
    DBConnector db;
    JPanel imagepanel;
    ResultSet rg;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    JButton back;

    public StatWindow() {
        
        
        //creating databse connector object
        db = new DBConnector();
        
        //set properties of jframe
        setTitle("Statistics");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        imagepanel = new JPanel();
        imagepanel.setBackground(new Color(3,2,155));        
        add(imagepanel);
        
        //creating the table
         table = new JTable();
         scrollPane = new JScrollPane(table);
         
          model=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Win", "Loss", "Tie"
            }
        );
        table.setModel(model);        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setOpaque(true);
        table.setBackground(new Color(3,2,155));
        table.setForeground(Color.YELLOW);
        table.setShowGrid(false);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );

        
       scrollPane.setViewportView(table);
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        db.getStat(model, table);
        
           imagepanel.add(scrollPane, BorderLayout.CENTER);
           
           
           back = new JButton("Home");
           
           back.addActionListener((ActionEvent e) -> {
               setVisible(false);
        });
           
           imagepanel.add(back);
           
    }
    
   
    
    
    
    
    
}
