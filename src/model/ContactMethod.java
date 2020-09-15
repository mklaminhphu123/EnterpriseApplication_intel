package model;

public enum ContactMethod{
    EMAIL(1),
    PHONE(2),
    FACE_TO_FACE(3),
    SOCIAL_MEDIA(4);

    private final int value;

    ContactMethod(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}

