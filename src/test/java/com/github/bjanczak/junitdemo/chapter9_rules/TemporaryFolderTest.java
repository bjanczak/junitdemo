package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * The TemporaryFolder Rule allows creation of files and folders that are deleted when the test method finishes
 * (whether it passes or fails). By default no exception is thrown if resources cannot be deleted.
 *
 * @author Bartłomiej Jańczak
 */
public class TemporaryFolderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("subfolder");
        System.out.println(folder.getRoot().getAbsolutePath());
    }
}
