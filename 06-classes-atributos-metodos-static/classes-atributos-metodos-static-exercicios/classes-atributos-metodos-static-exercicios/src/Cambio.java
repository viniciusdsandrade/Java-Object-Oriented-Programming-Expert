public class Cambio {
    public static double IOF = 0.06;

    public static double dolarParaReal(double dolar, double quantidade) {
        return dolar * quantidade * (1.0 + IOF);
    }
}
