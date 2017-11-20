package systems.singularity.buildware.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import systems.singularity.buildware.models.Address;

/**
 * Created by phts on 08/06/16.
 * © 2016 Singularity Systems
 */
public class Postmon {
    @NotNull
    public static JsonNode consultarCEP(@NotNull String cep) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://api.postmon.com.br/v1/cep/" + cep).asJson();
        return jsonResponse.getBody();
    }

    public static @NotNull Address addressFromZipCode(@NotNull String zipCode) {
        try {
            JSONObject jsonObject = consultarCEP(zipCode).getObject();
            return new Address()
                    .street(jsonObject.getString("logradouro"))
                    .neighborhood(jsonObject.getString("bairro"))
                    .city(jsonObject.getString("cidade"))
                    .state(jsonObject.getString("estado"))
                    .zipCode(zipCode);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
            return new Address();
        }
    }

    public static void addListener(@NotNull TextField zipCode, @Nullable TextField street, @Nullable TextField neighborhood, @Nullable TextField city, @Nullable TextField state) {
        zipCode.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("\\D+", "");

            if (value.length() == 8) {
                if (street != null)
                    street.setDisable(true);
                if (neighborhood != null)
                    neighborhood.setDisable(true);
                if (city != null)
                    city.setDisable(true);
                if (state != null)
                    state.setDisable(true);

                new AsyncCallable(() -> {
                    Address address = Postmon.addressFromZipCode(value);

                    Platform.runLater(() -> {
                        if (street != null) {
                            if (address.getStreet() != null)
                                street.setText(address.getStreet());
                            street.setDisable(false);
                        }
                        if (neighborhood != null) {
                            if (address.getNeighborhood() != null)
                                neighborhood.setText(address.getNeighborhood());
                            neighborhood.setDisable(false);
                        }
                        if (city != null) {
                            if (address.getCity() != null)
                                city.setText(address.getCity());
                            city.setDisable(false);
                        }
                        if (state != null) {
                            if (address.getState() != null)
                                state.setText(address.getState());
                            state.setDisable(false);
                        }
                    });

                    return null;
                }).start();
            }
        });
    }
}
