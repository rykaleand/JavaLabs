package Lab2_Reflection;

// Класс с аннотированными методами
public class MyClass {
    @Annotation(value = 1)
    private void privateMethod1(Double parameter, Boolean par) {
        System.out.println("first private method: " + parameter +' '+ par);
    }

    @Annotation(value = 2)
    private void privateMethod2(Integer parameter) {
        System.out.println("second private method: " + parameter);
    }

    @Annotation(value = 3)
    protected void protectedMethod1(String parameter) {
        System.out.println("first protected method with parameter: " + parameter + '!');
    }
    @Annotation(value = 2)
    protected void protectedMethod2(Character parameter1, Integer parameter2 ) {
        System.out.println("second protected method: " + parameter1 +' '+parameter2);
    }

    @Annotation(value = 3)
    public void publicMethod1(String par1, Float par2) {
        System.out.println("public method!!!!!!!!! " + par1 + ' ' + par2);
    }

    public void publicMethod2() {
        System.out.println("public, but second :(");
    }
}