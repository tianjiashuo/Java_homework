package factory;

import element.GigabyteMainboard;
import element.Mainboard;

public class GigabyteMainboardFactory implements MainboardProvider {
    public Mainboard produce(){
        return new GigabyteMainboard();
    }
}
