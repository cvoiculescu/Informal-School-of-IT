package org.voiculescu.siit.temawk11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * this class is to define the standings of Athletes
 * the athletes are read from a CSV file
 */
public class Standings {
    /**
     * this is the location of the database
     */
    public static final String DATABASE = "files/athletes.csv";

    /**
     * this is the list which stores the read athletes from the source CSV file
     */
    private List<Athlete> athletes = readAthletes();

    /**
     * reads the athletes from a file
     * @return a list of Athletes
     */
    private List<Athlete> readAthletes() {
        List<Athlete> newList = new ArrayList<>();
        Path databasePath = Paths.get(DATABASE);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(databasePath.toFile())))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                int athleteNumber = Integer.parseInt(splitLine[0]);
                String athleteName = splitLine[1];
                String countryCode = splitLine[2];
                String[] skyTime = splitLine[3].split(":");
                SkyTimeResult skyTimeResult = new SkyTimeResult(Integer.parseInt(skyTime[0]), Integer.parseInt(skyTime[1]));
                String firstShooting = splitLine[4];
                String secondShooting = splitLine[5];
                String thirdShooting = splitLine[6];
                Athlete newAthlete = new Athlete(athleteNumber, athleteName, countryCode, skyTimeResult, firstShooting, secondShooting, thirdShooting);
                newList.add(newAthlete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    /**
     * this will get the sorted list based on the Comparable Athlete. The athletes are sorted on their skytime
     * @return a sorted list of Athletes
     */
    public List<Athlete> getStandings(){
        List<Athlete> sortedList = new ArrayList<>(athletes);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * this method will print the first 3 rankings on the received list, based on the the skyTime result
     */
    public void showRankings(){
        List<Athlete> rankings = getStandings();
        Iterator<Athlete> iterator = rankings.iterator();
        int ranking = 1;
        while (iterator.hasNext()||ranking<=3){
            Athlete next = iterator.next();
            switch (ranking){
                case 1:
                    System.out.print("Winner - ");
                    break;
                case 2:
                    System.out.print("Runner-up - ");
                    break;
                case 3:
                    System.out.print("Third Place - ");
                    break;
            }
            System.out.println(next);
            ranking++;
        }
    }

}
