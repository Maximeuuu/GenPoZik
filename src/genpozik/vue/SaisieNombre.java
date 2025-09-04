package genpozik.vue;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import genpozik.vue.event.PanelSaisieListener;

public class SaisieNombre extends JPanel implements ChangeListener
{
	private PanelSaisieListener panelSaisieListener;

	private JSpinner spNombre;

	public SaisieNombre( int valeur, int min, int max )
	{
		this.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(valeur, min, max, 1);
		this.spNombre = new JSpinner( spinnerModel );
		this.add( this.spNombre );
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	public int getValeur()
	{
		return (int)this.spNombre.getValue();
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		this.panelSaisieListener.valueChanged();
	}
}
