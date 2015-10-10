package mx.x10.apeelingtech.app.events;

/**
 * Created by christian on 10/9/15.
 */
public class EventDispatcher {

    private Event event;

    public EventDispatcher(Event event) {
        this.event = event;
    }

    public void dispatch(Event.Type type, EventHandler handler) {
        if (event.handled)
            return;

        if (event.getType() == type) {
            event.handled = handler.onEvent(event);
        }
    }

}
