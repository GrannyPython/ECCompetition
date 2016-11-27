package competition;

/**
 * Created by mikhail on 03.11.2016.
 */
public class EmptyAlgorithm implements Algorithm {

    private FitnessEvaluator evaluator;



    @Override
    public void setEvaluator(FitnessEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * This is an entry point to your algorithm.
     * Implement your logic here.

     */
    @Override
    public void run() {
        /*
        * * Initialization
     * Loop {
     *     Operators
     *     Fitness evaluation by using evaluator.evaluate(your chromosome)
     * }\
     * */
    }
}
