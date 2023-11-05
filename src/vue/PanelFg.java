package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.evenement.*;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class PanelFg extends JPanel implements PanelSaisieListener, ActionListener
{
	private Controleur ctrl;

	private SaisieRGB saisieCouleur;
	private JButton btnSelectionImage;
	//listeFormesBasiques

	public PanelFg( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setLayout( new FlowLayout(FlowLayout.LEADING) );

		// Création des composants
		JPanel panelCouleur = new JPanel( new GridLayout(2,1) );
		this.saisieCouleur = new SaisieRGB( true );

		JPanel panelImage = new JPanel( new GridLayout(2,1) );
		this.btnSelectionImage = new JButton("Selectionner");

		// Positionnement des composants
		panelCouleur.add( new JLabel("Couleur : ") );
		panelCouleur.add( this.saisieCouleur );
		this.add( panelCouleur );

		panelImage.add( new JLabel("Image de forme : ") );
		panelImage.add( this.btnSelectionImage );
		this.add( panelImage );

		// Activation des composants
		this.saisieCouleur.setPanelSaisieListener(this);
		this.btnSelectionImage.addActionListener(this);
	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
		JFileChooser fileChooser = new FileChooserImage();
		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fileChooser.getSelectedFile();
			this.ctrl.majFg( selectedFile );
		}
	}

	public void valueChanged()
	{
		Color coul = this.saisieCouleur.getCouleur();
		this.ctrl.majFg( coul );
	}
}
