package com.sites;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SiteService {
    
    public static List<String> sites = new ArrayList();
    
    public static void build(String path) {
        BufferedReader reader = null;
        String line;
        
	try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(",");
                sites.add(strings[1] + " (Rank " + strings[0] + ")");
            }
	} catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find file", e);
	} catch (IOException e) {
            throw new RuntimeException("An IO error occurred reading the file.", e);
	} finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException("An I/O error occurred closing the file", e);
                }
            }
	}        
    }
    
    public static List<String> load(String startswith) {
        List<String> matches = new ArrayList();
        startswith = startswith.toLowerCase();
        for (String country : sites) {
            if (country.toLowerCase().startsWith(startswith)) {
                matches.add(country);
            }
            if (startswith.length() < 3 && matches.size() == 100) {
                return matches.subList(0, 100);
            }
        }

        return matches;
    }
}
