package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.vue.evenement.*;

import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SaisieTexte extends JPanel implements DocumentListener, PanelSaisieListener
{
	private PanelSaisieListener panelSaisieListener;

	private JTextField txtTexte;
	private JTextField txtTaille;
	private SaisieRGB  saisieRGB;
	//saisieCoordonnees

    public SaisieTexte( String titre )
	{
        this.setLayout( new GridLayout(4, 1) );

        JLabel lbl = new JLabel( titre );
        this.txtTexte  = new JTextField();
        this.txtTaille = new JTextField();
        this.saisieRGB = new SaisieRGB();

        this.add(lbl);
		this.add( panelSaisie( "Texte", this.txtTexte ) );
		this.add( panelSaisie( "Taille", this.txtTaille ) );
		this.add( panelSaisie( "Couleur", this.saisieRGB ) );

		this.txtTexte.getDocument().addDocumentListener(this);
        this.txtTaille.getDocument().addDocumentListener(this);
        this.saisieRGB.setPanelSaisieListener(this);
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
		try
		{
			texte.setTaille( Integer.parseInt( this.txtTaille.getText() ) );
		}
		catch( Exception e ){}

		texte.setCouleur( this.saisieRGB.getCouleur() );
		return texte;
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	@Override
	public void valueChanged()
	{
		System.out.println("Changement dans panel SaisieText via SaisieRGB");
		this.panelSaisieListener.valueChanged();
	}

	@Override
    public void insertUpdate(DocumentEvent e) {
		System.out.println("Changement dans panel SaisieText");
		this.panelSaisieListener.valueChanged();
        // Le texte a été inséré
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
		System.out.println("Changement dans panel SaisieText");
		this.panelSaisieListener.valueChanged();
        // Le texte a été supprimé
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
		System.out.println("Changement dans panel SaisieText");
		this.panelSaisieListener.valueChanged();
		//fireActionPerformed
    }
}
