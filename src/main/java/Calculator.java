
public class Calculator {

    //Сравнить value1 = value2 ? Yes / NO
    public boolean compareNumbers(double value1, float value2) {
        return (Math.abs(value1 - value2) < 0.000001);
    }

    //Округлить value1   134.45  --> 134.0   345.78 --> 346.0
    public double roundNumbers(double value1) {

        double value = Math.round(value1);
        return value;

    }

    //Отбросить дробную часть   134.297 --> 134    1234.888 --> 1234
    public long cut(double value1) {

        long value3 = (long) value1;
        return value3;

    }

    // перевод дней, часов и минут в секунды. convertToSeconds(2, 4, 53) --> 190380
    public int convertToSeconds(int days, int hours, int minutes) {
        int seconds = days * 24 * 3600 + hours * 3600 + minutes * 60;
        return seconds;

    }

    // перевод RUB to USD. rate = 134.297
    public double convertRubToUsd(double rub, double rate) {
        double usd = rub / rate;
        usd = roundNumbers(usd);
        return usd;  //1 USD = 134.297 RUB

    }


}
