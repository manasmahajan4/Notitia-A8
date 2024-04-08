package adnyey.notitia.a8.objects.upgrades;

import android.util.Log;

import adnyey.notitia.a8.utils.Utils;

public class MaxUpgrades {

    public static int MAX_UPGRADE_ROW = 5;
    public static int MAX_UPGRADE_COL = 4;

    private int[][] max_cost_table;

    public MaxUpgrades(int[][] ip_max_cost_table) {
        max_cost_table = new int[MAX_UPGRADE_ROW][MAX_UPGRADE_COL];
        if (ip_max_cost_table.length > 0)
            max_cost_table = ip_max_cost_table;
    }

    public int getTotalCredits() {

        int totalCredits = 0;

        if (max_cost_table.length > 0) {
            for (int i = 0; i < MAX_UPGRADE_ROW; i++) {
                for (int j = 0; j < MAX_UPGRADE_COL; j++) {
                    totalCredits += max_cost_table[i][j];
                }
            }
            totalCredits-=getTotalTokens();
        }
        return totalCredits;
    }

    public int getTotalTokens() {

        int totalTokens = 0;

        if (max_cost_table.length > 0) {
            for (int i = 0; i < MAX_UPGRADE_ROW; i++) {
                for (int j = 0; j < MAX_UPGRADE_COL; j++) {
                    if (isToken(i, j)) {
                        totalTokens += max_cost_table[i][j];
                    }
                }
            }
        }
        return totalTokens;
    }

    public boolean isToken(int rowId, int colId)
    {
        return Utils.isToken(max_cost_table, rowId, colId);
    }
}
