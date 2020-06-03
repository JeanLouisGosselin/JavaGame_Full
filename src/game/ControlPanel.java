/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class ControlPanel extends javax.swing.JPanel{

    private Game game;
    private Soldier soldier;
    private CollisionEvent e;
    
    /**
     *Constructor of instance of ControlPanel
     * @param game current object of class Game (enabling us, for instance, to get access to current instance of Soldier class and the current values of its associated fields).
     */
    public ControlPanel(Game game) {
        initComponents();
        this.game = game;
        soldier = game.getPlayer();      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollBar1 = new javax.swing.JScrollBar();
        jDialog1 = new javax.swing.JDialog();
        quitButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        skipNextLevel = new javax.swing.JButton();
        skipPreviousLevel = new javax.swing.JButton();
        volumeSlider = new javax.swing.JSlider();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 0, 0));

        quitButton.setBackground(new java.awt.Color(0, 0, 0));
        quitButton.setForeground(new java.awt.Color(255, 0, 0));
        quitButton.setText("Quit");
        quitButton.setFocusable(false);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        pauseButton.setBackground(new java.awt.Color(0, 0, 0));
        pauseButton.setForeground(new java.awt.Color(255, 255, 255));
        pauseButton.setText("Pause");
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        resumeButton.setBackground(new java.awt.Color(0, 0, 0));
        resumeButton.setForeground(new java.awt.Color(255, 255, 255));
        resumeButton.setText("Resume");
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        skipNextLevel.setBackground(new java.awt.Color(0, 0, 0));
        skipNextLevel.setForeground(new java.awt.Color(0, 204, 102));
        skipNextLevel.setText(">>>");
        skipNextLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipNextLevelActionPerformed(evt);
            }
        });

        skipPreviousLevel.setBackground(new java.awt.Color(0, 0, 0));
        skipPreviousLevel.setForeground(new java.awt.Color(0, 204, 102));
        skipPreviousLevel.setText("<<<");
        skipPreviousLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipPreviousLevelActionPerformed(evt);
            }
        });

        volumeSlider.setBackground(new java.awt.Color(0, 0, 0));
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resumeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skipPreviousLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skipNextLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pauseButton)
                        .addComponent(resumeButton)
                        .addComponent(quitButton)
                        .addComponent(skipNextLevel)
                        .addComponent(skipPreviousLevel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
      game.getWorld().stop();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        game.getWorld().start();
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void skipPreviousLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipPreviousLevelActionPerformed
        if(game.getLevelNumber() != 4)
            game.goPreviousLevel(game.getPlayer().getLife());      
    }//GEN-LAST:event_skipPreviousLevelActionPerformed

    private void skipNextLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipNextLevelActionPerformed
        game.goNextLevel(game.getPlayer().getLife());
    }//GEN-LAST:event_skipNextLevelActionPerformed

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeSliderStateChanged
        
        float vol = volumeSlider.getValue();
        
        vol = vol/(200);

        if (vol<.1f)
            vol = .1f;
        
        game.getMusic().setVolume(vol);  
    }//GEN-LAST:event_volumeSliderStateChanged
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton resumeButton;
    private javax.swing.JButton skipNextLevel;
    private javax.swing.JButton skipPreviousLevel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
