package factory;

import element.Memory;
import element.SamsungMemory;

public class SamsungMemoryFactory implements MemoryProvider {
    public Memory produce(){
        return new SamsungMemory();
    }
}
