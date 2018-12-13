package com.mycompany.store.dto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static volatile SingularAttribute<Cart, Date> datePurchased;
	public static volatile SingularAttribute<Cart, Integer> id;
	public static volatile SingularAttribute<Cart, Date> dateAdded;
	public static volatile SingularAttribute<Cart, Users> users;

}

