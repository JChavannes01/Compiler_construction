package pp.block4.cc.test;

//import org.junit.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;

public class IlocTest {
    private Program maxIlocProg;
    private Program fibMemProg;
    private Program fibRegProg;
    private Assembler maxIlocAssembler;
    private Assembler fibRegAssembler;
    private Assembler fibMemAssembler;
    @Before
    public void setup() {
        this.maxIlocAssembler = new Assembler();
        this.fibRegAssembler = new Assembler();
        this.fibMemAssembler = new Assembler();
        File maxIlocFile = new File("src/pp/block4/cc/iloc/max.iloc");
        File fibRegFile = new File("src/pp/block4/cc/iloc/fib-reg.iloc");
        File fibMemFile = new File("src/pp/block4/cc/iloc/fib-mem.iloc");
        try {
            maxIlocProg = maxIlocAssembler.assemble(maxIlocFile);
            fibRegProg = maxIlocAssembler.assemble(fibRegFile);
            fibMemProg = maxIlocAssembler.assemble(fibMemFile);
        } catch (FormatException | IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void assembleTest() {
        System.out.println(maxIlocProg.prettyPrint());
        String result = maxIlocProg.toString().replaceAll("\\s", "");
        String max_iloc = "start: loadI 0 => r_max           // Line 1: max = 0;\n" +
                "       loadI 0 => r_i             // Line 2: int i = 0;\n" +
                "       loadI @alength => r_len\n" +
                "while: cmp_LT r_i,r_len => r_cmp  // Line 3: while (i < a.length)\n" +
                "       cbr r_cmp -> body, end\n" +
                "body:  i2i r_i => r_a             // compute address of a[i]\n" +
                "       multI r_a,4 => r_a         // multiply by size of int\n" +
                "       addI r_a,@a => r_a         // add a's base offset\n" +
                "       loadAO r_arp,r_a => r_ai   // r_ai <- a[i]\n" +
                "       cmp_GT r_ai,r_max => r_cmp // Line 4: if (a[i] > max)\n" +
                "       cbr r_cmp -> then,endif\n" +
                "then:  i2i r_ai => r_max          // Line 5: max = a[i];\n" +
                "endif: addI r_i,1 => r_i          // Line 7: i = i + 1;\n" +
                "       jumpI -> while\n" +
                "end:   out \"Max: \", r_max         // Line 9: out; not \"official ILOC\"";
        Assert.assertEquals(max_iloc.replaceAll("\\s", ""), result);
    }

    @Test
    public void simulationTest_maxIloc() {
        Simulator simulator = new Simulator(maxIlocProg);
        Machine machine = simulator.getVM();
        machine.init("a", 1, 2, 3);
        machine.setNum("alength", 3);
        simulator.run();
        int r_max = machine.getReg("r_max");
        Assert.assertEquals(3 ,r_max);
        /*Every memory location is 1 byte long.
        * An int value consists of 4 bytes, so you need 4 memory locatons to store an int value.*/
    }

    @Test
    public void simulationTest_fibReg() {
        Simulator simulator = new Simulator(fibRegProg);
        Machine machine = simulator.getVM();
        machine.init("n", 10);
        simulator.run();
        int r_z = machine.getReg("r_z");
        Assert.assertEquals( 89, r_z);
    }

    @Test
    public void simulationTest_fibMem() {
        Simulator simulator = new Simulator(fibMemProg);
        Machine machine = simulator.getVM();
        machine.init("n", 45);
        machine.init("x", 1);
        machine.init("y", 1);
        machine.init("z", 1);
        simulator.run();
        int r_z = machine.getReg("r_z");
        Assert.assertEquals(1836311903 ,r_z);
    }




}