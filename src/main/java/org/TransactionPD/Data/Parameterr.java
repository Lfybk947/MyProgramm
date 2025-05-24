package org.TransactionPD.Data;



public class Parameterr implements java.io.Serializable {//сериализуемый класс
    private final String[][] mPODescrArr;
    private final String[][] mMODescrArr;
    private final String[][] mPOCateArr;
    private final String[][] mMOCateArr;

    private final String[][] qPODescrArr;
    private final String[][] qMODescrArr;
    private final String[][] qPOCateArr;
    private final String[][] qMOCateArr;

    private final String[][] yPODescrArr;
    private final String[][] yMODescrArr;
    private final String[][] yPOCateArr;
    private final String[][] yMOCateArr;

    public Parameterr(String[][] mPODescrArr, String[][] mMODescrArr, String[][] mPOCateArr, String[][] mMOCateArr,
                      String[][] qPODescrArr, String[][] qMODescrArr, String[][] qPOCateArr, String[][] qMOCateArr,
                      String[][] yPODescrArr, String[][] yMODescrArr, String[][] yPOCateArr, String[][] yMOCateArr) {
        this.mPODescrArr = mPODescrArr;
        this.mMODescrArr = mMODescrArr;
        this.mPOCateArr = mPOCateArr;
        this.mMOCateArr = mMOCateArr;

        this.qPODescrArr = qPODescrArr;
        this.qMODescrArr = qMODescrArr;
        this.qPOCateArr = qPOCateArr;
        this.qMOCateArr = qMOCateArr;

        this.yPODescrArr = yPODescrArr;
        this.yMODescrArr = yMODescrArr;
        this.yPOCateArr = yPOCateArr;
        this.yMOCateArr = yMOCateArr;
    }

    public String[][] getmPODescrArr() {return mPODescrArr;}
    public String[][] getmMODescrArr() {return mMODescrArr;}
    public String[][] getmPOCateArr() {return mPOCateArr;}
    public String[][] getmMOCateArr() {return mMOCateArr;}
    public String[][] getqPODescrArr() {return qPODescrArr;}
    public String[][] getqMODescrArr() {return qMODescrArr;}
    public String[][] getqPOCateArr() {return qPOCateArr;}
    public String[][] getqMOCateArr() {return qMOCateArr;}
    public String[][] getyPODescrArr() {return yPODescrArr;}
    public String[][] getyMODescrArr() {return yMODescrArr;}
    public String[][] getyPOCateArr() {return yPOCateArr;}
    public String[][] getyMOCateArr() {return yMOCateArr;}
}
