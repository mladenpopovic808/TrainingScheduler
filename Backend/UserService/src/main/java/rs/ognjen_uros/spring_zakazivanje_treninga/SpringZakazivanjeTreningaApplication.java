package rs.ognjen_uros.spring_zakazivanje_treninga;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringZakazivanjeTreningaApplication {

    public static void main(String[] args) {

        //U dockeru, se prvo podigne user-service pa baza,i user-service ne prepoznaje bazu i pukne,ali
        //docker ne prepozna da je servis pukao, kako bi mu uradio restart:on-failure,
        //i zato ovde radim System.exit(1) tako ga prepoznaje...

        try{
            BrokerService broker = new BrokerService();
            // configure the broker
            broker.addConnector("tcp://user-service:61616");
            broker.start();
        SpringApplication.run(SpringZakazivanjeTreningaApplication.class, args);

        }catch (Exception e){
            System.exit(1);

        }
    }

}
