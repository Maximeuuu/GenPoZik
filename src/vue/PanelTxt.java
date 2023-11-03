package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTxt extends JPanel implements ActionListener
{
	private Controleur ctrl;

	private SaisieTexte saisieTexteAuteur;
	private SaisieTexte saisieTexteTitre;
	private SaisieTexte saisieTexteDate;

	public PanelTxt( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setLayout( new GridLayout(3,1) );

		// Création des composants
		this.saisieTexteAuteur = new SaisieTexte("Auteur");
		this.saisieTexteTitre  = new SaisieTexte("Titre");
		this.saisieTexteDate   = new SaisieTexte("Date : ");

		// Ajout des composants
		this.add( this.saisieTexteAuteur );
		this.add( this.saisieTexteTitre );
		this.add( this.saisieTexteDate );
	}

	public void actionPerformed( ActionListener e )
	{
		Texte texteA =  this.saisieTexteAuteur.getTexte();
		Texte texteT = this.saisieTexteTitre.getTexte();
		Texte texteD = this.saisieTexteDate.getTexte();
		this.ctrl.maj( texteA, texteT, texteD );
	}
}
