package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.extension.ConfigurableExtension;

public class Endings {

    public static EndingProducer YML = new CommonEndingProducer.Builder(".yml")
            .withAttribute(ConfigurableExtension.class)
            .build();

}
