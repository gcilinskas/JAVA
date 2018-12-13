package com.mycompany.store.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderLine.class)
public abstract class OrderLine_ {

	public static volatile SingularAttribute<OrderLine, Product> product;
	public static volatile SingularAttribute<OrderLine, Integer> quantity;
	public static volatile SingularAttribute<OrderLine, Integer> id;
	public static volatile SingularAttribute<OrderLine, Order> order;

}

