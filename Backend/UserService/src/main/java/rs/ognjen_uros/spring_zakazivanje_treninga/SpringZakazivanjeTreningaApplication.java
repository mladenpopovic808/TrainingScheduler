package rs.ognjen_uros.spring_zakazivanje_treninga;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringZakazivanjeTreningaApplication {

    public static void main(String[] args)  throws Exception{
        BrokerService broker = new BrokerService();
        // configure the broker
        broker.addConnector("tcp://localhost:61616");
        broker.start();
        SpringApplication.run(SpringZakazivanjeTreningaApplication.class, args);
    }

}
