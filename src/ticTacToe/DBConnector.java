

package ticTacToe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBConnector {
     static org.apache.log4j.Logger log= org.apache.log4j.Logger.getLogger(TicTacToeGame.class);
    
        Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

        
    //constructor to initialise connection
    public DBConnector() {
        
                 try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/tictactoe?"+"user=root&password=");
			
		} catch (ClassNotFoundException | SQLException e) {
		System.out.println("Cant connect");
                log.error("Database connection error");
		}
    }
    
    
    
    //method to add a new player to the database
    
    public void addNewPlayer(String name){
        
        String insert="INSERT INTO stat(player)values('"+name+"')";
		try {
			preparedStatement = con.prepareStatement(insert);
			preparedStatement.execute();
                        log.info("New player "+name+" added");
                        
		} catch (SQLException e) {
                    log.error(name+" player exits");
                    
		}catch(Exception e){
                    log.error("Connection failed.");
                }
        
    }
    
    
    //method to update winning statistics
    public void updateWin(String name){
        
         String insert="UPDATE  stat SET win=win+1 WHERE player='"+name+"'";
		try {
			preparedStatement = con.prepareStatement(insert);
			preparedStatement.execute();
                        
		} catch (SQLException e) {
                    
                   log.error("Error updating");
                    
		}catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error in Connection to database.Updating data failed");
                    log.error("Error updating");
                }
        
    }
    
    
    //method to update loosing statistics
    public void updateLoss(String name){
        
         String insert="UPDATE  stat SET loss=loss+1 WHERE player='"+name+"'";
		try {
			preparedStatement = con.prepareStatement(insert);
			preparedStatement.execute();
                        
		} catch (SQLException e) {
                    
                    log.error("Error updating ");
		}catch(Exception e){
                    log.error("Error updating");
                }
        
        
    }
        
    //method to update tie statistics
     public void updateTie(String name,String name2){
        
         String insert="UPDATE  stat SET tie=tie+1 WHERE player='"+name+"'";
         String insert2="UPDATE  stat SET tie=tie+1 WHERE player='"+name2+"'";
		try {
			preparedStatement = con.prepareStatement(insert);
			preparedStatement.execute();
                        
                        preparedStatement = con.prepareStatement(insert2);
			preparedStatement.execute();
                        
		} catch (SQLException e) {
                    
                    log.error("Error updating tie");
		}catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error in Connection to database.Updating data failed");
                    log.error("Error updating");
                }
        
        
    }
     
     //method to load table to the StatWindow
     public void getStat(DefaultTableModel model,JTable table){
         
         String insert="SELECT * FROM stat";
		try {
			preparedStatement = con.prepareStatement(insert);
			resultSet = preparedStatement.executeQuery();
                        
		} catch (SQLException e) {
                   
                    log.error("Error in Connection to database.Updating data failed");
		}catch(Exception e){
                     JOptionPane.showMessageDialog(null,"Error in Connection to database");
                    log.error("Error reading from db");
                }
         
         
         
            try {
                while(resultSet.next())
                {
                    
                    model=(DefaultTableModel) table.getModel();
                    Object[] ob={resultSet.getString("player"), resultSet.getInt("win"),resultSet.getInt("loss"), resultSet.getInt("tie")};
                    model.addRow(ob);
                    

                }    } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error in Connection to database");
                log.error("Error loading the statistics");
                
            }catch(Exception e){
                    log.error("Error reading from db");
                }
         
         
     }
        
}
