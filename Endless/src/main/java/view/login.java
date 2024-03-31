/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import util.Auth;
import util.Encode;
import util.NhanVienDAO;

public class login extends javax.swing.JFrame {

    NhanVienDAO dao = new NhanVienDAO();
    Encode en = new Encode();

    public login() {
        initComponents();
    }

    public void changeTab(JPanel pnl) {
        pnlDangNhap.removeAll();
        pnlDangNhap.revalidate();
        pnlDangNhap.repaint();
        pnlDangNhap.setLayout(new AbsoluteLayout());
        pnlDangNhap.add(pnl, new AbsoluteConstraints(0, 0));
    }

    boolean matkhau = true;

    void dangNhap() {
        NhanVienDAO dao = new NhanVienDAO();
        String maTK = txtTenDangNhap.getText();
        char[] matkhauChars = txtMatKhau.getPassword();

        if (maTK.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống!");
        } else if (matkhauChars.length == 0) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
        } else {
            model.NhanVien nv = dao.selectByUserName(maTK);

            if (nv == null) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập không tồn tại!");
            } else {
                // Kiểm tra mật khẩu
                if (!en.checkPassword(String.valueOf(matkhauChars), nv.getMatKhau())) {
                    JOptionPane.showMessageDialog(this, "Sai mật khẩu, vui lòng nhập lại!");
                } else {
                    // Đăng nhập thành công
                    setVisible(false);
                    Auth.user = nv;
                    Auth.user.setMaTK(maTK);
                    pnlDangNhap.setVisible(false);
                    dispose();
                    new main.main().setVisible(true);
                }
            }
        }

    }

    boolean batLoi() {
        String maTK = txtTenDangNhap.getText();
        model.NhanVien nv = dao.selectByUserName(maTK);
        Auth.user = nv;
        String err = "";
        if (txtTenDangNhap.getText().isEmpty()) {
            err += "Tên Đăng nhập không được bỏ trống\n";
        }
        if (txtMatKhau.getText().isEmpty()) {
            err += "Mật khẩu không được bỏ trống\n";
        }
        if (nv == null) {
            err += "Sai tên đăng nhập";
        }
        if (!Auth.user.getMatKhau().equalsIgnoreCase(txtMatKhau.getText())) {
            err += "Sai mật khẩu";
        }
        if (!err.isEmpty()) {
            JOptionPane.showMessageDialog(this, err);

            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDangNhap = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblThayDoi = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lblMat = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 730));
        setMinimumSize(new java.awt.Dimension(1280, 730));
        setPreferredSize(new java.awt.Dimension(1280, 730));

        pnlDangNhap.setBackground(new java.awt.Color(254, 220, 197));
        pnlDangNhap.setMaximumSize(new java.awt.Dimension(1280, 730));
        pnlDangNhap.setMinimumSize(new java.awt.Dimension(1280, 730));
        pnlDangNhap.setPreferredSize(new java.awt.Dimension(1280, 730));
        pnlDangNhap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hinh (2).png"))); // NOI18N
        pnlDangNhap.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, 450));

        jPanel2.setBackground(new java.awt.Color(254, 230, 214));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Đăng Nhập");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 189, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 101, -1));

        lblQuenMatKhau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblQuenMatKhau.setText("Quên mật khẩu?");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });
        jPanel2.add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        lblThayDoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThayDoi.setText("Thay đổi sever");
        lblThayDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThayDoiMouseClicked(evt);
            }
        });
        jPanel2.add(lblThayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 80, 20));

        txtTenDangNhap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(txtTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 340, 40));

        lblMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mat.png"))); // NOI18N
        lblMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMatMouseClicked(evt);
            }
        });
        jPanel2.add(lblMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        txtMatKhau.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 340, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Tên đăng nhập:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        btnDangNhap.setBackground(new java.awt.Color(80, 199, 255));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 130, -1));

        pnlDangNhap.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 430, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        changeTab(new QuenMatKhau());
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void lblThayDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThayDoiMouseClicked
        changeTab(new chuyenServer());
    }//GEN-LAST:event_lblThayDoiMouseClicked

    private void lblMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMatMouseClicked
        if (matkhau == true) {
            txtMatKhau.setEchoChar((char) 0);
            
            lblMat.setIcon(new ImageIcon(getClass().getResource("/icon/Mat.png")));
            matkhau = false;
        } else {
            txtMatKhau.setEchoChar('*');
            lblMat.setIcon(new ImageIcon(getClass().getResource("/icon/MatDong.png")));
            matkhau = true;
        }
    }//GEN-LAST:event_lblMatMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        txtMatKhau.requestFocus();
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        dangNhap();
    }//GEN-LAST:event_txtMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMat;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblThayDoi;
    private javax.swing.JPanel pnlDangNhap;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}