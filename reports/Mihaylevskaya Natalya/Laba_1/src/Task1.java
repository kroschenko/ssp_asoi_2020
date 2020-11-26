public class Task1 {
    public static void main(String[]args){
        double[]array=new double[args.length];
        double[]dists=new double[args.length];
        for(int i=0;i<args.length;++i)
            array[i]=Double.parseDouble(args[i]);
        double dist=0;
        double argDist=0;
        double max=0;
        for(int i=0;i<array.length;++i){
            dist=0;
            for(int j=0;j<array.length;++j){
                dist+=(array[i]-array[j])+(array[i]-array[j]);
              dists[i]=Math.sqrt(dist);
              argDist+=dists[i];
              if(max<dists[i])
                max=dists[i];
            }          
        }    
        System.out.println("Arg distance = " + max*0.75);
        for(int i=0; i<dists.length;++i)
            System.out.println(dists[i]+ "");
        for (int i=0;i<dists.length;++i)
            if(dists[i]>max*0.75){
                System.out.println("i= "+i+""+array[i]);
            }
            

    }

}
