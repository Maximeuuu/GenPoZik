package genpozik.vue;

import genpozik.vue.evenement.*;

import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SaisieRGB extends JPanel implements DocumentListener
{
	private static final Color COULEUR_DEFAUT = new Color(255,255,255,255);

	private PanelSaisieListener panelSaisieListener;

    private JTextField txtRouge;
    private JTextField txtVert;
    private JTextField txtBleu;
	private boolean opaciteActive;
	private JTextField txtOpacite;

	public SaisieRGB( boolean opaciteActive )
	{
		this.opaciteActive = opaciteActive;
		this.setLayout( new GridLayout(1, 4) );

		// Création des composants
        this.txtRouge = RGBTextField();
        this.txtVert  = RGBTextField();
        this.txtBleu  = RGBTextField();
		if( opaciteActive ){ this.txtOpacite = RGBTextField(); }

		// Positionnement
        this.add(this.txtRouge);
        this.add(this.txtVert);
        this.add(this.txtBleu);
		if( opaciteActive ){ this.add(this.txtOpacite); }

		// Activation
		this.txtRouge.getDocument().addDocumentListener( this );
		this.txtVert.getDocument().addDocumentListener( this );
		this.txtBleu.getDocument().addDocumentListener( this );
		if( opaciteActive ){ this.txtOpacite.getDocument().addDocumentListener( this ); }
	}

	public SaisieRGB()
	{
		this( false );
	}

	private JTextField RGBTextField()
	{
        JTextField txt = new JTextField(3);
        PlainDocument doc = (PlainDocument) txt.getDocument();
        doc.setDocumentFilter(new IntRangeDocumentFilter(0, 255));
        return txt;
    }

    public Color getCouleur()
	{
		try
		{
			int rouge = Integer.parseInt(txtRouge.getText());
			int vert  = Integer.parseInt(txtVert.getText());
			int bleu  = Integer.parseInt(txtBleu.getText());
			if( !opaciteActive ){ return new Color( rouge, vert, bleu ); }

			int opacite = Integer.parseInt(txtOpacite.getText());
			return new Color( rouge, vert, bleu, opacite );
		}
		catch( Exception e ){}
		return COULEUR_DEFAUT;
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	@Override
    public void insertUpdate(DocumentEvent e) {
		this.panelSaisieListener.valueChanged();
        // Le texte a été inséré
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
		this.panelSaisieListener.valueChanged();
        // Le texte a été supprimé
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
		this.panelSaisieListener.valueChanged();
    }

	/**
	 * @author ChatGPT
	 */
	class IntRangeDocumentFilter extends DocumentFilter {
	    private int minValue;
	    private int maxValue;
	    private Pattern intPattern = Pattern.compile("\\d+");

	    public IntRangeDocumentFilter(int minValue, int maxValue) {
	        this.minValue = minValue;
	        this.maxValue = maxValue;
	    }

	    @Override
	    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
	            throws BadLocationException {
	        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
	        sb.insert(offset, text);
	        if (isValidValue(sb.toString())) {
	            super.insertString(fb, offset, text, attr);
	        }
	    }

	    @Override
	    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
	            throws BadLocationException {
	        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
	        sb.replace(offset, offset + length, text);
	        if (isValidValue(sb.toString())) {
	            super.replace(fb, offset, length, text, attrs);
	        }
	    }

	    private boolean isValidValue(String text) {
	        if (intPattern.matcher(text).matches()) {
	            int value = Integer.parseInt(text);
	            return value >= minValue && value <= maxValue;
	        }
	        return false;
	    }
	}
}
