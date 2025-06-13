package org.TransactionPD.ProcessingData;


import org.TransactionPD.Interfaces.TimeInterfaces;

public class TimeMonth implements TimeInterfaces {
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


    public TimeMonth(String[][] plusInputData, String[][] minusInputData, int timeColumn) {
        this.plusInputData = plusInputData;
        this.minusInputData = minusInputData;
        this.timeColumn = timeColumn;
    }

    @Override
    public void timeInterfaces(int amountMonth) {//numberTimeMonth
        int timeMonth = 1;
        int plusTimeLast = timeLast(plusInputData, timeMonth);//вычисление месяца последнего
        int minusTimeLast = timeLast(minusInputData, timeMonth);
        int timeYears = 2;
        int plusTimeYearsLast = timeLast(plusInputData, timeYears);//вычисление последнего года
        int minusTimeYearsLast = timeLast(minusInputData, timeYears);

        TimeInterval plusTimeInterval = TimeInterval.interval(plusInputData , plusTimeLast, plusTimeYearsLast, timeColumn, amountMonth);//отсчет интервала
        plusStartNumber = plusTimeInterval.startNumberMonth;
        plusEndNumber = plusTimeInterval.endNumberMonth;
        plusMonth = plusTimeInterval.month;
        plusYears = plusTimeInterval.years;

        TimeInterval minusTimeInterval = TimeInterval.interval(minusInputData , minusTimeLast, minusTimeYearsLast, timeColumn, amountMonth);
        minusStartNumber = minusTimeInterval.startNumberMonth;
        minusEndNumber = minusTimeInterval.endNumberMonth;
        minusMonth = minusTimeInterval.month;
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
    public int getPlusMonth() {
        return plusMonth;
    }
    @Override
    public int getPlusYears() {
        return plusYears;
    }
    @Override
    public int getMinusMonth() {
        return minusMonth;
    }
    @Override
    public int getMinusYears() {
        return minusYears;
    }


    public int timeLast(String[][] inputData, int time) {//последний месяц и год
        String[] timeLas = inputData[1][timeColumn].split("\\.");
        if (time==2) {
            String[] j = timeLas[time].split(" ");
            timeLas[time] = j[0];
        }

        return Integer.parseInt(timeLas[time]);
    }


    public static class TimeInterval {//подкласс для реализации возврата двух переменных из метода
        int startNumberMonth;
        int endNumberMonth;
        int month;
        int years;

        public TimeInterval(int startNumberMonth, int endNumberMonth, int month, int years) {
            this.startNumberMonth = startNumberMonth;
            this.endNumberMonth = endNumberMonth;
            this.month = month;
            this.years = years;
        }

        public static TimeInterval interval(String[][] inputData, int timeMonthLast, int timeYearsLast, int timeColumn, int amountMonth) {
            //метод вычисления начальной строки и конечной диапозона
            int numberMonther = 0;
            int m;
            int y;
            int q=0;
            int w=0;
            if (amountMonth+timeMonthLast<=0) {
                q += 12-12*((int) (double) ((amountMonth+timeMonthLast) / 12));//месяцы
                w+=1-((int) (double) ((amountMonth + timeMonthLast) / 12));//года
            }
            m = timeMonthLast+amountMonth+q;//месяцы
            y = timeYearsLast-w;//года
            int e=0;
            try {//для окончания перебора при окончании таблицы
                while (true) {//подсчет строк с одинаковыми месяцами и годом
                    e++;
                    String[] timeData;
                    timeData = inputData[e][timeColumn].split("\\.");
                    String[] j = timeData[2].split(" ");
                    timeData[2] = j[0];
                    if ((Integer.parseInt(timeData[1]) == m) && (Integer.parseInt(timeData[2]) == y)) {
                        numberMonther++;
                    } else if (numberMonther > 0) {
                        break;
                    }
                }
            } catch (Exception ex) {
                e-=0;//единица учтена в return
            }
            return new TimeInterval(e-1-numberMonther, e-1, m, y);
        }
    }



    public void printStringData() {//печатает начальную строку диапозона и конечную строку
        System.out.println(plusStartNumber+" "+plusEndNumber);
        System.out.println();
        System.out.println(minusStartNumber+" "+minusEndNumber);
    }


}
