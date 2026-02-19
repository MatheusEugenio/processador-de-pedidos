package core.domain.model.user;

public class Age {

    private int age;

    public Age(int age) {
        this.age = age;
        validate(age);
    }

    private void validate(int age){
        if (age <= 0 || age >= 121){
            throw new IllegalArgumentException("Erro: a idade é inválida!");
        }
    }

    public int getAge() {
        return age;
    }

}
