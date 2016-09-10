/*
 * Copyright (c) OSGi Alliance (2008, 2010). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.osgi.service.blueprint.reflect;

/**
 * Metadata for a simple {@code String} value that will be type-converted
 * if necessary before injecting.
 * 
 * @ThreadSafe
 * @version $Id: cae08bd55676fbd8fdd4efe4b76677de3786fb7f $
 */
public interface ValueMetadata extends NonNullMetadata {
	/**
	 * Return the unconverted string representation of the value.
	 * 
	 * This is specified by the {@code value} attribute or text part of the
	 * {@code value} element.
	 * 
	 * @return The unconverted string representation of the value.
	 */
	String getStringValue();

	/**
	 * Return the name of the type to which the value should be converted.
	 * 
	 * This is specified by the {@code type} attribute.
	 * 
	 * @return The name of the type to which the value should be converted or
	 *         {@code null} if no type is specified.
	 */
	String getType();
}
