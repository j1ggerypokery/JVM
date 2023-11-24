package org.example;

public class JvmComprehension { // в Metaspace загружаются классы (имя, методы, поля, константы)

    public static void main(String[] args) {   // в момент выполнения main Frame создается на Stack Memory
        int i = 1;                      // на Stack Memory в Frame main выделяется память для примитивной переменной i
        Object o = new Object();        // в Heap располагается объект класса Object (ссылочный). А ссылка "o" запоминается на Stack в Frame main
        Integer ii = 2;                 // на Stack Memory выделяется память для примитивной переменной ii
        printAll(o, i, ii);             // на Stack Memory создается Frame printAll, куда записываются переменные i,ii. Также в Frame printAll создается "o"б которая ссылается на Object, который лежит в Heap
        System.out.println("finished"); // на Stack Memory создается новый Frame, куда записывается "finished"
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // на Stack Memory в Frame printAll выделяется память для примитивной переменной uselessVar. При использовании сборщика мусора uselessVar можно убрать
        System.out.println(o.toString() + i + ii);  // на Stack Memory создается новый Frame, куда передается ссылка на o, i и ii
    }
}
