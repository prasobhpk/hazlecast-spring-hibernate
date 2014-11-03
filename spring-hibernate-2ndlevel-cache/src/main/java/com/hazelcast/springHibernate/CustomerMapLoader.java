package com.hazelcast.springHibernate;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.hazelcast.core.MapLoader;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 17.07.2014.
 */

public class CustomerMapLoader implements MapLoader<String, Customer> {

	public Customer load(final String id) {
		final Customer customer = getCustomerDAO().getCustomerById(id);
		System.out.println("load method is being processed. Customer : "
				+ customer);
		return customer;
	}

	public Map<String, Customer> loadAll(final Collection<String> idCol) {
		final Map<String, Customer> customerMap = getCustomerDAO()
				.getCustomerMap(idCol);
		System.out.println("loadAll method is being processed. CustomerMap : "
				+ customerMap);
		return customerMap;
	}

	public Set<String> loadAllKeys() {
		return null;
	}

	public CustomerDAO getCustomerDAO() {
		return ApplicationContextUtil.getApplicationContext().getBean(
				CustomerDAO.class);
	}

}
