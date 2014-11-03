package com.hazelcast.springHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hazelcast.core.Hazelcast;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 17.07.2014.
 */

public class Application {

	public static void main(final String[] args) throws InterruptedException {

		InitializeDB.start();

		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		final DistributedMapDemonstrator distributedMapDemonstrator = context
				.getBean(DistributedMapDemonstrator.class);
		distributedMapDemonstrator.demonstrate();
		Thread.sleep(300000);
		Hazelcast.shutdownAll();
	}

}
