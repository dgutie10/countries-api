package diegog.countries.api.main.utils;

import diegog.countries.api.model.*;

import java.util.List;

public class Logger {
    public Logger(){
    }

    /**
     *
     * @param country object to  log to console
     */
    public void countryLogger(Country country){
        System.out.println("######  Country Model: " + country.getName() + "  ######");
        System.out.println("Name: " + country.getName());
        System.out.println("Top Level Domain: " + country.getTopLevelDomain());
        System.out.println("Alpha Code 2:" + country.getAlpha2Code());
        System.out.println("Alpha Code 3:" + country.getAlpha3Code());
        System.out.println("Calling Code: " + country.getCallingCodes());
        System.out.println("Alternative Spelling: " + country.getAltSpellings());
        System.out.println("Region: " + country.getRegion());
        System.out.println("Subregion: " + country.getSubregion());
        System.out.println("Population: " + country.getPopulation());
        System.out.println("Latitude and Longitude: " + country.getLatlng());
        System.out.println("Denonym: " + country.getDemonym());
        System.out.println("Area:" + country.getArea());
        System.out.println("Gini: " + country.getGini());
        System.out.println("Timezones: " + country.getTimezones());
        System.out.println("Borders: " + country.getBorders());
        System.out.println("Native Name: " + country.getNativeName());
        System.out.println("Numeric code: " + country.getNumericCode());
        System.out.println("Flag Location: " + country.getFlag());
        System.out.println("CIOC: " + country.getCioc());
        currencyLogger(country.getCurrencies());
        languageLogger(country.getLanguages());
        tranlationLogger(country.getTranslations());
        regionalBlocsLogger(country.getRegionalBlocs());
    }

    /**
     *
     * @param currencies object to log to console
     */
    public void  currencyLogger(List<Currencies> currencies){
        System.out.println("Currency Information:");
        currencies.forEach((currencie) ->{
            System.out.println("\tCode: " + currencie.getCode());
            System.out.println("\tName: " + currencie.getName());
            System.out.println("\tSymbol: " + currencie.getSymbol());
        });
    }

    /**
     *
     * @param languages object to log to console
     */
    public void languageLogger(List<Languages> languages){
        System.out.println("Language Information:");
        languages.forEach((language) -> {
            System.out.println("\tName: " + language.getName());
            System.out.println("\tNative Name: " + language.getNativeName());
            System.out.println("\tiso639_1: " + language.getIso639_1());
            System.out.println("\tiso639_2: " + language.getIso639_2());
        });
    }

    /**
     *
     * @param translations object to log to console
     */
    public void tranlationLogger(Translations translations){
        System.out.println("Translation Information:");
        System.out.println("\tES: " + translations.getEs());
        System.out.println("\tFR: " + translations.getFr());
        System.out.println("\tDE: " + translations.getDe());
        System.out.println("\tJA: " + translations.getJa());
        System.out.println("\tIT: " + translations.getIt());
        System.out.println("\tBR: " + translations.getBr());
        System.out.println("\tPT: " + translations.getPt());
        System.out.println("\tNL: " + translations.getNl());
        System.out.println("\tHR: " + translations.getHr());
    }

    /**
     *
     * @param regionalBlocs object to log to console
     */
    public void regionalBlocsLogger(List<RegionalBlocs> regionalBlocs){
        System.out.println("Regional Organization Information:");
        regionalBlocs.forEach((regionalBloc) -> {
            System.out.println("\tName: " + regionalBloc.getName());
            System.out.println("\tAcronym: " + regionalBloc.getAcronym());
            System.out.println("\tOther Acronyms: " + regionalBloc.getOtherAcronyms());
            System.out.println("\tOther Names: " + regionalBloc.getOtherNames());
        });
    }

    /**
     *
     * @param countries arry of object Country to loop to log
     */
    public void logCountriesArray(Country[] countries){
        for (Country country : countries) {
            countryLogger(country);
        }
    }
}
