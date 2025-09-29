package com.OrangeHRM.qa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;

public class ScreenshotUtil {

    // Raw base64 (NO data: prefix) — preferred for ExtentReports MediaEntityBuilder
    public static String captureScreenshotBase64Raw(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("WebDriver is null");
        if (!(driver instanceof TakesScreenshot)) {
            throw new IllegalArgumentException("Driver does not support screenshots");
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    // Data URI (prefix included) — useful if embedding manually into <img src="...">
    public static String captureScreenshotBase64DataUri(WebDriver driver) {
        return "data:image/png;base64," + captureScreenshotBase64Raw(driver);
    }

    // Save screenshot as a file and return the absolute path
    public static String captureScreenshotToFile(WebDriver driver, String destPath) {
        if (driver == null) throw new IllegalArgumentException("WebDriver is null");
        if (!(driver instanceof TakesScreenshot)) {
            throw new IllegalArgumentException("Driver does not support screenshots");
        }
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = Paths.get(destPath);
        try {
            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot to " + destPath, e);
        }
        return dest.toAbsolutePath().toString();
    }

    // Write a base64 string to PNG (handles data: prefix if present)
    public static String saveBase64ToFile(String base64OrDataUri, String destPath) {
        String raw = base64OrDataUri;
        if (raw.startsWith("data:")) raw = raw.substring(raw.indexOf(',') + 1);
        byte[] bytes = Base64.getDecoder().decode(raw);
        Path dest = Paths.get(destPath);
        try {
            Files.createDirectories(dest.getParent());
            Files.write(dest, bytes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write decoded bytes to " + destPath, e);
        }
        return dest.toAbsolutePath().toString();
    }
}
