package competition;

/**
 * Created by mikhail on 03.11.2016.
 */
public interface FitnessEvaluator {

    /**
     * This function must be used for evaluation of fitnesses.
     * @param genotype
     * @return fitness
     */
    public double evaluate(double[] genotype);

    /**
     * This function returns the result at the end of evolution process.
     * @return result of evolutionary algorithm
     */
    public double result();

    /**
     * This function defines the dimension of problem. The number of genes in genotype.
     * If this function returns 100, than your genotype's (double array) length should be equal to 100.
     * @return dimension of problem
     */
    public int problemDimension();
}
