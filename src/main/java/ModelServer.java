import java.util.Map;

public class ModelServer {

    public Map execute(String modelName, Map inputs) {

        Model model = getModel(modelName);

        Map outputs = model.execute(inputs, null);

        return outputs;
    }

    private Model getModel(String modelName) {
        Model model = null;
        try {
            Class<Model> modelClass = (Class<Model>) Class.forName(modelName);

            model = modelClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return model;
    }

}
