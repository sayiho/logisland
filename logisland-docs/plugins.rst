Extension plugins
=================
You'll find here the list of all usable Processors, Engines and other components taht can be usable out of the box in your analytics streams

.. _com.hurence.logisland.processor.ConvertFieldsType: 

ConvertFieldsType
-----------------
Converts a field value into the given type. does nothing if converison is not possible

Class
_____
com.hurence.logisland.processor.ConvertFieldsType

Tags
____
type, fields, update, convert

Properties
__________
This component has no required or optional properties.

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "field", "the new type", "convert field value into new type", **true**

----------

.. _com.hurence.logisland.processor.DebugStream: 

DebugStream
-----------
This is a processor that logs incoming records

Class
_____
com.hurence.logisland.processor.DebugStream

Tags
____
record, debug

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**event.serializer**", "the way to serialize event", "Json serialization : serialize events as json blocs, String serialization : serialize events as toString() blocs, ", "json", "", ""

----------

.. _com.hurence.logisland.processor.DetectOutliers: 

DetectOutliers
--------------
Outlier Analysis: A Hybrid Approach
In order to function at scale, a two-phase approach is taken

For every data point

- Detect outlier candidates using a robust estimator of variability (e.g. median absolute deviation) that uses distributional sketching (e.g. Q-trees)
- Gather a biased sample (biased by recency)
- Extremely deterministic in space and cheap in computation

For every outlier candidate

- Use traditional, more computationally complex approaches to outlier analysis (e.g. Robust PCA) on the biased sample
- Expensive computationally, but run infrequently

This becomes a data filter which can be attached to a timeseries data stream within a distributed computational framework (i.e. Storm, Spark, Flink, NiFi) to detect outliers.

Class
_____
com.hurence.logisland.processor.DetectOutliers

Tags
____
analytic, outlier, record, iot, timeseries

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**value.field**", "the numeric field to get the value", "", "record_value", "", ""
   "**time.field**", "the numeric field to get the value", "", "record_time", "", ""
   "output.record.type", "the output type of the record", "", "alert_match", "", ""
   "**rotation.policy.type**", "...", "by_amount : , by_time : , never : , ", "by_amount", "", ""
   "**rotation.policy.amount**", "...", "", "100", "", ""
   "**rotation.policy.unit**", "...", "milliseconds : , seconds : , hours : , days : , months : , years : , points : , ", "points", "", ""
   "**chunking.policy.type**", "...", "by_amount : , by_time : , never : , ", "by_amount", "", ""
   "**chunking.policy.amount**", "...", "", "100", "", ""
   "**chunking.policy.unit**", "...", "milliseconds : , seconds : , hours : , days : , months : , years : , points : , ", "points", "", ""
   "sketchy.outlier.algorithm", "...", "SKETCHY_MOVING_MAD : , ", "SKETCHY_MOVING_MAD", "", ""
   "batch.outlier.algorithm", "...", "RAD : , ", "RAD", "", ""
   "global.statistics.min", "minimum value", "", "null", "", ""
   "global.statistics.max", "maximum value", "", "null", "", ""
   "global.statistics.mean", "mean value", "", "null", "", ""
   "global.statistics.stddev", "standard deviation value", "", "null", "", ""
   "**zscore.cutoffs.normal**", "zscoreCutoffs levele for normal outlier", "", "0.000000000000001", "", ""
   "**zscore.cutoffs.moderate**", "zscoreCutoffs levele for moderate outlier", "", "1.5", "", ""
   "**zscore.cutoffs.severe**", "zscoreCutoffs levele for severe outlier", "", "10.0", "", ""
   "zscore.cutoffs.notEnoughData", "zscoreCutoffs levele for notEnoughData outlier", "", "100", "", ""
   "smooth", "do smoothing ?", "", "false", "", ""
   "decay", "the decay", "", "0.1", "", ""
   "**min.amount.to.predict**", "minAmountToPredict", "", "100", "", ""
   "min_zscore_percentile", "minZscorePercentile", "", "50.0", "", ""
   "reservoir_size", "the size of points reservoir", "", "100", "", ""
   "rpca.force.diff", "No Description Provided.", "", "null", "", ""
   "rpca.lpenalty", "No Description Provided.", "", "null", "", ""
   "rpca.min.records", "No Description Provided.", "", "null", "", ""
   "rpca.spenalty", "No Description Provided.", "", "null", "", ""
   "rpca.threshold", "No Description Provided.", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.EvaluateJsonPath: 

EvaluateJsonPath
----------------
Evaluates one or more JsonPath expressions against the content of a FlowFile. The results of those expressions are assigned to Records Fieldsdepending on configuration of the Processor. JsonPaths are entered by adding user-defined properties; the name of the property maps to the Field Name into which the result will be placed. The value of the property must be a valid JsonPath expression. A Return Type of 'auto-detect' will make a determination based off the configured destination. If the JsonPath evaluates to a JSON array or JSON object and the Return Type is set to 'scalar' the Record will be routed to error. A Return Type of JSON can return scalar values if the provided JsonPath evaluates to the specified value. If the expression matches nothing, Fields will be created with empty strings as the value 

Class
_____
com.hurence.logisland.processor.EvaluateJsonPath

Tags
____
JSON, evaluate, JsonPath

Properties
__________
This component has no required or optional properties.

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "A Record field", "A JsonPath expression", "will be set to any JSON objects that match the JsonPath. ", ****

----------

.. _com.hurence.logisland.processor.GenerateRandomRecord: 

GenerateRandomRecord
--------------------
This is a processor that make random records given an Avro schema

Class
_____
com.hurence.logisland.processor.GenerateRandomRecord

Tags
____
record, avro, generator

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**avro.output.schema**", "the avro schema definition for the output serialization", "", "null", "", ""
   "**min.events.count**", "the minimum number of generated events each run", "", "10", "", ""
   "**max.events.count**", "the maximum number of generated events each run", "", "200", "", ""

----------

.. _com.hurence.logisland.stream.spark.KafkaRecordStreamDebugger: 

KafkaRecordStreamDebugger
-------------------------
No description provided.

Class
_____
com.hurence.logisland.stream.spark.KafkaRecordStreamDebugger

Tags
____
None.

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**kafka.error.topics**", "Sets the error topics Kafka topic name", "", "logisland_errors", "", ""
   "**kafka.input.topics**", "Sets the input Kafka topic name", "", "logisland_raw", "", ""
   "**kafka.output.topics**", "Sets the output Kafka topic name", "", "logisland_events", "", ""
   "kafka.metrics.topic", "a topic to send metrics of processing. no output if not set", "", "logisland_metrics", "", ""
   "avro.input.schema", "the avro schema definition", "", "null", "", ""
   "avro.output.schema", "the avro schema definition for the output serialization", "", "null", "", ""
   "kafka.input.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.output.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.error.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.JsonSerializer", "", ""
   "kafka.topic.autoCreate", "define wether a topic should be created automatically if not already exists", "", "true", "", ""
   "kafka.topic.default.partitions", "if autoCreate is set to true, this will set the number of partition at topic creation time", "", "20", "", ""
   "kafka.topic.default.replicationFactor", "if autoCreate is set to true, this will set the number of replica for each partition at topic creation time", "", "3", "", ""
   "**kafka.metadata.broker.list**", "a comma separated list of host:port brokers", "", "sandbox:9092", "", ""
   "**kafka.zookeeper.quorum**", "No Description Provided.", "", "sandbox:2181", "", ""
   "kafka.manual.offset.reset", "Sets manually an initial offset in ZooKeeper: smallest (automatically reset the offset to the smallest offset), largest (automatically reset the offset to the largest offset), anything else (throw exception to the consumer)", "largest offset : the offset to the largest offset, smallest offset : the offset to the smallest offset, ", "null", "", ""

----------

.. _com.hurence.logisland.stream.spark.KafkaRecordStreamHDFSBurner: 

KafkaRecordStreamHDFSBurner
---------------------------
No description provided.

Class
_____
com.hurence.logisland.stream.spark.KafkaRecordStreamHDFSBurner

Tags
____
None.

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**kafka.error.topics**", "Sets the error topics Kafka topic name", "", "logisland_errors", "", ""
   "**kafka.input.topics**", "Sets the input Kafka topic name", "", "logisland_raw", "", ""
   "**kafka.output.topics**", "Sets the output Kafka topic name", "", "logisland_events", "", ""
   "kafka.metrics.topic", "a topic to send metrics of processing. no output if not set", "", "logisland_metrics", "", ""
   "avro.input.schema", "the avro schema definition", "", "null", "", ""
   "avro.output.schema", "the avro schema definition for the output serialization", "", "null", "", ""
   "kafka.input.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.output.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.error.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.JsonSerializer", "", ""
   "kafka.topic.autoCreate", "define wether a topic should be created automatically if not already exists", "", "true", "", ""
   "kafka.topic.default.partitions", "if autoCreate is set to true, this will set the number of partition at topic creation time", "", "20", "", ""
   "kafka.topic.default.replicationFactor", "if autoCreate is set to true, this will set the number of replica for each partition at topic creation time", "", "3", "", ""
   "**kafka.metadata.broker.list**", "a comma separated list of host:port brokers", "", "sandbox:9092", "", ""
   "**kafka.zookeeper.quorum**", "No Description Provided.", "", "sandbox:2181", "", ""
   "kafka.manual.offset.reset", "Sets manually an initial offset in ZooKeeper: smallest (automatically reset the offset to the smallest offset), largest (automatically reset the offset to the largest offset), anything else (throw exception to the consumer)", "largest offset : the offset to the largest offset, smallest offset : the offset to the smallest offset, ", "null", "", ""
   "**output.folder.path**", "the location where to put files : file:///tmp/out", "", "null", "", ""
   "**output.format**", "can be parquet, orc csv", "parquet : , txt : , json : , json : , ", "null", "", ""
   "**record.type**", "the type of event to filter", "", "null", "", ""
   "num.partitions", "the numbers of physical files on HDFS", "", "4", "", ""
   "exclude.errors", "do we include records with errors ?", "", "true", "", ""

----------

.. _com.hurence.logisland.stream.spark.KafkaRecordStreamParallelProcessing: 

KafkaRecordStreamParallelProcessing
-----------------------------------
No description provided.

Class
_____
com.hurence.logisland.stream.spark.KafkaRecordStreamParallelProcessing

Tags
____
None.

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**kafka.error.topics**", "Sets the error topics Kafka topic name", "", "logisland_errors", "", ""
   "**kafka.input.topics**", "Sets the input Kafka topic name", "", "logisland_raw", "", ""
   "**kafka.output.topics**", "Sets the output Kafka topic name", "", "logisland_events", "", ""
   "kafka.metrics.topic", "a topic to send metrics of processing. no output if not set", "", "logisland_metrics", "", ""
   "avro.input.schema", "the avro schema definition", "", "null", "", ""
   "avro.output.schema", "the avro schema definition for the output serialization", "", "null", "", ""
   "kafka.input.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.output.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.error.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.JsonSerializer", "", ""
   "kafka.topic.autoCreate", "define wether a topic should be created automatically if not already exists", "", "true", "", ""
   "kafka.topic.default.partitions", "if autoCreate is set to true, this will set the number of partition at topic creation time", "", "20", "", ""
   "kafka.topic.default.replicationFactor", "if autoCreate is set to true, this will set the number of replica for each partition at topic creation time", "", "3", "", ""
   "**kafka.metadata.broker.list**", "a comma separated list of host:port brokers", "", "sandbox:9092", "", ""
   "**kafka.zookeeper.quorum**", "No Description Provided.", "", "sandbox:2181", "", ""
   "kafka.manual.offset.reset", "Sets manually an initial offset in ZooKeeper: smallest (automatically reset the offset to the smallest offset), largest (automatically reset the offset to the largest offset), anything else (throw exception to the consumer)", "largest offset : the offset to the largest offset, smallest offset : the offset to the smallest offset, ", "null", "", ""
   "max.results.count", "the max number of rows to output. (-1 for no limit)", "", "-1", "", ""
   "**sql.query**", "The SQL query to execute, please note that the table name must exists in input topics names", "", "null", "", ""

----------

.. _com.hurence.logisland.stream.spark.KafkaRecordStreamSQLAggregator: 

KafkaRecordStreamSQLAggregator
------------------------------
This is a stream capable of SQL query interpretations

Class
_____
com.hurence.logisland.stream.spark.KafkaRecordStreamSQLAggregator

Tags
____
stream, SQL, query, record

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**kafka.error.topics**", "Sets the error topics Kafka topic name", "", "logisland_errors", "", ""
   "**kafka.input.topics**", "Sets the input Kafka topic name", "", "logisland_raw", "", ""
   "**kafka.output.topics**", "Sets the output Kafka topic name", "", "logisland_events", "", ""
   "kafka.metrics.topic", "a topic to send metrics of processing. no output if not set", "", "logisland_metrics", "", ""
   "avro.input.schema", "the avro schema definition", "", "null", "", ""
   "avro.output.schema", "the avro schema definition for the output serialization", "", "null", "", ""
   "kafka.input.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.output.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.KryoSerializer", "", ""
   "kafka.error.topics.serializer", "No Description Provided.", "kryo serialization : serialize events as json blocs, avro serialization : serialize events as json blocs, avro serialization : serialize events as avro blocs, no serialization : send events as bytes, ", "com.hurence.logisland.serializer.JsonSerializer", "", ""
   "kafka.topic.autoCreate", "define wether a topic should be created automatically if not already exists", "", "true", "", ""
   "kafka.topic.default.partitions", "if autoCreate is set to true, this will set the number of partition at topic creation time", "", "20", "", ""
   "kafka.topic.default.replicationFactor", "if autoCreate is set to true, this will set the number of replica for each partition at topic creation time", "", "3", "", ""
   "**kafka.metadata.broker.list**", "a comma separated list of host:port brokers", "", "sandbox:9092", "", ""
   "**kafka.zookeeper.quorum**", "No Description Provided.", "", "sandbox:2181", "", ""
   "kafka.manual.offset.reset", "Sets manually an initial offset in ZooKeeper: smallest (automatically reset the offset to the smallest offset), largest (automatically reset the offset to the largest offset), anything else (throw exception to the consumer)", "largest offset : the offset to the largest offset, smallest offset : the offset to the smallest offset, ", "null", "", ""
   "max.results.count", "the max number of rows to output. (-1 for no limit)", "", "-1", "", ""
   "**sql.query**", "The SQL query to execute, please note that the table name must exists in input topics names", "", "null", "", ""
   "output.record.type", "the output type of the record", "", "aggregation", "", ""

----------

.. _com.hurence.logisland.engine.spark.KafkaStreamProcessingEngine: 

KafkaStreamProcessingEngine
---------------------------
No description provided.

Class
_____
com.hurence.logisland.engine.spark.KafkaStreamProcessingEngine

Tags
____
None.

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**spark.app.name**", "Tha application name", "", "logisland", "", ""
   "**spark.master**", "The url to Spark Master", "", "local[2]", "", ""
   "spark.yarn.deploy-mode", "The yarn deploy mode", "", "null", "", ""
   "spark.yarn.queue", "The name of the YARN queue", "", "default", "", ""
   "spark.driver.memory", "The memory size for Spark driver", "", "512m", "", ""
   "spark.executor.memory", "The memory size for Spark executors", "", "1g", "", ""
   "spark.driver.cores", "The number of cores for Spark driver", "", "4", "", ""
   "spark.executor.cores", "The number of cores for Spark driver", "", "1", "", ""
   "spark.executor.instances", "The number of instances for Spark app", "", "null", "", ""
   "spark.serializer", "Class to use for serializing objects that will be sent over the network or need to be cached in serialized form", "", "org.apache.spark.serializer.KryoSerializer", "", ""
   "spark.streaming.blockInterval", "Interval at which data received by Spark Streaming receivers is chunked into blocks of data before storing them in Spark. Minimum recommended - 50 ms", "", "350", "", ""
   "spark.streaming.kafka.maxRatePerPartition", "Maximum rate (number of records per second) at which data will be read from each Kafka partition", "", "5000", "", ""
   "**spark.streaming.batchDuration**", "No Description Provided.", "", "2000", "", ""
   "spark.streaming.backpressure.enabled", "This enables the Spark Streaming to control the receiving rate based on the current batch scheduling delays and processing times so that the system receives only as fast as the system can process.", "", "false", "", ""
   "spark.streaming.unpersist", "Force RDDs generated and persisted by Spark Streaming to be automatically unpersisted from Spark's memory. The raw input data received by Spark Streaming is also automatically cleared. Setting this to false will allow the raw data and persisted RDDs to be accessible outside the streaming application as they will not be cleared automatically. But it comes at the cost of higher memory usage in Spark.", "", "false", "", ""
   "spark.ui.port", "No Description Provided.", "", "4050", "", ""
   "spark.streaming.timeout", "No Description Provided.", "", "-1", "", ""
   "spark.streaming.kafka.maxRetries", "Maximum rate (number of records per second) at which data will be read from each Kafka partition", "", "3", "", ""
   "spark.streaming.ui.retainedBatches", "How many batches the Spark Streaming UI and status APIs remember before garbage collecting.", "", "200", "", ""
   "spark.streaming.receiver.writeAheadLog.enable", "Enable write ahead logs for receivers. All the input data received through receivers will be saved to write ahead logs that will allow it to be recovered after driver failures.", "", "false", "", ""
   "spark.yarn.maxAppAttempts", "Because Spark driver and Application Master share a single JVM, any error in Spark driver stops our long-running job. Fortunately it is possible to configure maximum number of attempts that will be made to re-run the application. It is reasonable to set higher value than default 2 (derived from YARN cluster property yarn.resourcemanager.am.max-attempts). 4 works quite well, higher value may cause unnecessary restarts even if the reason of the failure is permanent.", "", "4", "", ""
   "spark.yarn.am.attemptFailuresValidityInterval", "If the application runs for days or weeks without restart or redeployment on highly utilized cluster, 4 attempts could be exhausted in few hours. To avoid this situation, the attempt counter should be reset on every hour of so.", "", "1h", "", ""
   "spark.yarn.max.executor.failures", "a maximum number of executor failures before the application fails. By default it is max(2 * num executors, 3), well suited for batch jobs but not for long-running jobs. The property comes with corresponding validity interval which also should be set.8 * num_executors", "", "20", "", ""
   "spark.yarn.executor.failuresValidityInterval", "If the application runs for days or weeks without restart or redeployment on highly utilized cluster, x attempts could be exhausted in few hours. To avoid this situation, the attempt counter should be reset on every hour of so.", "", "1h", "", ""
   "spark.task.maxFailures", "For long-running jobs you could also consider to boost maximum number of task failures before giving up the job. By default tasks will be retried 4 times and then job fails.", "", "8", "", ""

----------

.. _com.hurence.logisland.processor.MatchQuery: 

MatchQuery
----------
Query matching based on `Luwak <http://www.confluent.io/blog/real-time-full-text-search-with-luwak-and-samza/>`_

you can use this processor to handle custom events defined by lucene queries
a new record is added to output each time a registered query is matched

A query is expressed as a lucene query against a field like for example: 

.. code-block::

	message:'bad exception'
	error_count:[10 TO *]
	bytes_out:5000
	user_name:tom*

Please read the `Lucene syntax guide <https://lucene.apache.org/core/5_5_0/queryparser/org/apache/lucene/queryparser/classic/package-summary.html#package_description>`_ for supported operations

.. warning::

	don't forget to set numeric fields property to handle correctly numeric ranges queries

Class
_____
com.hurence.logisland.processor.MatchQuery

Tags
____
analytic, percolator, record, record, query, lucene

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "numeric.fields", "a comma separated string of numeric field to be matched", "", "null", "", ""
   "output.record.type", "the output type of the record", "", "alert_match", "", ""
   "include.input.records", "if set to true all the input records are copied to output", "", "true", "", ""

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "query", "some Lucene query", "generate a new record when this query is matched", **true**

----------

.. _com.hurence.logisland.processor.ModifyId: 

ModifyId
--------
modify id of records or generate it following defined rules

Class
_____
com.hurence.logisland.processor.ModifyId

Tags
____
record, id, idempotent, generate, modify

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**id.generation.strategy**", "the strategy to generate new Id", "generate a random uid : generate a randomUid using java library, generate a hash from fields : generate a hash from fields, generate a string from java pattern and fields : generate a string from java pattern and fields, generate a concatenation of type, time and a hash from fields : generate a concatenation of type, time and a hash from fields (as for generate_hash strategy), ", "randomUuid", "", ""
   "**fields.to.hash**", "the comma separated list of field names (e.g. "policyid,date_raw"", "", "record_raw_value", "", ""
   "**hash.charset**", "the charset to use to hash id string (e.g. "UTF-8"", "", "UTF-8", "", ""
   "**hash.algorithm**", "the algorithme to use to hash id string (e.g. "SHA-256"", "SHA-384 : , SHA-224 : , SHA-256 : , MD2 : , SHA : , SHA-512 : , MD5 : , ", "SHA-256", "", ""
   "java.formatter.string", "the format to use to build id string (e.g. "%4$2s %3$2s %2$2s %1$2s" (see java Formatter)", "", "null", "", ""
   "**language.tag**", "the language to use to format numbers in string", "aa : , ab : , ae : , af : , ak : , am : , an : , ar : , as : , av : , ay : , az : , ba : , be : , bg : , bh : , bi : , bm : , bn : , bo : , br : , bs : , ca : , ce : , ch : , co : , cr : , cs : , cu : , cv : , cy : , da : , de : , dv : , dz : , ee : , el : , en : , eo : , es : , et : , eu : , fa : , ff : , fi : , fj : , fo : , fr : , fy : , ga : , gd : , gl : , gn : , gu : , gv : , ha : , he : , hi : , ho : , hr : , ht : , hu : , hy : , hz : , ia : , id : , ie : , ig : , ii : , ik : , in : , io : , is : , it : , iu : , iw : , ja : , ji : , jv : , ka : , kg : , ki : , kj : , kk : , kl : , km : , kn : , ko : , kr : , ks : , ku : , kv : , kw : , ky : , la : , lb : , lg : , li : , ln : , lo : , lt : , lu : , lv : , mg : , mh : , mi : , mk : , ml : , mn : , mo : , mr : , ms : , mt : , my : , na : , nb : , nd : , ne : , ng : , nl : , nn : , no : , nr : , nv : , ny : , oc : , oj : , om : , or : , os : , pa : , pi : , pl : , ps : , pt : , qu : , rm : , rn : , ro : , ru : , rw : , sa : , sc : , sd : , se : , sg : , si : , sk : , sl : , sm : , sn : , so : , sq : , sr : , ss : , st : , su : , sv : , sw : , ta : , te : , tg : , th : , ti : , tk : , tl : , tn : , to : , tr : , ts : , tt : , tw : , ty : , ug : , uk : , ur : , uz : , ve : , vi : , vo : , wa : , wo : , xh : , yi : , yo : , za : , zh : , zu : , ", "en", "", ""

----------

.. _com.hurence.logisland.processor.NormalizeFields: 

NormalizeFields
---------------
Changes the name of a field according to a provided name mapping
...

Class
_____
com.hurence.logisland.processor.NormalizeFields

Tags
____
record, fields, normalizer

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**conflict.resolution.policy**", "waht to do when a field with the same name already exists ?", "nothing to do : leave record as it was, overwrite existing field : if field already exist, keep only old field and delete the other : keep only old field and delete the other, keep old field and new one : creates an alias for the new field, ", "do_nothing", "", ""

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "alternative mapping", "a comma separated list of possible field name", "when a field has a name contained in the list it will be renamed with this property field name", **true**

----------

.. _com.hurence.logisland.processor.ParseProperties: 

ParseProperties
---------------
Parse a field made of key=value fields separated by spaces
a string like "a=1 b=2 c=3" will add a,b & c fields, respectively with values 1,2 & 3 to the current Record

Class
_____
com.hurence.logisland.processor.ParseProperties

Tags
____
record, properties, parser

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**properties.field**", "the field containing the properties to split and treat", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.elasticsearch.PutElasticsearch: 

PutElasticsearch
----------------
This is a processor that puts records to ES

Class
_____
com.hurence.logisland.processor.elasticsearch.PutElasticsearch

Tags
____
record, elasticsearch, sink, record

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
, whether a property supports the  `Expression Language <expression-language.html>`_ , and whether a property is considered "sensitive", meaning that its value will be encrypted. Before entering a value in a sensitive property, ensure that the **logisland.properties** file has an entry for the property **logisland.sensitive.props.key**.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**cluster.name**", "Name of the ES cluster (for example, elasticsearch_brew). Defaults to 'elasticsearch'", "", "elasticsearch", "", ""
   "**hosts**", "ElasticSearch Hosts, which should be comma separated and colon for hostname/port host1:port,host2:port,....  For example testcluster:9300.", "", "null", "", ""
   "ssl.context.service", "The SSL Context Service used to provide client certificate information for TLS/SSL connections. This service only applies if the Shield plugin is available.", "", "null", "", ""
   "shield.location", "Specifies the path to the JAR for the Elasticsearch Shield plugin. If the Elasticsearch cluster has been secured with the Shield plugin, then the Shield plugin JAR must also be available to this processor. Note: Do NOT place the Shield JAR into NiFi's lib/ directory, doing so will prevent the Shield plugin from being loaded.", "", "null", "", ""
   "username", "Username to access the Elasticsearch cluster", "", "null", "", ""
   "password", "Password to access the Elasticsearch cluster", "", "null", "**true**", ""
   "**ping.timeout**", "The ping timeout used to determine when a node is unreachable. For example, 5s (5 seconds). If non-local recommended is 30s", "", "5s", "", ""
   "**sampler.interval**", "How often to sample / ping the nodes listed and connected. For example, 5s (5 seconds). If non-local recommended is 30s.", "", "5s", "", ""
   "**default.index**", "The name of the index to insert into", "", "null", "", "**true**"
   "**default.type**", "The type of this document (used by Elasticsearch for indexing and searching)", "", "null", "", "**true**"
   "**charset**", "Specifies the character set of the document data.", "", "UTF-8", "", ""
   "batch.size", "The preferred number of Records to setField to the database in a single transaction", "", "1000", "", ""
   "bulk.size", "bulk size in MB", "", "5", "", ""
   "concurrent.requests", "setConcurrentRequests", "", "2", "", ""
   "**num.retry**", "number of time we should try to inject a bulk into es", "", "3", "", ""
   "**throttling.delay**", "number of time we should wait between each retry (in milliseconds)", "", "500", "", ""
   "**backoff.policy**", "strategy for retrying to execute requests in bulkRequest", "No retry policy : when a request fail there won't be any retry., wait a fixed amount of time between retries : wait a fixed amount of time between retries, using user put retry number and throttling delay, custom exponential policy : time waited between retries grow exponentially, using user put retry number and throttling delay, es default exponential policy : time waited between retries grow exponentially, using es default parameters, ", "defaultExponentialBackoff", "", ""
   "flush.interval", "flush interval in sec", "", "5", "", ""
   "**timebased.index**", "do we add a date suffix", "No date : no date added to default index, Today's date : today's date added to default index, yesterday's date : yesterday's date added to default index, ", "no", "", ""
   "es.index.field", "the name of the event field containing es index type => will override index value if set", "", "null", "", ""
   "es.type.field", "the name of the event field containing es doc type => will override type value if set", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.RemoveFields: 

RemoveFields
------------
Removes a list of fields defined by a comma separated list of field names

Class
_____
com.hurence.logisland.processor.RemoveFields

Tags
____
record, fields, remove, delete

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**fields.to.remove**", "the comma separated list of field names (e.g. "policyid,date_raw"", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.SampleRecords: 

SampleRecords
-------------
Query matching based on `Luwak <http://www.confluent.io/blog/real-time-full-text-search-with-luwak-and-samza/>`_

you can use this processor to handle custom events defined by lucene queries
a new record is added to output each time a registered query is matched

A query is expressed as a lucene query against a field like for example: 

.. code-block::
   message:'bad exception'
   error_count:[10 TO *]
   bytes_out:5000
   user_name:tom*

Please read the `Lucene syntax guide <https://lucene.apache.org/core/5_5_0/queryparser/org/apache/lucene/queryparser/classic/package-summary.html#package_description>`_ for supported operations

.. warning::
   don't forget to set numeric fields property to handle correctly numeric ranges queries

Class
_____
com.hurence.logisland.processor.SampleRecords

Tags
____
analytic, sampler, record, iot, timeseries

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "record.value.field", "the name of the numeric field to sample", "", "record_value", "", ""
   "record.time.field", "the name of the time field to sample", "", "record_time", "", ""
   "**sampling.algorithm**", "the implementation of the algorithm", "none : , lttb : , average : , first_item : , min_max : , mode_median : , ", "null", "", ""
   "**sampling.parameter**", "the parmater of the algorithm", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.SplitText: 

SplitText
---------
This is a processor that is used to split a String into fields according to a given Record mapping

Class
_____
com.hurence.logisland.processor.SplitText

Tags
____
parser, regex, log, record

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**value.regex**", "the regex to match for the message value", "", "null", "", ""
   "**value.fields**", "a comma separated list of fields corresponding to matching groups for the message value", "", "null", "", ""
   "key.regex", "the regex to match for the message key", "", ".*", "", ""
   "key.fields", "a comma separated list of fields corresponding to matching groups for the message key", "", "record_raw_key", "", ""
   "record.type", "default type of record", "", "record", "", ""
   "keep.raw.content", "do we add the initial raw content ?", "", "true", "", ""
   "timezone.record.time", "what is the time zone of the string formatted date for 'record_time' field.", "", "UTC", "", ""

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "alternative regex & mapping", "another regex that could match", "this regex will be tried if the main one has'nt matched must be in the form alt.value.regex.1 and alt.value.fields.1", **true**

See Also:
_________
`com.hurence.logisland.processor.SplitTextMultiline`_ 

----------

.. _com.hurence.logisland.processor.SplitTextMultiline: 

SplitTextMultiline
------------------
No description provided.

Class
_____
com.hurence.logisland.processor.SplitTextMultiline

Tags
____
None.

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**regex**", "the regex to match", "", "null", "", ""
   "**fields**", "a comma separated list of fields corresponding to matching groups", "", "null", "", ""
   "**event.type**", "the type of event", "", "null", "", ""

----------

.. _com.hurence.logisland.processor.SplitTextWithProperties: 

SplitTextWithProperties
-----------------------
This is a processor that is used to split a String into fields according to a given Record mapping

Class
_____
com.hurence.logisland.processor.SplitTextWithProperties

Tags
____
parser, regex, log, record

Properties
__________
In the list below, the names of required properties appear in **bold**. Any other properties (not in bold) are considered optional. The table also indicates any default values
.

.. csv-table:: allowable-values
   :header: "Name","Description","Allowable Values","Default Value","Sensitive","EL"
   :widths: 20,60,30,20,10,10

   "**value.regex**", "the regex to match for the message value", "", "null", "", ""
   "**value.fields**", "a comma separated list of fields corresponding to matching groups for the message value", "", "null", "", ""
   "key.regex", "the regex to match for the message key", "", ".*", "", ""
   "key.fields", "a comma separated list of fields corresponding to matching groups for the message key", "", "record_raw_key", "", ""
   "record.type", "default type of record", "", "record", "", ""
   "keep.raw.content", "do we add the initial raw content ?", "", "true", "", ""
   "**properties.field**", "the field containing the properties to split and treat", "", "properties", "", ""

Dynamic Properties
__________________
Dynamic Properties allow the user to specify both the name and value of a property.

.. csv-table:: dynamic-properties
   :header: "Name","Value","Description","EL"
   :widths: 20,20,40,10

   "alternative regex & mapping", "another regex that could match", "this regex will be tried if the main one has'nt matched must be in the form alt.value.regex.1 and alt.value.fields.1", **true**

See Also:
_________
`com.hurence.logisland.processor.SplitTextMultiline`_ 

----------

