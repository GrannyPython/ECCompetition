package competitionKarabaev;

import java.util.*;
import java.util.stream.Collectors;

public class Population {
	private List<Individual> population = new ArrayList<Individual>();

	public Population(int populationSize) {
		population = new ArrayList<>(populationSize);
	}

	public Population(List<Individual> list){
		population = list;
	}

	public Population(int populationSize, int chromosomeLength) {
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			population.add(new Individual(chromosomeLength));
		}
	}

	public void sortPopulation() {
		population =  population.stream().sorted((e1, e2) -> Double.compare(e2.getFitness(), e1.getFitness())).collect(Collectors.toList());
	}

	public List<Individual> getIndividualList() {
		return population;
	}



	public void killWeakest(){
		population =  population.stream().sorted((e1, e2) -> Double.compare(e2.getFitness(), e1.getFitness())).
				limit(Math.round(population.size()*0.5)).collect(Collectors.toList());
	}

	public void fridayNight(){
		/**
		 * will be soon
		 * */
	}
}