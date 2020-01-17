package minegenkode.trening2018;

import java.util.ArrayList;
import java.util.Collection;

public class DiceScore {
	
	private Collection<DiceScorer> diceScorers;
	
	public DiceScore(Collection <DiceScorer> diceScorers){
		this.diceScorers = new ArrayList<DiceScorer>();
		for (DiceScorer die : diceScorers) {
			this.diceScorers.add(die);
		}
	}
	 
	public Collection<Dice> computeDiceScores(Dice dice) {
	   Collection<Dice> result = new ArrayList<>();
	   // Vi f�lger algoritmen gitt over:
	   // S� lenge det er terninger igjen, s�
	   //   finner vi regelen som gir flest poeng og sparer p� de terningene den "brukte" og
	   //   fjerner dem fra gjenv�rende terninger
	   while (dice.getDieCount() > 0) {
		   //mens vi fortsatt har flwere terninger igjen
	      Dice best = null;
	      //g�r gjennom alle reglene vi kan teste for
	      for (DiceScorer diceScorer : diceScorers) {
	         Dice score = diceScorer.getScore(dice);
	         if (score != null && (best == null || score.getScore() > best.getScore())) {
	            best = score;
	         }
	      }
	      if (best == null) {
	         break;
	         //da finnes det ingen kombinasjoner som gir poeng
	      } else {
	         result.add(best);
	         dice = dice.remove(best);
	         //legger til det forel�pig beste resultatet i v�r collection, og trekker fra terningverdiene som disse tilsvarer
	      }
	   }
	   return result;
	}
}
