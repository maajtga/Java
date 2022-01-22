import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        
        int a = 5;
        int b = 12;
        int c = 13;

        System.out.println(getABC(a, b, c, ABC.GET_A));        
        System.out.println(getABC(a, b, c, ABC.GET_B));
        System.out.println(getABC(a, b, c, ABC.GET_C));
    }

    private enum ABC {
        GET_A, GET_B, GET_C;
    }
    
    private static String getABC (float a, float b, float c, ABC get) {       
        double sum = 0;
        
        switch (get) {
            case GET_A:
                sum = (c * c) - (b * b);
                return "One of the legs is: " + Math.sqrt(sum);    
            case GET_B:
                sum = (c * c) - (a * a);
                return "One of the legs is: " + Math.sqrt(sum);  
            case GET_C:
                sum = (a * a) + (b * b);
                return "The hypotenuse is: " + Math.sqrt(sum);    
            default:    
                return "Error processing the values!";    
        }       
    }
}

/* private static double getC (float a, float b) {
    
    double sum = (a * a) + (b * b);
    return Math.sqrt(sum);        

}

private static double getA (float c, float b) {

    double sum = (c * c) - (b * b);
    return Math.sqrt(sum);

}

private static double getB (float c, float a) {
    
    double sum = (c * c) - (a * a);
    return Math.sqrt(sum);

} */