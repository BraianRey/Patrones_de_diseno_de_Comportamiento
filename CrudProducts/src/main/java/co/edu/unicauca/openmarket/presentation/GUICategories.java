package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.infra.Messages;
import co.edu.unicauca.openmarket.presentation.commands.OMAddCategoryCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMDeleteCategoryCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMEditCategoryCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMInvoker;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author BRey
 */
public class GUICategories extends javax.swing.JFrame {

    private CategoryService categoryService;
   // private CategoryService categoryService;
    private ProductService catuctService;
    private boolean addOption;
    private OMInvoker ominvoker;

    /**
     * Creates new form GUICategories
     */
    public GUICategories(ProductService catuctService, CategoryService categoryService) {
        initComponents();
        this.catuctService = catuctService;
        this.categoryService = categoryService;
        ominvoker = new OMInvoker();
        stateInitial();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSouth = new javax.swing.JPanel();
        bttmRemake = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categorias");

        pnlSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bttmRemake.setText("Recuperar");
        bttmRemake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttmRemakeActionPerformed(evt);
            }
        });
        pnlSouth.add(bttmRemake);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSouth.add(btnNuevo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEditar);

        btnSave.setText("Grabar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlSouth.add(btnSave);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCancelar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEliminar);

        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        pnlSouth.add(btnFind);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCerrar);

        btnDeshacer.setText("Deshacer");
        btnDeshacer.setName("btnDeshacer"); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        pnlSouth.add(btnDeshacer);

        jButton1.setText("Asignar categoria(s)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlSouth.add(jButton1);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pnlCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCenter.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Id:");
        pnlCenter.add(jLabel1);

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlCenter.add(txtId);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombre:");
        pnlCenter.add(jLabel2);
        pnlCenter.add(txtName);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("Categorias");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        stateNew();
        txtName.requestFocus();
        addOption = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        stateInitial();
        cleanControls();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtName.getText().trim().equals("")) {
            Messages.showMessageDialog("Debe ingresar el nombre de la categoria", "Atención");
            txtName.requestFocus();
            return;
        }
        if (addOption) {
            //Agregar
            addCategory();

        } else {
            //Editar
            editCategory();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        addOption = false;
        stateEdit();
        txtId.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().trim().equals("")) {
            return;
        }
        Long categoryId = Long.parseLong(txtId.getText());
        Category cat = categoryService.findCategoryById(categoryId);
        if (cat == null) {
            Messages.showMessageDialog("El identificador de la categoria no existe", "Error");
            txtId.setText("");
            txtId.requestFocus();
        } else {
            txtName.setText(cat.getName());
        }
    }//GEN-LAST:event_txtIdFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el categoryo a eliminar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long categoryId = Long.parseLong(id);
        if (Messages.showConfirmDialog("Está seguro que desea eliminar este categoryo?", "Confirmación") == JOptionPane.YES_NO_OPTION) {
            OMDeleteCategoryCommand comm= new OMDeleteCategoryCommand(categoryId, categoryService);
            ominvoker.addCommand(comm);
            ominvoker.execute();
            if (categoryService.deleteCategory(categoryId)) {
                Messages.showMessageDialog("Categoryo eliminado con éxito", "Atención");
                stateInitial();
                cleanControls();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        GUICategoriesFind instance = new GUICategoriesFind(this, false, categoryService);
        instance.setVisible(true);
        categoryService.addObservador(instance);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:

        ominvoker.unexecute();
        if(!ominvoker.hasMoreCommands())
            this.btnDeshacer.setVisible(false);
        bttmRemake.setVisible(true);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GUIAssignCategory instance = new GUIAssignCategory(this, false, catuctService, categoryService);
        instance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instance.setVisible(true);
        categoryService.addObservador(instance);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bttmRemakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttmRemakeActionPerformed
        ominvoker.reexecute();
        if(!ominvoker.hasMoreRecuperableCommands())
            this.bttmRemake.setVisible(false);
        btnDeshacer.setVisible(ominvoker.hasMoreCommands());
    }//GEN-LAST:event_bttmRemakeActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void stateEdit() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(true);
        txtName.setEnabled(true);
    }

    private void stateInitial() {
        btnNuevo.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(false);
        btnCerrar.setVisible(true);
        btnSave.setVisible(false);
        btnFind.setVisible(true);
        txtId.setEnabled(false);
        txtName.setEnabled(false);
        bttmRemake.setVisible(ominvoker.hasMoreRecuperableCommands());
        btnDeshacer.setVisible(ominvoker.hasMoreCommands());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton bttmRemake;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void stateNew() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(false);
        txtName.setEnabled(true);
        btnDeshacer.setVisible(ominvoker.hasMoreCommands());
        bttmRemake.setVisible(ominvoker.hasMoreRecuperableCommands());
    }

    private void cleanControls() {
        txtId.setText("");
        txtName.setText("");
    }

    private void addCategory() {
        String name = txtName.getText().trim();
        Category category = new Category(0L, name);
        OMAddCategoryCommand comm= new OMAddCategoryCommand(category, categoryService);
        ominvoker.addCommand(comm);
        ominvoker.execute();
        if (comm.result()) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }

    private void editCategory() {
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el categoryo a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long categoryId = Long.parseLong(id);
        Category cat = new Category();
        cat.setName(txtName.getText().trim());
        
        OMEditCategoryCommand comm = new OMEditCategoryCommand(categoryId, categoryService, cat.getName());
        ominvoker.addCommand(comm);
        ominvoker.execute();
        
        if (comm.result()) {
            Messages.showMessageDialog("Se editó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al editar, lo siento mucho", "Atención");
        }
    }
}

/*
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        GUIAssignCategory instance = new GUIAssignCategory(this, false, categoryService, categoryService);
        instance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instance.setVisible(true);
        categoryService.addObservador(instance);
    }  
*/