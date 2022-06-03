/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.ModelParkirImpls;
import View.ViewParkir;
/**
 *
 * @author user
 */
public class ControllerParkir {
    ModelParkirImpls modelParkir;
    ViewParkir parkirView;
    private Integer dataTerpilih;
    private String namaParkirTerpilih;
    
    public ControllerParkir(ModelParkirImpls modelParkir, ViewParkir parkirView) {
        this.modelParkir = modelParkir;
        this.parkirView = parkirView;
        
        if (modelParkir.getBanyakData()!=0) {
            String dataParkir[][] = modelParkir.readData();
            parkirView.tabel.setModel((new JTable(dataParkir, parkirView.namaKolom)).getModel());
            parkirView.tabel.removeColumn(parkirView.tabel.getColumnModel().getColumn(5));
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        parkirView.tabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mousePressed(e);
               String data;
               int baris = parkirView.tabel.getSelectedRow();
               data = parkirView.tabel.getModel().getValueAt(parkirView.tabel.getSelectedRow(),5).toString();
               dataTerpilih = Integer.parseInt(data);
               namaParkirTerpilih = parkirView.tabel.getValueAt(baris, 0).toString();          
               parkirView.setPNomor(parkirView.tabel.getValueAt(baris, 0).toString());
               /*parkirView.setJbarang(parkirView.tabel.getValueAt(baris, 1).toString());*/
               parkirView.setjenisKen(parkirView.tabel.getValueAt(baris, 1).toString());
               parkirView.setHParkir(parkirView.tabel.getValueAt(baris, 2).toString());
   }
        });

        parkirView.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                if(parkirView.getPlatNomor().isBlank()){ 
                    throw new IllegalArgumentException("Plat Nomor belum terisi");
                }
                /*if(parkirView.getJumlahBarang().isBlank()){
                     throw new IllegalArgumentException("Jumlah Barang belum terisi");
                }*/
                if(parkirView.getJenisKendaraan().isBlank()){
                    
                     throw new IllegalArgumentException("Jenis Kendaraan belum terisi");
                }
                if(parkirView.getHargaParkir().isBlank()){
                     throw new IllegalArgumentException("Harga Parkir belum terisi");
                }
               
                
                String plat = parkirView.getPlatNomor();
                /*int jumlah = Integer.parseInt(parkirView.getJumlahBarang());*/
                String jenis = parkirView.getJenisKendaraan();
                String harga = parkirView.getHargaParkir();
                modelParkir.insertData(plat, jenis, harga);
                String dataParkir[][] = modelParkir.readData();
                parkirView.tabel.setModel((new JTable(dataParkir, parkirView.namaKolom)).getModel());
                parkirView.tabel.removeColumn(parkirView.tabel.getColumnModel().getColumn(5));
                parkirView.setPNomor("");
                /*parkirView.setJbarang("");*/
                parkirView.setjenisKen("");
                parkirView.setHParkir("");
            }catch(Exception error){
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }
            
        });
        
        parkirView.btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                if(dataTerpilih == null){
                    throw new IllegalArgumentException("Anda belum memilih kendaraan");
                }
                int id = dataTerpilih;

                if(parkirView.getPlatNomor().isBlank()){ 
                    throw new IllegalArgumentException("Plat Nomor belum terisi");
                }
                /*if(parkirView.getJumlahBarang().isBlank()){
                     throw new IllegalArgumentException("Jumlah Barang belum terisi");
                }*/
                if(parkirView.getJenisKendaraan().isBlank()){
                    
                     throw new IllegalArgumentException("Jenis Kendaraan belum terisi");
                }
                if(parkirView.getHargaParkir().isBlank()){
                     throw new IllegalArgumentException("Harga Parkir belum terisi");
                }
                String plat = parkirView.getPlatNomor();
                /*int jumlah = Integer.parseInt(parkirView.getJumlahBarang());*/
                String jenis = parkirView.getJenisKendaraan();
                String harga = parkirView.getHargaParkir();
                modelParkir.updateData(id, plat, jenis, harga);
                String dataParkir[][] = modelParkir.readData();
                parkirView.tabel.setModel((new JTable(dataParkir, parkirView.namaKolom)).getModel());
                parkirView.tabel.removeColumn(parkirView.tabel.getColumnModel().getColumn(5));
                dataTerpilih = null;
                parkirView.setPNomor("");
                /*parkirView.setJbarang("");*/
                parkirView.setjenisKen("");
                parkirView.setHParkir("");
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, error.getMessage());
                }
                
            }
        });
        
        parkirView.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                parkirView.setPNomor("");
                /*parkirView.setJbarang("");*/
                //parkirView.setjenisKen("");
                parkirView.setHParkir("");
            }
        });
        
        parkirView.btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               try{
                if(dataTerpilih == null){
                    throw new IllegalArgumentException("Anda belum memilih kendaraan yang ingin Keluar");
                }
                int id = dataTerpilih;
                
                String platNomor = namaParkirTerpilih;
                int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin mengeluarkan kendaraan " + platNomor + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if(input == 0){
                    modelParkir.deleteData(id);
                    String dataParkir[][] = modelParkir.readData();
                    parkirView.tabel.setModel((new JTable(dataParkir, parkirView.namaKolom)).getModel());
                    parkirView.tabel.removeColumn(parkirView.tabel.getColumnModel().getColumn(5));
                    dataTerpilih = null;
                    parkirView.setPNomor("");
                    /*parkirView.setJbarang("");*/
                    parkirView.setjenisKen("");
                    parkirView.setHParkir("");
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Keluar");
                }
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
            }
        });
    }
    
    
}
