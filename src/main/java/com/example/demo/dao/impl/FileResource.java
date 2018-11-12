package com.example.demo.dao.impl;

import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author admin
 * @date 2018-9-11 15:55
 */
public class FileResource extends AbstractResource {
    private final String path;

    private final File file;
    private final Path filePath;

    public FileResource(String path) {
        this.path = StringUtils.cleanPath(path);
        this.file = new File(path);
        this.filePath = this.file.toPath();

    }

    @Override
    public File getFile() throws IOException {
        InputStream in= new FileInputStream(file);
        return (this.file != null ? this.file : this.filePath.toFile());
    }

    @Override
    public String getDescription() {
        return "file[" + (this.file != null ? this.file.getAbsolutePath() : this.filePath.toAbsolutePath() + "]");
    }

    @Override
    public InputStream getInputStream() throws IOException {
        try {
            return Files.newInputStream(this.filePath);
        } catch (NoSuchFileException ex) {
            throw new FileNotFoundException(ex.getMessage());
        }
    }

}
