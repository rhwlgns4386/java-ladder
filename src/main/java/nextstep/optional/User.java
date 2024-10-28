package nextstep.optional;

import java.util.Optional;

public class User {
    private final static int MIN_AGE = 30;
    private final static int MAX_AGE = 45;

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange1(User user) {
        boolean isInRange = false;

        if (user != null && user.getAge() != null
                && user.isAgeInRange()) {
            isInRange = true;
        }
        return isInRange;
    }

    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .filter(d -> d.getAge() != null)
                .map(User::isAgeInRange)
                .isPresent();
    }

    private boolean isAgeInRange(){
        return this.age >= MIN_AGE && this.age <= MAX_AGE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
