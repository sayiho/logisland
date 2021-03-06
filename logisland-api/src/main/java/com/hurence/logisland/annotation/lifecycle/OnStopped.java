/**
 * Copyright (C) 2016 Hurence (bailet.thomas@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hurence.logisland.annotation.lifecycle;

import com.hurence.logisland.processor.ProcessContext;

import java.lang.annotation.*;

/**
 * <p>
 * Marker annotation a {@link com.hurence.logisland.processor.Processor Processor} implementation
 * can use to indicate that a method should be called whenever the component is
 * no longer scheduled to run. Methods marked with this annotation will be
 * invoked each time the component is stopped and will be invoked only after the
 * last thread has returned from the <code>onTrigger</code> method.
 * </p>
 *
 * <p>
 * This means that the thread executing in this method will be the only thread
 * executing in any part of the Processor. However, since other threads may
 * later execute other parts of the code, member variables must still be
 * protected appropriately. However, access to multiple variables need not be
 * atomic.
 * </p>
 *
 * <p>
 * To indicate that a method should be called immediately when a component is no
 * longer scheduled to run (as opposed to after all threads have returned from
 * the <code>onTrigger</code> method), see the {@link OnUnscheduled} annotation.
 * </p>
 *
 * <p>
 * Methods with this annotation are permitted to take either 0 or 1 argument. If
 * an argument is used, it must be oftype {@link ProcessContext} if the
 * component is a Processor.
 * </p>
 *
 * <p><b>Implementation Guidelines:</b>
 * <ul>
 *   <li>Methods with this annotation are expected to perform very quick, short-lived tasks. If the function is
 *       expensive or long-lived, the logic should be performed in the {@code onTrigger} method instead.</li>
 *   <li>If a method with this annotation does not return (exceptionally or otherwise) within a short period
 *       of time (the duration is configurable in the properties file), the Thread may be interrupted.</li>
 *   <li>Methods that make use of this interface should honor Java's Thread interruption mechanisms and not swallow
 *       {@link InterruptedException}.</li>
 * </ul>
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OnStopped {

}
