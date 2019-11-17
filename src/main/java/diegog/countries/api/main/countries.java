package diegog.countries.api.main;

import diegog.countries.api.main.utils.Logger;
import diegog.countries.api.model.Country;
import org.apache.commons.lang3.text.WordUtils;
import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class countries {
    private static HashMap<String, String> commands = new HashMap<>();
    private List<String> regions = Arrays.asList("Africa", "Americas", "Asia", "Europe", "Oceania");
    private HashMap<String, String> regionalBloc = new HashMap<>();
    public boolean exit = false;
    private Scanner input = new Scanner(System.in);
    private ApiService apiService = new ApiService();
    private Logger logger = new Logger();

    public enum CommandType {
        ALL("all"),
        NAME("name"),
        FULL("full"),
        CODE("code"),
        CODES("codes"),
        CURRENCY("currency"),
        LANGUAGE("language"),
        CAPITAL("capital"),
        CALLING("calling"),
        REGION("region"),
        BLOC("bloc"),
        EXIT("exit");

        String command;

        CommandType(String command){this.command = command; }

        public String getValue(){ return this.command;}
    }

    public countries() {

        //Initializing List of commands
        commands.put("List all countries", WordUtils.capitalizeFully(CommandType.ALL.toString()));
        commands.put("Search by country name (It can be the native name or partial name)", WordUtils.capitalizeFully(CommandType.NAME.toString()));
        commands.put("Search by country full name", WordUtils.capitalizeFully(CommandType.FULL.toString()));
        commands.put("Search by ISO 3166-1 2-letter or 3-letter country code", WordUtils.capitalizeFully(CommandType.CODE.toString()));
        commands.put("Search by list of ISO 3166-1 2-letter or 3-letter country codes", WordUtils.capitalizeFully(CommandType.CODES.toString()));
        commands.put("Search by ISO 4217 currency code", WordUtils.capitalizeFully(CommandType.CURRENCY.toString()));
        commands.put("Search by ISO 639-1 language code", WordUtils.capitalizeFully(CommandType.LANGUAGE.toString()));
        commands.put("Search by capital city", WordUtils.capitalizeFully(CommandType.CAPITAL.toString()));
        commands.put("Search by calling code", WordUtils.capitalizeFully(CommandType.CALLING.toString()));
        commands.put("Search by region " + regions, WordUtils.capitalizeFully(CommandType.REGION.toString()));
        commands.put("Search by regional bloc", WordUtils.capitalizeFully(CommandType.BLOC.toString()));
        commands.put("Exit", "Exit");

        //Initializing List of Regional Blocs
        regionalBloc.put("EU", "(European Union)");
        regionalBloc.put("EFTA", "(European Free Trade Association)");
        regionalBloc.put("CARICOM", "(Caribbean Community)");
        regionalBloc.put("PA", "(Pacific Alliance)");
        regionalBloc.put("AU", "(African Union)");
        regionalBloc.put("USAN", "(Union of South American Nations)");
        regionalBloc.put("EEU", "(Eurasian Economic Union)");
        regionalBloc.put("AL", "(Arab League)");
        regionalBloc.put("ASEAN", "(Association of Southeast Asian Nations)");
        regionalBloc.put("CAIS", "(Central American Integration System)");
        regionalBloc.put("CEFTA", "(Central European Free Trade Agreement)");
        regionalBloc.put("NAFTA", "(North American Free Trade Agreement)");
        regionalBloc.put("SAARC", "(South Asian Association for Regional Cooperation)");


        showCommandList();

    }

    public static void showCommandList(){
        System.out.println("Use the following commands to search for a country.");
        commands.forEach((instruction, command) -> {
            System.out.println("\t" +instruction + ": \t" + command);
        });
    }

    public String getInputFromUser(String message){
        System.out.print(message + ": ");
        return input.next().trim();
    }

    public static void  promptEnterCommand(){
        System.out.println("Press \"Enter\" to continue...");
        Scanner staticInput = new Scanner(System.in);
        staticInput.nextLine();
    }

    public void selectFunction(String commandStr){
        try {
            CommandType command = CommandType.valueOf(commandStr.toUpperCase());
            switch (command){
                case ALL:
                    System.out.println("Getting all countries...");
                    Country[] countries = apiService.getAll();
                    String userInput  = getInputFromUser("Found " + countries.length + ". Would you like to print them all?");
                    if (userInput.substring(0,1).equalsIgnoreCase("y")) logger.logCountriesArray(countries);
                    break;
                case BLOC:
                    System.out.println("Use the initials for the following Blocs");
                    regionalBloc.forEach((bloc, title) -> {
                        System.out.println("\t"+title + "=" + bloc);
                    });
                    String bloc = getInputFromUser("Enter Bloc: (Type \"Back\" to return to the main menu)");
                    if (bloc.equalsIgnoreCase("back")) break;
                    if (regionalBloc.containsKey(bloc.toUpperCase())){
                        System.out.println("Searching countries on Block " + bloc.toUpperCase() + "...");
                        logger.logCountriesArray(apiService.searchByRegionalBloc(bloc.toLowerCase()));
                    } else {
                        System.out.println("Invalid Bloc " + bloc);
                        selectFunction(commandStr);
                    }
                    break;
                case CODE:
                    String code = getInputFromUser("Search by ISO 3166-1 2-letter or 3-letter country code (Type \"Back\" to return to the main menu)");
                    try{
                        if (code.equalsIgnoreCase("back")) break;
                        if (code.length() <= 3 && code.length() >= 2){
                            System.out.println("Searching country with code " + code.toUpperCase() + "...");
                            logger.countryLogger(apiService.searchByCode(code));
                        } else {
                            throw new Exception("Invalid code");
                        }
                    } catch (Exception e ){
                        System.out.println("Invalid country code: " + code);
                        selectFunction(commandStr);
                    }
                    break;
                case FULL:
                    String fullName = getInputFromUser("Enter country full name(Type \"Back\" to return to the main menu)");
                    try{
                        if (fullName.equalsIgnoreCase("back")) break;
                        System.out.println("Searching for country " + fullName + "...");
                        logger.logCountriesArray(apiService.searchByFullName(fullName));
                    } catch (Exception e){
                        System.out.println("Country not found: " + fullName);
                        selectFunction(commandStr);
                    }
                    break;
                case NAME:
                    String name = getInputFromUser("Search by country name (It can be the native name or partial name)(Type \"Back\" to return to the main menu)");
                    try{
                        if (name.equalsIgnoreCase("back")) break;
                        System.out.println("Searching for country " + name + "...");
                        logger.logCountriesArray(apiService.searchByName(name));
                    } catch (Exception e){
                        System.out.println("Country not found: " + name);
                        selectFunction(commandStr);
                    }
                    break;
                case CODES:
                    String codes = getInputFromUser("ISO 3166-1 2-letter or 3-letter country codes separated by \";\" (Type \"Back\" to return to the main menu)");
                    try{
                        if (codes.equalsIgnoreCase("back")) break;
                        codes = codes.replaceAll(" ", "");
                        System.out.println("Searching for country  with codes: " + codes);
                        logger.logCountriesArray(apiService.searchByListOfCodes(codes));
                    } catch (Exception e){
                        System.out.println("Country not found: " + codes);
                        selectFunction(commandStr);
                    }
                    break;
                case REGION:
                    System.out.println("Search by these regions " + regions);
                    String region = getInputFromUser("Enter Region (Type \"Back\" to return to the main menu)");
                    region = WordUtils.capitalizeFully(region);
                    try{
                        if (region.equalsIgnoreCase("back")) break;
                        if (!regions.contains(region)) throw new Exception("Invalid region");
                        System.out.println("Searching countries in Region " + region + "...");
                        logger.logCountriesArray(apiService.searchByRegion(region));
                    } catch (Exception e ){
                        System.out.println("Invalid region: " + region);
                        selectFunction(commandStr);
                    }
                    break;
                case CALLING:
                    String callingCode = getInputFromUser("Enter calling code (Type \"Back\" to return to the main menu)");
                    try{
                        if (callingCode.equalsIgnoreCase("back")) break;
                        Integer.valueOf(callingCode);
                        System.out.println("Searching country with calling code " + callingCode + "...");
                        logger.logCountriesArray(apiService.searchByCallingCode(callingCode));
                    } catch (Exception e ){
                        System.out.println("Invalid calling code: " + callingCode);
                        selectFunction(commandStr);
                    }
                    break;
                case CAPITAL:
                    String capital = getInputFromUser("Enter name of capital city (Type \"Back\" to return to the main menu)");
                    try{
                        if (capital.equalsIgnoreCase("back")) break;
                        System.out.println("Searching country with capital " + WordUtils.capitalizeFully(capital) + "...");
                        logger.logCountriesArray(apiService.searchByCapital(capital));
                    }catch (Exception e ){
                        System.out.println("Invalid capital city name: " + capital);
                        selectFunction(commandStr);
                    }
                    break;
                case CURRENCY:
                    String currency = getInputFromUser("Enter ISO 4217 currency code(Type \"Back\" to return to the main menu)");
                    try{
                        if (currency.equalsIgnoreCase("back")) break;
                        System.out.println("Searching country with currency code " + currency + "...");
                        logger.logCountriesArray(apiService.searchByCurrency(currency));
                    }catch (Exception e ){
                        System.out.println("Invalid currency code: " + currency);
                        selectFunction(commandStr);
                    }
                    break;
                case LANGUAGE:
                    String language = getInputFromUser("Enter ISO 639-1 language code(Type \"Back\" to return to the main menu)");
                    try{
                        if (language.equalsIgnoreCase("back")) break;
                        System.out.println("Searching country with language code " + language + "...");
                        logger.logCountriesArray(apiService.searchByLanguage(language));
                    }catch (Exception e ){
                        System.out.println("Invalid language code: " + language);
                        selectFunction(commandStr);
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting program!");
                    System.exit(0);
            }
        } catch (Exception e){
            System.out.println("Command not found: " + commandStr);
        }
    }

    public static void main(String[] args) {
        countries countries = new countries();

        while (!countries.exit){
            String userCommand = countries.getInputFromUser("Enter command");
            countries.selectFunction(userCommand);
            promptEnterCommand();
            showCommandList();
        }
    }

}
