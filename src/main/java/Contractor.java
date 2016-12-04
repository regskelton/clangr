import java.util.HashMap;
import java.util.Map;

public class Contractor implements Model {
    @Override
    public Map execute(Map inputs, Map referenceData) {

        Double rate = (Double) inputs.get("rate");
        Integer days = (Integer) inputs.get("days");

        HashMap outputs = new HashMap();

        outputs.put("cost", rate * days);

        return outputs;
    }
}
