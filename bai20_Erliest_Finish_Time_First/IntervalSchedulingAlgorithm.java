package bai20_Erliest_Finish_Time_First;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalSchedulingAlgorithm {

    public List<Interval> readIntervalsFromFile(String fileName) {
        List<Interval> intervals = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(" ");
                int start = Integer.parseInt(tokens[0]);
                int end = Integer.parseInt(tokens[1]);
                intervals.add(new Interval(start, end));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
        return intervals;
    }

    public List<Interval> scheduleIntervals(List<Interval> intervals) {
        List<Interval> schedule = new ArrayList<>();
        // Sort intervals by finish time
        intervals.sort(Comparator.comparingInt(a -> a.end));
        Interval lastInterval = null;
        for (Interval interval : intervals) {
            if (lastInterval == null || interval.start >= lastInterval.end) {
                schedule.add(interval);
                lastInterval = interval;
            }
        }
        return schedule;
    }

    public void writeScheduleToFile(List<Interval> schedule, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (Interval interval : schedule) {
                writer.println(interval.start + " " + interval.end);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }
}
