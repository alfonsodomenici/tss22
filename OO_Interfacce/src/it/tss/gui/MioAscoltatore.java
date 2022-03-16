/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class MioAscoltatore extends MouseAdapter implements ActionListener  {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "click intercettato da MioAscoltatore");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         System.out.println("movimento mouse " + e.getX());
    }

    

    
}
