package bai20_Erliest_Finish_Time_First;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputFile = "D://Downloads//BTL_TKPTTT//bai20_Erliest_Finish_Time_First//input.txt";
        String outputFile = "output.txt";

        IntervalSchedulingAlgorithm intervalSchedulingAlgorithm = new IntervalSchedulingAlgorithm();
        List<Interval> intervals = intervalSchedulingAlgorithm.readIntervalsFromFile(inputFile);
        List<Interval> schedule = intervalSchedulingAlgorithm.scheduleIntervals(intervals);
        intervalSchedulingAlgorithm.writeScheduleToFile(schedule, outputFile);

        System.out.println("Schedule written to " + outputFile);
    }
}
