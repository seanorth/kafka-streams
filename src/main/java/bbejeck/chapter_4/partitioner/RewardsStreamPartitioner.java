package bbejeck.chapter_4.partitioner;

import bbejeck.model.Purchase;
import org.apache.kafka.streams.processor.StreamPartitioner;


public class RewardsStreamPartitioner implements StreamPartitioner<String, Purchase> {

    public Integer partition(String key, Purchase value, int numPartitions) {
        return value.getCustomerId().hashCode() % numPartitions;
    }

    @Override
    public Integer partition(String topic, String key, Purchase value, int numPartitions) {
        return value.getCustomerId().hashCode() % numPartitions;
    }
}
