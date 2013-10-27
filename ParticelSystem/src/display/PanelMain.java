package display;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import common.Position;

public class PanelMain extends JPanel implements MouseInputListener
{
	private final Scene mScene;

	public PanelMain(final Scene aScene)
	{
		mScene = aScene;
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics aGraphics)
	{

		aGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		mScene.draw(aGraphics);
	}

	@Override
	public void mouseClicked(MouseEvent aEvent)
	{
		int x = aEvent.getX();
		int y = aEvent.getY();

		mScene.mouseClicked(new Position(x, y));
	}

	@Override
	public void mouseEntered(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent aArg0)
	{
		// TODO Auto-generated method stub

	}

}
