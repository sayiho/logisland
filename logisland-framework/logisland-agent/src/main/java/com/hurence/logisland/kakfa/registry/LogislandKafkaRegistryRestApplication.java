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
package com.hurence.logisland.kakfa.registry;

import com.hurence.logisland.agent.rest.api.DefaultApi;
import com.hurence.logisland.agent.rest.api.JobsApi;
import com.hurence.logisland.agent.rest.api.TopicsApi;
import com.hurence.logisland.agent.rest.api.factories.DefaultApiServiceFactory;
import com.hurence.logisland.kakfa.registry.exceptions.RegistryException;
import com.hurence.logisland.kakfa.serialization.RegistrySerializer;
import io.confluent.kafka.schemaregistry.rest.SchemaRegistryConfig;
import io.confluent.kafka.schemaregistry.rest.resources.RootResource;
import io.confluent.rest.Application;
import io.confluent.rest.RestConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Configurable;
import java.util.Properties;

public class LogislandKafkaRegistryRestApplication extends Application<SchemaRegistryConfig> {

    private static final Logger log = LoggerFactory.getLogger(LogislandKafkaRegistryRestApplication.class);
    private KafkaRegistry kafkaRegistry = null;

    public LogislandKafkaRegistryRestApplication(Properties props) throws RestConfigException {
        this(new SchemaRegistryConfig(props));
    }

    public LogislandKafkaRegistryRestApplication(SchemaRegistryConfig config) {
        super(config);
    }

    @Override
    public void setupResources(Configurable<?> config, SchemaRegistryConfig schemaRegistryConfig) {
        try {
            kafkaRegistry = new KafkaRegistry(schemaRegistryConfig,  new RegistrySerializer());
            kafkaRegistry.init();
        } catch (RegistryException e) {
            log.error("Error starting the schema registry", e);
            System.exit(1);
        }

        config.register(new DefaultApi(kafkaRegistry));
        config.register(new JobsApi(kafkaRegistry));
        config.register(new TopicsApi(kafkaRegistry));
    }

    @Override
    public void onShutdown() {
        kafkaRegistry.close();
    }

    // for testing purpose only
    public KafkaRegistry schemaRegistry() {
        return kafkaRegistry;
    }
}