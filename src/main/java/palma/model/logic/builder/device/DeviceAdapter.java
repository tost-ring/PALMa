package palma.model.logic.builder.device;

import palma.model.logic.builder.Input;
import palma.model.logic.builder.Output;
import palma.model.logic.builder.Parameter;
import palma.model.logic.builder.ParameterCase;
import palma.model.logic.writer.XMLNode;
import palma.model.logic.writer.XMLizable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstrakcyjne urzadzenie. Kazde urzadzenie jest budowane przez rozszerzenie tej klasy,
 * dodajac w konstruktorze odpowiednie wejscia, wyjscia i parametry, oraz ustawiajac nazwe urzadzenia.
 */
public abstract class DeviceAdapter implements XMLizable {

    private String name;
    private List<Input> inputs;
    private List<Output> outputs;
    private ParameterCase parameters;

    public DeviceAdapter() {
        this("");
    }

    public DeviceAdapter(String name) {
        this.name = name;
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        parameters = new ParameterCase();
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public ParameterCase getParameters() {
        return parameters;
    }

    /**
     * @return Dla urzadzen powinna zwracac false, dla funkcji true
     */
    public boolean isGraphical() {
        return true;
    }

    /**
     * Indywidualna nazwa urzadzenia
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Domyslna nazwa urzadzenia
     * @return
     */
    public abstract String getDefaultName();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public XMLNode toXmlNode() {
        XMLNode node = new XMLNode(isGraphical() ? "device" : "function");
        node.add("name", name);
        node.getChildren().addAll(getInputs());
        node.getChildren().addAll(getOutputs());
        return node;
    }
}
