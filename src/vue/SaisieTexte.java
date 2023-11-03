package genpozik.vue;

import genpozik.modele.Texte;
import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;

public class SaisieTexte extends JPanel implements ActionListener
{
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
}
