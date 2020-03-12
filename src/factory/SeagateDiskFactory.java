package factory;

import element.Disk;
import element.SeagateDisk;

public class SeagateDiskFactory implements DiskProvider {
    public Disk produce(){
        return new SeagateDisk();
    }
}
