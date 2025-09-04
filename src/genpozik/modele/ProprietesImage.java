package genpozik.modele;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

	private List<Texte> ensTexte;

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

		this.ensTexte = new ArrayList<>();
	}

	public Color getCouleurBg1() { return this.couleurBg1; }
	public Color getCouleurBg2() { return this.couleurBg2; }
	public File getCheminImageBg() { return this.cheminImageBg; }
	public boolean estImageBgMode() { return this.estImageBgMode; }
	public Color getCouleurFg() { return this.couleurFg; }
	public File getCheminImageModeleFg() { return this.cheminImageModeleFg; }
	public List<Texte> getEnsTexte() { return this.ensTexte; }

	public void setCouleurBg1(Color couleurBg1) { this.couleurBg1 = couleurBg1; }
	public void setCouleurBg2(Color couleurBg2) { this.couleurBg2 = couleurBg2; }
	public void setCheminImageBg(File cheminImageBg) { this.cheminImageBg = cheminImageBg; }
	public void setImageBgMode( boolean etat ){ this.estImageBgMode = etat; }
	public void setCouleurFg(Color couleurFg) { this.couleurFg = couleurFg; }
	public void setCheminImageModeleFg( File cheminImageModeleFg ){ this.cheminImageModeleFg = cheminImageModeleFg; }
	public void setTextes(List<Texte> ensTexte) { this.ensTexte = ensTexte; }

}
