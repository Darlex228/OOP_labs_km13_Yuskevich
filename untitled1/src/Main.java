public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(2,3);
        a.set_Random();
        Matrix b = new Matrix(2,3);
        b.set_Random();
        a.print();
        b.print();

        Matrix c = new Matrix(a);
        c.add(b);
        c.print();
        a.multiply(-2);
        a.print();
        a.add(c);
        a.print();


    }
}