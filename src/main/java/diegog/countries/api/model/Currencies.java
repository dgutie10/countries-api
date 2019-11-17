package diegog.countries.api.model;

public class Currencies {
    private String code;
    private String name;
    private String symbol;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

}
