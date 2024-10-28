package animation_test.circles.sprites;

import animation_test.common.Interactable;
import animation_test.common.MainCanvas;

import java.awt.*;

public class Background implements Interactable {
    private static final float AMPLITUDE = 255f / 2;
    private float time;
    private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}