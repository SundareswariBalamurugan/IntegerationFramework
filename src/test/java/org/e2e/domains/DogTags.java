package org.e2e.domains;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class DogTags {

    long id;
    String name;
}
