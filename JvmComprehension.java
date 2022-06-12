public class JvmComprehension {
    // загрузка класса JvmComprehension через подсистему загрузчиков классов для поиска класса:
    // Application ClassLoader-Platform ClassLoader-Bootstrap ClassLoader

    // после идет подготовка классов к выполнению: проверка, что код валиден,
    // подготовка примитивов в статических полях,
    // связывание ссылок на другие классы

    // инициализация класса: выполняется инициализация static полей

    // загрузка класса в область памяти где хранится мета-информация - Metaspace.
    // загружается информация об имени, методах, полях и др.
    public static void main(String[] args) { // в момент вызова создается фрейм в стеке
        //фрейм main
        int i = 1;                      // 1 в стеке создается переменная i
        Object o = new Object();        // 2 в стеке создается переменная o и присваивается ссылка на Object в куче
        Integer ii = 2;                 // 3 в стеке создается переменная ii
        //- main
        //фрейм printAll
        printAll(o, i, ii);             // 4 в стеке создается ссылка на Object, переменные i и ii
        //- printAll

        // uselessVar нигде не используется сборщик мусора её удалит

        System.out.println("finished"); // 7 создается новый фрейм println и после выполнения удаляется
    }
    //после выполнения фрейм main удалется

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 создается переменная uselessVar в фрейме printAll
        System.out.println(o.toString() + i + ii);  // 6 создается фрейм println передаются ссылки на Object, i и ii
        // создается ещё один фрейм для toString после выполнения фрейм удаляется, println удалятся
        // фрейм printAll после выполнения тоже удаляется
    }
}
