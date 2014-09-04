/**
 * 
 */
package com.cgi.comparaisonxml.fenetres;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cgi.comparaisonxml.ComparaisonXML;
import com.cgi.comparaisonxml.MyTransferHandler;

/**
 * @author gruatlaformea
 * 
 */
public class FileChoice extends JFrame implements ActionListener {

	/**
	 * Construction de la fenêtre permettant de sélectionner deux fichiers XML à
	 * comparer
	 */

	private static final long serialVersionUID = 8063105506566652448L;
	private JButton lBtCompare;
	private JTextField lFieldFile1;
	private JTextField lFieldFile2;
	private JPanel lPanel;

	public FileChoice() {

		// Paramètres généraux de la fenêtre
		this.setTitle("Comparaison XML");
		this.setSize(700, 70);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		lPanel = new JPanel();

		// Champ de saisie du chemin File1
		lFieldFile1 = new JTextField();
		lFieldFile1.setPreferredSize(new Dimension(250, 30));
		lFieldFile1.setVisible(true);
		lFieldFile1.setDragEnabled(true);
		lFieldFile1.setTransferHandler(new MyTransferHandler());
		lPanel.add(lFieldFile1);

		// Bouton pour demander la comparaison
		lBtCompare = new JButton("Comparer");
		lBtCompare.addActionListener(this);
		lPanel.add(lBtCompare);

		// Champ de saisie du chemin File2
		lFieldFile2 = new JTextField();
		lFieldFile2.setVisible(true);
		lFieldFile2.setPreferredSize(new Dimension(250, 30));
		lFieldFile2.setDragEnabled(true);
		lFieldFile2.setTransferHandler(new MyTransferHandler());
		lPanel.add(lFieldFile2);

		// Ajout du JPanel au JFrame
		this.add(lPanel);
		this.setTransferHandler(new MyTransferHandler());
	}

	public void actionPerformed(ActionEvent pActionEvent) {
		
		Object source = pActionEvent.getSource();
		
		if(source == lBtCompare){
			//Lancement de la comparaison des fichiers
			
				StringBuffer lResultats;
				try {
				lResultats = ComparaisonXML.comparaison(lFieldFile1.getText(), lFieldFile2.getText());
				
				JFrame lJframe = new JFrame();
				JEditorPane lJEditorPane = new JEditorPane();
				lJEditorPane.setText(lResultats.toString());
				lJframe.add(lJEditorPane);
				lJframe.setSize(1200, 800);
				lJframe.setLocationRelativeTo(null);
				lJframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			
			}
	}
}
