package org.e2e.utils;

import lombok.extern.slf4j.Slf4j;
import org.e2e.domains.DogDetails;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import static org.junit.Assert.assertTrue;

@Slf4j
public class RestHelperUtil extends Restutil {


    public static void validateValueinList(List<DogDetails> dogDetailsAvailable, long id) {
        for (int i = 0; i < dogDetailsAvailable.size(); i++) {
            dogDetailsAvailable.get(i).getId();

            if (dogDetailsAvailable.get(i).getId() == id) {
                log.info("Value of dog detail id is" + dogDetailsAvailable.get(i).getId() + " compared with" + id);
                assertTrue(dogDetailsAvailable.get(i).getId() == id);
            }
        }
    }

    public static void validateValueinResponse(DogDetails dogDetailsAvailable, String name) {

        if (dogDetailsAvailable.getName() == name) {
            System.out.println("Value of dog detail id is" + dogDetailsAvailable.getName() + " compared with" + name);
            assertTrue(dogDetailsAvailable.getName() == name);
        }
    }

    public static String basicAuth(String userName, String password) {
        String key = userName + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(key.getBytes());
    }

    public static LocalDate getCurrentDate(){
        return LocalDate.now(Clock.systemDefaultZone());
    }

}
