package ch.sourcepond.integrationtest.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Photocopier {
    public static File copyTestProjectToTemporaryLocation(String moduleName) throws IOException {
        File source = new File("test-projects", moduleName);
        if (!source.isDirectory()) {
            source = new File(FilenameUtils.separatorsToSystem("../test-projects/" + moduleName));
        }
        if (!source.isDirectory()) {
            throw new RuntimeException("Could not find module " + moduleName);
        }

        File target = folderForSampleProject(moduleName);
        FileUtils.copyDirectory(source, target);
        return target;
    }

    public static File folderForSampleProject(String moduleName) {
        return new File(FilenameUtils.separatorsToSystem("target/samples/" + moduleName + "/" + UUID.randomUUID()));
    }
}
