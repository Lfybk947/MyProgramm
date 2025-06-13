package org.TransactionPD.ProcessingData;

import org.TransactionPD.Interfaces.TimeInterfaces;

public class TimeQuarter implements TimeInterfaces {
    private final String[][] plusInputData;
    private final String[][] minusInputData;
    private final int timeColumn;
    private int plusStartNumber;
    private int plusEndNumber;
    private int minusStartNumber;
    private int minusEndNumber;
    private int plusMonth;
    private int plusYears;
    private int minusMonth;
    private int minusYears;

    public TimeQuarter(String[][] plusInputData, String[][] minusInputData, int timeColumn) {
        this.plusInputData = plusInputData;
        this.minusInputData = minusInputData;
        this.timeColumn = timeColumn;
    }
    @Override
    public void timeInterfaces(int amountQuarter) {//numberTimeQuarter
        int timeQuarter = 1;
        int plusTimeLast = timeLastQuarter(plusInputData, timeQuarter);//вычисление месяца последнего
        int minusTimeLast = timeLastQuarter(minusInputData, timeQuarter);
        int timeYears = 2;
        int plusTimeYearsLast = timeLastYear(plusInputData, timeYears);//вычисление последнего года
        int minusTimeYearsLast = timeLastYear(minusInputData, timeYears);

        TimeQuarter.TimeInterval plusTimeInterval = TimeQuarter.TimeInterval.interval(plusInputData , plusTimeLast, plusTimeYearsLast, timeColumn, amountQuarter);//отсчет интервала
        plusStartNumber = plusTimeInterval.startNumberQuarter;
        plusEndNumber = plusTimeInterval.endNumberQuarter;
        plusMonth = plusTimeInterval.quarter;
        plusYears = plusTimeInterval.years;

        TimeQuarter.TimeInterval minusTimeInterval = TimeQuarter.TimeInterval.interval(minusInputData , minusTimeLast, minusTimeYearsLast, timeColumn, amountQuarter);
        minusStartNumber = minusTimeInterval.startNumberQuarter;
        minusEndNumber = minusTimeInterval.endNumberQuarter;
        minusMonth = minusTimeInterval.quarter;
        minusYears = minusTimeInterval.years;

    }
    @Override
    public int getPlusStartNumber() {return plusStartNumber;}
    @Override
    public int getPlusEndNumber() {return plusEndNumber;}
    @Override
    public int getMinusStartNumber() {return minusStartNumber;}
    @Override
    public int getMinusEndNumber() {return minusEndNumber;}
    @Override
    public int getPlusMonth() {return plusMonth;}
    @Override
    public int getPlusYears() {return plusYears;}
    @Override
    public int getMinusMonth() {return minusMonth;}
    @Override
    public int getMinusYears() {return minusYears;}

    public int timeLastQuarter(String[][] inputData, int time) {//последний квартал
        String[] timeLas = inputData[1][timeColumn].split("\\.");
        return quarter(timeLas,time);
    }
    public static int quarter(String[] timeLas, int time) {
        int quarter=0;
        if (Integer.parseInt(timeLas[time])==1||Integer.parseInt(timeLas[time])==2||Integer.parseInt(timeLas[time])==3) {
            quarter = 1;
        } else if (Integer.parseInt(timeLas[time])==4||Integer.parseInt(timeLas[time])==5||Integer.parseInt(timeLas[time])==6) {
            quarter = 2;
        }else if (Integer.parseInt(timeLas[time])==7||Integer.parseInt(timeLas[time])==8||Integer.parseInt(timeLas[time])==9) {
            quarter = 3;
        }else if (Integer.parseInt(timeLas[time])==10||Integer.parseInt(timeLas[time])==11||Integer.parseInt(timeLas[time])==12) {
            quarter = 4;
        }
        return quarter;
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
        int startNumberQuarter;
        int endNumberQuarter;
        int quarter;
        int years;

        public TimeInterval(int startNumberQuarter, int endNumberQuarter, int quarter, int years) {
            this.startNumberQuarter = startNumberQuarter;
            this.endNumberQuarter = endNumberQuarter;
            this.quarter = quarter;
            this.years = years;
        }

        public static TimeInterval interval(String[][] inputData, int timeQuarterLast, int timeYearsLast, int timeColumn, int amountQuarter) {
            //метод вычисления начальной строки и конечной диапозона
            int numberQuarter = 0;
            int m;
            int y;
            int q=0;
            int w=0;
            if (amountQuarter+timeQuarterLast<=0) {
                q += 4-4*((int) (double) ((amountQuarter+timeQuarterLast) / 4));//квартал
                w+=1-((int) (double) ((amountQuarter + timeQuarterLast) / 4));//года
            }
            m = timeQuarterLast+amountQuarter+q;//квартал
            y = timeYearsLast-w;//года
            int e=0;
            try {//для окончания перебора при окончании таблицы
                while (true) {//подсчет строк с одинаковым кварталом и годом
                    e++;
                    String[] timeData;
                    timeData = inputData[e][timeColumn].split("\\.");
                    String[] j = timeData[2].split(" ");
                    timeData[2] = j[0];
                    if ((quarter(timeData,1) == m) && (Integer.parseInt(timeData[2]) == y)) {
                        numberQuarter++;
                    } else if (numberQuarter > 0) {
                        break;
                    }
                }
            } catch (Exception ex) {
                e-=0;//единица учтена в return
            }
            return new TimeInterval(e-numberQuarter-1, e-1, m, y);
        }
    }



    public void printStringData() {//печатает начальную строку диапозона и конечную строку
        System.out.println(plusStartNumber +" "+ plusEndNumber);
        System.out.println();
        System.out.println(minusStartNumber +" "+ minusEndNumber);
    }

}
