package cgl;

public class cell {
	
	    // Set the size for each cell
	    int width = 10 ;
	    int height = 10;
            
	    public void constructor (context, gridX, gridY){
	    
	        this.context = context;

	        // Store the position of this cell in the grid
	        this.gridX = gridX;
	        this.gridY = gridY;

	        // Make random squares alive
	        this.alive = Math.random() > 0.5;
	    }

	    public void draw() {
	        // Draw a square, let the state determine the color
	        this.context.fillStyle = this.alive?'#ff8080':'#303030';
	        this.context.fillRect(this.gridX * Cell.width, this.gridY * Cell.height, Cell.width, Cell.height);
	    }
	}    

