package org.e2e.domains;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.e2e.utils.DataGenerator.generateDogName;
import static org.e2e.utils.DataGenerator.generateFirstName;
import static org.e2e.utils.DataGenerator.generateID;
import static org.e2e.utils.DataGenerator.generateLongId;

@Data
@Builder
@Jacksonized
public class DogDetails {
    long id;
    DogCategory category;
    String name;
    String status;
    List<DogTags> tags;
    List<String> photoUrls;

    public static DogDetails generate(){
        return DogDetails.builder().id(generateLongId()).name(generateFirstName()).status("available").
                category(DogCategory.builder().id(generateLongId()).name(generateDogName()).build()).
                tags(List.of(DogTags.builder().id(generateLongId()).name("Susie").build(),
                        DogTags.builder().id(generateLongId()).name("Bala").build())).photoUrls(List.of("https://www.google.com/imgres?imgurl=https%3A%2F%2Fdearpet.in%2Fcdn%2Fshop%2Farticles%2F1_2_1024x1024.jpg%3Fv%3D1631105369&tbnid=vBkDKFyvl9J1TM&vet=12ahUKEwjYps34kbeCAxVkz6ACHRHVBKgQMygKegQIARBi..i&imgrefurl=https%3A%2F%2Fdearpet.in%2Fblogs%2Fdear-pet%2Fwhy-is-a-rabbit-the-perfect-pet-for-your-family&docid=x6D_l34OlpnRoM&w=1024&h=576&q=rabbit&ved=2ahUKEwjYps34kbeCAxVkz6ACHRHVBKgQMygKegQIARBi","https://www.google.com/imgres?imgurl=https%3A%2F%2Fdearpet.in%2Fcdn%2Fshop%2Farticles%2F1_2_1024x1024.jpg%3Fv%3D1631105369&tbnid=vBkDKFyvl9J1TM&vet=12ahUKEwjYps34kbeCAxVkz6ACHRHVBKgQMygKegQIARBi..i&imgrefurl=https%3A%2F%2Fdearpet.in%2Fblogs%2Fdear-pet%2Fwhy-is-a-rabbit-the-perfect-pet-for-your-family&docid=x6D_l34OlpnRoM&w=1024&h=576&q=rabbit&ved=2ahUKEwjYps34kbeCAxVkz6ACHRHVBKgQMygKegQIARBi")).build();

    }





}
