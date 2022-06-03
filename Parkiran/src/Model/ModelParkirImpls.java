/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 *
 * @author user
 */
public class ModelParkirImpls implements ModelParkir{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/parkiran";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    public ModelParkirImpls() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    @Override
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM catatparkir";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    @Override
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][6]; 
            
            String query = "SELECT * FROM catatparkir"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][5] = String.valueOf(resultSet.getInt("id"));
                data[jmlData][0] = resultSet.getString("plat_nomor");
                data[jmlData][1] = resultSet.getString("jenis");                
                data[jmlData][2] = resultSet.getString("harga");
                data[jmlData][3] = resultSet.getString("masuk");
                data[jmlData][4] = resultSet.getString("keluar");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    @Override
    public void insertData(String plat_nomor, String jenis, String harga){
        int jmlData=0;
        Date dateNow = new Date();
        try {
           
            String query = "INSERT INTO catatparkir(plat_nomor,jenis,harga,masuk)"
                    + " VALUES('"+plat_nomor+"','"+jenis+"','"+harga+"','"+formatter.format(dateNow)+"')";
           
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); 
            System.out.println("Kendaraan Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Kendaraan Berhasil ditambahkan");
            
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    @Override
    public void updateData(int id, String plat_nomor, String jenis, String harga){
        int jmlData=0;
        String keluar = null;
        
        Date dateNow = new Date();
         try {
           String query = "SELECT * FROM catatparkir WHERE id='" + id +"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
                keluar = resultSet.getString("keluar");
            }
           
             if (jmlData==1) {
                if(keluar == null){
                query = "UPDATE catatparkir SET keluar='"+formatter.format(dateNow)+"' WHERE id='" + id+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); 
                System.out.println("Kendaraan Telah Keluar");
                JOptionPane.showMessageDialog(null, "Kendaraan Telah Keluar");
                }else {
                    JOptionPane.showMessageDialog(null, "Kendaraan OUT");
                }

             } 
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    @Override
    public void deleteData (int id) {
        try{
            String query = "DELETE FROM catatparkir WHERE id = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
