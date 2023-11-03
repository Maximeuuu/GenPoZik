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

	public Controleur()
	{
		this.modele = new GenerateurImage();
		this.test();
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

	public void maj( Texte texteA, Texte texteT, Texte texteD )
	{
		this.modele.setAuteur( texteA );
		this.modele.setTitre( texteT );
		this.modele.setDate( texteD );
		this.majIHM();
	}

	public void test()
	{
		this.modele.setCouleurBg1( new Color(255,255,200) );
		this.modele.setCouleurBg2( new Color(255,255,100) );

		//this.modele.setCheminImageBg(File cheminImageBg) { this.cheminImageBg = cheminImageBg; }
		this.modele.setImageBgMode( false );

		this.modele.setCouleurFg( new Color(122,0,122,50) );
		this.modele.setCheminImageModeleFg( new File("../data/modele.png") );

		this.modele.setAuteur( new Texte("Maxime", 10,  new Color(0,0,0)) );
		this.modele.setTitre( new Texte("Mes favoris", 14, new Color(0,0,0)) );
		this.modele.setDate( new Texte("novembre 2023", 12, new Color(0,0,0)) );
	}
}
