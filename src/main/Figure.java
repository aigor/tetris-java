import java.util.HashMap;
import java.util.Map;


public class Figure {
	public static final int rows = 5;	
	
	static Figure I = new Figure(	3, 3,
				"     ",
				"  *  ",
				"  *  ",
				"  *  ",
				"  *  ");

	static Figure O = new Figure(	3, 3,
				"     ",
				"     ",
	            "  ** ",
	            "  ** ",
	            "     ");
	
	static Figure L = new Figure(	3, 3,
				"     ",
	            "  *  ",
	            "  *  ",
	            "  ** ",
	            "     ");
	static Figure J = new Figure(	3, 3,
				"     ",
	            "  *  ",
	            "  *  ",
	            " **  ",
	            "     ");
	static Figure S = new Figure(	3, 3,
				"     ",
	            "  ** ",
	            " **  ",
	            "     ",
	            "     ");
	static Figure Z = new Figure(	3, 3,
				"     ",
	            " **  ",
	            "  ** ",
	            "     ",
	            "     ");
	static Figure T = new Figure(	3, 3,
				"     ",
	            "  *  ",
	            " *** ",
	            "     ",
	            "     ");
	
	
	static Map<String, Figure> map = new HashMap<String, Figure>();
	static {
		map.put("I", I);
		map.put("O", O);
		map.put("L", L);
		map.put("J", J);
		map.put("S", S);
		map.put("Z", Z);
		map.put("T", T);
	}
	
	
	String[] fig = new String[4];
	int centerX;
	int centerY;
	
	public String[] getFigure(){
		return fig;
	}
	
	Figure(int centerX, int centerY, String... str){
		this.centerX = centerX;
		this.centerY = centerY;
		fig = str;   	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < rows; i++){
    		sb.append(fig[i]);
    		sb.append("\n");
    	}   
		return sb.toString();
	}
	
	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}
	
	public int[][] getFigureAsArray(){
		int[][] res = new int[rows][rows];		
		for(int i=0;i<rows;i++){			
			for (int j = 0; j < rows; j++) {
				res[i][j] = (fig[i].charAt(j) == '*' ? 1 : 0);
			}		
		}		
		return res;
	}
	
	public int numbOfElemsOnField(){
		int[][] field = this.getFigureAsArray();
		int res = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				res += field[i][j];
			}
		}		
		return res;
	}
	
	public static String[] generateField(int[][] field){
		String[] res = new String[rows]; 
		
		for(int i=0;i<rows;i++){
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < rows; j++) {
				s.append(field[i][j] == 1 ? '*' : ' ');
			}			
			res[i] = s.toString();
		}
		return res;	
	}
	
	public Figure rotate(){
		int[][] field = getFigureAsArray();
		int[][] res = new int[rows][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				res[i][j] = field[rows-1- j][i];
			}
		}	
		return new Figure(3,3, generateField(res));
	}
	
	public Figure rotate(int rot){
		Figure rotated = this;
		for(int i = 0; i < rot; i++){
			rotated = rotated.rotate();
		}		
		return rotated;		
	}	
}
