package factory;

import element.Disk;
import element.WestDigitalsDisk;

public class WestDigitalsDiskFactory implements DiskProvider{
    public Disk produce(){
        return new WestDigitalsDisk();
    }
}
