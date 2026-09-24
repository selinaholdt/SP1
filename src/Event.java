import java.util.ArrayList;

public class Event {
    Venue venue;
    ArrayList<Band> bands;
    int eventType;

    Event(Venue venue, ArrayList<Band> bands){
        this.venue = venue;
        this.bands = bands;
    }
}
