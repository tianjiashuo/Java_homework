package factory;

import element.AmdCPU;
import element.CPU;

public class AmdCpuFactory implements CpuProvider {
    public CPU produce(){
        return new AmdCPU();
    }
}
