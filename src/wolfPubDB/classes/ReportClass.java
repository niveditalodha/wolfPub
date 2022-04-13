package wolfPubDB.classes;

import java.util.List;

/**
 * Plain Old Java Object (POJO) class for storing and passing results from
 * SQL query.
 */
public class ReportClass {
    public List<String> resultKeys;
    public ResultClass results;

    /**
     * Constructor for ReportClass
     * @param rKeys List of column headers that are displayed while printing
     *              the result table. The name and order of each key should
     *              exactly match what we expect SQL queries to return.
     * @param rList
     */
    public ReportClass(List<String> rKeys, ResultClass rList) {
        resultKeys = rKeys;
        results = rList;
    }

    public static void printReport(ReportClass report) {
        for (String key : report.resultKeys) {
            System.out.print(key + "\t");
        }

        for (List<String> row : report.results.rows) {
            System.out.println();
            for (int i = 0; i < report.resultKeys.size(); i++) {
                System.out.print(row.get(i) + "\t");
            }
        }
        System.out.println();
    }

}
