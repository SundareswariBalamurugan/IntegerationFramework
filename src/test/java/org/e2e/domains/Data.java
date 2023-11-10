package org.e2e.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@lombok.Data
@Builder
@Jacksonized
public class Data {

    @JsonProperty("Id")
    int id;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Email")
    String email;
    @JsonProperty("Vat")
    String vat;
    @JsonProperty("Phone")
    String phone;
    @JsonProperty("Country")
    String country;
    @JsonProperty("Website")
    String website;
    @JsonProperty("Image")
    String image;



}
