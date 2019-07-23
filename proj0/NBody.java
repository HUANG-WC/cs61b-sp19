public class NBody {
    public static double readRadius(String fn){
        In in = new In(fn);
        int num = in.readInt();
        return in.readDouble();
    }
    public static Body [] readBodies(String planetsTxtPath){
        In in = new In(planetsTxtPath);
		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
        Body [] allPlanets = new Body[numOfPlanets];
        for(int i = 0; i < numOfPlanets; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
            String imgFileName ="images/"+ in.readString();
            
	        allPlanets[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
		return allPlanets;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body [] allPlanets = readBodies(filename);
        Double radius = readRadius(filename);
        // First,set the scale so that it matches the radius of the universe,
        // Then draw the image starfield.jpg as the background.
        StdDraw.setScale(-2 * radius, 2 * radius);
        StdDraw.enableDoubleBuffering();
        double[] xForces=new double [allPlanets.length];
        double[] yForces=new double [allPlanets.length];
        for(double time=0.0;time<T;time+=dt){
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int i=0;i<allPlanets.length;i++){
                xForces[i]=allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i]=allPlanets[i].calcNetForceExertedByY(allPlanets);
                allPlanets[i].update(dt,xForces [i], yForces [i]);
                allPlanets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        } 
        StdOut.printf("%d\n",allPlanets.length);
        stdOut.printf("%.2e\n",radius);
        for(i=0;i<allPlanets.lenght;i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
  
}