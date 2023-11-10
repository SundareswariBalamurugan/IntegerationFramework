package org.e2e.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@lombok.Data
@Builder
@Jacksonized
@JsonIgnoreProperties
public class CompanyEmployee {

    @JsonProperty("Status")
    String status;
    @JsonProperty("Code")
    int code;
    @JsonProperty("Total")
    int total;
    @JsonProperty("Data")
    List<Data> data;
}
