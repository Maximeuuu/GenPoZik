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
	private static final Color COULEUR_DEFAUT = new Color(255,255,255);

	private PanelSaisieListener panelSaisieListener;

    private JTextField txtRouge;
    private JTextField txtVert;
    private JTextField txtBleu;
	//txtOpacite

    public SaisieRGB()
	{
        this.setLayout( new GridLayout(1, 3) );

        //JLabel lbl = new JLabel( lblTitre );
        this.txtRouge = RGBTextField();
        this.txtVert  = RGBTextField();
        this.txtBleu  = RGBTextField();

        //this.add(lbl);
        this.add(txtRouge);
        this.add(txtVert);
        this.add(txtBleu);

		//Activation
		this.txtRouge.getDocument().addDocumentListener( this );
		this.txtVert.getDocument().addDocumentListener( this );
		this.txtBleu.getDocument().addDocumentListener( this );
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
			return new Color( rouge, vert, bleu );
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
		System.out.println("Changement dans panel SaisieRGB");
		this.panelSaisieListener.valueChanged();
        // Le texte a été inséré
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
		System.out.println("Changement dans panel SaisieRGB");
		this.panelSaisieListener.valueChanged();
        // Le texte a été supprimé
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("Changement dans panel SaisieRGB");
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
