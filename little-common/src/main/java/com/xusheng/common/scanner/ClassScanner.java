package com.xusheng.common.scanner;

import javax.security.auth.login.Configuration;
import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author xusheng
 * @Date 2022/8/30 16:58
 * @Desc
 */
public class ClassScanner {

    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_JAR = "jar";
    private static final String CLASS_FILE_SUFFIX = ".class";

    public static List<String> getClassNameList(String packageName) throws Exception {
        List<String> resultClassName = new ArrayList<>();
        String packageDirName = packageName.replace(".", "/");
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if (PROTOCOL_FILE.equals(protocol)) {
                findAndAddClassesInPackageByFile(packageName, url.getPath(), resultClassName);
            }
        }
        return resultClassName;
    }

    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, List<String> classNameList) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] dirFiles = dir.listFiles(file -> file.isDirectory() || (file.getName().endsWith(".class")));
        for (File dirFile : dirFiles) {
            if (dirFile.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + dirFile.getName(), dirFile.getPath(), classNameList);
                continue;
            }
            String className = dirFile.getName().substring(0, dirFile.getName().length() - 6);
            classNameList.add(packageName + "." + className);
        }
    }
}
