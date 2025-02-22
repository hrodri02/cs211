import javafx.event.*;

public class CalculatorController implements EventHandler {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
        this.view.setButtonsHandler(this);
    }

    @Override
    public void handle(Event event) {
        Object src = event.getSource();
        String operator = model.getOperator();

        // clear button was pressed
        if (src.equals(view.getButtonAtIndex(12))) {
            view.resetInput();
        }
        // operator button was pressed
        else if (src.equals(view.getButtonAtIndex(3)) || src.equals(view.getButtonAtIndex(7)) || 
                src.equals(view.getButtonAtIndex(11)) || src.equals(view.getButtonAtIndex(15))) {
            model.setOperator(view.getButtonText(src));
        }
        // equals button was pressed
        else if (src.equals(view.getButtonAtIndex(14))) {
            if (operator != null) {
                Double res = 0.0;
                switch (operator) {
                    case "+":
                        res = model.add();
                        break;
                    case "-":
                        res = model.subtract();
                        break;
                    case "x":
                        res = model.multiply();
                        break;
                    case "/":
                        res = model.divide();
                        break;
                }
                view.setInputText(Double.toString(res));;
            }
        }
        // number or dot button was pressed
        else {
            String character = view.getButtonText(src);
            if (operator == null) {
                Double firstOperand = model.getFirstOperand();
                String currText = view.getInputText();
                boolean containsDot = currText.contains(character);
                if (containsDot) {
                    System.out.println("the input contains a dot already");
                }
                String res = (firstOperand == null)? character : currText + character;
                view.setInputText(res);
                firstOperand = Double.parseDouble(res);
                model.setFirstOperand(firstOperand);
            }
            else {
                Double secondOperand = model.getSecondOperand();
                String res = (secondOperand == null)? character : view.getInputText() + character;
                view.setInputText(res);
                secondOperand = Double.parseDouble(res);
                model.setSecondOperand(secondOperand);
            }
        }
    }
}
