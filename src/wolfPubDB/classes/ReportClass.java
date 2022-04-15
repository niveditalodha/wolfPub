package wolfPubDB.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain Old Java Object (POJO) class for storing and passing results from
 * SQL query.
 */
public class ReportClass {
    public List<String> resultKeys;
    public ResultClass results;
    List<Integer> maxColWidth;

    /**
     * Constructor for ReportClass
     *
     * @param rKeys List of column headers that are displayed while printing
     *              the result table. The name and order of each key should
     *              exactly match what we expect SQL queries to return.
     * @param rList
     */
    public ReportClass(List<String> rKeys, ResultClass rList) {
        resultKeys = rKeys;
        results = rList;
        calculateColWidth();
    }

    private void calculateColWidth() {
        maxColWidth = new ArrayList<>();
        for (int i = 0; i < resultKeys.size(); i++) {
            int max = resultKeys.get(i).length();
            for (List<String> row : results.rows) {
                if (max < row.get(i).length()) {
                    max = row.get(i).length();
                }
            }
            maxColWidth.add(max);
        }
    }

    public static void printReport(ReportClass report) {
        int index = 0;
        for (int i = 0; i < report.resultKeys.size(); i++) {
            printChar('-', '+', report.maxColWidth.get(i));
        }
        System.out.println();
        for (String key : report.resultKeys) {
            System.out.print(key);
            printChar(' ', '|', report.maxColWidth.get(index++) - key.length());
        }

        System.out.println();
        for (int i = 0; i < report.resultKeys.size(); i++) {
            printChar('-', '+', report.maxColWidth.get(i));
        }

        for (List<String> row : report.results.rows) {
            System.out.println();
            for (int i = 0; i < report.resultKeys.size(); i++) {
                System.out.print(row.get(i));
                printChar(' ', '|', report.maxColWidth.get(i) - row.get(i).length());
            }
        }
        System.out.println();
        for (int i = 0; i < report.resultKeys.size(); i++) {
            printChar('-', '+', report.maxColWidth.get(i));
        }
        System.out.println();
    }

    private static void printChar(char ch, char separator, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        System.out.print(sb.toString() + ch + separator + ch);
    }


}
