public class Main {

    public static void main(String[] args){

        Rectangle first =new Rectangle();
        Rectangle second =new Rectangle(2,2);
        Rectangle third =new Rectangle(-2,4);
        Rectangle fourth =new Rectangle(1,2);
        Rectangle fifth =new Rectangle(3,5);

        System.out.println("Площадь прямоугольника со сторонами " +first.a+" и " + first.b+ ":");
        System.out.println(first.square());

        System.out.println("Периметр прямоугольника со сторонами " +first.a+" и " + first.b+ ":");
        System.out.println(first.perimeter());


        System.out.println("Прямоугольник со сторонами " +second.a+" и " + second.b+ " квадрат?");
        System.out.println(second.isItSquare());
        System.out.println("Прямоугольник со сторонами " +fourth.a+" и " + fourth.b+ " квадрат?");
        System.out.println(fourth.isItSquare());


        System.out.println("Существует ли  прямоугольник со сторонами "+third.a+" и " + third.b+ "?");
        System.out.println(third.checkForExistence());
        System.out.println("Существует ли  прямоугольник со сторонами "+fourth.a+" и " + fourth.b+ "?");
        System.out.println(fourth.checkForExistence());


        System.out.println("Первый прямоугольник со сторонами " +first.a+" и " + first.b+
                " равен второму прямоугольнику со сторонами "+second.a+" и " + second.b);
        System.out.println(first.equals(second));
        System.out.println("Первый прямоугольник со сторонами " +first.a+" и " + first.b+
                " равен второму прямоугольнику со сторонами "+fifth.a+" и " + fifth.b);
        System.out.println(first.equals(fifth));



    }

}
