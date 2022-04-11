package wolfPubDB.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReportClass {
    public List<String> resultKeys;
    public List<ResultSet> resultList;

    public ReportClass(List<String> rKeys, List<ResultSet> rList) {
        resultKeys = rKeys;
        resultList = rList;
    }

    public static void printReport(ReportClass monthlyPubReport) throws SQLException {
        for (String key : monthlyPubReport.resultKeys) {
            System.out.print(key + "\t");
        }

        for (ResultSet res : monthlyPubReport.resultList) {
            System.out.println();
            for (String key : monthlyPubReport.resultKeys) {
                System.out.print(res.getString(key) + "\t");
            }
        }
    }

}
