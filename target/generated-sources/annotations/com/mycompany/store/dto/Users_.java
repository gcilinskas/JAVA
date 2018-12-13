package com.mycompany.store.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> password;
	public static volatile SetAttribute<Users, Roles> rolesList;
	public static volatile SingularAttribute<Users, Integer> id;
	public static volatile SingularAttribute<Users, Boolean> isAdmin;
	public static volatile SingularAttribute<Users, Cart> cart;
	public static volatile SingularAttribute<Users, String> username;

}

