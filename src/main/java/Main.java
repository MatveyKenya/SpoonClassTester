
public class Main {

    private static final String pathToClass = "src/main/java/";

    public static void main(String[] args) {
        //1- Child extends Parent
        test1("Child", "Parent");

        //2- Child овверайдит метод foo()
        test2("Child", "foo");

        //3- OtherChild extends Child
        test1("OtherChild","Child");

        //4- OtherChild implements Usable
        test3("OtherChild", "Usable");

        //5- OtherChild овверайдит метод use()
        test2("OtherChild", "use");

        //6- OtherChild не овверайдит метод foo
        test2("OtherChild", "foo");
    }

    private static void test1(String classChildFileName, String classParentFileName) {
        System.out.println("(тест #1) проверка клас " + classChildFileName + " extends " + classParentFileName + " - " +
                SpoonTest.testClassChildToParent(pathToClass + classChildFileName, pathToClass + classParentFileName));
    }

    private static void test2(String classFileName, String methodName) {
        System.out.println("(тест #2) наличие @overide метода " + methodName + " в классе " + classFileName + " - " +
                SpoonTest.testClassToMethodOverride(pathToClass + classFileName, methodName));
    }

    private static void test3(String classFileName, String interfaceFileName) {
        System.out.println("(тест #3) наличие у класса " + classFileName + " интерфейса " + interfaceFileName + " - " +
                SpoonTest.testClassToInterface(pathToClass + classFileName, interfaceFileName));
    }

}
