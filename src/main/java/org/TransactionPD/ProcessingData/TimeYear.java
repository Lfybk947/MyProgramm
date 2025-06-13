package org.TransactionPD.ProcessingData;

import org.TransactionPD.Interfaces.TimeInterfaces;

public class TimeYear implements TimeInterfaces {
    private final String[][] plusInputData;
    private final String[][] minusInputData;
    private final int timeColumn;
    private int plusStartNumber;
    private int plusEndNumber;
    private int minusStartNumber;
    private int minusEndNumber;
    private int plusYears;
    private int minusYears;


    public TimeYear(String[][] plusInputData, String[][] minusInputData, int timeColumn) {
        this.plusInputData = plusInputData;
        this.minusInputData = minusInputData;
        this.timeColumn = timeColumn;
    }

    @Override
    public void timeInterfaces(int amountYear) {//numberTimeYear
        int timeYears = 2;
        int plusTimeYearsLast = timeLastYear(plusInputData, timeYears);//вычисление последнего года
        int minusTimeYearsLast = timeLastYear(minusInputData, timeYears);

        TimeYear.TimeInterval plusTimeInterval = TimeYear.TimeInterval.interval(plusInputData , plusTimeYearsLast, timeColumn, amountYear);//отсчет интервала
        plusStartNumber = plusTimeInterval.startNumberYear;
        plusEndNumber = plusTimeInterval.endNumberYear;
        plusYears = plusTimeInterval.years;

        TimeYear.TimeInterval minusTimeInterval = TimeYear.TimeInterval.interval(minusInputData , minusTimeYearsLast, timeColumn, amountYear);
        minusStartNumber = minusTimeInterval.startNumberYear;
        minusEndNumber = minusTimeInterval.endNumberYear;
        minusYears = minusTimeInterval.years;

    }
    @Override
    public int getPlusStartNumber() {
        return plusStartNumber;
    }
    @Override
    public int getPlusEndNumber() {
        return plusEndNumber;
    }
    @Override
    public int getMinusStartNumber() {
        return minusStartNumber;
    }
    @Override
    public int getMinusEndNumber() {
        return minusEndNumber;
    }
    @Override
    public int getPlusYears() {
        return plusYears;
    }
    @Override
    public int getMinusYears() {
        return minusYears;
    }
    @Override
    public int getPlusMonth() {
        return 0;
    }
    @Override
    public int getMinusMonth() {
        return 0;
    }


    public int timeLastYear(String[][] inputData, int time) {//последний год
        String[] timeLas = inputData[1][timeColumn].split("\\.");
        if (time==2) {
            String[] j = timeLas[time].split(" ");
            timeLas[time] = j[0];
        }
        return Integer.parseInt(timeLas[time]);
    }


    public static class TimeInterval {//подкласс для реализации возврата двух переменных из метода
        int startNumberYear;
        int endNumberYear;
        int years;

        public TimeInterval(int startNumberYear, int endNumberYear, int years) {
            this.startNumberYear = startNumberYear;
            this.endNumberYear = endNumberYear;
            this.years = years;
        }

        public static TimeInterval interval(String[][] inputData, int timeYearsLast, int timeColumn, int amountYear) {//метод вычисления начальной строки и конечной диапозона
            int numberYear = 0;
            int y;
            y = timeYearsLast+amountYear;//года
            int e=0;
            try {//для окончания перебора при окончании таблицы
                while (true) {//подсчет строк с одинаковым годом
                    e++;
                    String[] timeData;
                    timeData = inputData[e][timeColumn].split("\\.");
                    String[] j = timeData[2].split(" ");
                    timeData[2] = j[0];
                    if (Integer.parseInt(timeData[2]) == y) {
                        numberYear++;
                    } else if (numberYear > 0) {
                        break;
                    }
                }
            } catch (Exception ex) {
                e-=0;//единица учтена в return
            }
            return new TimeInterval(e-numberYear-1, e-1, y);
        }
    }



    public void printStringData() {//печатает начальную строку диапозона и конечную строку
        System.out.println(plusStartNumber +" "+ plusEndNumber);
        System.out.println();
        System.out.println(minusStartNumber +" "+ minusEndNumber);
    }

}
