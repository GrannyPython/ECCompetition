package competition;


import java.util.ArrayList;
import java.util.List;

public class Individual {
    private List<Double> chromosome = new ArrayList<>();
    private double fitness = - Double.MAX_VALUE;

    public Individual(List<Double> chromosome) {
        // Create individual chromosome
        this.chromosome = chromosome;
    }

    public List<Double> getChromosome() {
        return chromosome;
    }

    public void setChromosome(ArrayList<Double> chromosome) {
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength) {
        chromosome = new ArrayList<Double>(chromosomeLength);
        for (int gene = 0; gene < chromosomeLength; gene++) {
            chromosome.add(gene, ((Math.random() - 0.5) * 20));
        }
    }


//    public void setGene(int offset, double gene) {
//        this.chromosome.get(offset)=
//    }

//    public double getGene(int offset) {
//        return this.chromosome[offset];
//    }


    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public String toString() {
        return  String.valueOf( (getFitness()==0) ?  0 : getFitness());
    }

    public static Individual crossover(Individual i1, Individual i2){
        List<Double> list = new ArrayList();

        for (int i = 0; i <i1.getChromosome().size() ; i++) {
            if (Math.random()>0.5){
                list.add(i1.getChromosome().get(i));
            }
            else {
                list.add(i2.getChromosome().get(i));
            }
        }

        return new Individual(list.subList(0, list.size()));
    }

}
