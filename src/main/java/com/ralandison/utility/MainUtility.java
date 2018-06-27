package com.ralandison.utility;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class MainUtility {

    public static String guavaHash(String originalString){
        if(originalString==null){
            return null;
        }else{
            return Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
        }
    }

}
