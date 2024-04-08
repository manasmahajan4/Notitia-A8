package adnyey.notitia.a8;

public class CommonStuff {

    private static Boolean saltiness=false;

    public static Boolean getSaltiness() {
        return saltiness;
    }

    public static void setSaltiness(Boolean saltiness) {
        CommonStuff.saltiness = saltiness;
    }

    public static int engineFinder(String input) {
        switch (input) {
            case "cre":
                return R.drawable.eng_cre;
            case "electric":
                return R.drawable.eng_electric;
            case "f12":
                return R.drawable.eng_f12;
            case "f6":
                return R.drawable.eng_f6;
            case "fiv8":
                return R.drawable.eng_fiv8;
            case "hybrid":
                return R.drawable.eng_hybrid;
            case "i4":
                return R.drawable.eng_i4;
            case "i5":
                return R.drawable.eng_i5;
            case "i6":
                return R.drawable.eng_i6;
            case "rotary":
                return R.drawable.eng_rotary;
            case "sre":
                return R.drawable.eng_sre;
            case "v10":
                return R.drawable.eng_v10;
            case "v12":
                return R.drawable.eng_v12;
            case "v16":
                return R.drawable.eng_v16;
            case "v6":
                return R.drawable.eng_v6;
            case "v8":
                return R.drawable.eng_v8;
            case "w16":
                return R.drawable.eng_w16;
            case "rare":
                return R.drawable.eng_rare;
            case "legend":
                return R.drawable.eng_legend;
            case "fse":
                return R.drawable.eng_fse;
            case "vte":
                return R.drawable.eng_vte;
            case "ffse":
                return R.drawable.eng_ffse;
            case "hot":
                return R.drawable.eng_hot;
            case "electricl":
                return R.drawable.eng_electricl;
            case "v12mpi":
                return R.drawable.eng_v12mpi;
            case "i3":
                return R.drawable.eng_i3;
            default:
                return -1;
        }
    }

    public static int partsFinder(int input) {
        switch (input) {
            case 1:
                return R.drawable.part_d;
            case 2:
                return R.drawable.part_c;
            case 3:
                return R.drawable.part_b;
            case 4:
                return R.drawable.part_a;
            case 5:
                return R.drawable.part_s;
            default:
                return -1;
        }
    }


}
