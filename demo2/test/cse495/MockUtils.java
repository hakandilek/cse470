package cse495;

import java.lang.reflect.Field;

public class MockUtils {
	/**
	 * This method is used to set singleton static fields in the given class.
	 * 
	 * @param <T>
	 *            type of the field to set.
	 * @param aClass
	 *            the class to set static fields
	 * @param fieldName
	 *            name of the singleton field
	 * @param object
	 *            object to set
	 */
	public static <T> void setStaticField(final Class<?> aClass,
			final String fieldName, final T object) {
		try {
			final Field field = aClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(null, object);
		} catch (Exception e) {
			// should not occur
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to set private singleton fields in the given class.
	 * 
	 * @param <O>
	 *            type of the object containing the field
	 * @param <V>
	 *            type of the field
	 * @param aClass
	 *            the class to set static fields
	 * @param object
	 *            object containing the field
	 * @param fieldName
	 *            name of the singleton field
	 * @param fieldValue
	 *            new value of the field
	 */
	public static <O, V> void setPrivateField(final Class<O> aClass, O object,
			String fieldName, V fieldValue) {
		try {
			final Field field = aClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, fieldValue);
		} catch (Exception e) {
			// should not occur
			e.printStackTrace();
		}
	}
}
