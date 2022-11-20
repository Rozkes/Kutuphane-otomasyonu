/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphanetakip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class admin extends javax.swing.JFrame {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Connection conn2 = null;
    Statement stmt2 = null;
    ResultSet rs2 = null;
    Connection conn3;
    Statement komut3;
    ResultSet rs3;
    Connection conn4 = null;
    Statement stmt4 = null;
    ResultSet rs4 = null;
    Connection conn5 = null;
    Statement stmt5 = null;
    ResultSet rs5 = null;
    Connection conn6 = null;
    Statement stmt6 = null;
    ResultSet rs6 = null;
    Connection conn7 = null;
    Statement stmt7 = null;
    ResultSet rs7 = null;
    Connection connd = null;
    Statement stmtd= null;
    ResultSet rsd = null;
    Connection conny = null;
    Statement stmty= null;
    ResultSet rsy = null;
    Connection connko = null;
    Statement stmtko= null;
    ResultSet rsko = null;
    Integer kontrol1, kontrol2;
    PreparedStatement st1;
    private Statement komut7;

    private admin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void baglan() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/KutuphaneTakip", "root", "");
    }

    public void baglan2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn2 = DriverManager.getConnection("jdbc:mysql://localhost/KutuphaneTakip", "root", "");
    }

    public void baglan3() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("sürücü yüklendi");
            conn3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kutuphaneTakip", "root", "");
            System.out.println("VT ye baglandi");
            komut3 = conn3.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs3 = komut3.executeQuery("select * from kitaplar");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException s) {
            System.out.print("baglanamadi" + s.getMessage());

        }
    }
     public void bagland() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("sürücü yüklendi");
            connd = DriverManager.getConnection("jdbc:mysql://localhost:3306/kutuphaneTakip", "root", "");
            System.out.println("VT ye baglandi");
            stmtd = connd.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rsd = stmtd.executeQuery("select * from duyuru");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException s) {
            System.out.print("baglanamadi" + s.getMessage());

        }
    }
       public void baglany() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("sürücü yüklendi");
            conny = DriverManager.getConnection("jdbc:mysql://localhost:3306/kutuphaneTakip", "root", "");
            System.out.println("VT ye baglandi");
            stmty = conny.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rsy = stmty.executeQuery("select * from uyeler");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException s) {
            System.out.print("baglanamadi" + s.getMessage());

        }
    }

    public void baglan4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn4 = DriverManager.getConnection("jdbc:mysql://localhost/KutuphaneTakip", "root", "");
    }

    public void baglan5() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn5 = DriverManager.getConnection("jdbc:mysql://localhost/KutuphaneTakip", "root", "");
    }

    public void baglan6() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("sürücü yüklendi");
            conn6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kutuphaneTakip", "root", "");
            System.out.println("VT ye baglandi");
            stmt6 = conn6.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs6 = stmt6.executeQuery("select * from kitap_onay");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException s) {
            System.out.print("baglanamadi" + s.getMessage());

        }
    }
 public void baglanko() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/KutuphaneTakip", "root", "");
    }
    public void onaytablodoldur() throws SQLException {


        String baslik[] = new String[]{"adi", "kitap adi","kitap_onay"};

        try {
            baglan();

            String sorgu = "select kitap_onay.id,uyeler.adi,kitaplar.kitap_adi,uyeler.id, kitaplar.id,kitap_onay.onay"
                    + " from  uyeler  inner join kitap_onay on uyeler.id=kitap_onay.uid inner join kitaplar  on kitaplar.id=kitap_onay.kid ";


            stmt = conn.createStatement();
            rs = stmt.executeQuery(sorgu);
            // kac tane kayit var onu buluyor
            rs.last();
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            //  JOptionPane.showMessageDialog(rootPane, sorgu);

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;
            while (rs.next()) {
if(rs.getString("kitap_onay.onay").equals("1")){
                data[i] = new Object[]{
                    rs.getInt("kitap_onay.id"),
                    rs.getString("uyeler.adi"),
                    rs.getString("kitaplar.kitap_adi"),
                    rs.getString("kitap_onay.onay")
//                    rs.getInt("onay")    
                };


                //  kontrol1 = rs.getInt("uyeler.id"); 
                i++;
            }}
            conn.close();
            onaytablo.setModel(new DefaultTableModel(data, baslik));
        } catch (Exception ex) {
        }
    }

    public void tablodansil() throws SQLException {


        String baslik[] = new String[]{"id", "adi", "soyadi", "kadi", "sifresi", "yetkisi"};

        try {
            baglan2();

            String sorgu = "select * from uyeler";

            stmt2 = conn2.createStatement();
            rs2 = stmt2.executeQuery(sorgu);

            // kac tane kayit var onu buluyor
            rs2.last();
            int kayitsayisi = rs2.getRow();
            rs2.beforeFirst();


            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs2.next()) {

                data[i] = new Object[]{
                    rs2.getInt("id"),
                    rs2.getString("adi"),
                    rs2.getString("soyadi"),
                    rs2.getString("kadi"),
                    rs2.getInt("sifresi"),
                    rs2.getString("yetkisi")
                };
                i++;
            }
            conn2.close();
            uye.setModel(new DefaultTableModel(data, baslik));
        } catch (Exception ex) {
        }
    }

    public void aratablodoldur(String ad) throws SQLException {

        String gelenad = ad;
        String baslik[] = new String[]{"adi", "soyadi", "yetkisi"};

        try {
            baglan();

            String sorgu = "select * from uyeler where adi like '%" + gelenad + "%'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sorgu);

            // kac tane kayit var onu buluyor
            rs.last();
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();


            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{
                    rs.getString("adi"),
                    rs.getString("soyadi"),
                    rs.getString("yetkisi")
                };
                i++;
            }
            conn.close();
            uye.setModel(new DefaultTableModel(data, baslik));
        } catch (Exception ex) {
        }

    }

    public void aratablodoldur2(String ad) throws SQLException {

        String gelenad = ad;
        String baslik[] = new String[]{"yazar_adi", "yazar_soyadi", "kitap_adi"};

        try {
            baglan4();

            String sorgu = "select * from kitaplar where kitap_adi like '%" + gelenad + "%'";

            stmt4 = conn4.createStatement();
            rs4 = stmt4.executeQuery(sorgu);

            // kac tane kayit var onu buluyor
            rs4.last();
            int kayitsayisi = rs4.getRow();
            rs4.beforeFirst();


            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs4.next()) {

                data[i] = new Object[]{
                    rs4.getString("yazar_adi"),
                    rs4.getString("yazar_soyadi"),
                    rs4.getString("kitap_adi")
                };
                i++;
            }
            conn4.close();
            kitapara.setModel(new DefaultTableModel(data, baslik));
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "HATA!!");
        }

    }

    public void tablodansil2() throws SQLException {


        String baslik[] = new String[]{"id", "yazar_adi", "yazar_soyadi", "kitap_adi", "yayin_evi", "kitap_turu"};

        try {
            baglan5();

            String sorgu = "select * from kitaplar";

            stmt5 = conn5.createStatement();
            rs5 = stmt5.executeQuery(sorgu);

            // kac tane kayit var onu buluyor
            rs5.last();
            int kayitsayisi = rs5.getRow();
            rs5.beforeFirst();


            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs5.next()) {

                data[i] = new Object[]{
                    rs5.getInt("id"),
                    rs5.getString("yazar_adi"),
                    rs5.getString("yazar_soyadi"),
                    rs5.getString("kitap_adi"),
                    rs5.getString("yayin_evi"),
                    rs5.getString("kitap_turu")
                };
                i++;
            }
            conn5.close();
            kitapara.setModel(new DefaultTableModel(data, baslik));
        } catch (Exception ex) {
        }
    }

    public admin(int id, String adi, String soyadi) throws SQLException {
        initComponents();
        tablodansil();
        tablodansil2();
        onaytablodoldur();

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ara_ad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        uyeAra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        uye = new javax.swing.JTable();
        uyeCikar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        yazar_ad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        kit_ad = new javax.swing.JTextField();
        yazar_soyad = new javax.swing.JTextField();
        goster = new javax.swing.JLabel();
        turu = new javax.swing.JComboBox();
        yay_ev = new javax.swing.JTextField();
        KitapEkle = new javax.swing.JButton();
        KitapCikar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        kitap_ara = new javax.swing.JTextField();
        kitapAra = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        kitapara = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        onaytablo = new javax.swing.JTable();
        KitapOnay = new javax.swing.JButton();
        jonay = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        duyuru = new javax.swing.JTextArea();
        DuyuruEkle = new javax.swing.JButton();
        goster4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        baslik = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        ad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soyad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        yetki = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        YetkiliEkle = new javax.swing.JButton();
        yonay = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/anaustresim_1.png"))); // NOI18N

        jTabbedPane1.setForeground(new java.awt.Color(204, 102, 0));
        jTabbedPane1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Adi");

        uyeAra.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        uyeAra.setForeground(new java.awt.Color(204, 102, 0));
        uyeAra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/arama.png"))); // NOI18N
        uyeAra.setText("ARA");
        uyeAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ara_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(uyeAra, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uyeAra)
                    .addComponent(ara_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(24, 24, 24))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        uye.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Adı", "Soyadı", "Yetkisi"
            }
        ));
        jScrollPane3.setViewportView(uye);

        uyeCikar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        uyeCikar.setForeground(new java.awt.Color(204, 102, 0));
        uyeCikar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/temizle.png"))); // NOI18N
        uyeCikar.setText("SİL");
        uyeCikar.setToolTipText("");
        uyeCikar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uyeCikar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        uyeCikar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeCikarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(uyeCikar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(uyeCikar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Üye İşlem", jPanel1);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Yazar Soyadı");

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Kitap Türü");

        yazar_ad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        yazar_ad.setForeground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Kitap Adı");

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Yayin Evi");

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Yazar Adı");

        kit_ad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        kit_ad.setForeground(new java.awt.Color(51, 51, 51));

        yazar_soyad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        yazar_soyad.setForeground(new java.awt.Color(51, 51, 51));

        turu.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        turu.setForeground(new java.awt.Color(51, 51, 51));
        turu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hikaye", "Roman", "Ansiklopedi", "Ders Kitabı", "Diger" }));

        yay_ev.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        yay_ev.setForeground(new java.awt.Color(51, 51, 51));

        KitapEkle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        KitapEkle.setForeground(new java.awt.Color(51, 51, 51));
        KitapEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/tamam.png"))); // NOI18N
        KitapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapEkleActionPerformed(evt);
            }
        });

        KitapCikar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        KitapCikar.setForeground(new java.awt.Color(51, 51, 51));
        KitapCikar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/kapat.png"))); // NOI18N
        KitapCikar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapCikarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yay_ev)
                            .addComponent(yazar_ad)
                            .addComponent(kit_ad)
                            .addComponent(yazar_soyad))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(KitapEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(KitapCikar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(goster, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(yazar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(yazar_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kit_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addGap(8, 8, 8)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(yay_ev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(KitapCikar)
                                            .addComponent(KitapEkle))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(goster)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        kitapAra.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        kitapAra.setForeground(new java.awt.Color(204, 102, 0));
        kitapAra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/arama.png"))); // NOI18N
        kitapAra.setText("ARA");
        kitapAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitapAraActionPerformed(evt);
            }
        });

        kitapara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Yazar Adı", "Yazar Soyadı", "Kitap Adı"
            }
        ));
        jScrollPane4.setViewportView(kitapara);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(kitap_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kitapAra)
                .addGap(147, 147, 147))
            .addComponent(jScrollPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kitap_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kitapAra))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("Kitap İşlem", jPanel4);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        onaytablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(onaytablo);

        KitapOnay.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        KitapOnay.setForeground(new java.awt.Color(204, 102, 0));
        KitapOnay.setText("ONAYLA");
        KitapOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapOnayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jonay)
                        .addGap(0, 534, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(KitapOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(KitapOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jonay)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kitap Onay", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        duyuru.setColumns(20);
        duyuru.setRows(5);
        jScrollPane5.setViewportView(duyuru);

        DuyuruEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/tamam.png"))); // NOI18N
        DuyuruEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuyuruEkleActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 13)); // NOI18N
        jLabel3.setText("Başlık");

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 13)); // NOI18N
        jLabel13.setText("Duyuru");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(baslik, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(goster4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(DuyuruEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baslik, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(goster4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DuyuruEkle)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Duyuru Ekle", jPanel7);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        ad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        ad.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Adı");

        soyad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        soyad.setForeground(new java.awt.Color(51, 51, 51));
        soyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soyadActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Soyadı");

        kad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        kad.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Kullanıcı Adı");

        pass.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Şifre");

        pass2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        pass2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Şifre Tekrar");

        yetki.setEditable(true);
        yetki.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        yetki.setForeground(new java.awt.Color(51, 51, 51));
        yetki.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yetkili" }));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Yetki");

        YetkiliEkle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        YetkiliEkle.setForeground(new java.awt.Color(204, 102, 0));
        YetkiliEkle.setText("Yetki Ver");
        YetkiliEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YetkiliEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yonay)
                    .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(soyad, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(kad, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(pass2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(yetki, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(YetkiliEkle)
                .addGap(293, 293, 293))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yetki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(YetkiliEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(yonay)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Yetkili Ekle", jPanel10);

        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kutuphanetakip/programkapat.png"))); // NOI18N
        jButton1.setText("ÇIKIŞ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(679, 679, 679)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uyeAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeAraActionPerformed
        try {
            String gidenad = ara_ad.getText();
            aratablodoldur(gidenad);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_uyeAraActionPerformed

    private void uyeCikarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeCikarActionPerformed
        try {
            baglan2();

            String tablodangelen = uye.getValueAt(uye.getSelectedRow(), 0).toString();
            stmt2 = conn2.createStatement();
            String sql = "DELETE FROM uyeler "
                    + "WHERE id = " + tablodangelen;
            stmt2.executeUpdate(sql);
            tablodansil();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_uyeCikarActionPerformed

    private void KitapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapEkleActionPerformed
        String y_adi = yazar_ad.getText();
        String y_soyadi = yazar_soyad.getText();
        String y_kadi = kit_ad.getText();
        String y_yev = yay_ev.getText();
        String kit_tur = (String) turu.getSelectedItem();

        try {
            baglan3();
            rs3.moveToInsertRow();
            rs3.updateString("yazar_adi", y_adi);
            rs3.updateString("yazar_soyadi", y_soyadi);
            rs3.updateString("kitap_adi", y_kadi);
            rs3.updateString("yayin_evi", y_yev);
            rs3.updateString("kitap_turu", kit_tur);
            rs3.updateString("konay", "");


            rs3.insertRow();
            goster.setText("Kayit yapildi..");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_KitapEkleActionPerformed

    private void kitapAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitapAraActionPerformed
        try {
            String gidenad = kitap_ara.getText();
            aratablodoldur2(gidenad);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_kitapAraActionPerformed

    private void KitapCikarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapCikarActionPerformed
        try {
            baglan5();

            String tablodangelen = kitapara.getValueAt(kitapara.getSelectedRow(), 0).toString();
            stmt5 = conn5.createStatement();
            String sql = "DELETE FROM kitaplar "
                    + "WHERE id = " + tablodangelen;
            stmt5.executeUpdate(sql);
            tablodansil2();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_KitapCikarActionPerformed

    private void DuyuruEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuyuruEkleActionPerformed
        String duyurular = duyuru.getText();
        String baslikk = baslik.getText();
        try {
            bagland();
            rsd.moveToInsertRow();
            rsd.updateString("basliklar", baslikk);
            rsd.updateString("duyurular", duyurular);
            rsd.insertRow();
            goster4.setText("Duyuru eklendi..");
        } catch (Exception ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DuyuruEkleActionPerformed

    private void soyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soyadActionPerformed

    private void KitapOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapOnayActionPerformed

       String tablodangelen = onaytablo.getValueAt(onaytablo.getSelectedRow(), 0).toString();
       
     
        try { 
              
baglan();
          
           
            stmtko = conn.createStatement();        
            String sql = "UPDATE kitap_onay SET onay = '0'  WHERE id=" + tablodangelen;         
            stmtko.executeUpdate(sql);
                jonay.setText("Onaylandı.");     
                onaytablodoldur();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_KitapOnayActionPerformed

    private void YetkiliEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YetkiliEkleActionPerformed
        String y_adi = ad.getText();
        String y_soyadi = soyad.getText();
        String y_kadi = kad.getText();
        Integer y_sifre = Integer.parseInt(pass.getText());
        Integer y_sifre2 = Integer.parseInt(pass2.getText());
        String yetki_sec = (String) yetki.getSelectedItem();
        
         try {
                baglany();
                rsy.moveToInsertRow();
                rsy.updateString("adi", y_adi);
                rsy.updateString("soyadi", y_soyadi);
                rsy.updateString("kadi",y_kadi);
                rsy.updateInt("sifresi", y_sifre);
                rsy.updateString("yetkisi",yetki_sec);
                

                rsy.insertRow();
                yonay.setText("Kayit yapildi..");
            } catch (Exception ex) {
                Logger.getLogger(UyeEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_YetkiliEkleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
          new AnaSayfa().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.comjLabel12se/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new admin().setVisible(true);
                } catch (Exception ex) {
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DuyuruEkle;
    private javax.swing.JButton KitapCikar;
    private javax.swing.JButton KitapEkle;
    private javax.swing.JButton KitapOnay;
    private javax.swing.JButton YetkiliEkle;
    private javax.swing.JTextField ad;
    private javax.swing.JTextField ara_ad;
    private javax.swing.JTextField baslik;
    private javax.swing.JTextArea duyuru;
    private javax.swing.JLabel goster;
    private javax.swing.JLabel goster4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jonay;
    private javax.swing.JTextField kad;
    private javax.swing.JTextField kit_ad;
    private javax.swing.JButton kitapAra;
    private javax.swing.JTextField kitap_ara;
    private javax.swing.JTable kitapara;
    private javax.swing.JTable onaytablo;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField soyad;
    private javax.swing.JComboBox turu;
    private javax.swing.JTable uye;
    private javax.swing.JButton uyeAra;
    private javax.swing.JButton uyeCikar;
    private javax.swing.JTextField yay_ev;
    private javax.swing.JTextField yazar_ad;
    private javax.swing.JTextField yazar_soyad;
    private javax.swing.JComboBox yetki;
    private javax.swing.JLabel yonay;
    // End of variables declaration//GEN-END:variables
}
