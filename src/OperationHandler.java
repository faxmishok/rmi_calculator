public class OperationHandler {

    double opX,opY,result;
    int opNumber;

    public OperationHandler(){  }

    public OperationHandler(double x, double y, int num){
        this.opX = x;
        this.opY = y;
        this.opNumber = num;
    }


    public double calculate() {
        if ( this.opNumber == 1 )
            this.result =  this.opX+this.opY;

        else if ( this.opNumber == 2 ) {
            if ( this.opX - this.opY > 0 )	this.result = this.opX-this.opY;
            else 							this.result = this.opY-this.opX;
        }

        else if ( this.opNumber == 3 )
            this.result =  this.opX*this.opY;

        else if ( this.opNumber == 4 ) {
            if ( this.opY == 0 ) {
                System.out.println("Error. Division by 0!\nReturning -1");
                this.result = -1;
            }
            else this.result = this.opX/this.opY;
        }
        return this.result;
    } // calculate() without args



    public double calculate(double x, double y, int num) {
        if ( num == 1 )
            this.result = x+y;

        else if ( num == 2 ) {
            if ( x-y > 0 )		this.result = x-y;
            else				this.result = y-x;
        }
        else if ( num == 3 )
            this.result = x*y;

        else if ( num == 4 ) {
            if ( y == 0 ) {
                System.out.println("Error. Division by 0!");
                this.result = -1;
            }
            else this.result =  x/y;
        }
        return this.result;
    } // calculate() with args


    public double getX() {
        return this.opX;
    }

    public double getY() {
        return this.opY;
    }

    public double getOpNum() {
        return this.opNumber;
    }

    public boolean isset() {
        if ( getX() == -1 || getY() == -1 || getOpNum() == -1 )
            return false;
        else
            return true;
    }


}