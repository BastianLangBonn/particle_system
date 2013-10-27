package display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import common.Force;
import common.ParticleSystem;
import common.Position;

public class Scene
{
	private final List<ParticleSystem> mParticleSystems = new ArrayList<ParticleSystem>();
	private final Force GRAVITY = new Force(0, 30);

	public void mouseClicked(final Position aPosition)
	{
		int emissionRate = 10;
		int mParticleLifetime = 1000;
		ParticleSystem particleSystem = new ParticleSystem.Builder(aPosition, emissionRate, mParticleLifetime)//
				.horizontalSpreading(2000)//
				.verticalSpreading(2000)//
				.startColor(new Color(Color.yellow.getRed() / 255, Color.yellow.getGreen() / 255, Color.yellow.getBlue() / 255, 1f))//
				.endColor(new Color(Color.red.getRed() / 255, Color.red.getGreen() / 255, Color.red.getBlue() / 255, 0f))//
				.build();
		mParticleSystems.add(particleSystem);
	}

	public void draw(Graphics aGraphicsContext)
	{
		for (ParticleSystem particleSystem : mParticleSystems)
		{
			particleSystem.draw(aGraphicsContext, 1);
		}

	}

	public void update(double aTimeIntervall)
	{
		for (ParticleSystem particleSystem : mParticleSystems)
		{
			particleSystem.update(GRAVITY, aTimeIntervall);
		}
	}
}
