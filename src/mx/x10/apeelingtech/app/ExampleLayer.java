package mx.x10.apeelingtech.app;

import mx.x10.apeelingtech.app.events.Event;
import mx.x10.apeelingtech.app.events.EventDispatcher;
import mx.x10.apeelingtech.app.events.types.MouseMovedEvent;
import mx.x10.apeelingtech.app.events.types.MousePressedEvent;
import mx.x10.apeelingtech.app.events.types.MouseReleasedEvent;
import mx.x10.apeelingtech.app.layers.Layer;

import java.awt.*;
import java.util.Random;

/**
 * Created by christian on 10/9/15.
 */
public class ExampleLayer extends Layer {

    private String name;
    private Color color;
    private Rectangle box;

    private int px, py;
    private boolean dragging = false;

    private static final Random random = new Random();

    public ExampleLayer(String name, Color color) {
        this.name = name;
        this.color = color;
        this.box = new Rectangle(random.nextInt(300) + 100, random.nextInt(200) + 80, 80, 50);
    }

    @Override
    public void onEvent(Event event) {
        EventDispatcher dispatcher = new EventDispatcher(event);
        dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> onMousePressed((MousePressedEvent) e));
        dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> onMouseReleased((MouseReleasedEvent) e));
        dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) -> onMouseMoved((MouseMovedEvent) e));
    }

    public boolean onMousePressed(MousePressedEvent e) {
        if (box.contains(new Point(e.getX(), e.getY())))
            dragging = true;

        return dragging;
    }

    public boolean onMouseReleased(MouseReleasedEvent e) {
        dragging = false;

        return false;
    }

    public boolean onMouseMoved(MouseMovedEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (dragging) {
            box.x += x - px;
            box.y += y - py;
        }

        px = x;
        py = y;

        return dragging;
    }

    @Override
    public void onRender(Graphics g) {
        g.setColor(color);
        g.fillRect(box.x, box.y, box.width, box.height);

        g.setColor(Color.white);
        g.drawString(name, box.x + 5, box.y + 15);
    }

}
