package me.aurium.beetle.defaults.file.config;

import me.aurium.beetle.api.file.extension.FileExtension;

public interface ConfReadableFileExtension extends FileExtension {

    Reader getCorrespondingReader();

}
