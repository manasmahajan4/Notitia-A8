package adnyey.notitia.a8.utils;

import static adnyey.notitia.a8.objects.upgrades.MaxUpgrades.MAX_UPGRADE_COL;

public class Utils {

    public static boolean isToken(int[][] max_cost_table, int rowId, int colId) {
        if (max_cost_table[rowId][colId] < getMaxElementInRow(max_cost_table, rowId) / 12)
            return true;
        return(max_cost_table[rowId][colId] < getMaxElementInColInPrevRows(max_cost_table, rowId, colId));
    }

    private static int getMaxElementInRow(int[][] max_cost_table, int rowId) {
        int maxElementValue = 0;

        for (int i = 0; i < MAX_UPGRADE_COL; i++) {
            if (max_cost_table[rowId][i] > maxElementValue)
                maxElementValue = max_cost_table[rowId][i];
        }

        return maxElementValue;
    }

    private static int getMaxElementInColInPrevRows(int[][] max_cost_table, int rowId, int colId) {
        int maxElementValue = max_cost_table[rowId][colId];

        for (int i = 0; i < rowId; i++) {
            if (max_cost_table[i][colId] > maxElementValue)
                maxElementValue = max_cost_table[i][colId];
        }

        return maxElementValue;
    }
}
