package com.example.demo.dao.impl;

import com.example.demo.dao.interfaces.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author admin
 * @date 2018-9-11 15:42
 */

public abstract class AbstractResource implements Resource {
    @Override
    public boolean exists() {
        try {
            return getFile().exists();
        } catch (IOException e) {
            try {
                getInputStream().close();
                return true;
            } catch (IOException e1) {
                return false;
            }
        }
    }

    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException("cannot be resolved to absolute file path");
    }

    @Override
    public long lastModified() throws IOException {
        long lastModified = getFileForLastModifiedCheck().lastModified();
        if (lastModified == 0L) {
            throw new FileNotFoundException();
        }
        return lastModified;
    }


    protected File getFileForLastModifiedCheck() throws IOException {
        return getFile();
    }
}
