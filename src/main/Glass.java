
public class Glass {
	public static int rows = 20;
	public static int cols = 10;
	
	static String COMLETE_ROW;
	static {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cols; i++) {
			sb.append('*');
		}
		COMLETE_ROW = sb.toString();		
	}
	
	private String[] field = new String[rows];
	
	public Glass(String glass){
		for(int i = 0; i <rows; i++){
			field[i] = glass.substring(i*cols, ((i+1)*cols));
		}	
	}
	
	public Glass(String[] field){
		this.field = field;	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = rows - 1; i >= 0; i--){
			sb.append("|");
			sb.append(field[i]);
			sb.append("|");
			sb.append("\n");
		}
		for(int i = 0; i< cols+2; i++){
			sb.append("-");
		}
		return sb.toString();
	}	
	
	public int[] getSurface(){
    	int[] surface = new int[cols];
    	int[] surfDiff = new int[cols - 1];
    	
    	for(int j = 0; j < cols; j++){
    		for(int i = rows - 1; i >= 0; i--){
    			if (field[i].charAt(j) == '*'){
    				surface[j] = i + 1;    				
    				break;    				
    			}
    		}	
    	}
    	for (int i=0; i< cols - 1; i++){
    		surfDiff[i] = surface[i+1] - surface[i];
    	}    	
    	return surfDiff;    
    }
	
	public String getSurfaceRepres(){
		int[] surf = this.getSurface();
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < surf.length; i++) {
			res.append(surf[i] + ", ");
		}
		return res.toString();
	}
	
	public int getSurfaceRange(){
		int[] surf = this.getSurface();
		int res = 0;
		for (int i = 0; i < surf.length; i++) {
			res += Math.abs(surf[i]);
		}
		res+= getNumberOfHoles() * 20;		
		res -= 20 * getNumOfCompleteRows();
		
		return res;		
	}	
	
	public int getNumOfCompleteRows(){
		int comp = 0;
		for (int i = 0; i < rows; i++) {
			if(field[i].equals(COMLETE_ROW)){
				comp++;				
			}
		}
		return comp;
	}
	
	public int getNumberOfHoles(){
		int[][] array = getFieldAsArray();
		int holes = 0;
		for (int i = 0; i < cols; i++) {
			boolean barier = false;
			for (int j = rows - 1; j >= 0; j--) {
				if(array[j][i] == 1){
					barier = true;
				} else {
					if (barier){				
						holes++;
					}
				}
			}
		}
		return holes;
		
	}
	
	public int numbOfElemsOnField(){
		int[][] field = this.getFieldAsArray();
		int res = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				res += field[i][j];
			}
		}
		
		return res;
	}	
	
	public Glass dropFigure(Figure f, int figureX, int figureY){		
		Glass curr = null;
		Glass prev = null;
		int dropLines = 0;	
		
		curr = addFigure(f, figureX, figureY - dropLines);		
		dropLines = 1;		
		do{
			prev = curr;
			curr = addFigure(f, figureX, figureY - dropLines);
			dropLines += 1;
		} while((curr.numbOfElemsOnField() == this.numbOfElemsOnField() + f.numbOfElemsOnField()));		
				
		return prev;
	}
	
	public Glass addFigure(Figure f, int figureX, int figureY) {
		int[][] field = getEmptyArray();
		
		for(int i = 0; i < Figure.rows; i++){
			for(int j = 0; j < Figure.rows; j++){
				int resultRow = figureY - i - 1 + f.getCenterY();
				int resultCol = figureX + j - f.getCenterX() + 1;
				if (resultRow >= 0 && resultRow < rows &&
					resultCol >= 0 && resultCol < cols){
						field[resultRow][resultCol] = 
								f.getFigure()[i].charAt(j) == '*' ? 1:0;
				}
			}
		}
		int[][] originalField = this.getFieldAsArray();			
		int[][] temp;
				
		temp = getEmptyArray();
		for(int i=0; i < rows; i++){
			for(int j=0; j < cols;j++){
				temp[i][j] = originalField[i][j] | field[i][j]; 
			}
		}		
		String[] fieldResult = generateField(temp);				
		return new Glass(fieldResult);
	}
		
	public static int[][] getEmptyArray(){
		int[][] res = new int[rows][cols]; 
		return res; 
	}
	
	public int[][] getFieldAsArray(){
		int[][] res = new int[rows][cols];		
		for(int i = 0; i < rows; i++){			
			for (int j = 0; j < cols; j++) {
				res[i][j] = (field[i].charAt(j) == '*' ? 1 : 0);
			}		
		}		
		return res;
	}
	
	public static String[] generateField(int[][] field){
		String[] res = new String[rows]; 
		
		for(int i=0;i<rows;i++){
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < cols; j++) {
				s.append(field[i][j] == 1 ? '*' : ' ');
			}			
			res[i] = s.toString();
		}
		return res;	
	}
}
