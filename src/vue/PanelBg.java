package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.evenement.*;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class PanelBg extends JPanel implements PanelSaisieListener, ActionListener
{
	private Controleur ctrl;

	private SaisieRGB saisieCouleur1;
	private SaisieRGB saisieCouleur2;
	private JButton btnSelectionImage;
	//directionDegrade
	//typeDegrade

	public PanelBg( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setLayout( new FlowLayout(FlowLayout.LEADING) );

		// Création des composants
		JPanel panelCouleurs = new JPanel( new GridLayout(3,1) );
		this.saisieCouleur1 = new SaisieRGB();
		this.saisieCouleur2 = new SaisieRGB();

		JPanel panelImage = new JPanel( new GridLayout(2,1) );
		this.btnSelectionImage = new JButton("Selectionner");

		// Positionnement des composants
		panelCouleurs.add( new JLabel("Dégradé couleurs : ") );
		panelCouleurs.add( this.saisieCouleur1 );
		panelCouleurs.add( this.saisieCouleur2 );
		this.add( panelCouleurs );

		panelImage.add( new JLabel("Image de fond : ") );
		panelImage.add( this.btnSelectionImage );
		this.add( panelImage );

		// Activation des composants
		this.saisieCouleur1.setPanelSaisieListener(this);
		this.saisieCouleur2.setPanelSaisieListener(this);
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
			this.ctrl.majBg( selectedFile );
		}
	}

	public void valueChanged()
	{
		Color coul1 =  this.saisieCouleur1.getCouleur();
		Color coul2 = this.saisieCouleur2.getCouleur();
		this.ctrl.majBg( coul1, coul2 );
	}
}
