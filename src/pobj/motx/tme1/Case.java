package pobj.motx.tme1;

public class Case {
	int lig; int col; char c;



	public Case(int lig, int col, char c) {
		this.lig = lig;
		this.col = col;
		this.c = c;
	}



	public char getChar() {
		return c;
	}



	public void setChar(char c) {
		this.c = c;
	}



	public int getLig() {
		return lig;
	}



	public int getCol() {
		return col;
	}
	
	public boolean isVide() {
		if(this.getChar()==' ') {
			return true;
		}
		else return false;
	}
	
	public boolean isPleine() {
		if(this.getChar()=='*') {
			return true;
		}
		else return false;
	}
	
	
	
	
	

}
