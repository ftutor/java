package com.operasolutions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Any field annotated as {@code @Published} is subject of CSV export in
 * {@link Responder}.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Published {

	/**
	 * Alternative name, can be used to override field name.
	 * 
	 * @return field alternative name for CSV export.
	 */
	String value() default "";

	/**
	 * The order indicates the ordering of the field in CSV file.
	 * 
	 * @return the ordering of the field in CSV file.
	 */
	int order() default 0;

	/**
	 * Optional formatting of the field before writing to CSV file.
	 * 
	 * @return format indication.
	 */
	CsvFieldFormat format() default CsvFieldFormat.RAW;

}
