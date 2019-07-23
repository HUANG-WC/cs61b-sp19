public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public Body(double xP, double yP, double xV,
    double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }
     public double calcDistance(Body b){
        return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos)+(yyPos-b.yyPos)*(yyPos-b.yyPos));
     }
    public double calcForceExertedBy(Body p){
        return mass * p.mass * 6.67 * Math.pow(10,-11) / Math.pow(this.calcDistance(p),2);
    }
    public double calcForceExertedByX(Body p){
    	double dx = p.xxPos - this.xxPos;
    	return this.calcForceExertedBy(p)* dx / this.calcDistance(p);
    }

    public double calcForceExertedByY(Body p){
    	double dy = p.yyPos - this.yyPos;
    	return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }
    public double calcNetForceExertedByX(Body[] allPlanets){
    	double forceX = 0.0;
    	for(int i = 0; i < allPlanets.length; i++) {
    		if (this.equals(allPlanets[i]) != true){
    			
    			forceX += this.calcForceExertedByX(allPlanets[i]);
    		}
    	}
    	return forceX;
    }

    public double calcNetForceExertedByY(Body[] allPlanets){
    	double forceY = 0.0;
    	for(int i = 0; i < allPlanets.length; i++) {
    		if (this.equals(allPlanets[i]) != true){
    			
    			forceY += this.calcForceExertedByY(allPlanets[i]);
    		}
    	}
    	return forceY;
    }


    public void update(double dt, double fX, double fY) {
        double xxAcc = fX / this.mass;
        double yyAcc = fY / this.mass;
        this.xxVel += dt * xxAcc;
        this.yyVel += dt * yyAcc;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
      }
      public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
   }

}