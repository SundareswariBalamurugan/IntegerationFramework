package org.e2e.constant;

import io.restassured.http.Header;
import lombok.Getter;

@Getter
public class QueryParamSetup {
   static float latVal;

    public static float getLatVal() {
        return latVal;
    }

    public Header setLatVal(float latVal) {
        this.latVal = latVal;
        return null;
    }

    public static float getLongVal() {
        return longVal;
    }

    public void setLongVal(float longVal) {
        this.longVal = longVal;
    }

    static float longVal;
}
