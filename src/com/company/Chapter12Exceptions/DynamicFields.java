package com.company.Chapter12Exceptions;

/**
 * Created by oleg on 16.03.16.
 */

class DynamicFieldException extends Exception{}

public class DynamicFields {
    private Object[][] fields;

    DynamicFields(final int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Object[] objects : fields) {
            buffer.append(objects[0]);
            buffer.append(". ");
            buffer.append(objects[1]);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1 ) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }
    private int makeField(String id) throws NoSuchFieldException {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        // no such empty field
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = new Object[] {null, null};
        }
        fields = tmp;
        return makeField(id);
    }
    public Object getField(final String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(final String id, final Object value) throws DynamicFieldException {
        if (value == null) {
            /*
             * he majority is no exception constructor takes an object-cause
             * In such cases, you should use the init method,
             * available to all subclasses of class */
            DynamicFieldException dynamicFieldException = new DynamicFieldException();
            dynamicFieldException.initCause(new NullPointerException());
            throw  dynamicFieldException;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            try {
                fieldNumber = makeField(id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace(System.out);
            }
        }
        Object result = null;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            throw  new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "value d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "new value d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\")" + df.getField("d"));
            Object field = df.setField("d", null); //exception
        } catch (DynamicFieldException e) {
            e.printStackTrace(System.out);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        }

    }
}
