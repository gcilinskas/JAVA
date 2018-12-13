package com.mycompany.store.dto;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartLine.class)
public abstract class CartLine_ {

	public static volatile SingularAttribute<CartLine, Product> product;
	public static volatile SingularAttribute<CartLine, Integer> quantity;
	public static volatile SingularAttribute<CartLine, BigDecimal> price;
	public static volatile SingularAttribute<CartLine, Integer> id;
	public static volatile SingularAttribute<CartLine, Cart> cart;

}

