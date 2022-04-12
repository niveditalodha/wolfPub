package wolfPubDB.classes;

import java.util.List;

public class ReportClass {
    public List<String> resultKeys;
    public ResultClass results;

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
