import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * Created by reg on 03/12/2016.
 */
public class ModelServerTest {
    @Test
    public void execute() throws Exception {

        ModelServer ms = new ModelServer();

        HashMap inputs = new HashMap();
        inputs.put("days", 43);
        inputs.put("rate", 750.49);

        Map outputs = ms.execute("Contractors", inputs);

        assertEquals(43 * 750.48, outputs.get("cost"));
    }

}