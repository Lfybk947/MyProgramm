package org.TransactionPD.Interface;



import java.util.List;


public class FormaInterface {
    private final List<String> PODescr;
    private final List<String> MODescr;
    private final List<String> POCate;
    private final List<String> MOCate;
    private  String[][] PODescrArr;
    private  String[][] MODescrArr;
    private  String[][] POCateArr;
    private  String[][] MOCateArr;


    public FormaInterface(List<String> PODescr, List<String> MODescr, List<String> POCate, List<String> MOCate) {
        this.PODescr = PODescr;
        this.MODescr = MODescr;
        this.POCate = POCate;
        this.MOCate = MOCate;

    }
    public void graphicInterface() {
        PODescrArr = graphicInterface2(PODescr);
        MODescrArr = graphicInterface2(MODescr);
        POCateArr = graphicInterface2(POCate);
        MOCateArr = graphicInterface2(MOCate);
    }
    public String[][] getPODescrArr() {
        return PODescrArr;
    }
    public String[][] getMODescrArr() {
        return MODescrArr;
    }
    public String[][] getPOCateArr() {
        return POCateArr;
    }
    public String[][] getMOCateArr() {
        return MOCateArr;
    }

    public String[][] graphicInterface2(List<String> PODescr) {//формирования файла для вывода в таблицу интерфейса
        String[][] PODescrToArr = new String[PODescr.size()/4][4];
        int ll = 0;
        for (int j = 0; j < PODescr.size(); j+=4) {
            PODescrToArr[ll][0] = PODescr.get(j);
            PODescrToArr[ll][1] = PODescr.get(j+1);
            PODescrToArr[ll][2] = PODescr.get(j+2);
            PODescrToArr[ll][3] = PODescr.get(j+3);
            ll++;
        }
        return PODescrToArr;
    }

}
