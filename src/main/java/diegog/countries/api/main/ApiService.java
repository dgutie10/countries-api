package diegog.countries.api.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import diegog.countries.api.main.utils.Logger;
import diegog.countries.api.model.Country;
import diegog.countries.api.main.utils.CountriesUrls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ApiService {
    private String host = "https://restcountries.eu";
    private ObjectMapper mapper = new ObjectMapper();

    public ApiService() {
    }

    /**
     * @param endpoint
     * @return Response
     * @throws IOException
     */
    private Response getRequest(String endpoint) throws IOException {
        io.restassured.response.Response response = given()
                .urlEncodingEnabled(false)
                .baseUri(host)
                .accept(ContentType.JSON)
                .when()
                .get(endpoint);
        return response;
    }

    /**
     * @param code
     * @return
     * @throws IOException
     */
    public Country searchByCode(String code) throws IOException {
        Response response = getRequest(CountriesUrls.CODE_URL + "/" + code);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), Country.class);
    }

    /**
     * @return
     * @throws IOException
     */
    public Country[] getAll() throws IOException {
        Response response = getRequest(CountriesUrls.ALL_URL);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    public Country[] searchByName(String name) throws IOException {
        Response response = getRequest(CountriesUrls.NAME_URL + "/" + name);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param name
     * @return
     * @throws IOException
     */
    public Country[] searchByFullName(String name) throws IOException {
        name = name.replaceAll(" ", "%20");

        Response response = getRequest(CountriesUrls.NAME_URL + "/" + name + "?fullText=true");
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param codes
     * @return
     * @throws IOException
     */
    public Country[] searchByListOfCodes(String codes) throws IOException {
        Response response = getRequest(CountriesUrls.LIST_OF_CODES_URL + codes);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    public Country[] searchByCurrency(String currency) throws IOException {
        Response response = getRequest(CountriesUrls.CURRENCY_URL + "/" + currency);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param language
     * @return
     * @throws IOException
     */
    public Country[] searchByLanguage(String language) throws IOException {
        Response response = getRequest(CountriesUrls.LANGUAGE_URL + "/" + language);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param capital
     * @return
     * @throws IOException
     */
    public Country[] searchByCapital(String capital) throws IOException {
        Response response = getRequest(CountriesUrls.CAPITAL_CITY_URL + "/" + capital);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param code
     * @return
     * @throws IOException
     */
    public Country[] searchByCallingCode(String code) throws IOException {
        Response response = getRequest(CountriesUrls.CALLING_CODE_URL + "/" + code);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param region
     * @return
     * @throws IOException
     */
    public Country[] searchByRegion(String region) throws IOException {
        Response response = getRequest(CountriesUrls.REGION_URL + "/" + region);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }

    /**
     * @param bloc
     * @return
     * @throws IOException
     */
    public Country[] searchByRegionalBloc(String bloc) throws IOException {
        Response response = getRequest(CountriesUrls.REGIONAL_BLOC_URL + "/" + bloc);
        return mapper.readValue(response.getBody().asString(), Country[].class);
    }
}
