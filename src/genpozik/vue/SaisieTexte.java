package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.vue.event.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SaisieTexte extends JPanel implements DocumentListener, PanelSaisieListener
{
	private PanelSaisieListener panelSaisieListener;

	private JTextField   txtTexte;
	private SaisieNombre saisieTaille;
	private SaisieRGB    saisieRGB;
	private SaisiePos    saisiePosition;

	public SaisieTexte()
	{
		// Configuration
		this.setLayout( new GridLayout(4, 1) );
		this.setBackground( new Color(255,255,255,122) );

		// Creation des composants
		this.txtTexte       = new JTextField();
		this.saisieTaille   = new SaisieNombre(30, 0, 1000);
		this.saisieRGB      = new SaisieRGB();
		this.saisiePosition = new SaisiePos();

		// Positionnement des composants
		this.add( panelSaisie( "Texte", this.txtTexte ) );
		this.add( panelSaisie( "Taille", this.saisieTaille ) );
		this.add( panelSaisie( "Couleur", this.saisieRGB ) );
		this.add( panelSaisie( "Position", this.saisiePosition ) );

		// Activation des composants
		this.txtTexte.getDocument().addDocumentListener(this);
		this.saisieTaille.setPanelSaisieListener(this);
		this.saisieRGB.setPanelSaisieListener(this);
		this.saisiePosition.setPanelSaisieListener(this);
	}

	private JPanel panelSaisie( String type, Component composant )
	{
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout( new GridLayout(2,1) );

		panelTmp.add( new JLabel(type+" : ") );
		panelTmp.add( composant );

		return panelTmp;
	}

	public Texte getTexte()
	{
		Texte texte = new Texte( this.txtTexte.getText() );

		texte.setTaille( this.saisieTaille.getValeur() );
		texte.setCouleur( this.saisieRGB.getCouleur() );
		texte.setPosition( this.saisiePosition.getPosition() );
		return texte;
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	@Override
	public void valueChanged()
	{
		this.panelSaisieListener.valueChanged();
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		this.panelSaisieListener.valueChanged(); // Le texte a été inséré
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		this.panelSaisieListener.valueChanged(); // Le texte a été supprimé
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		this.panelSaisieListener.valueChanged();
	}
}
