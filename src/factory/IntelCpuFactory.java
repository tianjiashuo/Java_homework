package factory;

import element.CPU;
import element.IntelCPU;

public class IntelCpuFactory implements CpuProvider{
    public CPU produce(){
        return new IntelCPU();
    }
}
