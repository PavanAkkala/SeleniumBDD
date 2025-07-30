package utils;

import io.cucumber.java.BeforeAll;

import java.io.File;
import java.io.IOException;

public class DockerGirdManager {
    public static void startDockerGrid() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "start_dockergrid.bat");
        builder.directory(new File(System.getProperty("user.dir"))); // Set working directory
        builder.start();
        Thread.sleep(15000);
    }

    public static void stopDockerGrid() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "stop_dockergrid.bat");
        builder.directory(new File(System.getProperty("user.dir")));
        builder.start();

        Thread.sleep(5000); // Wait for stop script to execute

        // Kill all open CMD windows (optional and aggressive)
        new ProcessBuilder("taskkill", "/f", "/im", "cmd.exe").start();
    }
}
