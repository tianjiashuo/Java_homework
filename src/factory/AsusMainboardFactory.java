package factory;

import element.AsusMainboard;
import element.Mainboard;

public class AsusMainboardFactory implements Mainboard {
    public Mainboard produce(){
        return new AsusMainboard();
    }
}
