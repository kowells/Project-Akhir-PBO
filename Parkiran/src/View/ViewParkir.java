package View;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewParkir extends JFrame {

    private JPanel contentPane;

    private JTextField PNomor;
    private JTextField Jbarang;
    private JTextField JenisKend;
    private JTextField HParkir;
    public JTable tabel;

    // masuk
    ImageIcon img2 = new ImageIcon(ImageIO.read(new File("./asset/in.jpg")));
    public JButton btnTambah = new JButton(img2);

    // hapus
    ImageIcon img3 = new ImageIcon(ImageIO.read(new File("./asset/hps.png")));
    public JButton btnDelete = new JButton(img3);

    // keluar
    ImageIcon img4 = new ImageIcon(ImageIO.read(new File("./asset/out.png")));
    public JButton btnUpdate = new JButton(img4);

    // reset
    ImageIcon img5 = new ImageIcon(ImageIO.read(new File("./asset/reset.png")));
    public JButton btnClear = new JButton(img5);

    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Plat Nomor", "Jenis Kendaraan", "Harga Parkir",
            "Waktu Masuk", "Waktu Keluar", ""};

    public ViewParkir() throws IOException {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm)
        {
            public boolean isCellEditable(int row, int column)
            {
              return false;
            }
  
        };
        scrollPane = new JScrollPane(tabel);
        tabel.removeColumn(tabel.getColumnModel().getColumn(5));
        
        tabel.setFocusable(false);
        tabel.setRowSelectionAllowed(true);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1149, 598);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(4, 4, 4, 4));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg = new JPanel();
        bg.setBounds(0, 0, 1135, 561);
        contentPane.add(bg);
        bg.setLayout(null);
        ImageIcon img = new ImageIcon(ImageIO.read(new File("./asset/ikonkiri.png")));
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(161, 166, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);

        scrollPane.setBounds(227, 122, 733, 439);
        bg.add(scrollPane);

        JLabel labelplatnomor = new JLabel("Plat Nomor");
        labelplatnomor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelplatnomor.setForeground(Color.BLACK);
        labelplatnomor.setBounds(970, 134, 85, 17);
        bg.add(labelplatnomor);

        PNomor = new JTextField();
        PNomor.setBounds(970, 161, 143, 25);
        bg.add(PNomor);
        PNomor.setColumns(10);

        /*JLabel labeljumlahbarang = new JLabel("Jumlah Barang");
        labeljumlahbarang.setForeground(Color.BLACK);
        labeljumlahbarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labeljumlahbarang.setBounds(970, 196, 94, 17);
        bg.add(labeljumlahbarang);

        Jbarang = new JTextField();
        Jbarang.setColumns(10);
        Jbarang.setBounds(970, 223, 143, 25);
        bg.add(Jbarang);*/

        JLabel labeljeniskendaraan = new JLabel("Jenis Kendaraan");
        labeljeniskendaraan.setForeground(Color.BLACK);
        labeljeniskendaraan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labeljeniskendaraan.setBounds(970, 196, 150, 17);
        bg.add(labeljeniskendaraan);

       /* JenisKend = new JTextField();
        JenisKend.setColumns(10);
        JenisKend.setBounds(970, 223, 143, 25);
        bg.add(JenisKend); */
       
        String[] kendaraan = {"motor", "mobil","pesawat"};
        JComboBox JenisKend = new JComboBox(kendaraan);
        JenisKend.setBounds(970, 223, 143, 25);
        bg.add(JenisKend);
        
        
        /*JComboBox<String> JenisKend = new JComboBox<>();
        JenisKend.setBounds(970, 223, 143, 25);
            bg.add (JenisKend);
            JenisKend.addItem(" ");
            JenisKend.addItem("motor");
            JenisKend.addItem("mobil");
            JenisKend.addItem("pesawat"); */

        JLabel labelharga = new JLabel("Harga Parkir");
        labelharga.setForeground(Color.BLACK);
        labelharga.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelharga.setBounds(970, 258, 80, 17);
        bg.add(labelharga);

        HParkir = new JTextField();
        HParkir.setColumns(10);
        HParkir.setBounds(970, 285, 143, 25);
        bg.add(HParkir);

        // Button Tambah
        btnTambah.setBounds(985, 344, 36, 32);
        bg.add(btnTambah);

        JLabel lblNewLabel_3 = new JLabel("Masuk");
        lblNewLabel_3.setBounds(985, 380, 45, 13);
        bg.add(lblNewLabel_3);

        // button delete

        btnDelete.setBounds(1049, 344, 36, 32);
        bg.add(btnDelete);

        JLabel lblNewLabel_3_1 = new JLabel("Hapus");
        lblNewLabel_3_1.setBounds(1049, 380, 45, 13);
        bg.add(lblNewLabel_3_1);

        // Button Update
        btnUpdate.setBounds(985, 417, 36, 32);
        bg.add(btnUpdate);

        JLabel lblNewLabel_3_2 = new JLabel("Keluar");
        lblNewLabel_3_2.setBounds(985, 455, 45, 13);
        bg.add(lblNewLabel_3_2);

        // Button Clear
        btnClear.setBounds(1049, 417, 36, 32);
        bg.add(btnClear);

        JLabel lblNewLabel_3_2_1 = new JLabel("Reset");
        lblNewLabel_3_2_1.setBounds(1049, 455, 45, 13);
        bg.add(lblNewLabel_3_2_1);

        // Panel
        JPanel side = new JPanel();
        side.setBackground(new Color(240,240,240));
        side.setBounds(0, 0, 227, 561);
        bg.add(side);
        side.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(img);
        lblNewLabel.setBounds(28, 168, 161, 166);
        side.add(lblNewLabel);

        JLabel sidelabel1 = new JLabel("APLIKASI PARKIR");
        sidelabel1.setFont(new Font("Tahoma", Font.BOLD, 18));
        sidelabel1.setForeground(Color.BLACK);
        sidelabel1.setBounds(30, 45, 211, 22);
        side.add(sidelabel1);

        JLabel sidelabel2 = new JLabel("KENDARAAN\r\n");
        sidelabel2.setForeground(Color.BLACK);
        sidelabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
        sidelabel2.setBounds(56, 75, 200, 22);
        side.add(sidelabel2);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,127,0));
        panel.setBounds(227, 0, 908, 122);
        bg.add(panel);
        panel.setLayout(null);

        JLabel datagudang = new JLabel("DATA KENDARAAN");
        datagudang.setBounds(250, 50, 500, 28);
        datagudang.setForeground(Color.WHITE);
        datagudang.setFont(new Font("Tahoma", Font.BOLD, 38));
        panel.add(datagudang);

        setVisible(true);
    }

    public String getPlatNomor() {
        return PNomor.getText();
    }

    /*public String getJumlahBarang() {
        return Jbarang.getText();
    }*/

    public String getJenisKendaraan() {
        return JenisKend.getText();
    }

    public String getHargaParkir() {
        return HParkir.getText();
    }

    public void setPNomor(String string) {
        this.PNomor.setText(string);
    }

    /*public void setJbarang(String string) {
        this.Jbarang.setText(string);
    }*/

    public void setjenisKen(String string) {
        this.JenisKend.setText(string);
    }

    public void setHParkir(String string) {
        this.HParkir.setText(string);
    }

}
