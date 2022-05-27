package com.esliceu.service;

import com.esliceu.model.Meteorit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que serveix per cercar els meteorits que s'aproximen a la Terra
 * @author Artem Rudenko
 */
public class MeteroidsService {
    /**
     * La propietat API_KEY_NASA és la clau de la API de la NASA
     */
    public String API_KEY_NASA = "1S7YAGqlynqf8nuMSqxRpMve3WSlvoogEcpDqmIv";

    /**
     * La propietat maxMeteorits és la quantitat màxima de meteorits que retorna el mètode getAsteroidsFromNasa (reanomenat a getMeteorits)
     */
    public int maxMeteorits = 1000;

    /**
     * El mètode getAsteroidsFromNasa rep la data a partir de la qual es fa la cerca de meteorits, retorna una llista de meteorits i llança una IOException si no es pot connectar al servidor de la NASA
     * @param
     * @return
     * @throws IOException
     */
    public List<Meteorit> getMeteorits(LocalDate data) throws IOException {
        String date = data.toString();
        URL url = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + date + "&end_date=" + date +
                "&api_key=" + API_KEY_NASA);

        String body = getString(url);

        List<Meteorit> meteorits = new ArrayList<>();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject response = (JSONObject) jsonParser.parse(body);
            JSONObject nearEarthObjects = (JSONObject) response.get("near_earth_objects");
            JSONArray nearEarthObjectsByDate = (JSONArray) nearEarthObjects.get(date);
            for (int i = 0; i < nearEarthObjectsByDate.size() && i < maxMeteorits; i++) {
                JSONObject object = (JSONObject) nearEarthObjectsByDate.get(i);
                String nom = (String) object.get("name");
                Double velocitat = Double.parseDouble(
                        (String) ((JSONObject) ((JSONObject) ((JSONArray) object.get("close_approach_data")).get(0))
                                .get("relative_velocity")).get("kilometers_per_hour"));
                Boolean esPerillos = (Boolean) object.get("is_potentially_hazardous_asteroid");
                Double distancia = Double.parseDouble(
                        (String) ((JSONObject) ((JSONObject) ((JSONArray) object.get("close_approach_data")).get(0))
                                .get("miss_distance")).get("kilometers"));
                Double diametre = (Double) ((JSONObject) ((JSONObject) object.get("estimated_diameter"))
                        .get("kilometers")).get("estimated_diameter_max");
                Meteorit meteorit = new Meteorit(nom, velocitat, esPerillos, distancia, diametre);
                meteorits.add(meteorit);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return meteorits;
    }

    private String getString(URL url) throws IOException {
        // Fetch data
        URLConnection connexio = url.openConnection();
        connexio.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(connexio.getInputStream()));
        String inputLine;
        StringBuilder outputLine = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            outputLine.append(inputLine);
        }
        in.close();
        String body = outputLine.toString();
        return body;
    }
}
