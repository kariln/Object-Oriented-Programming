package patterns.observable;
import java.util.*;
public class HighscoreList {
	private int maxSize;
	List <Integer> results = new ArrayList<Integer>();
	Set <HighscoreListListener> listeners = new HashSet<HighscoreListListener>();
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void checkSize() {
		if (results.size() > maxSize) {
			int lengde1 = results.size();
			for (int i =(maxSize+1); i <= lengde1 ; i +=1) {
				results.remove(i);
			}
		}
	}
	
	public int size() {
		return results.size();
	}
	
	public int getElement(int indeks) {
		return this.getElement(indeks);
	}
	
	public void addResult(int res) {
		int lengde2 = results.size();
		for (int i = 0; i <= lengde2 ; i += 1) {
			if (res < results.get(i)) {
				results.set(i, res);
				this.checkSize();
				break;
			}
			
		}
	}
	
	public void addHighscoreListListener(HighscoreListListener listener) {
		listeners.add(listener);
		//må referere til listChange
		//hva er int i listchange?
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		listeners.remove(listener);
		//må referere til listChange
		//hva er int i listchange?
		
	}

}
