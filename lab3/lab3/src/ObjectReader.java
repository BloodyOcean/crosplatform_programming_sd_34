import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ObjectReader {
    public static List<Film> read(String path) {

        List<Film> data = new ArrayList<>();

        try {
            String json = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

            Type listType = new TypeToken<List<Film>>(){}.getType();
            data = new Gson().fromJson(json, listType);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
