package factory;

import element.KingstonMemory;
import element.Memory;

public class KingstonMemoryFactory implements MemoryProvider{
    public Memory produce(){
        return new KingstonMemory();
    }
}
