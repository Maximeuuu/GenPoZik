package genpozik.vue;

import genpozik.vue.event.*;

import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SaisiePos extends JPanel implements ChangeListener
{
	private static final Point POSITION_DEFAUT = new Point(200,200); //millieu de l'image ? -> passer en paramètre de constructeur ?

	private PanelSaisieListener panelSaisieListener;

    private JSpinner spPosX;
    private JSpinner spPosY;
	//checkbox positionnable ?

	public SaisiePos()
	{
		// Configuration
		this.setLayout( new FlowLayout( FlowLayout.LEFT ) );

		// Création des composants
        this.spPosX = PosSpinner();
        this.spPosY = PosSpinner();

		// Positionnement des composants
		this.add( new JLabel("x:") );
        this.add(this.spPosX);
        this.add( new JLabel("  y:") );
        this.add(this.spPosY);

		// Activation des composants
		this.spPosX.addChangeListener( this );
		this.spPosY.addChangeListener( this );
	}

	private JSpinner PosSpinner()
	{
		SpinnerModel spinnerModel = new SpinnerNumberModel(200, 0, 400, 1); //à remplacer par les dimensions de l'image
        return new JSpinner( spinnerModel );
    }

    public Point getPosition()
	{
		try
		{
			int x = (int) this.spPosX.getValue();
			int y = (int) this.spPosY.getValue();

			return new Point( x, y );
		}
		catch( Exception e ){}
		return new Point(200,200);
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		this.panelSaisieListener.valueChanged();
	}

}
