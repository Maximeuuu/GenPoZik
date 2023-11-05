package genpozik.modele;

import java.awt.Color;
import java.io.File;

/**
 * @author Maximeuuu
 * @date 03-11-23
 */
public class ProprietesImage
{
	private Color couleurBg1;
	private Color couleurBg2;
	private File cheminImageBg;
	private boolean estImageBgMode;

	private Color couleurFg;
	private File cheminImageModeleFg;

	private Texte auteur; //Remplacer par la suite par une liste de Texte
	private Texte titre;
	private Texte date;

	public ProprietesImage()
	{
		this.setAlldefaut();
	}

	public void setAlldefaut()
	{
		this.couleurBg1 = new Color(0,0,0,0);
		this.couleurBg2 = new Color(0,0,0,0);
		this.cheminImageBg = null;
		this.estImageBgMode = false;

		this.cheminImageModeleFg = null;
		this.couleurFg = new Color(0,0,0,0);

		this.auteur = new Texte();
		this.titre = new Texte();
		this.date = new Texte();
	}

	public Color getCouleurBg1() { return couleurBg1; }
	public Color getCouleurBg2() { return couleurBg2; }
	public File getCheminImageBg() { return cheminImageBg; }
	public boolean estImageBgMode() { return this.estImageBgMode; }
	public Color getCouleurFg() { return couleurFg; }
	public File getCheminImageModeleFg() { return cheminImageModeleFg; }
	public Texte getAuteur() { return auteur; }
	public Texte getTitre() { return titre; }
	public Texte getDate() { return date; }

	public void setCouleurBg1(Color couleurBg1) { this.couleurBg1 = couleurBg1; }
	public void setCouleurBg2(Color couleurBg2) { this.couleurBg2 = couleurBg2; }
	public void setCheminImageBg(File cheminImageBg) { this.cheminImageBg = cheminImageBg; }
	public void setImageBgMode( boolean etat ){ this.estImageBgMode = etat; }
	public void setCouleurFg(Color couleurFg) { this.couleurFg = couleurFg; }
	public void setCheminImageModeleFg( File cheminImageModeleFg ){ this.cheminImageModeleFg = cheminImageModeleFg; }
	public void setAuteur(Texte auteur) { this.auteur = auteur; }
	public void setTitre(Texte titre) { this.titre = titre; }
	public void setDate(Texte date) { this.date = date; }

}
