public class Polynomial {
    double[] coefficients;

    public Polynomial() {
        coefficients = new double[] {0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    // testing function; ignore for evaluation
    public void print() {
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print(coefficients[i] + "x^" + i);

            if (i < coefficients.length - 1)
                System.out.print(" + ");
        }

        System.out.print("\n");
    }

    public Polynomial add(Polynomial other) {
        if (coefficients.length < other.coefficients.length) {
            return other.add(this);
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            coefficients[i] += other.coefficients[i];
        }

        return this;
    }

    public double evaluate(double x) {
        double sum = 0.0;

        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }

        return sum;
    }

    public boolean hasRoot(double x) {
        return this.evaluate(x) == 0;
    }
}
