/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Jean-Louis
 */
public class IntroFrame extends javax.swing.JPanel {
    
    private Game game;
    /**
     * Creates new form test
     * @param game parameter of class Game
     */
    public IntroFrame(Game game) {
        this.game = game;
        initComponents();
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
        register = new javax.swing.JButton();
        player = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setText("Sign in");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));
        add(player, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 140, -1));
        add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 140, -1));

        jLabel4.setText("password: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 100, 90, 20));

        jLabel3.setText("username:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 20));

        jLabel5.setText("(tango)");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setText("(foxtrot)");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
       
       String user = player.getText();
       String password = pass.getText();
       
       if(user.equals("tango") && password.equals("foxtrot")){
       
            game.getFrame().setVisible(false);
            game.getFrame().removeAll();
            game.startGame();
       }

    }//GEN-LAST:event_registerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField player;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables
}
