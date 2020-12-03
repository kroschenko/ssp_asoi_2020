public class Main {
    public static void main(String[] args){
        EquilTriangle first = new EquilTriangle(3.0,3.0,3.0);
        EquilTriangle second = new EquilTriangle(3,3,3);
        EquilTriangle trird = new EquilTriangle(3,5,8);

        System.out.println("first "+ first.isTriangle());
        System.out.println("trird "+ trird.isTriangle());

        System.out.println("Perimeter first "+ first.perimeter());
        System.out.println("Square first "+ first.square());

        System.out.println("first equals second - "+first.equals(second));
        System.out.println("first equals trird - "+ first.equals(trird));

    }
}
