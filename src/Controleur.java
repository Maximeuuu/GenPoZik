package genpozik;

import genpozik.modele.*;
import genpozik.vue.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;

public class Controleur
{
	private Fenetre vue;
	private GenerateurImage modele;
	public static final String REP_IMAGE = "../data/";

	public Controleur()
	{
		this.modele = new GenerateurImage();
		this.initValeur(); //à remplacer par des valeurs initiales récupérées dans la vue
		this.vue = new Fenetre( this );
	}

	public BufferedImage getImage()
	{
		this.modele.maj();
		return this.modele.getImage();
	}

	public static void main( String[] args )
	{
		new Controleur();
	}

	public void majIHM()
	{
		System.out.println("maj ihm");
		this.vue.maj();
	}

	public void majTxt( Texte texteA, Texte texteT, Texte texteD )
	{
		this.modele.setAuteur( texteA );
		this.modele.setTitre( texteT );
		this.modele.setDate( texteD );
		this.majIHM();
	}

	public void majBg( Color coul1, Color coul2 )
	{
		this.modele.setCouleurBg1( coul1 );
		this.modele.setCouleurBg2( coul2 );
		this.modele.setImageBgMode( false ); //checkbox par la suite ?
		this.majIHM();
	}

	public void majFg( Color coul )
	{
		this.modele.setCouleurFg( coul );
		this.majIHM();
	}

	public void initValeur()
	{
		/*this.modele.setCouleurBg1( new Color(0,0,0) );
		this.modele.setCouleurBg2( new Color(0,0,0) );

		//this.modele.setCheminImageBg(File cheminImageBg) { this.cheminImageBg = cheminImageBg; }
		this.modele.setImageBgMode( false );

		this.modele.setCouleurFg( new Color(0,0,0,0) );*/
		this.modele.setCheminImageModeleFg( new File(Controleur.REP_IMAGE+"modele.png") );

		/*this.modele.setAuteur( new Texte("", 0,  new Color(0,0,0)) );
		this.modele.setTitre( new Texte("", 0, new Color(0,0,0)) );
		this.modele.setDate( new Texte("", 0, new Color(0,0,0)) );*/
	}
}
