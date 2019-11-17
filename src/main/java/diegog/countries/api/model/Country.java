package diegog.countries.api.model;

import java.util.List;

public class Country {
    private String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private int population;
    private List<Integer> latlng;
    private String demonym;
    private String area;
    private String gini;
    private List<String> timezones;
    private List<String> borders;
    private String nativeName;
    private String numericCode;
    private List<Currencies> currencies;
    private List<Languages> languages;
    private Translations translations;
    private String flag;
    private List<RegionalBlocs> regionalBlocs;
    private String cioc;

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public int getPopulation() {
        return population;
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public List<Integer> getLatlng() {
        return latlng;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public List<RegionalBlocs> getRegionalBlocs() {
        return regionalBlocs;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public List<String> getBorders() {
        return borders;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public String getCioc() {
        return cioc;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getFlag() {
        return flag;
    }

    public String getGini() {
        return gini;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setGini(String gini) {
        this.gini = gini;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public void setLatlng(List<Integer> latlng) {
        this.latlng = latlng;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRegionalBlocs(List<RegionalBlocs> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }
}
