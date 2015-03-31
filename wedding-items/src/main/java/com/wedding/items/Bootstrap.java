package com.wedding.items;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Bootstrap {
	
	protected static final Log logger = LogFactory.getLog(Bootstrap.class);

	public static void main(String[] args) throws InterruptedException {
		final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ac.start();
        logger.info("item service started successfully");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
            	logger.debug("Shutdown hook was invoked. Shutting down Item Service.");
                ac.close();
            }
        });
        //prevent main thread from exit
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
	}

}
