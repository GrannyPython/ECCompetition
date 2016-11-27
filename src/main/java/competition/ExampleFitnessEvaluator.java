package competition;

/**
 * Created by mikhail on 03.11.2016.
 */
public class ExampleFitnessEvaluator implements FitnessEvaluator {

    private double best = -Double.MAX_VALUE;
    private int dimension = 20;
    private long counter = 0;

    @Override
    public double evaluate(double[] genotype) {
        double fitness = 0.0;
        counter++;

        for (int i = 0; i < dimension; i++) {
            fitness += genotype[i];
        }

        if (fitness > best) {
            best = fitness;
            if (counter < 200000000)
                System.out.println(best);
            if (counter > 200000000){
                System.exit(1);
            }
        }

        return fitness;
    }

    @Override
    public double result() {
        return best;
    }

    @Override
    public int problemDimension() {
        return dimension;
    }
}
