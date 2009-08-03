/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPanel.java
 *
 * Created on May 10, 2009, 5:52:24 PM
 */

package com.artivisi.pos.ui.sekuriti;

import com.artivisi.pos.model.sekuriti.Pengguna;
import com.artivisi.pos.ui.frame.FrameUtama;
import com.artivisi.pos.util.TextComponentUtils;
import com.twmacinta.util.MD5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ifnu
 */
public class PenggunaPanel extends javax.swing.JInternalFrame {

    /** Creates new form UserPanel */
    public PenggunaPanel() {
        initComponents();

        initListener();

        TextComponentUtils.setAutoUpperCaseAndLimitText(30, txtId);
        TextComponentUtils.setAutoUpperCaseAndLimitText(100, txtNama);

        tblPengguna.setAutoCreateColumnsFromModel(false);
    }

    private void initListener(){
        // Listener untuk table ketika table di Klik
        tblPengguna.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent evt) {
                if(tblPengguna.getSelectedRow()>=0){
                    pengguna = penggunas.get(tblPengguna.getSelectedRow());
                    loadModelToForm();
                }
            }
        });

        //ketika tombol delete di Klik
        buttonPanelMaster1.getBtnHapus().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try{
                    if(pengguna!=null){
                        FrameUtama.getSekuritiService().hapus(pengguna);
                    }
                } catch(Throwable t){
                    JOptionPane.showMessageDialog(FrameUtama.getInstance(), "Data ini masih digunakan!",
                            "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        //button edit di Klik
        buttonPanelMaster1.getBtnEdit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            }
        });

        // Ketika Button Tambah di Klick
        buttonPanelMaster1.getBtnTambah().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
            }
        });

        // Ketika Tombol Batal di Klik
        buttonPanelMaster1.getBtnBatal().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                buttonPanelMaster1.kondisiAwal();
                pengguna = null;
                tblPengguna.getSelectionModel().clearSelection();
                
            }
        });

        // Ketika Tombol Keluar di Klik
        buttonPanelMaster1.getBtnKeluar().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                FrameUtama.getInstance().removeInternalFrame(PenggunaPanel.this);
            }
        });

        // Ketika tombol Simpan di Klik
        buttonPanelMaster1.getBtnSimpan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if(validateForm()){
                    if(pengguna == null) pengguna = new Pengguna();
                    loadFormToModel();
                    FrameUtama.getSekuritiService().simpan(pengguna);
                    clearForm();
                    buttonPanelMaster1.kondisiAwal();
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanelMaster1 = new com.artivisi.pos.ui.toolbar.MasterToolbarPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengguna = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        setTitle("Pengguna");

        jLabel1.setText("Search Character");

        tblPengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Nama Lengkap"
            }
        ));
        tblPengguna.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPengguna);

        jLabel3.setText("Nama Lengkap");

        jLabel4.setText("Password");

        jLabel5.setText("Nama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanelMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanelMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Pengguna pengguna;
    private List<Pengguna> penggunas;

    private void loadModelToForm(){
        txtId.setText(pengguna.getId());
        txtNama.setText(pengguna.getNamaLengkap());
        txtPassword.setText(pengguna.getKataSandi());
    }

    private void loadFormToModel(){
        pengguna.setId(txtId.getText());
        pengguna.setNamaLengkap(txtNama.getText());
        if(pengguna.getKataSandi()!=null &&
                !new String(txtPassword.getPassword()).equals(pengguna.getKataSandi())){
            pengguna.setKataSandi(new MD5(new String(txtPassword.getPassword())).asHex());
        }
    }

    private boolean validateForm(){
        if(txtId.getText().length()>0 &&
                txtNama.getText().length()>0 &&
                txtPassword.getPassword()!=null && txtPassword.getPassword().length>0){
            return true;
        } else {
            JOptionPane.showMessageDialog(FrameUtama.getInstance(), "Isi semua field!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void clearForm(){
        txtId.setText("");
        txtNama.setText("");
        txtPassword.setText("");
        tblPengguna.getSelectionModel().clearSelection();
        pengguna = null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.artivisi.pos.ui.toolbar.MasterToolbarPanel buttonPanelMaster1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPengguna;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
