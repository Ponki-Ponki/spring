package com.example.task.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    /**
     * Экземпляр готового канала
     * @return
     */
    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    /**
     * Канал записи в файл
     * @return
     */
    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    /**
     * inputChannel = "textInputChanel", outputChannel = "fileWriterChanel"
     * С какого канала берёт       и     в какой канал кладёт
     * @return
     */
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
            //какая-то логика например перевод текста
            return text;
        };
    }

    /**
     * Сохранение в файл
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "D:/studies/JAVA/Spring/NewProject/NewProject"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}