package diegog.countries.api.model;

import java.util.List;

public class RegionalBlocs {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;

    public String getName() {
        return name;
    }

    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }
}
