package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class JanelaPrint extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    String salvar;

    public JanelaPrint() {
        initComponents();
        con = new Conexao().conector();
        consultaGeral();
        pesquisaPaciente();
        cbxPlanoActionPerformed(null);
        cbxEspecialidadeActionPerformed(null);
    }

    public void consultaGeral() {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "select * from fichapaciente;";
            rs = stmt.executeQuery(comando);
            rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibeDados() {
        try {
            txtNomePaciente.setText(rs.getString("nomePaciente"));
            txtNumeroCarteira.setText(rs.getString("numeroCarteiraPlano"));
            int planoId = rs.getInt("idPlanoDeSaude");
            for (int i = 0; i < cbxPlano.getItemCount(); i++) {
                String item1 = (String) cbxPlano.getItemAt(i);
                if (item1.startsWith(planoId + " - ")) {
                    cbxPlano.setSelectedIndex(i);
                    break;
                }
            }
            int especialidadeId = rs.getInt("idEspecialidade");
            for (int i = 0; i < cbxEspecialidade.getItemCount(); i++) {
                String item2 = (String) cbxEspecialidade.getItemAt(i);
                if (item2.startsWith(especialidadeId + " - ")) {
                    cbxEspecialidade.setSelectedIndex(i);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void pesquisaPaciente() {
        String sql = "select * from fichapaciente where nomePaciente like ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, txtPesq.getText() + "%");
            rs = ps.executeQuery();
            fichapaciente.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setarCampos() {
        int setar = fichapaciente.getSelectedRow();
        
        txtNomePaciente.setText(fichapaciente.getModel().getValueAt(setar, 1).toString());
        txtNumeroCarteira.setText(fichapaciente.getModel().getValueAt(setar, 2).toString());
        
        int planoId = Integer.parseInt(fichapaciente.getModel().getValueAt(setar, 3).toString());
        for (int i = 0; i < cbxPlano.getItemCount(); i++) {
            String item1 = (String) cbxPlano.getItemAt(i);
            if (item1.startsWith(planoId + " - ")) {
                cbxPlano.setSelectedIndex(i);
                break;
            }
        }
        int especialidadeId = Integer.parseInt(fichapaciente.getModel().getValueAt(setar, 4).toString());
        for (int i = 0; i < cbxEspecialidade.getItemCount(); i++) {
            String item2 = (String) cbxEspecialidade.getItemAt(i);
            if (item2.startsWith(especialidadeId + " - ")) {
                cbxEspecialidade.setSelectedIndex(i);
                break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        txtNumeroCarteira = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fichapaciente = new javax.swing.JTable();
        cbxPlano = new javax.swing.JComboBox<>();
        cbxEspecialidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital");

        jLabel1.setText("FICHA DO PACIENTE");

        jLabel2.setText("Nome do Paciente:");

        jLabel3.setText("Número da Carteira:");

        jLabel4.setText("Especialidade:");

        jLabel5.setText("Plano:");

        txtNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePacienteActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel6.setText("Busca:");

        txtPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqActionPerformed(evt);
            }
        });
        txtPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqKeyReleased(evt);
            }
        });

        fichapaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "N° da Carteira", "Plano", "Especialidade"
            }
        ));
        fichapaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fichapacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fichapaciente);

        cbxPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlanoActionPerformed(evt);
            }
        });

        cbxEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecialidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomePaciente)
                                .addComponent(txtNumeroCarteira)
                                .addComponent(cbxPlano, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInserir)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar)
                            .addGap(18, 18, 18)
                            .addComponent(btnExcluir))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtPesq))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumeroCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePacienteActionPerformed
        //campo de texto do nome do paciente.
    }//GEN-LAST:event_txtNomePacienteActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        salvar = "inserir";
        JOptionPane.showMessageDialog(null, "Preencha os campos com os dados do paciente.");
        txtNomePaciente.setText("");
        txtNumeroCarteira.setText("");
        cbxPlano.setSelectedIndex(0);
        cbxEspecialidade.setSelectedIndex(0);
        txtNomePaciente.requestFocus();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (salvar.equals("inserir")) {
            try {
                String sqlInserir = "insert into fichapaciente (nomePaciente, numeroCarteiraPlano, idPlanoDeSaude, idEspecialidade) VALUES (?, ?, ?, ?);";
                ps = con.prepareStatement(sqlInserir);
                ps.setString(1, txtNomePaciente.getText());
                ps.setString(2, txtNumeroCarteira.getText());
                String selectedItemPlano = (String) cbxPlano.getSelectedItem();
                int plano = Integer.parseInt(selectedItemPlano.split(" - ")[0]);
                String selectedItemEspecialidade = (String) cbxEspecialidade.getSelectedItem();
                int especialidade = Integer.parseInt(selectedItemEspecialidade.split(" - ")[0]);
                ps.setInt(3, plano);
                ps.setInt(4, especialidade);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ficha cadastrada");
                pesquisaPaciente();
            } catch (SQLException e) {
                if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "Já existe uma ficha para este paciente com a mesma especialidade e plano de saúde.");
                } else {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao inserir ficha: " + e.getMessage());
                }
            }
        }
        if (salvar.equals("editar")) {
            int selectedRow = fichapaciente.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) fichapaciente.getValueAt(selectedRow, 0);
                if (JOptionPane.showConfirmDialog(null, "Atualizar ficha com ID " + id + "?", "Editar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        String sqlEditar = "update fichapaciente set nomePaciente =?, numeroCarteiraPlano = ?, idPlanoDeSaude = ?, idEspecialidade = ? where id = ?;";
                        ps = con.prepareStatement(sqlEditar);
                        ps.setString(1, txtNomePaciente.getText());
                        ps.setString(2, txtNumeroCarteira.getText());
                        String selectedItemPlano = (String) cbxPlano.getSelectedItem();
                        int plano = Integer.parseInt(selectedItemPlano.split(" - ")[0]);
                        String selectedItemEspecialidade = (String) cbxEspecialidade.getSelectedItem();
                        int especialidade = Integer.parseInt(selectedItemEspecialidade.split(" - ")[0]);
                        ps.setInt(3, plano);
                        ps.setInt(4, especialidade);
                        ps.setInt(5, id);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Ficha atualizada com sucesso!");
                        pesquisaPaciente();
                    } catch (SQLException e) {
                         if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "Já existe uma ficha para este paciente com a mesma especialidade e plano de saúde.");
                         } else {
                             e.printStackTrace();
                             JOptionPane.showMessageDialog(null, "Erro ao inserir ficha: " + e.getMessage());
                         }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        salvar = "editar";
        JOptionPane.showMessageDialog(null, "Selecione e edite os dados da ficha do paciente.");
        txtNomePaciente.setText("");
        txtNumeroCarteira.setText("");
        cbxPlano.setSelectedIndex(0);
        cbxEspecialidade.setSelectedIndex(0);
        txtNomePaciente.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = fichapaciente.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) fichapaciente.getValueAt(selectedRow, 0);
            if (JOptionPane.showConfirmDialog(null, "Excluir ficha com ID " + id + "?", "Excluir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    String sqlApagar = "DELETE FROM fichapaciente WHERE id = ?;";
                    ps = con.prepareStatement(sqlApagar);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Ficha excluída com sucesso!");
                    pesquisaPaciente();
                    txtNomePaciente.setText("");
                    txtNumeroCarteira.setText("");
                    cbxPlano.setSelectedIndex(0);
                    cbxEspecialidade.setSelectedIndex(0);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir ficha: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma ficha para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqKeyReleased
        pesquisaPaciente();
    }//GEN-LAST:event_txtPesqKeyReleased

    private void fichapacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fichapacienteMouseClicked
        setarCampos();
    }//GEN-LAST:event_fichapacienteMouseClicked

    private void txtPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqActionPerformed
        //campo de texto de pesquisa pelo nome do paciente
    }//GEN-LAST:event_txtPesqActionPerformed

    private void cbxPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlanoActionPerformed
        if (cbxPlano.getItemCount() > 1) {
            return;
        }
        try {
            String sql = "SELECT id, nome FROM PlanosDeSaude";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbxPlano.removeAllItems();
            cbxPlano.addItem("Selecione");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomePlano = rs.getString("nome");
                String item = id + " - " + nomePlano;
                cbxPlano.addItem(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar planos de saúde: " + e.getMessage());
        }
    }//GEN-LAST:event_cbxPlanoActionPerformed

    private void cbxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecialidadeActionPerformed
        if (cbxEspecialidade.getItemCount() > 1) {
            return;
        }
        try {
            String sql = "SELECT id, nome FROM Especialidades";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbxEspecialidade.removeAllItems();
            cbxEspecialidade.addItem("Selecione");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeEspecialidade = rs.getString("nome");
                String item = id + " - " + nomeEspecialidade;
                cbxEspecialidade.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar especialidades: " + e.getMessage());
        }
    }//GEN-LAST:event_cbxEspecialidadeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrint().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxEspecialidade;
    private javax.swing.JComboBox<String> cbxPlano;
    private javax.swing.JTable fichapaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNomePaciente;
    private javax.swing.JTextField txtNumeroCarteira;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}
