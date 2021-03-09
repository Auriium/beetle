package me.aurium.beetle.defaults.utility;

import java.io.File;
import java.nio.file.Path;

public class LauncherUtils {

    private static Path getLauncherFileFolder(Class<?> clazz) {
        String absolutePath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
        absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        absolutePath = absolutePath.replaceAll("%20"," "); // Surely need to do this here
        return Path.of(absolutePath);
    }

}
