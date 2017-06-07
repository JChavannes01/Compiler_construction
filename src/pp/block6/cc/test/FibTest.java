package pp.block6.cc.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class FibTest {
    private final static String PATH = "src/pp/block6/cc/sample/";

    private Assembler assembler;
    private Program prog;

    @Before
    public void setup() {
        this.assembler = new Assembler();

        File file = new File(PATH + "fib.iloc");
        try {
            this.prog = assembler.assemble(file);
        } catch (FormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simulationTest() {
        Simulator sim = new Simulator(prog);
        Machine machine = sim.getVM();

        // Set in and out streams and run
        sim.setIn(new ByteArrayInputStream("5".getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sim.setOut(out);
        sim.run();

        // Print and test results
        System.out.println(out);
        int result = machine.getReg("r_res");
//        Assert.assertEquals(10946, result);
        Assert.assertEquals(8, result);
    }

}
