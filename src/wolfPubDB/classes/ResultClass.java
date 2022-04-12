package wolfPubDB.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultClass {
    List<List<String>> rows;

    public ResultClass() {
        rows = new ArrayList<>();
    }

    public void addRow(ResultSet res, int size) throws SQLException {
        List<String> row = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            row.add(res.getString(i));
        }
        rows.add(row);
    }
}
