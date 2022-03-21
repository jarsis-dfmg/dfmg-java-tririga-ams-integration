package io.jarsis.dfmg.integration.ams;

import com.google.gson.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationRunner {

    public static String returnValueAsString(JsonElement je, String keyword) {
        StringBuilder sb = null;


        return "";
    }

    private static String printClass(JsonElement je) {
        StringBuilder sb = null;
        if (je.isJsonNull())
            return "null";

        if (je.isJsonPrimitive()) {
            return je.toString();
        }

        if (je.isJsonArray()) {
            sb = new StringBuilder("array<");
            for (JsonElement e : je.getAsJsonArray()) {
                sb.append(printClass(e));
            }
            sb.append(">");
            return sb.toString();
        }

        if (je.isJsonObject()) {
            sb = new StringBuilder();
            for (Map.Entry<String, JsonElement> e : je.getAsJsonObject().entrySet()) {
                HashMap<String, String> tempMap = new HashMap<String, String>();

                if(!e.getValue().isJsonObject()) {
                    sb.append(e.getKey()).append(":");
                }
                sb.append(printClass(e.getValue())); //ITERATION on itself
                sb.append("\n");
            }
            return sb.toString();
        }
        return "";

    }

    private static HashMap<String, String> jsonToHashMap(String testJSON) {
        HashMap<String, String> integrationMap = new HashMap<String, String>();



        return integrationMap;
    }

    public static void main(String[] args) {
        String testJSON = "{\"manufacturer\":{\"manId\":6,\"name\":\"Commscope\"},\"antenna\":{\"atyId\":23530,\"antennaName\":\"LDX-9013DS-VTM\"},\"athId\":64795,\"version\":1,\"athStatus\":\"RELEASED\",\"antennaType\":\"PA\",\"validFrom\":\"01/01/1900\",\"modDate\":\"03/03/2022 09:13 AM\",\"commentText\":\"Antennengewinn mit Toleranz gem. msi-File eingetragen!\\n\\nAntenna ID: 2229\\nCasing id: 2229\\nVersion: 1\",\"height\":1831,\"width\":225,\"length\":164,\"frontSurface\":0.41,\"frontSurfaceSalesEq\":false,\"centerHeight\":915.5,\"centerWidth\":112.5,\"weight\":12.0,\"frontSurfaceDishAntenna\":0.0,\"windLoad\":392.0,\"windSpeed\":150.0,\"portsPos\":\"UNKNOWN\",\"ca\":0.3612672}";
        Map<String, String> integrationMap = new HashMap<>();

        JsonElement je = JsonParser.parseString(testJSON);
        System.out.println(printClass(je));
//        System.out.println("\n\n\n\nSOMETHING\n\n\n\n");
//        System.out.println(printClass(je,"    "));

    }
}


//    JsonParser parser = new JsonParser();
//    JsonObject jsonObject = parser.parse(lastResponsePayload).getAsJsonObject()

//
//    final JsonObject jsonObject = GSON.toJsonTree(<Object>).getAsJsonObject();
//        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
//        System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue() );
//        }