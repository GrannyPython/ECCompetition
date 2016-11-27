package competition;

/**
 * Created by mikhail on 03.11.2016.
 */
public interface Algorithm {

    /**
     * Function set a fitness evaluator, which will be used during evolution process.
     * @param evaluator
     */
    public void setEvaluator(FitnessEvaluator evaluator);

    /**
     * Function is used an entry point to your algorithm.
     * Implement your logic here
     */
    public void run();

}
