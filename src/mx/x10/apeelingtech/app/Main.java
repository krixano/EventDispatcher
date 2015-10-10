package mx.x10.apeelingtech.app;

import mx.x10.apeelingtech.app.core.Window;

import java.awt.*;

/**
 * Created by christian on 10/9/15.
 */
public class Main {

    public static void main(String[] args) {
        Window window = new Window("Events", 640, 360);
        window.addLayer(new ExampleLayer("Bottom", new Color(0x2233CC)));
        window.addLayer(new ExampleLayer("Top", new Color(0xCC2233)));
    }

}
