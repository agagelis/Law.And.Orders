/*
 * Copyright (c) OSGi Alliance (2002, 2010). All Rights Reserved.
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
package org.osgi.service.upnp;

import java.util.Dictionary;

/**
 * UPnP Events are mapped and delivered to applications according to the OSGi
 * whiteboard model. An application that wishes to be notified of events
 * generated by a particular UPnP Device registers a service extending this
 * interface.
 * <p>
 * The notification call from the UPnP Service to any
 * {@code UPnPEventListener} object must be done asynchronous with respect
 * to the originator (in a separate thread).
 * <p>
 * Upon registration of the UPnP Event Listener service with the Framework, the
 * service is notified for each variable which it listens for with an initial
 * event containing the current value of the variable. Subsequent notifications
 * only happen on changes of the value of the variable.
 * <p>
 * A UPnP Event Listener service filter the events it receives. This event set
 * is limited using a standard framework filter expression which is specified
 * when the listener service is registered.
 * <p>
 * The filter is specified in a property named "upnp.filter" and has as a value
 * an object of type {@code org.osgi.framework.Filter}.
 * <p>
 * When the Filter is evaluated, the folowing keywords are recognized as defined
 * as literal constants in the {@code UPnPDevice} class.
 * <p>
 * The valid subset of properties for the registration of UPnP Event Listener
 * services are:
 * <ul>
 * <li>{@code UPnPDevice.TYPE}-- Which type of device to listen for events.
 * </li>
 * <li>{@code UPnPDevice.ID}-- The ID of a specific device to listen for
 * events.</li>
 * <li>{@code UPnPService.TYPE}-- The type of a specific service to listen
 * for events.</li>
 * <li>{@code UPnPService.ID}-- The ID of a specific service to listen for
 * events.</li>
 * </ul>
 * 
 * @version $Id: 9b3521a5da0f062c4bcbd6ffb4039c140c093ea5 $
 */
public interface UPnPEventListener {
	/**
	 * Key for a service property having a value that is an object of type
	 * {@code org.osgi.framework.Filter} and that is used to limit received
	 * events.
	 */
	static final String	UPNP_FILTER	= "upnp.filter";

	/**
	 * Callback method that is invoked for received events.
	 * 
	 * The events are collected in a {@code Dictionary} object. Each entry
	 * has a {@code String} key representing the event name (= state variable
	 * name) and the new value of the state variable. The class of the value
	 * object must match the class specified by the UPnP State Variable
	 * associated with the event. This method must be called asynchronously
	 * 
	 * @param deviceId ID of the device sending the events
	 * @param serviceId ID of the service sending the events
	 * @param events {@code Dictionary} object containing the new values for
	 *        the state variables that have changed.
	 * 
	 *  
	 */
	void notifyUPnPEvent(String deviceId, String serviceId, Dictionary events);
}
