/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import util.LoaiGiayDAO;

/**
 *
 * @author Hi There
 */
public class LoaiGiay extends javax.swing.JFrame {

    LoaiGiayDAO lgDAO = new LoaiGiayDAO();
    int row = -1;

    /**
     * Creates new form LoaiGiay
     */
    public LoaiGiay() {
        initComponents();
        fillTableLoaiGiay();
        initTableModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    void fillTableLoaiGiay() {
        DefaultTableModel model = (DefaultTableModel) tblLoaiGiay.getModel();
        model.setRowCount(0);
        try {
            List<model.LoaiGiay> list = lgDAO.selectAll();
            for (model.LoaiGiay lg : list) {
                Object[] rows = {lg.getMaLoaiGiay(), lg.getTenLoaiGiay(), lg.getMoTa()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        txtTenLoaiGiay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMoTaLg = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoaiGiay = new javax.swing.JTable();
        btnThemLg = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tên Loại Giày:(*)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 119, -1, -1));

        txtTenLoaiGiay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtTenLoaiGiay, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 141, 390, 35));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mô tả :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 200, -1, -1));

        txtMoTaLg.setColumns(20);
        txtMoTaLg.setLineWrap(true);
        txtMoTaLg.setRows(5);
        txtMoTaLg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMoTaLg.setMaximumSize(new java.awt.Dimension(300, 70));
        txtMoTaLg.setMinimumSize(new java.awt.Dimension(300, 70));
        getContentPane().add(txtMoTaLg, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 222, 390, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit-24.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        tblLoaiGiay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại giày", "Tên loại giày", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiGiayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoaiGiay);
        if (tblLoaiGiay.getColumnModel().getColumnCount() > 0) {
            tblLoaiGiay.getColumnModel().getColumn(0).setMinWidth(100);
            tblLoaiGiay.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLoaiGiay.getColumnModel().getColumn(0).setMaxWidth(100);
            tblLoaiGiay.getColumnModel().getColumn(1).setMinWidth(110);
            tblLoaiGiay.getColumnModel().getColumn(1).setPreferredWidth(110);
            tblLoaiGiay.getColumnModel().getColumn(1).setMaxWidth(110);
        }

        btnThemLg.setBackground(new java.awt.Color(80, 199, 255));
        btnThemLg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemLg.setForeground(new java.awt.Color(255, 255, 255));
        btnThemLg.setText("Thêm");
        btnThemLg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThemLg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLgActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("THÊM LOẠI GIÀY");

        btnLamMoi.setBackground(new java.awt.Color(80, 199, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(btnThemLg, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemLg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initTableModel() {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(49, 0, 158));
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblLoaiGiay.getColumnCount(); i++) {
            tblLoaiGiay.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    void setFormLoaiGiay(model.LoaiGiay lg) {
        txtTenLoaiGiay.setText(lg.getTenLoaiGiay());
        txtMoTaLg.setText(lg.getMoTa());
    }

    model.LoaiGiay getFormLoaiGiay() {
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setTenLoaiGiay(txtTenLoaiGiay.getText());
        lg.setMoTa(txtMoTaLg.getText());
        return lg;
    }

    public String taoMaLG() {
        model.LoaiGiay lg = lgDAO.selectDESC().get(0);
        if (lg == null) {
            lg = new model.LoaiGiay();
            lg.setMaLoaiGiay("LG000");
        }
        String oldID = lg.getMaLoaiGiay();
        String number = oldID.substring(2, oldID.length());
        String newID = "LG";
        int idNumber = Integer.parseInt(number) + 1;
        if (idNumber < 10) {
            newID += "00" + idNumber;
        } else if (idNumber < 100) {
            newID += "0" + idNumber;
        } else {
            newID += idNumber;
        }
        return newID;
    }
    
    
    //Kiểm tra hàm tạo mã loại giày
    public String taoMaLG_Test(List<model.LoaiGiay> list) {
        if (list == null || list.isEmpty()) {
           return ("LG001");
        }
        model.LoaiGiay lg = list.get(list.size() - 1);
        String oldID = lg.getMaLoaiGiay();
        String number = oldID.substring(2, oldID.length());
        String newID = "LG";
        int idNumber = Integer.parseInt(number) + 1;
        if (idNumber < 10) {
            newID += "00" + idNumber;
        } else if (idNumber < 100) {
            newID += "0" + idNumber;
        } else {
            newID += idNumber;
        }
        return newID;
    }

    void ThemLoaiGiay() {
        if (KiemLoiLoaiGiay() == true) {
            model.LoaiGiay lg = getFormLoaiGiay();
            lg.setMaLoaiGiay(taoMaLG());
            try {
                lgDAO.insert(lg);
                JOptionPane.showMessageDialog(this, "Thêm loại giày thành công!");
                this.show(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm loại giày thất bại!");
                System.out.println(e);
            }
        }
    }
    
    
    //Kiểm tra hàm thêm loại giày
    public String ThemLoaiGiay_Test(model.LoaiGiay lg) {
    	lg.setMaLoaiGiay(taoMaLG());
        if (KiemLoi_Test(lg).equals("")) {
            try {
                lgDAO.insert(lg);
                return "Thêm loại giày thành công!";
            } catch (Exception e) {
                return e+"";
            }
        }
		return KiemLoi_Test(lg);
    }

    public boolean KiemLoiLoaiGiay() {
        String err = "";
        if (txtTenLoaiGiay.getText().isEmpty()) {
            err += "Tên loại giày không được bỏ trống\n";
        }
        if (!err.isEmpty()) {
            JOptionPane.showMessageDialog(this, err);

            return false;
        }
        return true;
    }

    //Kiểm tra hàm kiểm lỗi loại gìay
    public String KiemLoi_Test(model.LoaiGiay lg) {
        String err = "";
        if (lg.getTenLoaiGiay() == null ||lg.getTenLoaiGiay().isEmpty()) {
            err += "Lỗi bỏ trống tên loại giày";
        }
        return err;
    }

    
    void LamMoiLoaiGiay() {
        txtTenLoaiGiay.setText("");
        txtMoTaLg.setText("");
        this.row = -1;
        tblLoaiGiay.clearSelection();
    }
    private void btnThemLgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLgActionPerformed
        ThemLoaiGiay();

    }//GEN-LAST:event_btnThemLgActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tblLoaiGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiGiayMouseClicked
        row = tblLoaiGiay.getSelectedRow();
        if (evt.getClickCount() == 1) {
            String id = (String) tblLoaiGiay.getValueAt(row, 0);
            model.LoaiGiay lg = lgDAO.selectById(id);
            setFormLoaiGiay(lg);
        }
    }//GEN-LAST:event_tblLoaiGiayMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        LamMoiLoaiGiay();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoaiGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoaiGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoaiGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoaiGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoaiGiay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemLg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoaiGiay;
    private javax.swing.JTextArea txtMoTaLg;
    private javax.swing.JTextField txtTenLoaiGiay;
    // End of variables declaration//GEN-END:variables
}
