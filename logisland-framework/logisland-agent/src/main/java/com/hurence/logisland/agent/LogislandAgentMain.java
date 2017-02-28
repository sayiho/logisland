/**
 * Copyright 2014 Confluent Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hurence.logisland.agent;

import com.hurence.logisland.kakfa.registry.LogislandKafkaRegistryRestApplication;
import io.confluent.kafka.schemaregistry.rest.SchemaRegistryConfig;
import io.confluent.rest.RestConfigException;
import org.eclipse.jetty.server.Server;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LogislandAgentMain {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LogislandAgentMain.class);

    /**
     * Starts an embedded Jetty server running the REST server.
     */
    public static void main(String[] args) throws IOException {

        try {
            if (args.length != 1) {
                log.error("Properties file is required to start the schema registry REST instance");
                System.exit(1);
            }


            SchemaRegistryConfig config = new SchemaRegistryConfig(args[0]);
            LogislandKafkaRegistryRestApplication app = new LogislandKafkaRegistryRestApplication(config);
            Server server = app.createServer();
            server.start();
            log.info("Server started, listening for requests...");
            server.join();
        } catch (RestConfigException e) {
            log.error("Server configuration failed: ", e);
            System.exit(1);
        } catch (Exception e) {
            log.error("Server died unexpectedly: ", e);
            System.exit(1);
        }
    }
}