package home;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
    public String firstName;
    public String lastName;
    public int age;

    public Person(){}

    public Person(String firstName, String ln) {
        this.firstName = firstName;
        lastName = ln;
    }

    public Person(String firstName, String ln, int age) {
        this.firstName = firstName;
        lastName = ln;
        this.age = age;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }
    // Генерация метода toString с использованием commons-lang3
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    // Генерация метода equals с использованием commons-lang3
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    // Генерация метода hashCode с использованием commons-lang3
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}

