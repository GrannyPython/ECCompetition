package competitionKarabaev;


import java.util.ArrayList;

import static competitionKarabaev.Individual.crossover;

public class MyAlgorithm implements Algorithm {
    private int populationSize;
    private double mutationRate;
    private int luxuryVIP;
    private FitnessEvaluator evaluator;

    public MyAlgorithm(int populationSize, double mutationRate, int luxuryVIP) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.luxuryVIP = luxuryVIP;
    }

    public Population initPopulation(int chromosomeLength) {
        Population population = new Population(populationSize, chromosomeLength);
        return population;
    }


    public Population mutatePopulation(Population population) {
        population.sortPopulation();

        for (int populationIndex = luxuryVIP; populationIndex < population.getIndividualList().size(); populationIndex++) {
            Individual individual = population.getIndividualList().get(populationIndex);
            boolean mutant = false;
            for (int geneIndex = 0; geneIndex < evaluator.problemDimension(); geneIndex++) {
                if (Math.random() < mutationRate / 100) {
                    individual.getChromosome().set(geneIndex, (Math.random() - 0.5) * 20);
                    mutant = true;
                }
            }
            if (mutant) {
                individual.setFitness(-Double.MAX_VALUE);
            }
            population.getIndividualList().set(populationIndex, individual);
        }

        return population;
    }

    int counter = 0;

    public Population evalPopulation(Population population) {
        Individual ind;
        for (int i = 0; i < population.getIndividualList().size(); i++) {
            ind = population.getIndividualList().get(i);
            double[] unboxed = (ind.getChromosome()).stream().mapToDouble(d -> d).toArray();
            if (counter < 20000) {
                if (ind.getFitness() == -Double.MAX_VALUE) {
                    ind.setFitness(evaluator.evaluate(unboxed));
                    counter++;
                }
            } else {
                System.exit(0);
            }
        }
        population.sortPopulation();
        return population;
    }


    public Population crossoverPopulation(Population population) {
        ArrayList childs = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Individual parent1 = population.getIndividualList().get(0);
            Individual parent2 = population.getIndividualList().get(i);

            childs.add(crossover(parent1, parent2));
        }
        population.getIndividualList().addAll(childs);
        return population;
    }

    Population killWeakest(Population population) {
        population.killWeakest();
        return population;
    }

    @Override
    public void setEvaluator(FitnessEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * This is an entry point to your algorithm.
     * Implement your logic here.
     */
//    int populationSize, double mutationRate, double crossoverRate, int elitismCount;
    @Override
    public void run() {
        setEvaluator(new ExampleFitnessEvaluator());

        Population population = initPopulation(evaluator.problemDimension());
        evalPopulation(population);

        while (true) {
            population = killWeakest(population);
            population = crossoverPopulation(population);

            population = mutatePopulation(population);

            population = evalPopulation(population);
        }

    }

    public static void main(String[] args) {
        MyAlgorithm ga = new MyAlgorithm(30, 1.0, 5);
        ga.run();
    }
}
