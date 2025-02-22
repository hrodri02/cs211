public class CalculatorModel {
    private Double first;
    private Double second;
    private String operator;

    public Double getFirstOperand() {
        return this.first;
    }

    public Double getSecondOperand() {
        return this.second;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setFirstOperand(Double first) {
        this.first = first;
    }

    public void setSecondOperand(Double second) {
        this.second = second;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double add() {
        return first + second;
    }

    public Double subtract() {
        return first - second;
    }

    public Double multiply() {
        return first * second;
    }

    public Double divide() {
        return first / second;
    }
}
