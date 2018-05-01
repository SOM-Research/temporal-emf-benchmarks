package test.original;

import tll.load.ModelLoader;

public class CountProducedItems {

	public static void main(String[] args) {
		tll.System klyo = new ModelLoader().load("output/simOutput.klyo.xmi");
		
		int kyloItems = klyo.getArea().stream().mapToInt(element -> element.getStore().getFinalItems().size()).sum();
		
		tll.System emf = new ModelLoader().load("output/simOutput.emf.xmi");
		
		int emfItems =  emf.getArea().stream().mapToInt(element -> element.getStore().getFinalItems().size()).sum();
		
		System.out.println("kylo: " + kyloItems + " emf: " + emfItems);
		
	}

}
