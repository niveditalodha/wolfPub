package wolfPubDB.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for storing all result rows as string list.
 */
public class ResultClass {
    List<List<String>> rows;

    /**
     * Constructor instantiates empty rows array list.
     */
    public ResultClass() {
        rows = new ArrayList<>();
    }

    /**
     * Adds a new string list
     * @param res
     * @param size
     * @throws SQLException
     */
    public void addRow(ResultSet res, int size) throws SQLException {
        List<String> row = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            row.add(res.getString(i));
        }
        rows.add(row);
    }
}
