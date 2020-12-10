class Main {
  public static void main(String[] args) {
    Word w1 = new Word("i");
    Word w2 = new Word("did");
    Word w3 = new Word("this");
    Word w4 = new Word("laboratory");
    Word w5 = new Word("work");
    Abzac ab = new Abzac(w1,w2,w3,w4,w5);
    ab.print();
  }
}

/*
Реализовать агрегирование. При создании класса агрегируемый класс объявляется как атрибут (локальная переменная, параметр метода). Включить в каждый класс 2-3 метода на выбор. Продемонстрировать использование разработанных классов.

Создать класс Абзац, используя класс Слово. 

https://ru.stackoverflow.com/questions/596697
*/