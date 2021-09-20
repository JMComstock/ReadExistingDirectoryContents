package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

//     BASIC GLOB SEARCH PARAMETERS
//     full  list @   https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystem.html#getPathMatcher-java.lamg.String-

//  The * character matches any string (which can contain any number of characters)
//  *.dat   will match any path with the .dat extension
//  *.{dat,txt}  will match anyh path that has the extension .dat or .txt
//  ? matches exactly one character. the glob ??? would match any path that contains exactly 3 characters
//  myfile*  matches any path that begin with myfile
//  b?*.txt  match any paths that are at least two characters long and begin with the character b
//      (the ? forces a second character, and the * matches 0 or more characters).

public class Main {

    public static void main(String[] args) {

//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };

        // code on lines 22 - 26 gives same result as the code on line 29
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

	    Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
	    try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
	        for(Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }
}
