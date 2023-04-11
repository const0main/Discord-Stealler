package application.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigManager {

    public static String getWebhookUrl(){
        String result = "";
        try {
            Scanner scanner = new Scanner(new File("C:\\TokenStealler\\src\\main\\resources\\config.txt"));

            result = scanner.nextLine();

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;

    }

}
