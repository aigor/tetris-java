import java.util.LinkedList;
import java.util.List;


public class Finder {
	
	public Solution findBestPosition(Glass g, Figure f, int figureX, int figureY) {
		long timer = System.currentTimeMillis();		
		
		Glass best = g.dropFigure(f, figureX, figureY);
		int bestX = 0;
		int bestRot = 0;
		List<Integer> ranges = new LinkedList<Integer>();
		
		// for each rotate:
		for (int r = 4; r >= 0; r--) {
			Figure rotated = f.rotate(r);
			// for each x
			for(int i=0; i< Glass.cols; i++) {
				Glass res = g.dropFigure(rotated, i, figureY);
				ranges.add(res.getSurfaceRange());
				if (res.numbOfElemsOnField() == g.numbOfElemsOnField() + rotated.numbOfElemsOnField() &&
					res.getSurfaceRange() <= best.getSurfaceRange()){
					best = res;
					bestX = i;
					bestRot = r;
				}			
			}			
		}	
		
		System.out.println("Best:\n" + best.toString());
		System.out.println("Current range: " + g.getSurfaceRange());
		System.out.println("New range: " + best.getSurfaceRange());	
		System.out.println("Possible ranges: " + ranges);
		System.out.println("Best x:" + bestX);
		System.out.println("Best rotate:" + bestRot);
		System.out.println("Number of holes: " + best.getNumberOfHoles());		
		
		Solution res = null;
		if(bestX > figureX){
			res = new Solution(bestX - figureX,0, bestRot);
		} else {
			res = new Solution(0,figureX - bestX, bestRot);
		}
		
		System.out.println("Solution:" + res.toString());
		
		timer = System.currentTimeMillis() - timer;		
		System.out.println("Computation time: " + timer + " ms");
		
		return res;
		
	}

}
