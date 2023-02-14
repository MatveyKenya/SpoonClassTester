import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpoonTest {

    static public boolean testClassToMethodOverride(String nameClass, String overrideNameMethod) {

        CtClass<?> testClass = Launcher.parseClass(getContent(nameClass));
        CtMethod<?> method = testClass.getMethod(overrideNameMethod);

        return (method != null && method.hasAnnotation(Override.class));
    }

    static public boolean testClassChildToParent(String nameChildClass, String nameParentClass) {

        CtClass<?> childClass = Launcher.parseClass(getContent(nameChildClass));
        CtClass<?> parentClass = Launcher.parseClass(getContent(nameParentClass));

        return childClass.getSuperclass().equals(parentClass.getReference());
    }

    static public boolean testClassToInterface(String nameClass, String nameInterface) {

        CtClass<?> ctClass = Launcher.parseClass(getContent(nameClass));

        return ctClass.getSuperInterfaces().toString().contains(nameInterface);
    }

    static private String getContent(String nameClass) {
        try{
            return Files.lines(Paths.get(nameClass + ".java")).reduce("", String::concat);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
