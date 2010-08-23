/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.prophed;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ray
 */
public class Scaffold extends JPanel {

    private final ImagePanel ip;

    public Scaffold(ImagePanel ip) {
        this.ip = ip;
        setLayout(new GridBagLayout());

        Dimension size = new Dimension(ip.getWidth() + 200, ip.getHeight() + 200);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        /*
        javax.swing.GroupLayout jPanelImageLayout = new javax.swing.GroupLayout(ip);
        ip.setLayout(jPanelImageLayout);
        jPanelImageLayout.setHorizontalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelImageLayout.setVerticalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(99, 149, 99, 149);

        add(ip, gridBagConstraints);
         * */
         add(ip, new GridBagConstraints());

        //pack();
    }
}
